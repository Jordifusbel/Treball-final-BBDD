package org.mvpigs;
import java.sql.*;

public class Jdbc {
    public boolean Logged = false;


    public Connection connectDB(){
        try{
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName); // here is the ClassNotFoundException

            String serverName = "localhost";
            String mydatabase = "bestiary";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";
            String password = "lersimchaat";
            Connection connection = DriverManager.getConnection(url, username, password);
            Logged = true;
            return  connection;
        } catch (Exception e){
            return null;
        }
    }

    public ResultSet getAllEntrys(Connection connection){
        try {
            Statement st = connection.createStatement();
            return st.executeQuery("Select * from monsters");
        } catch (Exception e){
            return  null;
        }
    }

    public boolean updateMonster (Connection connection, int id, String name, String cr, String type, String alignment) {
        try
        {
            PreparedStatement ps = connection.prepareStatement("UPDATE monsters SET name = ?, cr= ?, type = ?, alignment = ? WHERE id = ?;");

            ps.setString(1,name);
            ps.setString(2,cr);
            ps.setString(3,type);
            ps.setString(4,alignment);
            //ps.setInt(5,id);

            ps.executeUpdate();
            return true;
        }
        catch (SQLException e)
        {
            return false;
        }
    }

    public boolean deleteMonster (Connection connection, int id) {
        try
        {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM monsters WHERE id = " + id + ";");
            ps.executeUpdate();
            return true;
        }
        catch (SQLException se)
        {
            return false;
        }

    }

    public boolean insertMonster (Connection connection, String name, String cr, String type, String alignment) {
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO monsters (name, cr, type, alignment)" + "VALUES ('" + name + "', '" + cr + "', '" + type + "', '" + alignment +"');");
            return true;
        }
        catch (SQLException se)
        {
            return false;
        }
    }
}