package model;

public class Storage {
    private String name_storage;
    private String adress;
    public Storage(String name_storage, String adress){
        this.name_storage = name_storage;
        this.adress = adress;
    }

    public  String getNameStorage(){
        return name_storage;
    }

    public String getAdress(){
        return adress;
    }
}
