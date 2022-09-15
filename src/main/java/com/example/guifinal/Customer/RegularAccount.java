package com.example.guifinal.Customer;

import com.example.guifinal.Item.Item;

public class RegularAccount extends GuestAccount {
    //Constructors
    protected RegularAccount(){};
    public RegularAccount(GuestAccount guestAccount){
        super(guestAccount.getId(),
                guestAccount.getName(),
                guestAccount.getAddress(),
                guestAccount.getPhone(),
                guestAccount.getUsername(),
                guestAccount.getPassword(),
                guestAccount.getSuccessfullyReturn());
        this.setRentalList(guestAccount.getRentalList());
    }

    //Methods

    public VIPAccount promote() {
        //Reset successfullyReturn
        this.setSuccessfullyReturn(0);
        return new VIPAccount(this);
    }
}
