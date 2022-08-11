package Customer;

import Interfaces.*;
import Item.Item;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Customer implements Update {
    //Attributes
    private String ID;
    private String name;
    private String address;
    private String phone;
    private ArrayList<Item> rentalList;
    private String username;
    private String password;

    //Constructors
    public Customer(){};

    public Customer(String ID, String name, String address, String phone, ArrayList<Item> rentalList,String username, String password) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.rentalList = rentalList;
        this.username = username;
        this.password = password;
    }

    //Methods
    public String getID() {return ID;}

    protected void setID(String input) {
        //               0123
        //Valid ID Form 'Cxxx'
        while (true) {
            if (input.length() != 4) {break;}
            char[] ID = input.toCharArray();
            if (ID[0] != 'C') {break;}
            for (int index = 1; index < 4; index++) {
                if (!Character.isDigit(ID[index])) {break;}
                return;
            }
            System.out.println("Invalid input for ID!");
        }
    }

    public String getName() {return name;}

    protected void setName(String name) {this.name = name;}

    public String getAddress() {return address;}

    protected void setAddress(String address) {this.address = address;}

    public String getPhone() {return phone;}

    protected void setPhone(String phone) {this.phone = phone;}

    public ArrayList<Item> getRentalList() {return rentalList;}

    protected void setRentalList(ArrayList<Item> rentalList) {this.rentalList = rentalList;}

    public String getUsername() {return username;}

    protected void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    protected void setPassword(String password) {this.password = password;}

    @Override
    public String toString() {
        return "Customer.Customer{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", rentalList=" + rentalList +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public boolean update(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an attribute you wanted to update: ");
        String attribute = scanner.next();
        switch(attribute){
            case "ID":
                System.out.print("Enter new ID: ");
                String ID = scanner.next();
                this.setID(ID);
                if (this.getID() != null) {System.out.println("Successfully update the ID.");}
                break;

            case "name":
                System.out.print("Enter new name: ");
                String name = scanner.next();
                this.setName(name);
                System.out.println("Successfully update the name.");
                break;

            case "address":
                System.out.print("Enter new address: ");
                String address = scanner.next();
                this.setAddress(address);
                break;

            case "phone":
                System.out.print("Enter new phone: ");
                String phone = scanner.next();
                this.setPhone(phone);
                break;

            case "username":
                System.out.print("Enter new username: ");
                String username = scanner.next();
                this.setUsername(username);
                break;

            case "password":
                System.out.print("Enter new password: ");
                String password = scanner.next();
                this.setPassword(password);
                break;

            default:
                System.out.println("Invalid attribute");
                return false;
        }
        return true;
    }

    public abstract Customer promote();

    public abstract boolean rent(Item item);

    public abstract boolean itemReturn(Item item);
}

