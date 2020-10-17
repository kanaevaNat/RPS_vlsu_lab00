package model;

public class Product {
    private String name_product;
    private int storage_life;
    private float weight;
    private int id_storage;
    public Product(String name_product, int storage_life, float weight, int id_storage){
        this.name_product = name_product;
        this.storage_life = storage_life;
        this.weight = weight;
        this.id_storage = id_storage;
    }

    public  String getNameProduct(){
        return name_product;
    }

    public int getStorageLife(){
        return storage_life;
    }

    public  float getWeight(){
        return weight;
    }

    public int getStorageID(){
        return id_storage;
    }
}
