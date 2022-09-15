package com.example.guifinal.InputOutput;

import com.example.guifinal.Customer.CustomerList;

import java.io.*;

import com.example.guifinal.Customer.RegularAccount;
import com.example.guifinal.Customer.VIPAccount;

public class SaveCustomer {

    private static CustomerList customerList = new CustomerList();

    public SaveCustomer() {};
    public SaveCustomer(CustomerList customerList) {
        this.customerList = customerList;
    }

    public static boolean saveCustomerFile() {
        File file = new File("." + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Data" + File.separator + "customers.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            for (int i = 0; i < customerList.getSize(); i++) {
                if (customerList.getCustomerAt(i) instanceof VIPAccount) {
                    fr.write(customerList.getCustomerAt(i).writeCustomer("VIP"));
                } else if (customerList.getCustomerAt(i) instanceof RegularAccount) {
                    fr.write(customerList.getCustomerAt(i).writeCustomer("Regular"));
                } else {
                    fr.write(customerList.getCustomerAt(i).writeCustomer("Guest"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close resources
            try {
                fr.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
