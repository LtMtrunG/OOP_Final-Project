package com.example.guifinal.InputOutput;

import com.example.guifinal.Item.Item;
import com.example.guifinal.Item.ItemList;

import java.io.*;
import java.util.ArrayList;
import java.lang.*;

public class ReadItem {

    protected static boolean isIDRight(String id) {
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

    private static boolean isRentalTypeRight(String rentalType) {
        switch (rentalType) {
            case "Record", "DVD", "Game": return true;
        }
        return false;
    }

    private static boolean isLoanTypeRight(String loanType) {
        switch (loanType) {
            case "2-day", "1-week": return true;
        }
        return false;
    }

    private static boolean isNumOfCopiesRight(String numOfCopies) {
        try {
            int numOfCopiesInt = Integer.parseInt(numOfCopies);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static boolean isRentalFeeRight(String rentalFee) {
        try {
            double rentalFeeDble = Double.parseDouble(rentalFee);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static boolean isGenreRight(String genre) {
        switch (genre) {
            case "Action", "Horror", "Drama", "Comedy": return true;
        }
        return false;
    }

    private static Item createItem(String str) {

        //Process the string
        //Return the index of new line character depend on whether the system is Window or macOS
        int position;
        if (str.indexOf("\r\n") != -1) {
            position = str.indexOf("\r\n");
        } else {
            position = str.indexOf("\n");
        }
        //Split the string into components
        StringBuffer resString = new StringBuffer(str);
        resString.insert(position, ",");
        str = resString.toString();
        String[] subStr = str.split(",");

        //an item record has the following format
        //ID,Title,Rent type,Loan type,Number of copies,rental fee,[genre] if it is a video record or a DVD

        //Check condition of each attribute, return null Item if the condition is wrong
        if (!isIDRight(subStr[0])) {
            return null;
        }
        if (!isRentalTypeRight(subStr[2])) {
            return null;
        }
        if (!isLoanTypeRight(subStr[3])) {
            return null;
        }
        if (!isNumOfCopiesRight(subStr[4])) {
            return null;
        }
        if (!isRentalFeeRight(subStr[5])) {
            return null;
        }
        if (!subStr[2].equals("Game")) {
            if (!isGenreRight(subStr[6])) {
                return null;
            }
        } else {
            subStr[6] = "";
        }

        //Return new object if all attributes pass the condition
        return new Item(subStr[0], subStr[1], subStr[2], subStr[6] , subStr[3], Integer.parseInt(subStr[4]), Float.parseFloat(subStr[5]));
    }

    public static ItemList readItemFile() {
        ArrayList<String> unpItemList = new ArrayList<String>();
        ItemList pItemList = new ItemList();

        try {
            //Open the file and read each line
            BufferedReader bufferedReader = new BufferedReader(new  FileReader("." + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Data" + File.separator + "items.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();

            while(line != null ) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                unpItemList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                line = bufferedReader.readLine();

                //Take the line and create the item
                Item item = createItem(unpItemList.get(unpItemList.size()-1));
                if (item != null) {
                    pItemList.add(item);
                }
            }
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Return the itemList
        return pItemList;
    }
}
