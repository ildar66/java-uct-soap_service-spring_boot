####################### НАСТРОЙКИ ПРОЕКТА ДЛЯ РАЗРАБОТКИ #######################

1. Настроить gradle на java 8: задать свойство org.gradle.java.home в файле gradle.properties либо при запуске (н-р, "gradlew -Dorg.gradle.java.home=C:/Java/jdk1.8.0_151/ bootRun" )
2. В проекте 2 конфигурации запуска приложения (profile): 
 * prod (по умолчанию) - используется CryptoPro JCP
 * dev - стандатный Java-криптопровайдер


----------------------- dev -----------------------

1. Для запуска необходимо задать переменную окружения spring.profiles.active=dev
2. Конфигурация указана в application-dev.properties
3. Для генерации ключей использовался скрипт certificates/gen-certs.bat
3. Сертификаты сервера:
 * keystore.jks - ключ авторизации сервера
 * truststore.jks - доверенные сертификаты
4. Ключи авторизации пользователя:
 * user1.p12 - ключ авторизации пользователя
5. Для проверки успешности запуска:
 * в папке soap project расположен проект SoapUI для отладки web-сервисов
 * при выполнении web-сервиса необходимо использовать java-сертификат user1.p12 (Preferences -> SSL settings -> Keystore)

Полезная информация:
* http://www.baeldung.com/x-509-authentication-in-spring-security


----------------------- prod -----------------------

1. Конфигурация указана в application.properties
2. Ключи, загруженные в JCP (были сформированы в самом JCP с помощью Тестового УЦ КриптоПро):
 * контейнер server
 * контейнер client
3. Хранилище доверенных сертификатов JCP:
 * C:/store.store - содержит только сертификат Тестового УЦ КриптоПро
4. Для проверки соединения можно воспользоваться утилитой из дистрибутива JCP samples.jar:
C:\Java\jdk1.8.0_91\jre\bin\java -Dcom.sun.security.enableCRLDP=true -cp samples.jar ComLine.Client -port 8443 -server localhost -keyStoreType HDImageStore -keyStoreAlias client -trustStoreType CertStore -trustStorePath C:/store.store -trustStorePassword Passw0rd -keyStorePassword Passw0rd -fileget /ws

Полезная информация:
 * документация КриптоПро JCP
 * https://support.cryptopro.ru/index.php?/Knowledgebase/Article/View/45/0/vkljuchenie-zhurnlirovnija-kriptopro-jcp
 * https://support.cryptopro.ru/index.php?/Knowledgebase/Article/View/226/0/otkljuchenie-preduprezhdjushhikh-okon-o-neobkhodimosti-skorogo-perekhod-n-gost-r-3410-2012&utm_campaign=warn_2017-10


####################### СБОРКА ПРОЕКТА #######################

1. В папке uct-system/uct запустить команду ./gradlew clean build
2. Собранное приложение находится в папке uct-system/uct/build/libs/uct.jar
