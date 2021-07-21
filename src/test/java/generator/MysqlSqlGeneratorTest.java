package generator;

import entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MysqlSqlGeneratorTest {

    String table = "user";
    String schema = "test_schema";
    User user = new User("user", "user");
    List<String> column = Arrays.asList(user.getName(), user.getSurname());
    private final MysqlSqlGenerator mysqlSqlGenerator = new MysqlSqlGenerator();

    @Test
    public void dropTableQueryTest() {
        String dropTableQuery = mysqlSqlGenerator.getDropTableQuery(table, schema);
        assertEquals("drop table if exists `test_schema`.`user`", dropTableQuery);
    }

    @Test
    public void dropTableTableNameOrSchemaIsEmptyQueryTest() {
        String dropTableQuery = mysqlSqlGenerator.getDropTableQuery("", "");
        assertEquals("table or schema can not be empty!", dropTableQuery);
    }

    @Test
    public void dropTableTableNameOrSchemaIsNullQueryTest() {
        try {
            mysqlSqlGenerator.getDropTableQuery(null, null);
        } catch (NullPointerException e) {
            assertEquals("tableName or schema is null", e.getMessage());
        }
    }

    @Test
    public void truncateTableQueryTest() {
        String truncateTableQuery = mysqlSqlGenerator.getTruncateTableQuery(table, schema);
        assertEquals("truncate table `test_schema`.`user`", truncateTableQuery);
    }

    @Test
    public void truncateTableOrSchemaIsEmptyQueryTest() {
        String truncateTableQuery = mysqlSqlGenerator.getTruncateTableQuery(table, "");
        assertEquals("table or schema can not be empty!", truncateTableQuery);
    }

    @Test
    public void truncateTableOrSchemaIsNullQueryTest() {
        try {
            mysqlSqlGenerator.getTruncateTableQuery(null, null);
        } catch (NullPointerException e) {
            assertEquals("tableName or schema is null", e.getMessage());
        }
    }

    @Test
    public void batchInsertQueryTest() {
        String batchInsertQuery = mysqlSqlGenerator.getBatchInsertQuery(table, schema, column);
        assertEquals("insert into `test_schema`.`user` (`name`, `surname`) values (?, ?)", batchInsertQuery);
    }

    @Test
    public void batchInsertTableOrSchemaIsEmptyQueryTest() {
        String batchInsertQuery = mysqlSqlGenerator.getBatchInsertQuery("", "", column);
        assertEquals("table or schema can not be empty!", batchInsertQuery);
    }

    @Test
    public void batchInsertTableColumnListIsEmptyTest() {
        String batchInsertQuery = mysqlSqlGenerator.getBatchInsertQuery(table, schema, new ArrayList<>());
        assertEquals("columns can not be empty!", batchInsertQuery);
    }

    @Test
    public void batchInsertTableColumnIsIsEmptyTest() {
        String batchInsertQuery = mysqlSqlGenerator.getBatchInsertQuery(table, schema, Arrays.asList("", ""));
        assertEquals("name or surname can not be empty!", batchInsertQuery);
    }

    @Test
    public void batchInsertNullQueryTest() {
        try {
            mysqlSqlGenerator.getBatchInsertQuery(null, null, null);
        } catch (NullPointerException e) {
            assertEquals("tableName,schema or column is null", e.getMessage());
        }
    }

    @Test
    public void selectCountQueryTest() {
        String selectCountQuery = mysqlSqlGenerator.getSelectCountQuery(table, schema);
        Integer integer = Integer.valueOf(selectCountQuery);
        assertNotEquals(integer, null);
    }

    @Test
    public void selectCountTableOrSchemaIsEmptyQueryTest() {
        String selectCountQuery = mysqlSqlGenerator.getSelectCountQuery("", "");
        assertEquals("table or schema can not be empty!", selectCountQuery);

    }

    @Test
    public void selectCountIsNullQueryTest() {
        try {
            mysqlSqlGenerator.getSelectCountQuery(null, null);
        } catch (NullPointerException e) {
            assertEquals("tableName or schema is null", e.getMessage());
        }
    }

    @Test
    public void createDatabaseQueryTest() {
        String createDatabaseQuery = mysqlSqlGenerator.getCreateDatabaseQuery("test_5", "test3_schema");
        assertEquals("create database `test_5`", createDatabaseQuery);
    }

    @Test
    public void createDatabaseIsEmptyQueryTest() {
        String createDatabaseQuery = mysqlSqlGenerator.getCreateDatabaseQuery("", "dt_test5_schema");
        assertEquals("database can not be empty!", createDatabaseQuery);

    }

    @Test
    public void createDatabaseIsNullQueryTest() {
        try {
            mysqlSqlGenerator.getCreateDatabaseQuery(null, null);
        } catch (NullPointerException e) {
            assertEquals("database is null", e.getMessage());
        }
    }

    @Test
    public void dropDatabaseQueryTest() {
        String createDatabaseQuery = mysqlSqlGenerator.getDropDatabaseQuery("test_5", "test5_schema");
        assertEquals("drop database `test_5`", createDatabaseQuery);
    }

    @Test
    public void dropDatabaseIsEmptyQueryTest() {
        String createDatabaseQuery = mysqlSqlGenerator.getDropDatabaseQuery("", "test5_schema");
        assertEquals("database can not be empty!", createDatabaseQuery);
    }

    @Test
    public void dropDatabaseIsNullQueryTest() {
        try {
            mysqlSqlGenerator.getDropDatabaseQuery(null, "test5_schema");
        } catch (NullPointerException e) {
            assertEquals("database is null", e.getMessage());
        }
    }

    @Test
    public void createSchemaQueryTest() {
        String createDatabaseQuery = mysqlSqlGenerator.getCreateSchemaQuery("test_schema2");
        assertEquals("create schema `test_schema2`", createDatabaseQuery);
    }

    @Test
    public void createSchemaIsEmptyQueryTest() {
        String createDatabaseQuery = mysqlSqlGenerator.getCreateSchemaQuery("");
        assertEquals("schema can not be empty!", createDatabaseQuery);
    }

    @Test
    public void createSchemaIsNullQueryTest() {
        try {
            mysqlSqlGenerator.getCreateSchemaQuery(null);
        } catch (NullPointerException e) {
            assertEquals("schema is null", e.getMessage());
        }
    }

    @Test
    public void dropSchemaQueryTest() {
        String dropDatabaseQuery = mysqlSqlGenerator.getDropSchemaQuery("test_schema2");
        assertEquals("drop schema `test_schema2`", dropDatabaseQuery);
    }

    @Test
    public void dropSchemaIsNullQueryTest() {
        try {
            mysqlSqlGenerator.getDropSchemaQuery(null);
        } catch (NullPointerException e) {
            assertEquals("schema is null", e.getMessage());
        }

    }

}
