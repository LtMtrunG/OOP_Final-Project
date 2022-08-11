package Customer;
import Item.Item;

public class RegularAccount extends GuestAccount {
    //Constructors
    protected RegularAccount(){};
    public RegularAccount(GuestAccount guestAccount){
        super(guestAccount.getID(),
                guestAccount.getName(),
                guestAccount.getAddress(),
                guestAccount.getPhone(),
                guestAccount.getUsername(),
                guestAccount.getPassword());
        this.setRentalList(guestAccount.getRentalList());
        this.setNumberOfItems(guestAccount.getNumberOfItems());
        this.setNumberOfItems(0);
    }

    //Methods
    @Override
    public String toString() {
        return "Customer.RegularAccount{}";
    }

    @Override
    public boolean rent(Item item) {
        if(this.getRentalList().contains(item)){System.out.println("You have already rented a copy of this item!"); return false;}
        this.getRentalList().add(item);
        this.setNumberOfItems(this.getNumberOfItems() + 1);
        System.out.println("Successfully rent the item " +item.getID() +".");
        return true;
    }

    @Override
    public boolean itemReturn(Item item) {
        if(!this.getRentalList().contains(item)){System.out.println("You did not rent this item!"); return false;}
        this.getRentalList().remove(item);
        this.setNumberOfItems(this.getNumberOfItems()-1);
        this.setSuccessfullyReturn(this.getSuccessfullyReturn() +1);
        return true;
    }

    public RegularAccount promote() {
        if(this.getSuccessfullyReturn() != 5) {System.out.println("This account hasn't satisfied the promote condition!"); return null;}
        return new RegularAccount(this);
    }
}
