package com.example.guifinal.Customer;

import com.example.guifinal.Item.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class GuestAccount extends Customer {
    //Constructor
    public GuestAccount(){};

    public GuestAccount(String ID, String name, String address, String phone,String username, String password, int successfullyReturn) {
        super(ID, name, address, phone, new ArrayList<>(), username, password, successfullyReturn);
    }

    //Methods
    public RegularAccount promote() {
        //Reset successfullyReturn
        this.setSuccessfullyReturn(0);
        return new RegularAccount(this);
    }

}
