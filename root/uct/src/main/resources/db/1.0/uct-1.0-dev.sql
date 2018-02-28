--liquibase formatted sql

--changeset svaliev:uct-1.0-insert-ekk-branch logicalFilePath:uct-1.0-insert-ekk-branch endDelimiter:/ context:dev
insert into ekk_branch (branchid, branchbic, branchname, branchnamefull)
values (1, 44525060, 'Внешэкономбанк', 'Государственная корпорация "Банк развития и внешнеэкономической деятельности (Внешэкономбанк)"')
/

--changeset svaliev:uct-1.0-insert-ekk-client logicalFilePath:uct-1.0-insert-ekk-client endDelimiter:/ context:dev runOnChange:true
delete from ekk_client
/
insert into ekk_client (custid, ln, customertype, fiscalreasoncode, inn, intaddress, intplace, intstate, intzip, lawaddress, lawcountry, lawplace,
                        lawplacetype, lawstate, lawzip, namefull, nameint, nameshort, okatocode, okpocode, propertytype, lawdistrict, lawcity, lawstreet, lawbuilding, lawblock, lawoffice, modified)
values (11, 'CN=Первый клиент для тестов/O=VEB', 0, '111111111', '1111111111', null, null, null, null, null, '643', null, null, null, null, 'ОАО "Первый клиент"',
        'FIRST TEST CLIENT', 'ОАО "Первый клиент"', null, '00000000', null, null, null, null, null, null, null, to_date('15-12-2017 12:33:15', 'dd-mm-yyyy hh24:mi:ss'))
/
