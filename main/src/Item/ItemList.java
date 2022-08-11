package Item;
import Interfaces.SortByID;
import Interfaces.SortByName;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ItemList implements SortByID, SortByName {
    //Attribute
    private LinkedList <Item> list;

    //Constructor
    public ItemList(){}

    //Methods
    public LinkedList<Item> getList() {return list;}

    public boolean add(Item item){
        if(this.searchItem(item.getID()) != null){return false;}
        list.add(item);
        return true;
    }

    public boolean remove(Item item){
        if(this.searchItem(item.getID()) != null){return false;}
        list.remove(item);
        return true;
    }

    public Item searchItem(String str){
        for(Item item:this.getList()){
            if(item.getID().equals(str) || item.getTitle().equals(str)){
                System.out.println("There is a found item.");
                return item;
            }
        }
        System.out.println("No item has been found.");
        return null;
    }

    public void sortByID(){
        this.getList().sort(new ItemByID());
    }

    public void sortByName(){
        this.getList().sort(new ItemByTitle());
    }

    public ItemList findOutOfStock(){
        ItemList result = new ItemList();
        for(Item item: this.getList()){
            if(!item.isStatus()){
                result.add(item);
            }
        }
        return result;
    }
}
