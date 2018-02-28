package ru.masterdm.uct.route.components;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.IntStream;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.camel.Body;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Camel component for validation.
 */
@Component("schemaProcessor")
public class SchemaProcessor {

    /**
     * Validates xml by xsd.
     * @param xml xml
     * @param xsd xsd
     * @return boolean
     */
    public String validate(String xml, String xsd) {
        InputStream xmlStream = null;
        InputStream xsdStream = null;
        try {
            xmlStream = new ByteArrayInputStream(xml.getBytes("cp1251"));
            xsdStream = new ByteArrayInputStream(xsd.getBytes("UTF-8"));
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsdStream));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlStream));
            return "true";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * Removes nil attribute from xml.
     * @param xml xml
     * @return xml without nil attributes
     * @throws XPathExpressionException exception
     */
    public Document removeNilAttribute(@Body Document xml) throws XPathExpressionException {
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile("//*[@*[local-name() = 'nil'] = 'true']");

        NodeList nodes = (NodeList) expr.evaluate(xml, XPathConstants.NODESET);
        IntStream.range(0, nodes.getLength()).forEach(index -> {
            Element element = ((Element) nodes.item(index));
            element.removeAttribute("xmlns:xsi");
            element.removeAttribute("xsi:nil");
        });

        return xml;
    }
}