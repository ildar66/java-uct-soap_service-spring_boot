package ru.masterdm.uct.entity;

/**
 * Error codes to be fixed in journal.
 */
public enum ErrorCode {
    /** Common Error Code **/
    WRONG_CERTIFICATE("2.00.00"),
    WRONG_CLIENT("2.00.02"),

    /** Выписки: wsGetStatement **/
    // операция выполнена успешно
    GET_STATEMENT_SUCCESS("20401"),
    // ошибка поиска клиента
    GET_STATEMENT_NO_CLIENT("20402"),
    // ошибка поиска выписки
    GET_STATEMENT_NO_DOCUMENT("20403"),

    /** wsPrepareDocForCancel */
    // операция выполнена успешно
    PREPARE_DOC_FOR_CANCEL_SUCCESS("20301"),
    // ошибка поиска документа
    PREPARE_DOC_FOR_CANCEL_NO_DOCUMENT("20303"),

    /** wsImportDocument, wsImportSignedDocument. */
    // операция выполнена успешно
    IMPORT_DOCUMENT_SUCCESS("20101"),
    // ошибка проверки наличия прав на обслуживание заявленной организации
    IMPORT_DOCUMENT_NO_SERVICE("20102"),
    // ошибка проверки наличия значений (идентификаторов, референсов) в таблицах СДБО
    IMPORT_DOCUMENT_WRONG_VALUE("20103"),
    // ошибка проверки наличия прав на исполнение запроса с указанными параметрами
    IMPORT_DOCUMENT_ACCESS_DENIED_BY_PARAMS("20104"),
    // ошибка проверки XML по XSD
    IMPORT_DOCUMENT_INVALID_XML("20105"),
    // ошибка проверки соответствия организации заявленной и определенной
    IMPORT_DOCUMENT_WRONG_ORGANIZATION("20106"),
    // ошибка вставки документа
    IMPORT_DOCUMENT_DB_ERROR("20107"),

    /** wsGetCustomer. */
    // операция выполнена успешно
    GET_CUSTOMER_SUCCESS("20801"),
    // отправитель запроса не имеет прав на обслуживание данной организации
    GET_CUSTOMER_NO_SERVICE("20802"),
    // указанные в запросе значения не зарегистрированы в СДБО
    GET_CUSTOMER_WRONG_VALUE("20803"),
    // составленный запрос не принадлежит инициатору
    GET_CUSTOMER_WRONG_ORGANIZATION("20806"),

    /** Справочники СДБО. */
    // операция выполнена успешно
    DICTIONARY_SUCCESS("21001"),
    // отправитель запроса не имеет прав на обслуживание данной организации
    DICTIONARY_NO_SERVICE("21002"),
    // недостаточно прав для исполнения запроса с указанными параметрами
    DICTIONARY_WRONG_VALUE("21003"),
    // составленный запрос не принадлежит инициатору
    DICTIONARY_WRONG_ORGANIZATION("21006"),

    /** Статус документа: wsGetDocStatus. */
    // операция выполнена успешно
    GET_DOC_STATUS_SUCCESS("20201"),
    // ошибка поиска клиента
    GET_DOC_STATUS_NO_CLIENT("20202"),
    // ошибка проверки наличия сертификата
    GET_DOC_STATUS_WRONG_CERTIFICATE("20203"),
    // ошибка поиска документа
    GET_DOC_STATUS_NO_DOCUMENT("20304"),

    /** Документы из банка: getFreeBankDoc. **/
    // операция выполнена успешно
    GET_FREE_BANK_DOC_SUCCESS("20401"),
    // ошибка проверки наличия сертификата
    GET_FREE_BANK_DOC_WRONG_CERTIFICATE("20000"),
    // ошибка поиска клиента
    GET_FREE_BANK_DOC_NO_CLIENT("20402"),
    // ошибка поиска банковского документа
    GET_FREE_BANK_DOC_NO_DOCUMENT("20404"),

    /** Документы из банка: getFreeBankDocList. **/
    // операция выполнена успешно
    GET_FREE_BANK_DOC_LIST_SUCCESS("20401"),
    // ошибка проверки наличия сертификата
    GET_FREE_BANK_DOC_LIST_WRONG_CERTIFICATE("20000"),
    // ошибка поиска клиента
    GET_FREE_BANK_DOC_LIST_NO_CLIENT("20402");

    private String code;

    /**
     * Constructor.
     * @param code code
     */
    ErrorCode(String code) {
        this.code = code;
    }

    /**
     * code field getter.
     * @return error code
     */
    public String getCode() {
        return code;
    }
}