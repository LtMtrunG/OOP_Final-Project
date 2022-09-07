package SystemManagement.Customer;

import SystemManagement.Interfaces.SortByID;
import SystemManagement.Interfaces.SortByNameOrTitle;

import java.util.ArrayList;

public class CustomerList implements SortByID, SortByNameOrTitle {
    //Attribute
    private ArrayList<Customer> list = new ArrayList<Customer>();

    //Constructor
    public CustomerList(){};

    //Methods
    public ArrayList<Customer> getList() {return list;}

    public Customer searchCustomer(String str){
        if (this.getList() != null) {
            for (Customer customer : this.getList()) {
                if (customer.getID().equals(str) || customer.getName().equals(str)) {
                    System.out.println("There is a found customer.");
                    return customer;
                }
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
