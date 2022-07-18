public class DVDs extends Item{
    //Attributes
    private String type = "DVDs";
    private String genre;

    //Constructors
    public DVDs(){};
    public DVDs(String genre) {this.genre = genre;}
    public DVDs(String ID, String title, int copy, long fee, String genre){
        super(ID,title,copy,fee);
        this.genre = genre;
    }

    //Methods
    public String getType() {return type;}

    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre;}
}
