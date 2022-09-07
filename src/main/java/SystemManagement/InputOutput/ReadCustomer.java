package SystemManagement.InputOutput;

import SystemManagement.Customer.*;
import SystemManagement.Item.Item;
import com.example.guifinal.Application;
import SystemManagement.Item.ItemList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCustomer {

    private static boolean isIDCustomerRight(String id) {
        if (id.charAt(0) != 'C') {
            return false;
        }
        if (!Character.isDigit(id.charAt(1)) && !Character.isDigit(id.charAt(2)) && !Character.isDigit(id.charAt(3))) {
            return false;
        }
        return true;
    }

    public static boolean isPhoneNumRight(String phoneNum) {
        for (int i = 0; i < phoneNum.length(); i++) {
            if (!Character.isDigit(phoneNum.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNumOfRentalsRight(String numOfRentals) {
        try {
            int numOfRentalsInt = Integer.parseInt(numOfRentals);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    private static boolean isCustomerTypeRight(String customerType) {
        switch (customerType) {
            case "Guest", "Regular", "VIP": return true;
        }
        return false;
    }

    private static Customer createCustomer(String str) {

        //Process the string
        StringBuffer resString = new StringBuffer(str);
        resString.insert(resString.length()-2, ",");
        str = resString.toString();
        String[] subStr = str.split(",");

        //Check condition of each attribute, return null Customer if the condition is wrong
        if (!isIDCustomerRight(subStr[0])) {
            System.out.println("Invalid Customer's ID");
            return null;
        }
        if (!isPhoneNumRight(subStr[3])) {
            System.out.println("Invalid Customer's Phone Number");
            return null;
        }
        if (!isNumOfRentalsRight(subStr[4])) {
            System.out.println("Invalid Customer's Number Of Rentals");
            return null;
        }
        if (!isCustomerTypeRight(subStr[5])) {
            System.out.println("Invalid Customer's Account Type");
            return null;
        }

        //Create customer with suitable Account Type
        System.out.println("Successfully create Customer");
        switch (subStr[5]) {
            case "Guest": return new GuestAccount(subStr[0], subStr[1], subStr[2], subStr[3], subStr[6], subStr[7], Integer.parseInt(subStr[4]));
            case "Regular": return new RegularAccount(new GuestAccount(subStr[0], subStr[1], subStr[2], subStr[3], subStr[6], subStr[7], Integer.parseInt(subStr[4])));
            case "VIP": return new VIPAccount(new RegularAccount(new GuestAccount(subStr[0], subStr[1], subStr[2], subStr[3], subStr[6], subStr[7], Integer.parseInt(subStr[4]))));
        }

        return null;
    }

    private static boolean isIDItemRight(String id) {
        if (id.charAt(0) != 'I') {
            return false;
        }
        if (!Character.isDigit(id.charAt(1)) && !Character.isDigit(id.charAt(2)) && !Character.isDigit(id.charAt(3))) {
            return false;
        }
        if (id.charAt(4) != '-') {
            return false;
        }
        if (!Character.isDigit(id.charAt(5)) && !Character.isDigit(id.charAt(6)) && !Character.isDigit(id.charAt(7)) && !Character.isDigit(id.charAt(8))) {
            return false;
        }
        return true;
    }

    private static Item createItem(String str) {

        //Process the string
        StringBuffer resString = new StringBuffer(str);
        resString.insert(resString.length()-2, ",");
        str = resString.toString();
        String[] subStr = str.split(",");

        //Check the format of the item's ID
        if (!isIDItemRight(subStr[0])) {
            System.out.println("Invalid Item ID");
            return null;
        }

        //Get the Item from the itemList to add to rentalsList
        for (int i = 0; i < Application.itemList.getSize(); i++) {
            if (subStr[0].equals(Application.itemList.getItemAt(i).getID())) {
                return Application.itemList.getItemAt(i);
            }
        }
        return null;
    }

    public static CustomerList readCustomerFile() {
        ArrayList<String> unpCustomerList = new ArrayList<String>();
        CustomerList pCustomerList = new CustomerList();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\java\\Data\\customers.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();

            while(line != null ) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                unpCustomerList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder("");
                line = bufferedReader.readLine();

                //If the input is Customers' Info
                if (unpCustomerList.get(unpCustomerList.size()-1).length() != 11) {
                    Customer customer = createCustomer(unpCustomerList.get(unpCustomerList.size() - 1));
                    if (customer != null) {
                        pCustomerList.add(customer);
                    }
                } else { //If the input is the itemList of that customer
                    Item item = createItem(unpCustomerList.get(unpCustomerList.size() - 1));
                    if (item != null) {
                        pCustomerList.getCustomerAt(pCustomerList.getSize()-1).getRentalList().add(item);
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pCustomerList;
    }
}
