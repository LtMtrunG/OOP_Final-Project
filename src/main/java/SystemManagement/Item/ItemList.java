package SystemManagement.Item;

import SystemManagement.Interfaces.SortByID;
import SystemManagement.Interfaces.SortByNameOrTitle;

import java.util.LinkedList;

public class ItemList implements SortByID, SortByNameOrTitle {
    //Attribute
    private LinkedList <Item> list = new LinkedList<Item>();

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
        if (this.getList() != null) {
            for (Item item : this.getList()) {
                if (item.getID().equals(str) || item.getTitle().equals(str)) {
                    System.out.println("There is a found item.");
                    return item;
                }
            }
        }
        System.out.println("No item has been found.");
        return null;
    }

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
