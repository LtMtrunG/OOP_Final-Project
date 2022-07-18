import java.util.LinkedList;

public class ItemList {
    //Attribute
    LinkedList <Item> list;

    //Constructors
    public ItemList(){}

    //Methods
    public void addItem(Item i){
        this.list.add(i);
    }
}
