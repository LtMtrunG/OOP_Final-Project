package Customer;

import Customer.Customer;

import java.util.Comparator;

public class CustomerByName implements Comparator<Customer> {
    public int compare(Customer customer1, Customer customer2){
        int minLength = Math.min(customer1.getName().length(),customer2.getName().length());
        for(int  i = 0 ; i < minLength; i++){
            int ID1 = (int)customer1.getName().charAt(i);
            int ID2 = (int)customer2.getName().charAt(i);
            if(ID1 < ID2) {return -1;}
            if(ID1 > ID2) {return 1;}
        }
        if(customer1.getName().length() < customer2.getName().length()){return -1;}
        if(customer1.getName().length() > customer2.getName().length()){return 1;}
        return 0;
    }
}
