package ru.masterdm.uct.axis;

import org.apache.axis.AxisProperties;
import org.apache.axis.EngineConfiguration;
import org.apache.axis.configuration.EngineConfigurationFactoryDefault;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.utils.Messages;

import javax.servlet.ServletConfig;
import java.io.InputStream;

/**
 * Customize Axis factory of engine configuration to locate config.
 */
public class EngineConfigurationFactory extends EngineConfigurationFactoryDefault {

    private ServletConfig cfg;

    /**
     * Creates new factory.
     * @param param ServletConfig object
     * @return org.apache.axis.EngineConfigurationFactory
     */
    public static org.apache.axis.EngineConfigurationFactory newFactory(Object param) {
        // see comments inside method newFactory in org.apache.axis.configuration.EngineConfigurationFactoryServlet
        return (param instanceof ServletConfig)
                ? new EngineConfigurationFactory((ServletConfig) param)
                : null;
    }

    /**
     * Constructor with servlet configuration.
     * @param cfg ServletConfig
     */
    protected EngineConfigurationFactory(ServletConfig cfg) {
        super();
        this.cfg = cfg;
    }

    /**
     * This method works similarly to the method defined in
     * org.apache.axis.configuration.EngineConfigurationFactoryServlet
     * except it also tries to find wsdd config file in classpath.
     *
     * @return instance of EngineConfiguration
     */
    @Override
    public EngineConfiguration getServerEngineConfig() {
        // Respect the system property setting for a different config file
        String configFile = cfg.getInitParameter(OPTION_SERVER_CONFIG_FILE);
        if (configFile == null) {
            configFile = AxisProperties.getProperty(OPTION_SERVER_CONFIG_FILE);
        }
        if (configFile == null) {
            configFile = SERVER_CONFIG_FILE;
        }

        FileProvider config = null;
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        InputStream is = cl.getResourceAsStream(configFile);

        if (is != null) {
            config = new FileProvider(is);
        }
        if (config == null) {
            log.error(Messages.getMessage("servletEngineWebInfError03", configFile));
        }
        return config;
    }
}
