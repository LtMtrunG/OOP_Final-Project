package com.example.guifinal.Customer;

import com.example.guifinal.Interfaces.SortByID;
import com.example.guifinal.Interfaces.SortByNameOrTitle;

import java.util.ArrayList;

public class CustomerList implements SortByID, SortByNameOrTitle {
    //Attribute
    private ArrayList<Customer> list = new ArrayList<Customer>();

    //Constructor
    public CustomerList(){};

    //Methods
    public ArrayList<Customer> getList() {return list;}

    public void add(Customer customer){
        list.add(customer);
    }

    public void remove(Customer customer){
        list.remove(customer);
    }

    public void sortByID(){
        this.getList().sort(new CustomerByID());
    }

    @Override
    public void sortByNameOrTitle() {
        this.getList().sort(new CustomerByName());
    }

    public Customer getCustomerAt(int i) {
        return list.get(i);
    }

    public int getSize() {
        return list.size();
    }
}
