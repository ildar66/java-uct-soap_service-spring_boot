set PASSWORD=Passw0rd
set CN_HOST=domain
set CN_CLIENT=user1
set TRUSTSTORE=truststore.jks
set KEYSTORE=keystore.jks

set DN_O=O=Mastrer-Domino,L=Moscow,ST=Moscow,C=RU
set DN_CA=CN=RootCA,%DN_O%
set DN_HOST=CN=%CN_HOST%,%DN_O%
set DN_CLIENT=CN=%CN_CLIENT%,%DN_O%

rem Generate a certificate authority (CA%
keytool -genkey -alias ca -ext BC=ca:true -keyalg RSA -keysize 4096 -sigalg SHA512withRSA -keypass %PASSWORD% -validity 3650 -dname %DN_CA% -keystore %KEYSTORE% -storepass %PASSWORD%

rem Generate a host certificate
keytool -genkey -alias %CN_HOST% -keyalg RSA -keysize 4096 -sigalg SHA512withRSA -keypass %PASSWORD% -validity 3650 -dname %DN_HOST% -keystore %KEYSTORE% -storepass %PASSWORD%
rem Generate a host certificate signing request
keytool -certreq -alias %CN_HOST% -ext BC=ca:true -keyalg RSA -keysize 4096 -sigalg SHA512withRSA -validity 3650 -file "%CN_HOST%.csr" -keystore %KEYSTORE% -storepass %PASSWORD%
rem Generate signed certificate with the certificate authority
keytool -gencert -alias ca -validity 3650 -sigalg SHA512withRSA -infile "%CN_HOST%.csr" -outfile "%CN_HOST%.crt" -rfc -keystore %KEYSTORE% -storepass %PASSWORD%
rem Import signed certificate into the keystore
keytool -import -trustcacerts -alias %CN_HOST% -file "%CN_HOST%.crt" -keystore %KEYSTORE% -storepass %PASSWORD%

rem Export certificate authority
keytool -export -alias ca -file ca.crt -rfc -keystore %KEYSTORE% -storepass %PASSWORD%

rem Import certificate authority into a new truststore
keytool -import -trustcacerts -noprompt -alias ca -file ca.crt -keystore %TRUSTSTORE% -storepass %PASSWORD%

rem Generate client certificate
keytool -genkey -alias %CN_CLIENT% -keyalg RSA -keysize 4096 -sigalg SHA512withRSA -keypass %PASSWORD% -validity 3650 -dname %DN_CLIENT% -keystore %TRUSTSTORE% -storepass %PASSWORD%
rem Generate a host certificate signing request
keytool -certreq -alias %CN_CLIENT% -ext BC=ca:true -keyalg RSA -keysize 4096 -sigalg SHA512withRSA -validity 3650 -file "%CN_CLIENT%.csr" -keystore %TRUSTSTORE% -storepass %PASSWORD%
rem Generate signed certificate with the certificate authority
keytool -gencert -alias ca -validity 3650 -sigalg SHA512withRSA -infile "%CN_CLIENT%.csr" -outfile "%CN_CLIENT%.crt" -rfc -keystore %KEYSTORE% -storepass %PASSWORD%
rem Import signed certificate into the truststore
keytool -import -trustcacerts -alias %CN_CLIENT% -file "%CN_CLIENT%.crt" -keystore %TRUSTSTORE% -storepass %PASSWORD%
rem Export private certificate for importing into a browser
keytool -importkeystore -srcalias %CN_CLIENT% -srckeystore %TRUSTSTORE% -srcstorepass %PASSWORD% -destkeystore "%CN_CLIENT%.p12" -deststorepass %PASSWORD% -deststoretype PKCS12