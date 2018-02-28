Сертификаты:
* rootCA0 - Корневой сертификат УЦ, используемый для создания сертификата Сервера0 и Клиентов 01 и 02
* server0 - Сертификат сервера, изданный rootCARight
* client01 - Сертификат клиента, изданный rootCA0
* rootCA1 - Корневой сертификат УЦ, используемый для создания сертификатов Клиентов 11 и 12
* client11, client12 - CСертификаты клиентов, изданные rootCA1

Хранилища:
* trustedCAServer0 - хранилище доверенных УЦ
* trustedServer0 - хранилище доверенных сертификатов

Ситуация 1. trustedCAServer0 = [rootCA0]; trustedServer0 = []
Авторизации:
* client01 - success
* client11 - fail
* client12 - fail

Ситуация 2. trustedCAServer0 = [rootCA0]; trustedServer0 = [client11]
Авторизации:
* client01 - success
* client11 - success
* client12 - fail

Ситуация 3. trustedCAServer0 = [rootCA0,rootCA1]; trustedServer0 = []
Авторизации:
* client01 - success
* client11 - success
* client12 - success