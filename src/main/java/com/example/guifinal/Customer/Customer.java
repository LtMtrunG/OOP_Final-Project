package com.example.guifinal.Customer;

import com.example.guifinal.Item.Item;

import java.util.ArrayList;

public abstract class Customer {
    //Attributes
    private String id;
    private String name;
    private String address;
    private String phone;
    private ArrayList<Item> rentalList;
    private String username;
    private String password;
    private int successfullyReturn;

    //Constructors
    public Customer(){};

    public Customer(String ID, String name, String address, String phone, ArrayList<Item> rentalList,String username, String password, int successfullyReturn) {
        this.id = ID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.rentalList = rentalList;
        this.username = username;
        this.password = password;
        this.successfullyReturn = successfullyReturn;
    }

    //Methods
    public String getId() {return id;}

    protected void setId(String input) {
        //               0123
        //Valid ID Form 'Cxxx'
        while (true) {
            if (input.length() != 4) {break;}
            char[] ID = input.toCharArray();
            if (ID[0] != 'C') {break;}
            for (int index = 1; index < 4; index++) {
                if (!Character.isDigit(ID[index])) {break;}
                this.id = input;
                return;
            }
            System.out.println("Invalid input for ID!");
        }
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public ArrayList<Item> getRentalList() {return rentalList;}

    public void setRentalList(ArrayList<Item> rentalList) {this.rentalList = rentalList;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public int getSuccessfullyReturn() {return successfullyReturn;}

    public void setSuccessfullyReturn(int successfullyReturn) {this.successfullyReturn = successfullyReturn;}


    public String writeCustomer(String customerType) {
        String str = id + "," +
                    name + "," +
                    address + "," +
                    phone + "," +
                    successfullyReturn + "," +
                    customerType + "," +
                    username + "," +
                    password;
        str += "\r\n";
        for (Item item : rentalList) {
            str += item.getId() + "\r\n";
        }
        return str;
    }

    public abstract Customer promote();
}
