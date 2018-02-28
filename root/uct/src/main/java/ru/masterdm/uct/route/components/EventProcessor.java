package ru.masterdm.uct.route.components;

import java.util.List;

import org.springframework.stereotype.Component;

import ru.masterdm.uct.entity.Document;
import ru.masterdm.uct.entity.ErrorCode;
import ru.masterdm.uct.entity.Event;
import ru.masterdm.uct.entity.FreeBankDoc;
import ru.masterdm.uct.entity.FreeBankDocList;
import ru.masterdm.uct.entity.StatementDoc;

/**
 * Camel component for event generation.
 */
@Component("eventProcessor")
public class EventProcessor {

    /**
     * Creates new event.
     * @param code error code
     * @param error error text
     * @return UctEvent
     */
    public Event createEvent(ErrorCode code, String error) {
        return new Event(code, error);
    }

    /**
     * Calculate document status.
     * @param doc input document
     * @return document
     */
    public Document calcDocStatus(Document doc) {
        // В случае нахождения записи необходимо по текстовому значению значению "DocStatus"
        // вернуть числовой статус (см. "Приложение 1. Список статусов СДБО").
        // TODO create enum ?
        // Если в таблице соответствия статус не определен, но значение "DocStatus" может быть
        // преобразовано в число, то возвращать следует данное значение.
        // TODO
        //  Метод "GetDocStatus" должен возвращать значение "Status" только,
        // если значения "bserrorcode" и "bserror" не определены. В противном случае,
        // возвращаются именно эти значения.
        if (doc != null && (doc.getBsError() != null || doc.getBsErrorCode() != null)) {
            doc.setDocStatus(null);
        } else if (doc != null && doc.getDocStatus() == null) {
            // Если в таблице соответствия статус не определен, то возвращать "0".
            doc.setDocStatus("0");
        }
        return doc;
    }

    /**
     * Processing for free bank documents.
     * @param freeBankDocXml xml for free bank document
     * @param document input document
     * @param freeBankDoc free bank document
     * @return Document output document
     */
    public Document processFreeBankDoc(String freeBankDocXml, Document document, FreeBankDoc freeBankDoc) {
        document.setDocData(freeBankDocXml);
        document.setSignData(freeBankDoc.getSignData());
        return document;
    }

    /**
     * Processing for statement documents.
     * @param statementXml xml for free bank document
     * @param document input document
     * @param statementDoc statement document
     * @return Document output document
     */
    public Document processStatementDoc(String statementXml, Document document, StatementDoc statementDoc) {
        document.setDocData(statementXml);
        document.setSignData(statementDoc.getSignData());
        return document;
    }

    /**
     * Processing for empty statement document.
     * @param document input document
     * @return Document output document
     */
    public Document processEmptyStatementDoc(Document document) {
        String statementXml = "<?xml version=\"1.0\" encoding=\"windows-1251\"?>";
        document.setDocData(statementXml);
        return document;
    }

    /**
     * Processing document for cancel.
     * @param document input document
     * @return Document output document
     */
    public Document processDocForCancel(Document document) {
        //  temp return: DocScheme+"_"+DOCVERSION
        String cancelFields = document.getDocScheme() + "_" + document.getDocVersion();
        document.setCancelFields(cancelFields);
        return document;
    }

    /**
     * Create free bank documents for marshalling.
     * @param docList free bank documents
     * @param document input document
     * @return List free bank document list
     */
    public FreeBankDocList createAndFillFreeBankDocs(List<FreeBankDoc> docList, Document document) {
        return new FreeBankDocList(docList);
    }
}
