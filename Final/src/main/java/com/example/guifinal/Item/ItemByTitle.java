package com.example.guifinal.Item;

import java.util.Comparator;

public class ItemByTitle implements Comparator<Item> {
    public int compare(Item item1, Item item2){
        int minLength = Math.min(item1.getTitle().length(),item2.getTitle().length());
        for(int  i = 0 ; i < minLength; i++){
            int ID1 = (int)item1.getTitle().charAt(i);
            int ID2 = (int)item2.getTitle().charAt(i);
            if(ID1 < ID2) {return -1;}
            if(ID1 > ID2) {return 1;}
        }
        if(item1.getId().length() < item2.getTitle().length()){return -1;}
        if(item1.getId().length() > item2.getTitle().length()){return 1;}
        return 0;
    }
}
