package com.example.guifinal.Item;

import com.example.guifinal.Interfaces.SortByID;
import com.example.guifinal.Interfaces.SortByNameOrTitle;

import java.util.LinkedList;

public class ItemList implements SortByID, SortByNameOrTitle {
    //Attribute
    private LinkedList <Item> list = new LinkedList<Item>();

    //Constructor
    public ItemList(){}

    //Methods
    public LinkedList<Item> getList() {return list;}

    public int getSize() {
        return list.size();
    }

    public Item getItemAt(int i) {
        return list.get(i);
    }

    public void sortByID(){
        this.getList().sort(new ItemByID());
    }

    public void sortByNameOrTitle(){
        this.getList().sort(new ItemByTitle());
    }

    public void add(Item item){
        list.add(item);
    }
    public void remove(Item item) {
        this.getList().remove(item);
    }

}