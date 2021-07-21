package generator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String query = "";
        String schema="test_schema";
        String table="user";
        MysqlSqlGenerator mysqlSqlGenerator = new MysqlSqlGenerator();


        //drop table
//        query = mysqlSqlGenerator.getDropTableQuery(table,schema);
//        System.out.println(query);


        //truncate table
//        query = mysqlSqlGenerator.getTruncateTableQuery(table,schema);
//        System.out.println(query);


        //insert table
//         query = mysqlSqlGenerator.getBatchInsertQuery(table, schema, Arrays.asList("name", "surname"));
//        System.out.println(query);


        //create database
//        query = mysqlSqlGenerator.getCreateDatabaseQuery("dt_test4","dt_schema");
//        System.out.println(query);


        //Drop database
////        query = mysqlSqlGenerator.getDropDatabaseQuery("dt_test4",schema);
//        System.out.println(query);

        //count
//        query = mysqlSqlGenerator.getSelectCountQuery(table, schema);
//        System.out.println(query);

        //create schema
//        query = mysqlSqlGenerator.getCreateSchemaQuery(schema);
//        System.out.println(query);

        //drop schema
//        query = mysqlSqlGenerator.getDropSchemaQuery(schema);
//        System.out.println(query);

    }
}
