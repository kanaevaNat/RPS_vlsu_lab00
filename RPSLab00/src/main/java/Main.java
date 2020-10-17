import dao.StorageDAO;
import dao.ProductDAO;
import model.Storage;
import model.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductDAO prodDAO = new ProductDAO();
        StorageDAO storDAO = new StorageDAO();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("1 - Create product");
        System.out.println("2 - Read product");
        System.out.println("3 - Update product");
        System.out.println("4 - Delete product");
        System.out.println("5 - Update storage");
        System.out.println("6 - Read storage");
        System.out.println("7 - Create storage");
        System.out.println("8 - Delete storage");
        System.out.println("9 - Exit");
        boolean k = true;
        while(k){
            System.out.println("Input command");
            int command = scanner.nextInt();
            switch (command){
                case 1:
                    System.out.print("Name product: ");
                    String name_product = scanner.next();
                    System.out.print("Storage life: ");
                    int storage_life = scanner.nextInt();
                    System.out.print("Weight: ");
                    float weight = scanner.nextFloat();
                    System.out.print("Storage: ");
                    int id_storage = scanner.nextInt();
                    prodDAO.add(new Product(name_product, storage_life, weight, id_storage));
                    break;
                case 2:
                    System.out.println("Input id");
                    int id = scanner.nextInt();
                    Product prod = prodDAO.getOneById(id);
                    System.out.print("Name product: ");
                    System.out.println(prod.getNameProduct());
                    System.out.print("Storage life: ");
                    System.out.println(prod.getStorageLife());
                    System.out.print("Weight: ");
                    System.out.println(prod.getWeight());
                    Storage star = storDAO.getOneById(prod.getStorageID());
                    System.out.print("Storage: ");
                    System.out.println(star.getNameStorage());
                    break;
                case 3:
                    System.out.println("Input id");
                    int idd = scanner.nextInt();
                    System.out.println("Name Product: ");
                    String updName = scanner.next();
                    System.out.println("Storage Life: ");
                    int updStorageLife = scanner.nextInt();
                    System.out.println("Weight: ");
                    float updWeight = scanner.nextFloat();
                    System.out.println("Storage: ");
                    int updStorage = scanner.nextInt();
                    prodDAO.update(idd,new Product(updName, updStorageLife, updWeight, updStorage));
                    break;
                case 4:
                    System.out.println("Input id");
                    int delId = scanner.nextInt();
                    prodDAO.delete(delId);
                    break;
                case 5:
                    System.out.println("Input id");
                    int idS = scanner.nextInt();
                    System.out.println("Name Storage: ");
                    String updNameS = scanner.next();
                    System.out.println("Address: ");
                    String updAdress = scanner.next();
                    storDAO.update(idS,new Storage(updNameS, updAdress));
                    break;
                case 6:
                    System.out.println("Input id");
                    int idStor = scanner.nextInt();
                    Storage stor = storDAO.getOneById(idStor);
                    System.out.print("Name product: ");
                    System.out.println(stor.getNameStorage());
                    System.out.print("Storage life: ");
                    System.out.println(stor.getAdress());
                    break;
                case 7:
                    System.out.print("Name storage: ");
                    String nameS = scanner.next();
                    System.out.print("Address: ");
                    String addr = scanner.next();
                    storDAO.add(new Storage(nameS, addr));
                    break;
                case 8:
                    System.out.println("Input id");
                    int deleteId = scanner.nextInt();
                    storDAO.delete(deleteId);
                    break;
                case 9:
                    k = false;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }
}
