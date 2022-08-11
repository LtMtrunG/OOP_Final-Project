package Customer;
import Item.Item;
import java.util.ArrayList;
import java.util.Scanner;

public class GuestAccount extends Customer {
    //Attributes
    private int numberOfItems;
    private int successfullyReturn;

    //Constructor
    public GuestAccount(){};

    public GuestAccount(String ID, String name, String address, String phone,String username, String password) {
        super(ID, name, address, phone, new ArrayList<>(), username, password);
        this.numberOfItems = 0;
        this.successfullyReturn = 0;
    }

    //Methods
    //New customer -> automatically set as Guest Customer.Customer
    //Therefore the user cannot create a Regular or Vip account
    //Regular and Vip account only constructed via promotion

    public int getNumberOfItems() {return numberOfItems;}

    protected void setNumberOfItems(int numberOfItems) {this.numberOfItems = numberOfItems;}

    public int getSuccessfullyReturn() {return successfullyReturn;}

    protected void setSuccessfullyReturn(int successfullyReturn) {this.successfullyReturn = successfullyReturn;}

    public static GuestAccount createAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your ID: ");
        String ID = scanner.next();
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter your address: ");
        String address = scanner.next();
        System.out.print("Enter your phone number: ");
        String phone = scanner.next();
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        return new GuestAccount(ID, name, address, phone, username, password);
    }

    @Override
    public boolean rent(Item item) {
        if(item.getLoanType().equals("2-day")){System.out.println("Only Regular or VIP Account is able to rent a 2-day item!"); return false;}
        if(this.getRentalList().contains(item)){System.out.println("You have already rented a copy of this item!"); return false;}
        if(this.getNumberOfItems() == 2){System.out.print("A Guest Account can only rent maximum 2 items at a time!"); return false;}
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
        if(this.getSuccessfullyReturn() != 3) {System.out.println("This account hasn't satisfied the promote condition!"); return null;}
        return new RegularAccount(this);
    }

}
