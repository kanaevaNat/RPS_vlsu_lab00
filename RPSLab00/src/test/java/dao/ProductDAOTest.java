package dao;

import model.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOTest {

    @org.junit.jupiter.api.Test
    void getOneById() {
        System.out.println("Get by id test");
        int id=2;
        ProductDAO prodDAO=new ProductDAO();
        Product prod = prodDAO.getOneById(id);
        assertEquals(prod.getNameProduct(), "Table", "False");
    }

    @org.junit.jupiter.api.Test
    void add() {
        System.out.println("Insert test");
        String nameT="Food";
        int storL=12;
        float weig=4;
        int idS=1;
        ProductDAO prodDAO=new ProductDAO();
        boolean real = prodDAO.add(new Product(nameT,storL,weig,idS));
        assertEquals(true, real, "False");
    }

    @org.junit.jupiter.api.Test
    void update() {
        System.out.println("Update test");
        int id=4;
        String nameT="FoodTest";
        int storL=12;
        float weig=4;
        int idS=1;
        ProductDAO prodDAO=new ProductDAO();
        boolean real = prodDAO.update(id,new Product(nameT,storL,weig,idS));
        assertEquals(true, real, "False");
    }

    @org.junit.jupiter.api.Test
    void delete() {
        System.out.println("Delete test");
        int id=10;
        ProductDAO prodDAO=new ProductDAO();
        boolean real = prodDAO.delete(id);
        assertEquals(false, real, "False");
    }
}