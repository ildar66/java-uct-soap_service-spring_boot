package ru.masterdm.uct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import ru.masterdm.uct.config.EnviromentInitializer;

/**
 * Spring Boot application class.
 */
@SpringBootApplication
public class UctWebApplication extends SpringBootServletInitializer {

    private static final Logger LOG = LoggerFactory.getLogger("application");

    /**
     * Main method.
     * @param args String[]
     */
    public static void main(String[] args) {
        LOG.info("----   Java vendor: " + System.getProperty("java.vendor"));
        LOG.info("----   Java vendor URL: " + System.getProperty("java.vendor.url"));
        LOG.info("----   Java version: " + System.getProperty("java.version"));
        System.setProperty("com.sun.security.enableCRLDP", "true");
        SpringApplication application = new SpringApplication(UctWebApplication.class);
        application.addInitializers(new EnviromentInitializer());
        application.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UctWebApplication.class);
    }

}