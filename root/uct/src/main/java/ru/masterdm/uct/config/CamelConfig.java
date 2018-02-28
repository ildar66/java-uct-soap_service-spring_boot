package ru.masterdm.uct.config;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mybatis.MyBatisComponent;
import org.apache.camel.spring.SpringCamelContext;
import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Spring configuration for Camel.
 */
@Configuration
public class CamelConfig extends CamelAutoConfiguration {

    public static final String MAPPER_PATTERN_UCT = "mybatis/*.xml";
    public static final String MAPPER_PATTERN_SBC = "mybatis-sbc/*.xml";

    /**
     * UCT datasource bean.
     * @return datasource
     */
    @Primary
    @Bean(name = "datasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * UCT SqlSessionFactory bean.
     * @return SqlSessionFactory
     * @throws Exception exception
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        return createSqlSessionFactory(datasource(), MAPPER_PATTERN_UCT);
    }

    /**
     * UCT MyBatisComponent bean.
     * @return MyBatisComponent
     * @throws Exception exception
     */
    @Bean(name = "mybatis")
    public MyBatisComponent myBatisComponent() throws Exception {
        MyBatisComponent result = new MyBatisComponent();
        result.setSqlSessionFactory(sqlSessionFactory());
        return result;
    }

    /**
     * SBC datasource bean.
     * @return datasource
     */
    @Bean(name = "datasourceSbc")
    @ConfigurationProperties(prefix = "spring.datasourceSbc")
    public DataSource datasourceSbc() {
        return DataSourceBuilder.create().build();
    }

    /**
     * SBC SqlSessionFactory bean.
     * @return SqlSessionFactory
     * @throws Exception exception
     */
    @Bean(name = "sqlSessionFactorySbc")
    public SqlSessionFactory sqlSessionFactorySbc() throws Exception {
        return createSqlSessionFactory(datasourceSbc(), MAPPER_PATTERN_SBC);
    }

    /**
     * SBC MyBatisComponent bean.
     * @return MyBatisComponent
     * @throws Exception exception
     */
    @Bean(name = "mybatisSbc")
    public MyBatisComponent myBatisComponentSbc() throws Exception {
        MyBatisComponent result = new MyBatisComponent();
        result.setSqlSessionFactory(sqlSessionFactorySbc());
        return result;
    }

    /**
     * Creates session factory by datasource and mapper.
     * @param datasource datasource
     * @param mapperLocationPattern mapperLocationPattern
     * @return SqlSessionFactory
     * @throws Exception exception
     */
    private SqlSessionFactory createSqlSessionFactory(DataSource datasource, String mapperLocationPattern) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(datasource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(mapperLocationPattern));
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactory;
    }
}