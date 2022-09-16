package com.example.guifinal.Customer;

import java.util.Comparator;

public class CustomerByID implements Comparator<Customer> {
    public int compare(Customer customer1, Customer customer2) {
        int minLength = Math.min(customer1.getId().length(), customer2.getId().length());
        for (int i = 0; i < minLength; i++) {
            int ID1 = (int) customer1.getId().charAt(i);
            int ID2 = (int) customer2.getId().charAt(i);
            if (ID1 < ID2) {
                return -1;
            }
            if (ID1 > ID2) {
                return 1;
            }
        }
        if (customer1.getId().length() < customer2.getId().length()) {
            return -1;
        }
        if (customer1.getId().length() > customer2.getId().length()) {
            return 1;
        }
        return 0;
    }
}
