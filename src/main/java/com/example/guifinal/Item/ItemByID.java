package com.example.guifinal.Item;

import java.util.Comparator;

public class ItemByID implements Comparator<Item> {
    public int compare(Item item1, Item item2){
        int minLength = Math.min(item1.getId().length(),item2.getId().length());
        for(int  i = 0 ; i < minLength; i++){
            int ID1 = item1.getId().charAt(i);
            int ID2 = item2.getId().charAt(i);
            if(ID1 < ID2) {return -1;}
            if(ID1 > ID2) {return 1;}
        }
        if(item1.getId().length() < item2.getId().length()){return -1;}
        if(item1.getId().length() > item2.getId().length()){return 1;}
        return 0;
    }
}
