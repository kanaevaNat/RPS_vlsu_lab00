package dao;
import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDAO extends DAO{
    private Connection connection;

    public Product getOneById(int prod_id){
        try {
            connection = ds.getConnection(user, password);
            String getCommand = "SELECT * FROM rps_lab1.Product WHERE product_id = ?";
            PreparedStatement select = connection.prepareStatement(getCommand);
            select.setInt(1, prod_id);
            ResultSet result = select.executeQuery();
            result.next();
            String name_product = result.getString("name_product");
            int storage_life = result.getInt("storage_life");
            float weight = result.getFloat("weight");
            int id_storage = result.getInt("id_storage");
            return new Product(name_product, storage_life, weight, id_storage);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Product> getAll(){
        try {
            List<Product> prodList = new ArrayList<Product>();
            connection = ds.getConnection(user, password);
            String getCommand = "SELECT * FROM rps_lab1.Product";
            PreparedStatement select = connection.prepareStatement(getCommand);
            ResultSet result = select.executeQuery();
            while (result.next()){
                int product_id = result.getInt("product_id");
                String name_product = result.getString("name_product");
                int storage_life = result.getInt("storage_life");
                float weight = result.getFloat("weight");
                int id_storage = result.getInt("id_storage");
                Product prod = new Product(name_product, storage_life, weight, id_storage);
                prodList.add(prod);
            }
            return prodList;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public boolean add(Product prod){
        try{
            connection = ds.getConnection(user, password);
            String insertCommand = "INSERT INTO rps_lab1.Product(name_product, storage_life, weight, id_storage) VALUES(?,?,?,?)";
            PreparedStatement insert = connection.prepareStatement(insertCommand);
            insert.setString(1, prod.getNameProduct());
            insert.setInt(2, prod.getStorageLife());
            insert.setFloat(3,prod.getWeight());
            insert.setInt(4,prod.getStorageID());
            if (insert.executeUpdate()>0) return true;
            insert.execute();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean update(int id, Product prod){
        try{connection = ds.getConnection(user, password);
            String updateCommand = "UPDATE rps_lab1.Product SET name_product = ?, storage_life = ?, weight = ?, id_storage = ? WHERE product_id = ?";
            PreparedStatement update = connection.prepareStatement(updateCommand);
            update.setString(1,prod.getNameProduct());
            update.setInt(2,prod.getStorageLife());
            update.setFloat(3,prod.getWeight());
            update.setInt(4,prod.getStorageID());
            update.setInt(5,id);
            update.execute();
            if (update.executeUpdate()>0) return true;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean delete(int product_id) {
        try{
            connection = ds.getConnection(user,password);
            String deleteCommand = "DELETE FROM rps_lab1.Product WHERE product_id = ?";
            PreparedStatement delete = connection.prepareStatement(deleteCommand);
            delete.setInt(1, product_id);
            delete.execute();
            if (delete.executeUpdate()>0) return true;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
