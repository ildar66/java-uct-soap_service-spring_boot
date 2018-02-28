package ru.masterdm.uct.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import ru.masterdm.uct.entity.Document;
import ru.masterdm.uct.entity.FreeBankDoc;
import ru.masterdm.uct.entity.Statement;
import ru.masterdm.uct.entity.StatementDoc;

/**
 * Mapper for documents.
 */
@MapperScan
public interface DocumentDao {

    /**
     * Returns xsd scheme from database.
     * @param doc parameters
     * @return xsd scheme
     */
    byte[] selectDocScheme(@Param("body") Document doc);

    /**
     * Saves document in database.
     * @param doc parameters
     */
    void insertDocument(@Param("body") Document doc);

    /**
     * Returns document from database.
     * @param doc parameters
     * @return uct document
     */
    Document selectDocument(@Param("body") Document doc);

    /**
     * Returns free bank document from database.
     * @param doc parameters
     * @return uct document
     */
    FreeBankDoc selectFreeBankDoc(@Param("body") Document doc);

    /**
     * Returns all available free bank docs.
     * @return list of documents
     */
    List<FreeBankDoc> selectFreeBankDocList();

    /**
     * Returns statement document from database.
     * @param doc parameters
     * @return statement document
     */
    StatementDoc selectStatementDoc(@Param("body") Statement doc);
}
