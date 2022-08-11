package SystemManagement;

import Customer.*;
import Item.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Functions extends Item{
    public static boolean addItem(ItemList itemList){
        Item item = Item.createItem();
        return itemList.add(item);
    }

    public static boolean updateItem(ItemList itemList){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an ID or title of an item you wanted to update: ");
        String searchString = scanner.next();
        Item item = itemList.searchItem(searchString);
        if(item == null){return false;}
        return item.update();
    }

    public static boolean deleteItem(ItemList itemList){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an ID or title of an item you wanted to delete: ");
        String searchString = scanner.next();
        Item item = itemList.searchItem(searchString);
        if(item == null){return false;}
        itemList.remove(item);
        return true;
    }

    public static boolean addCustomer(CustomerList customerList){
        Customer c = GuestAccount.createAccount();
       return customerList.add(c);
    }

    public static boolean updateCustomer(CustomerList customerList){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an ID or name of an customer you wanted to update: ");
        String searchString = scanner.next();
        Customer c = customerList.searchCustomer(searchString);
        if(c == null){return false;}
        return c.update();
    }

    public static boolean promoteCustomer(Customer customer){
        Customer unpromotedCustomer = customer;
        customer = customer.promote();
        if(unpromotedCustomer == customer){return  false;}
        return true;
    }

    public static boolean rent(ItemList itemList, Customer customer){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an ID or title of an item you wanted to rent: ");
        String searchString = scanner.next();
        Item item = itemList.searchItem(searchString);
        if(!item.isStatus()) {System.out.println("This item is not available (Out of Stock)!"); return false;}
        if(customer.rent(item)){
            item.modifyCopies(-1);
            return true;
        }
        return false;
    }

    public static boolean returnItem(ItemList itemList, Customer customer){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an ID or title of an item you wanted to rent: ");
        String searchString = scanner.next();
        Item item = itemList.searchItem(searchString);
        if(customer.itemReturn(item)){
            item.modifyCopies(1);
            return true;
        }
        return false;
    }

    public static void displayItem(ItemList itemList){
        for(Item item: itemList.getList()){
            System.out.println(item);
        }
    }

    public static void displayOOSItem(ItemList itemList){
        ItemList out_of_stockItem = itemList.findOutOfStock();
        displayItem(out_of_stockItem);
    }

    public static void displayCustomer(CustomerList customerList){
        for(Customer customer: customerList.getList()){
            System.out.println(customer);
        }
        System.out.println();
    }

    public static void displayGuestCustomer(CustomerList customerList){
        ArrayList<Customer> result = new ArrayList<>();
        for(Customer customer: customerList.getList()){
            if(customer instanceof GuestAccount){
                result.add(customer);
            }
        }
        System.out.println("-----Guest Account-----");
        for(Customer customer: result){
            System.out.println(customer);
        }
        System.out.println();
    }

    public static void displayRegularCustomer(CustomerList customerList){
        ArrayList<Customer> result = new ArrayList<>();
        for(Customer customer: customerList.getList()){
            if(customer instanceof RegularAccount){
                result.add(customer);
            }
        }
        System.out.println("-----Regular Account-----");
        for(Customer customer: result){
            System.out.println(customer);
        }
        System.out.println();
    }

    public static void displayVIPAccount(CustomerList customerList){
        ArrayList<Customer> result = new ArrayList<>();
        for(Customer customer: customerList.getList()){
            if(customer instanceof VIPAccount){
                result.add(customer);
            }
        }
        System.out.println("-----VIP Account-----");
        for(Customer c: result){
            System.out.println(c);
        }
        System.out.println();
    }

    public static boolean search(ItemList itemList, CustomerList customerList){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 1 for search item or 2 for search customer: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        switch (num) {
            case 1:
                System.out.print("Enter an ID or title of an item you wanted to update: ");
                String searchItem = scanner.next();
                Item item = itemList.searchItem(searchItem);
                if (item != null) {
                    return true;
                }
                return false;
            case 2:
                System.out.print("Enter an ID or name of an customer you wanted to update: ");
                String searchCustomer = scanner.next();
                Customer customer = customerList.searchCustomer(searchCustomer);
                if (customer != null) {
                    return true;
                }
                return false;
            default:
                System.out.println("You can only select 1 or 2.");
                return false;
        }
    }
}
