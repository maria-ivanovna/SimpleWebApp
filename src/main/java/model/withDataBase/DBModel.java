package model.withDataBase;

import entities.withDataBase.DBUser;

import java.sql.*;
import java.util.ArrayList;

public class DBModel {
    public static final String URL = "jdbc:postgresql://localhost:5432/userlist";
    public static final String USERNAME = "postgresql_user";
    public static final String PASSWORD = "4149";
    public static final String DRIVER = "org.postgresql.Driver";

    private static volatile DBModel instance;

    private DBModel(){}
    public static DBModel getInstance(){
        if(instance == null){
            synchronized (DBModel.class){
                if(instance == null){
                    instance = new DBModel();
                }
            }
        }
        return instance;
    }

    public  ArrayList<DBUser> select(){
        ArrayList<DBUser> dbUsers = new ArrayList<DBUser>();
        try{
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
            try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    DBUser dbUser = new DBUser(id, name);
                    dbUsers.add(dbUser);
                }
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return dbUsers;
    }
    public DBUser selectOne(int selectId){
        DBUser dbUser = null;
            try{
                Class.forName(DRIVER).getDeclaredConstructor().newInstance();
                try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
                    try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id=?")){
                        preparedStatement.setInt(0, selectId);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if(resultSet.next()){
                            int id = resultSet.getInt(1);
                            String name = resultSet.getString(2);
                            dbUser = new DBUser(id, name);
                        }
                    }
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
        return dbUser;
    }
    public int insert (DBUser dbUser){
        try{
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
            try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
                try(PreparedStatement preparedStatement = connection
                        .prepareStatement("INSERT INTO users( name, password) Values (?, ?)")){
                    preparedStatement.setString(1, dbUser.getName());
                    preparedStatement.setString(2, dbUser.getPass());
                    return preparedStatement.executeUpdate();
                }
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public int update(DBUser dbUser){
        try{
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
            try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
                try(PreparedStatement preparedStatement = connection
                        .prepareStatement("UPDATE users SET name = ?, password = ? WHERE id = ?")){
                    preparedStatement.setString(1, dbUser.getName());
                    preparedStatement.setString(2, dbUser.getPass());
                    return preparedStatement.executeUpdate();
                }
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public int delete(int id){
        try{
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
            try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
                try(PreparedStatement preparedStatement = connection
                        .prepareStatement("DELETE FROM users WHERE id = ?")){
                    preparedStatement.setInt(1, id);
                    return preparedStatement.executeUpdate();
                }
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
