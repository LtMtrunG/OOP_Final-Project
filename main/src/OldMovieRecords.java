public class OldMovieRecords extends Item{
    //Attributes
    private String type = "Old Movie Records";
    private String genre;

    //Constructors
    public OldMovieRecords(){};
    public OldMovieRecords(String genre) {this.genre = genre;}
    public OldMovieRecords(String ID, String title, int copy, long fee, String genre){
        super(ID,title,copy,fee);
        this.genre = genre;
    }

    //Methods
    public String getType() {return type;}

    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre;}

}
