package jdbctests;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dynamic_list {

    String dbUrl = "jdbc:oracle:thin:@3.80.189.73:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";
    @Test
    public void dynamic_list() throws SQLException {
        //create connection
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        //create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("select * from countries");

        //get the resultset object metadata
        ResultSetMetaData rsMetadata = resultSet.getMetaData();

        //list for keeping all rows a map
        List<Map<String,Object>> queryData = new ArrayList<>();

        //number of columns
        int colCount = rsMetadata.getColumnCount();

        //loop through each row to get all the columns and rows in database g sql data base of hr
        while(resultSet.next()){
            Map<String,Object> row = new HashMap<>();

            for (int i = 1; i <=colCount; i++) {

                //looping through every column and saving rows and column  information in  map<key,value>
                // whoz name is row(in line 36)
                //rsmetadata gets data of clmns n rows from database on basis of i iteration n saving it in row(map)
                //in shape of key and values structure e.g name of column n its value
                row.put(rsMetadata.getColumnName(i),resultSet.getObject(i));

            }

            //after above adding evry row(map) in list of maps=queryData cz we have so many rows and columns
            //add your map to your list
            queryData.add(row);
        }


        //print the result  but outside the above both loops and in each loop
        //change querydata list of map into map row and print all..cz u cant print list of map direstly
        for (Map<String, Object> row : queryData) {
            System.out.println(row.toString());
        }

        //close all connections
        resultSet.close();
        statement.close();
        connection.close();
    }


}