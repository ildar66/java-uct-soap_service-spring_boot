package ru.masterdm.uct.repository;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import ru.masterdm.uct.entity.Client;
import ru.masterdm.uct.entity.Document;

/**
 * Mapper for uct clients.
 * @author Ildar Shafigullin
 */
@MapperScan
public interface ClientDao {

    /**
     * Returns client from database.
     * @param doc parameters
     * @return uct client
     */
    Client selectClient(@Param("body") Document doc);
}
