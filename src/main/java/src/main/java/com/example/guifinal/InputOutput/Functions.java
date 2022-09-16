package com.example.guifinal.InputOutput;

import com.example.guifinal.Customer.*;
import com.example.guifinal.Item.*;
import com.example.guifinal.InputOutput.*;
import com.example.guifinal.Item.Item;

public class Functions extends Item {
    public static ItemList readItemListFile() {
        return ReadItem.readItemFile();
    }

    public static CustomerList readCustomerListFile() {
        return ReadCustomer.readCustomerFile();
    }

    public static boolean saveFiles(ItemList itemList, CustomerList customerList) {
        SaveItem saveItemFile = new SaveItem(itemList);
        if (SaveItem.saveItemFile()) {
            System.out.println("Successfully update items.txt");
        } else {
            System.out.println("Cannot update items.txt");
            return false;
        }

        SaveCustomer saveCustomerFile = new SaveCustomer(customerList);
        if (SaveCustomer.saveCustomerFile()) {
            System.out.println("Successfully update customers.txt");
        } else {
            System.out.println("Cannot update customers.txt");
            return false;
        }

        return true;
    }
}
