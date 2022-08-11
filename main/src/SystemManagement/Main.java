package SystemManagement;

import Customer.CustomerList;
import Item.ItemList;

import java.util.Scanner;

import static SystemManagement.Functions.*;

public class Main {

    public static void menu(){
        System.out.println("-----Welcome to the Store-----");
        System.out.println("1. Add A New Item.Item, Interfaces.Update or Delete An Existing Item.Item.");
        System.out.println("2. Add New Customer.Customer or Interfaces.Update An Existing Customer.Customer.");
        System.out.println("3. Promote An Existing Customer.Customer.");
        System.out.println("4. Interfaces.Rent An Item.Item.");
        System.out.println("5. Interfaces.Return An Item.Item.");
        System.out.println("6. Display All Items.");
        System.out.println("7. Display Out-of-Stock Items.");
        System.out.println("8. Display All Customers.");
        System.out.println("9. Display Group of Customers.");
        System.out.println("10. Search Items or Customers.");
    }


    public static void run() {
        ItemList itemList = new ItemList();
        CustomerList customerList = new CustomerList();

        menu();

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter an option(eg: 1 or 2 or 3 or...): ");
        int num = scanner.nextInt();
        scanner.nextLine();
        System.out.println("-----------------------------------------");
        switch (num) {
            case 1:
                System.out.println("1. Add A New Item.");
                System.out.println("2. Update An Existing Item.");
                System.out.println("3. Delete An Existing Item.");
                System.out.printf("Enter an option(eg: 1 or 2 or 3): ");
                int option1 = scanner.nextInt();
                scanner.nextLine();
                switch(option1){
                    case 1:
                        addItem(itemList);
                    case 2:
                        updateItem(itemList);
                    case 3:
                        deleteItem(itemList);
                    default:
                        System.out.println("You can only select 1 or 2 or 3.");
                }
            case 2:
                System.out.println("1. Add A New Item.Item.");
                System.out.println("2. Interfaces.Update An Existing Item.Item.");
                System.out.printf("Enter an option(eg: 1 or 2): ");
                int option2 = scanner.nextInt();
                scanner.nextLine();
                switch(option2) {
                    case 1:
                        addCustomer(customerList);
                    case 2:
                        updateCustomer(customerList);
                    default:
                        System.out.println("You can only select 1 or 2.");
                }
            case 3:

        }
    }

    public static void main (String[] args){}
}


