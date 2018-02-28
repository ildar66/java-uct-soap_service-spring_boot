package ru.masterdm.uct.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Free bank documents for marshalling.
 * @author Ildar Shafigullin
 */
@XmlRootElement(name = "FreeBankDoc")
public class FreeBankDocList {

    private List<FreeBankDoc> docs = new ArrayList<>();

    /**
     * Default constructor.
     */
    public FreeBankDocList() {
        super();
    }

    /**
     * Constructor with free documents.
     * @param docList free documents
     */
    public FreeBankDocList(List<FreeBankDoc> docList) {
        this.docs = docList;
    }

    /**
     * Returns list documents.
     * @return list free bank docs
     */
    @XmlElement(name = "Doc")
    public List<FreeBankDoc> getDocs() {
        return docs;
    }
}
