--liquibase formatted sql

--changeset rislamov:uct-1.0-VEBUCT-2 logicalFilePath:uct-1.0-VEBUCT-2 endDelimiter:/
create table ekk_scheme (
    scheme varchar2(256) not null enable,
    version number(4, 0) not null enable,
    xsd blob
)
/
comment on column ekk_scheme.scheme is 'Название схемы'
/
comment on column ekk_scheme.version is 'Версия'
/
comment on column ekk_scheme.xsd is 'XSD-файл'
/

create table ekk_environment (
    systemid number(5, 0) not null enable,
    property varchar2(256),
    value varchar2(1024)
)
/
comment on column ekk_environment.systemid is 'Уникальный идентификатор комплекса'
/
comment on column ekk_environment.property is 'Имя свойства'
/
comment on column ekk_environment.value is 'Значение свойства'
/

create table ekk_doc (
    docscheme varchar2(256) not null enable,
    docversion number(4, 0) not null enable,
    docdata clob not null enable,
    signdata clob,
    recordid varchar2(32) not null enable,
    unid varchar2(32),
    docstatus number(5, 0)
)
/
comment on column ekk_doc.docscheme is 'Схема документа'
/
comment on column ekk_doc.docversion is 'Версия'
/
comment on column ekk_doc.docdata is 'Данные по документу'
/
comment on column ekk_doc.signdata is 'Данные ЭЦП'
/
comment on column ekk_doc.recordid is 'Референс документа'
/
comment on column ekk_doc.unid is 'ID документа в СБК'
/
comment on column ekk_doc.docstatus is 'Статус документа в СБК'
/

create table ekk_client (
    custid number(5, 0) not null enable,
    ln varchar2(256) not null enable,
    customertype number(1, 0),
    fiscalreasoncode varchar2(9),
    inn varchar2(12),
    intaddress varchar2(1024),
    intplace varchar2(256),
    intstate varchar2(256),
    intzip varchar2(10),
    lawaddress varchar2(1024),
    lawcountry varchar2(3),
    lawplace varchar2(128),
    lawplacetype number(5, 0),
    lawstate varchar2(128),
    lawzip varchar2(6),
    namefull varchar2(512),
    nameint varchar2(512),
    nameshort varchar2(256),
    okatocode varchar2(11),
    okpocode varchar2(10),
    propertytype number(5, 0),
    lawdistrict varchar2(128),
    lawcity varchar2(128),
    lawstreet varchar2(256),
    lawbuilding varchar2(16),
    lawblock varchar2(16),
    lawoffice varchar2(16),
    accounts clob,
    modified date default sysdate not null enable
)
/
comment on column ekk_client.custid is 'ID организации'
/
comment on column ekk_client.ln is 'LN-имя Клиента в СБК'
/
comment on column ekk_client.customertype is 'Тип организации'
/
comment on column ekk_client.fiscalreasoncode is 'КПП'
/
comment on column ekk_client.inn is 'ИНН'
/
comment on column ekk_client.intaddress is 'Международный Адрес'
/
comment on column ekk_client.intplace is 'Международный: Населенный пункт'
/
comment on column ekk_client.intstate is 'Международный: Субъект РФ/штат'
/
comment on column ekk_client.intzip is 'Международный Индекс'
/
comment on column ekk_client.lawaddress is 'Адрес'
/
comment on column ekk_client.lawcountry is 'Код страны'
/
comment on column ekk_client.lawplace is 'Населенный пункт'
/
comment on column ekk_client.lawplacetype is 'Тип населенного пункта (не используется)'
/
comment on column ekk_client.lawstate is 'Субъект РФ/штат'
/
comment on column ekk_client.lawzip is 'Индекс'
/
comment on column ekk_client.namefull is 'Полное название'
/
comment on column ekk_client.nameint is 'Международное название'
/
comment on column ekk_client.nameshort is 'Название в фин. документах'
/
comment on column ekk_client.okatocode is 'Код ОКАТО'
/
comment on column ekk_client.okpocode is 'Код ОКПО'
/
comment on column ekk_client.propertytype is 'Форма собственности (не используется)'
/
comment on column ekk_client.lawdistrict is 'Район'
/
comment on column ekk_client.lawcity is 'Город'
/
comment on column ekk_client.lawstreet is 'Улица'
/
comment on column ekk_client.lawbuilding is 'Номер дома/владение'
/
comment on column ekk_client.lawblock is 'Корпус/строение'
/
comment on column ekk_client.lawoffice is 'Офис/квартира'
/
comment on column ekk_client.accounts is 'Список счетов'
/
comment on column ekk_client.modified is 'Дата/время модификации записи'
/

create table ekk_cert (
    serialnumber varchar2(32) not null enable,
    subject varchar2(1024) not null enable,
    issuer varchar2(1024) not null enable,
    subject_altname varchar2(1024) not null enable,
    organizationname varchar2(1024),
    businesscategory varchar2(1024),
    keyid varchar2(16),
    notes_address varchar2(512),
    time_notbefore date not null enable,
    time_notafter date not null enable,
    time_notbefore_private date not null enable,
    time_notafter_private date not null enable,
    certificate clob not null enable,
    unid varchar2(32) not null enable,
    constraint unid unique (unid)
)
/
comment on column ekk_cert.serialnumber is 'Серийный номер'
/
comment on column ekk_cert.subject is 'Владелец'
/
comment on column ekk_cert.issuer is 'Издатель'
/
comment on column ekk_cert.subject_altname is 'Имя владельца'
/
comment on column ekk_cert.organizationname is 'Компания'
/
comment on column ekk_cert.businesscategory is 'Должность'
/
comment on column ekk_cert.keyid is 'ID ключа'
/
comment on column ekk_cert.notes_address is 'LN-имя'
/
comment on column ekk_cert.time_notbefore is 'Дата начала действия сертификата'
/
comment on column ekk_cert.time_notafter is 'Дата окончания действия сертификата'
/
comment on column ekk_cert.time_notbefore_private is 'Дата начала действия ключа'
/
comment on column ekk_cert.time_notafter_private is 'Дата окончания действия ключа'
/
comment on column ekk_cert.certificate is 'Сертификат'
/
comment on column ekk_cert.unid is 'ID документа в СБК'
/

create table ekk_branch (
    branchid number(1, 0) default 1 not null enable,
    branchbic number(9, 0) not null enable,
    branchname varchar2(128) not null enable,
    branchnamefull varchar2(256) not null enable
)
/
comment on column ekk_branch.branchid is 'ID организации'
/
comment on column ekk_branch.branchbic is 'БИК подразделения Банка'
/
comment on column ekk_branch.branchname is 'Название подразделения Банка'
/
comment on column ekk_branch.branchnamefull is 'Полное название подразделения Банка'
/

--changeset rislamov:uct-1.0-VEBUCT-3 logicalFilePath:uct-1.0-VEBUCT-3 endDelimiter:/
alter table ekk_doc
  add created date default sysdate
/
comment on column ekk_doc.created is 'Дата добавления документа'
/

--changeset rislamov:uct-1.0-VEBUCT-4-1 logicalFilePath:uct-1.0-VEBUCT-4-1 endDelimiter:/
alter table ekk_client
    drop column accounts
/

--changeset ishafigullin:uct-1.0-VEBUCT-7 logicalFilePath:uct-1.0-VEBUCT-7 endDelimiter:/
alter table ekk_doc
    add docinfo clob
/

--changeset ishafigullin:uct-1.0-VEBUCT-16 logicalFilePath:uct-1.0-VEBUCT-16 endDelimiter:/
comment on column ekk_doc.docinfo is 'Дополнительная информация'
/

--changeset ishafigullin:uct-1.0-VEBUCT-15 logicalFilePath:uct-1.0-VEBUCT-15 endDelimiter:/
create table ekk_doc_bank
(
    docscheme varchar2(256) not null,
    created date default sysdate not null,
    recordid varchar2(32) not null,
    documentdate date not null,
    document clob not null,
    signdata clob,
    custid number(5) not null,
    doctype varchar2(256),
    docname varchar2(1024)
)
/
comment on column ekk_doc_bank.docscheme is 'Схема документа'
/
comment on column ekk_doc_bank.created is 'Дата добавления документа'
/
comment on column ekk_doc_bank.recordid is 'ID документа (UNID)'
/
comment on column ekk_doc_bank.documentdate is 'Дата документа'
/
comment on column ekk_doc_bank.document is 'Данные по документу'
/
comment on column ekk_doc_bank.signdata is 'Данные ЭЦП'
/
comment on column ekk_doc_bank.custid is 'ID организации'
/
comment on column ekk_doc_bank.doctype is 'Тип документа'
/
comment on column ekk_doc_bank.docname is 'Название документа'
/

--changeset svaliev:uct-1.0-ekk-scheme-uk logicalFilePath:uct-1.0-ekk-scheme-uk endDelimiter:/
alter table ekk_scheme modify xsd not null
/
alter table ekk_scheme add constraint ekk_scheme_pk primary key (scheme, version)
/

--changeset ishafigullin:uct-1.0-VEBUCT-19 logicalFilePath:uct-1.0-VEBUCT-19 endDelimiter:/ failOnError:false
create table ekk_statement
(
    custid number(5) not null,
    account varchar2(20) not null,
    statementdate date not null,
    satetementtype number(1) default 0 not null,
    statementdoc clob not null,
    signdata clob
)
/
comment on column ekk_statement.custid is 'ID организации'
/
comment on column ekk_statement.account is 'Счет'
/
comment on column ekk_statement.statementdate is 'Дата выписки'
/
comment on column ekk_statement.satetementtype is 'Тип выписки'
/
comment on column ekk_statement.statementdoc is 'Данные выписки'
/
comment on column ekk_statement.signdata is 'Данные ЭЦП'
/

--changeset ishafigullin:uct-1.0-VEBUCT-28 logicalFilePath:uct-1.0-VEBUCT-28 endDelimiter:/
alter table ekk_doc
    add bserrorcode varchar2(5)
/
comment on column ekk_doc.bserrorcode is 'Код ошибки'
/
alter table ekk_doc
    add bserror varchar2(512)
/
comment on column ekk_doc.bserror is 'Текст ошибки'
/
