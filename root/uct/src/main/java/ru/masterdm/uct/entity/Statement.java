package ru.masterdm.uct.entity;

/**
 * Statement entity object.
 * @author Ildar Shafigullin
 */
public class Statement extends Document {

    private String account; // счет, по которому нужно получить выписку
    private int type; // тип запроса: 0 – выписка, 1-справка.

    /**
     * Default constructor.
     */
    public Statement() {
    }

    /**
     * Constructor for statement.
     * @param doc base param for document
     * @param account accoutn
     * @param statementType statement type
     */
    public Statement(Document doc, String account, int statementType) {
        super(doc.getDocData(), doc.getDocScheme(), doc.getDocVersion(), doc.getCustID(), doc.getSignData(), doc.getRemoteUser());
        this.setDocumentDate(doc.getDocumentDate());
        this.account = account;
        this.type = statementType;
    }

    /**
     * Returns statement account.
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets account for statement.
     * @param account statement
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Returns statement type.
     * @return type statement
     */
    public int getType() {
        return type;
    }

    /**
     * Sets statement type.
     * @param type statement
     */
    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Statement{" +
               "account='" + account + '\'' +
               ", type=" + type +
               "} " + super.toString();
    }
}
