package ru.masterdm.uct.config;

import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.net.SSLHostConfig;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.CryptoPro.ssl.tomcat.jsse.JCPJSSEImplementation;

/**
 * Spring config customization for CryptoPro.
 */
@Configuration
@Profile("prod")
public class ContainerConfiguration implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        if (container instanceof TomcatEmbeddedServletContainerFactory) {
            TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory) container;
            factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
                Http11NioProtocol proto = (Http11NioProtocol) connector.getProtocolHandler();
                proto.setSslImplementationName(JCPJSSEImplementation.class.getCanonicalName());
                for (SSLHostConfig config: proto.findSslHostConfigs()) {
                    // spring boot автоматически задает путь для хранилища ключа
                    // но для использования JCP-хранилища HDImageStore требуется указывать пустой путь
                    // иначе возникает Exception
                    if (config.getCertificateKeystoreProvider().equals("JCP") && config.getCertificateKeystoreType().equals("HDImageStore"))
                        config.setCertificateKeystoreFile("");
                }
            });
        }
    }
}
