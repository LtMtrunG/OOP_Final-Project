public class Item {
    //Attributes
    private String ID;
    private String title;
    private int copy;
    private long fee;
    private boolean status;

    //Constructors
    public Item() {}
    public Item(String ID, String title, int copy, long fee){
        this.ID= ID;
        this.title = title;
        this.copy = copy;
        this.fee = fee;
        if(copy > 0 ){
            this.status = true;
        } else {this.status = false;}
    }

    //Methods
    public String getID() {return ID;}
    protected void setID(String ID) {this.ID = ID;}

    public String getTitle() {return title;}
    protected void setTitle(String title) {this.title = title;}

    public int getCopy() {return copy;}
    protected void setCopy(int copy) {this.copy = copy;}

    public long getFee() {return fee;}
    protected void setFee(long fee) {this.fee = fee;}

    public boolean isStatus() {return status;}

    @Override
    public String toString() {
        String stringStatus = "";
        if(this.isStatus()){stringStatus = "Available";}
        else{stringStatus = "Unavailable";}
        return "Item{" +
                "ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", copy=" + copy +
                ", fee=" + fee +
                ", status=" + stringStatus +
                '}';
    }
}
