set WSDL_PATH=D:\Work\git\uct-system\uct\src\main\resources\wsdl\
for %%w in (%WSDL_PATH%*) do (
    echo %%~nxw
    java -cp activation-1.1.jar;axis.jar;commons-logging.jar;commons-discovery.jar;jaxrpc.jar;saaj.jar;wsdl4j.jar org.apache.axis.wsdl.WSDL2Java --output %%~nxw/ --verbose --package ru.masterdm.uct.axis.ws --server-side --skeletonDeploy true file:///%WSDL_PATH%%%~nxw
)
