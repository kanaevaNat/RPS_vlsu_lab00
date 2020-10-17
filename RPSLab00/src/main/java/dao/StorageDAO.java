package dao;
import model.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StorageDAO extends DAO{
    private Connection connection;

    public Storage getOneById(int storage_id){
        try{
            connection = ds.getConnection(user, password);
            String selectCommand = "SELECT * FROM rps_lab1.Storage WHERE storage_id = ?";
            PreparedStatement select = connection.prepareStatement(selectCommand);
            select.setInt(1, storage_id);
            ResultSet result = select.executeQuery();
            result.next();
            String name_storage = result.getString("name_storage");
            String adress = result.getString("adress");

            return new Storage(name_storage, adress);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Storage> getAll(){
        try{
            List<Storage> storList = new ArrayList<Storage>();
            connection = ds.getConnection(user, password);
            String selectCommand = "SELECT * FROM rps_lab1.Storage";
            PreparedStatement select = connection.prepareStatement(selectCommand);
            ResultSet result = select.executeQuery();
            while(result.next()){
                int storage_id = result.getInt("storage_id");
                String name_storage = result.getString("name_storage");
                String adress = result.getString("adress");
                Storage stor = new Storage(name_storage, adress);
                storList.add(stor);
            }
            return storList;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void add(Storage stor){
        try{
            connection = ds.getConnection(user, password);
            String insertCommand = "INSERT INTO rps_lab1.Storage(name_storage,adress) VALUES(?,?)";
            PreparedStatement insert = connection.prepareStatement(insertCommand);
            insert.setString(1, stor.getNameStorage());
            insert.setString(2, stor.getAdress());
            insert.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void update(int id,Storage stor){
        try{
            connection = ds.getConnection(user, password);
            String updateCommand = "UPDATE rps_lab1.Storage SET name_storage = ?, adress = ? WHERE storage_id = ?";
            PreparedStatement update = connection.prepareStatement(updateCommand);
            update.setString(1, stor.getNameStorage());
            update.setString(2, stor.getAdress());
            update.setInt(3,id);
            update.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(int storage_id){
        try{
            connection = ds.getConnection(user, password);
            String deleteCommand = "DELETE FROM rps_lab1.Storage WHERE storage_id = ?";
            PreparedStatement delete = connection.prepareStatement(deleteCommand);
            delete.setInt(1, storage_id);
            delete.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}