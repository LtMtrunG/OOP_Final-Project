public class VideoGames extends Item{
    //Attributes
    private String type = "Video Games";
    private String genre;

    //Constructors
    public VideoGames(){};
    public VideoGames(String genre) {this.genre = genre;}
    public VideoGames(String ID, String title, int copy, long fee, String genre){
        super(ID,title,copy,fee);
        this.genre = genre;
    }

    //Methods
    public String getType() {return type;}

    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre;}
}
