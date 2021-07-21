package generator;

import connection.JdbcConnectionProvider;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.List;

import static java.lang.String.format;
import static org.jooq.impl.DSL.*;

public class MysqlSqlGenerator implements SqlGenerator {
    private final DSLContext JOOQ_CONTEXT = DSL.using(JdbcConnectionProvider.getProvider().getConnection(), SQLDialect.MYSQL);

    @Override
    public String getDropTableQuery(String tableName, String schema) throws NullPointerException {
        checkTableNameSchema(tableName, schema);
        if (tableName.equals("") || schema.equals("")) {
            return "table or schema can not be empty!";
        }
        Name tableNameWithSchema = DSL.name(schema, tableName);
        DropTableStep dropTableStep = JOOQ_CONTEXT.dropTableIfExists(tableNameWithSchema);
        dropTableStep.execute();
        return dropTableStep.getSQL();
    }

    @Override
    public String getTruncateTableQuery(String tableName, String schema) throws NullPointerException {
        checkTableNameSchema(tableName, schema);
        if (tableName.equals("") || schema.equals("")) {
            return "table or schema can not be empty!";
        }
        Name tableNameWithSchema = DSL.name(schema, tableName);
        TruncateFinalStep<Record> cascade = JOOQ_CONTEXT.truncate(tableNameWithSchema);
        cascade.execute();
        return cascade.getSQL();
    }

    @Override
    public String getBatchInsertQuery(String tableName, String schema, List<String> column) throws NullPointerException {
        if (tableName == null | schema == null | column == null) {
            throw new NullPointerException("tableName,schema or column is null");
        } else if (tableName.equals("") || schema.equals("")) {
            return "table or schema can not be empty!";
        } else if (column.isEmpty()) {
            return "columns can not be empty!";
        } else if (column.size() != 2 | column.get(0).equals("") | column.get(1).equals("")) {
            return "name or surname can not be empty!";
        }
        Name tableNameWithSchema = DSL.name(schema, tableName);
        InsertSetMoreStep<Record> set = JOOQ_CONTEXT
                .insertInto(table(tableNameWithSchema))
                .set(field(name("name")), column.get(0))
                .set(field(name("surname")), column.get(1));
        set.execute();
        return set.getSQL();
    }

    @Override
    public String getDisableConstraintQuery(String tableName, String constraintName, String schema) throws NullPointerException {
        //todo
        return null;
    }

    @Override
    public String getEnableConstraintQuery(String tableName, String constraintName, String schema) throws NullPointerException {
        //todo
        return null;
    }

    @Override
    public String getSelectCountQuery(String tableName, String schema) throws NullPointerException {
        checkTableNameSchema(tableName, schema);
        if (tableName.equals("") || schema.equals("")) {
            return "table or schema can not be empty!";
        }
        Name tableNameWithSchema = DSL.name(schema, tableName);
        Integer result = JOOQ_CONTEXT.selectCount()
                .from(tableNameWithSchema)
                .fetchOne().value1();
        return String.valueOf(result);
    }

    @Override
    public String getCreateDatabaseQuery(String databaseName, String schema) throws NullPointerException {
        checkValue(databaseName,"database");
        if (databaseName.equals("")) {
            return "database can not be empty!";
        }
        CreateDatabaseFinalStep test2 = JOOQ_CONTEXT.createDatabase(databaseName);
        test2.execute();
        return test2.getSQL();
    }

    @Override
    public String getDropDatabaseQuery(String databaseName, String schema) throws NullPointerException {
        checkValue(databaseName,"database");
        if (databaseName.equals("")) {
            return "database can not be empty!";
        }
        DropDatabaseFinalStep dropDatabaseFinalStep = JOOQ_CONTEXT.dropDatabase(databaseName);
        dropDatabaseFinalStep.execute();
        return dropDatabaseFinalStep.getSQL();
    }

    @Override
    public String getCreateSchemaQuery(String schema) throws NullPointerException {
        checkValue(schema,"schema");
        if (schema.equals("")) {
            return "schema can not be empty!";
        }
        CreateSchemaFinalStep schema1 = JOOQ_CONTEXT.createSchema(schema);
        schema1.execute();
        return schema1.getSQL();
    }

    @Override
    public String getDropSchemaQuery(String schema) throws NullPointerException {
        checkValue(schema,"schema");
        if (schema.equals("")) {
            return "schema can not be empty!";
        }
        DropSchemaStep dropSchemaStep = JOOQ_CONTEXT.dropSchema(schema);
        dropSchemaStep.execute();
        return dropSchemaStep.getSQL();
    }

    private void checkTableNameSchema(String tableName, String schema) {
        if (tableName == null || schema == null) {
            throw new NullPointerException("tableName or schema is null");
        }
    }

    private void checkValue(String value,String name) {
        if (value == null) {
            String format = format("%s is null", name);
            throw new NullPointerException(format);
        }
    }
}
