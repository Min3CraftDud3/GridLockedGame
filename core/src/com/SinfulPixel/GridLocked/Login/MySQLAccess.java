package com.SinfulPixel.GridLocked.Login;
/**
 * Created by Min3 on 4/21/2014.
 * Usage:
 * MySQLAccess dao = new MySQLAccess();
   try{dao.readDataBase();}catch(Exception i){}
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            // this will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // setup the connection with the DB.
            connect = DriverManager.getConnection("jdbc:mysql://192.3.118.3/ldwppckc_GridLocked?"+"user=ldwppckc_Java&password=Min3CraftDud3");
            // statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // resultSet gets the result of the SQL query
            resultSet = statement.executeQuery("select * from ldwppckc_GridLocked.USERS");
            writeResultSet(resultSet);
            // preparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("insert into  ldwppckc_GridLocked.USERS values (default, ?, ?, ?, ?)");
            // "myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
            // parameters start with 1
            preparedStatement.setString(1, "Test");
            preparedStatement.setString(2, "TestPass");
            preparedStatement.setString(3, "TestEmail");
            preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
            preparedStatement.executeUpdate();
            preparedStatement = connect.prepareStatement("SELECT myuser, passw, email, datum from ldwppckc_GridLocked.USERS");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);
            // remove again the insert comment
            preparedStatement = connect.prepareStatement("delete from ldwppckc_GridLocked.USERS where myuser= ? ; ");
            preparedStatement.setString(1, "Test");
            preparedStatement.executeUpdate();
            resultSet = statement.executeQuery("select * from ldwppckc_GridLocked.USERS");
            writeMetaData(resultSet);
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            preparedStatement.close();
            resultSet.close();
            connect.close();
        }
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        // now get some metadata from the database
        System.out.println("The columns in the table are: ");
        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // resultSet is initialised before the first data set
        while (resultSet.next()) {
            // it is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g., resultSet.getSTring(2);
            String user = resultSet.getString("myuser");
            String pass = resultSet.getString("passw");
            String email = resultSet.getString("email");
            Date date = resultSet.getDate("datum");
            System.out.println("User: " + user);
            System.out.println("Website: " + pass);
            System.out.println("Summary: " + email);
            System.out.println("Date: " + date);
        }
    }

    private void close() throws SQLException{
        preparedStatement.close();
        resultSet.close();
        connect.close();
    }
}