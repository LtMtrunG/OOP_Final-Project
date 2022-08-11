package Customer;

import Customer.RegularAccount;
import Item.Item;

public class VIPAccount extends RegularAccount {
    //Constructors
    public VIPAccount(){};
    public VIPAccount(RegularAccount regularAccount){
        this.setID(regularAccount.getID());
        this.setName(regularAccount.getName());
        this.setAddress(regularAccount.getAddress());
        this.setPhone(regularAccount.getPhone());
        this.setRentalList(regularAccount.getRentalList());
        this.setUsername(regularAccount.getUsername());
        this.setPassword(regularAccount.getPassword());
        this.setNumberOfItems(regularAccount.getNumberOfItems());
        this.setSuccessfullyReturn(0);
    }

    //Methods
    @Override
    public boolean rent(Item item) {
        if(this.getRentalList().contains(item)){System.out.println("You have already rented a copy of this item!"); return false;}
        this.getRentalList().add(item);
        System.out.println("Successfully rent the item " +item.getID() +".");
        return true;
    }

    @Override
    public boolean itemReturn(Item item) {
        if(!this.getRentalList().contains(item)){System.out.println("You ddd not rent this item!"); return false;}
        this.getRentalList().remove(item);
        return true;
    }
}
