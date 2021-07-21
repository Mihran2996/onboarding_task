package generator;

import org.jooq.DSLContext;
import org.jooq.DropTableStep;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.util.List;

public class PostgresSqlGenerator implements SqlGenerator {

    private final DSLContext JOOQ_CONTEXT = DSL.using(SQLDialect.POSTGRES);

    @Override
    public String getDropTableQuery(String tableName, String schema) {
//        DropTableStep query = JOOQ_CONTEXT.dropTable(schema + "." +tableName);
//        String sql = query.getSQL();
//        return sql;
        return null;
    }

    @Override
    public String getTruncateTableQuery(String tableName, String schema) {
        return null;
    }

    @Override
    public String getBatchInsertQuery(String tableName, String schema, List<String> columns) {
        return null;
    }

    @Override
    public String getDisableConstraintQuery(String tableName, String constraintName, String schema) {
        return null;
    }

    @Override
    public String getEnableConstraintQuery(String tableName, String constraintName, String schema) {
        return null;
    }

    @Override
    public String getSelectCountQuery(String tableName, String schema) {
        return null;
    }

    @Override
    public String getCreateDatabaseQuery(String databaseName, String schema) {
        return null;
    }

    @Override
    public String getDropDatabaseQuery(String databaseName, String schema) {
        return null;
    }

    @Override
    public String getCreateSchemaQuery(String schema) {
        return null;
    }

    @Override
    public String getDropSchemaQuery(String schema) {
        return null;
    }
}
