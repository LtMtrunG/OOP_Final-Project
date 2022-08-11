package Customer;
import Interfaces.SortByID;
import Interfaces.SortByName;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerList implements SortByID, SortByName {
    //Attribute
    private ArrayList<Customer> list;

    //Constructor
    public CustomerList(){};

    //Methods
    public ArrayList<Customer> getList() {return list;}

    public Customer searchCustomer(String str){
        for(Customer customer:this.getList()){
            if(customer.getID().equals(str) || customer.getName().equals(str)){
                System.out.println("There is a found customer.");
                return customer;
            }
        }
        System.out.println("No customer has been found.");
        return null;
    }

    public boolean add(Customer customer){
        if(this.searchCustomer(customer.getID()) != null){return false;}
        list.add(customer);
        return true;
    }

    public void sortByID(){
        this.getList().sort(new CustomerByID());
    }

    @Override
    public void sortByName() {
        this.getList().sort(new CustomerByName());
    }
}
