package generator;

import java.util.List;

public interface SqlGenerator {

    // Query example - DROP TABLE schema.tableName
    String getDropTableQuery(String tableName, String schema)throws NullPointerException;

    // Query example - TRUNCATE TABLE schema.tableName
    String getTruncateTableQuery(String tableName, String schema)throws NullPointerException;

    // Query example - INSERT INTRO schema.tableName (COLUMNS) (? ,? ,? ...)
    String getBatchInsertQuery(String tableName, String schema, List<String> columns)throws NullPointerException;

    // Query example - ALTER TABLE schema.tableName DISABLE CONSTRAINT constraintName
    String getDisableConstraintQuery(String tableName, String constraintName, String schema)throws NullPointerException;

    // Query example - ALTER TABLE schema.tableName ENABLE CONSTRAINT constraintName
    String getEnableConstraintQuery(String tableName, String constraintName, String schema)throws NullPointerException;

    // Query example - SELECT count(*) FROM schema.tableName
    String getSelectCountQuery(String tableName, String schema)throws NullPointerException;

    // Query example - CREATE DATABASE databaseName
    String getCreateDatabaseQuery(String databaseName, String schema)throws NullPointerException;

    // Query example - DROP DATABASE databaseName
    String getDropDatabaseQuery(String databaseName, String schema)throws NullPointerException;

    // Query example - CREATE SCHEMA schema
    String getCreateSchemaQuery(String schema)throws NullPointerException;

    // Query example - DROP SCHEMA schema
    String getDropSchemaQuery(String schema)throws NullPointerException;


}
