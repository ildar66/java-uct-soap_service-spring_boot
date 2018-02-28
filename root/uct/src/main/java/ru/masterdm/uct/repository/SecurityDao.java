package ru.masterdm.uct.repository;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import ru.masterdm.uct.entity.Certificate;
import ru.masterdm.uct.entity.Document;

/**
 * Mapper for uct certificate and so on.
 * @author Ildar Shafigullin
 */
@MapperScan
public interface SecurityDao {

    /**
     * Returns certificate from database.
     * @param doc parameters
     * @return certificate
     */
    Certificate selectCertificate(@Param("body") Document doc);
}
