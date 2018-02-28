package ru.masterdm.uct.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Load properties from database.
 */
public class EnviromentInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment env = applicationContext.getEnvironment();
        Map<String, Object> propertySource;
        try {
            DataSource ds = DataSourceBuilder.create()
                    .username(env.getProperty("spring.datasource.username"))
                    .password(env.getProperty("spring.datasource.password"))
                    .url(env.getProperty("spring.datasource.url"))
                    .driverClassName(env.getProperty("spring.datasource.driverClassName"))
                    .build();
            JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
            propertySource = jdbcTemplate.query("select property,value from ekk_environment", (ResultSetExtractor<Map>) rs -> {
                HashMap<String, String> resultMap = new HashMap<>();
                while (rs.next()) {
                    resultMap.put(rs.getString("property"), rs.getString("value"));
                }
                return resultMap;
            });
            env.getPropertySources().addFirst(new MapPropertySource("dbProperties", propertySource));
        } catch (Exception e) {
            throw new RuntimeException("Error fetching properties from db");
        }
    }
}
