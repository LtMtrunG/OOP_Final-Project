package SystemManagement.Item;

import SystemManagement.Interfaces.Update;

import java.util.Scanner;

public class Item implements Update {
    //Attributes
    private String ID;
    private String title;
    private String rentalType;
    private String genre;
    private String loanType;
    private int copy;
    private float fee;
    private boolean status;

    //Constructors
    public Item() {}
    public Item(String ID, String title, String rentalType, String genre, String loanType, int copy, float fee){
        this.ID= ID;
        this.title = title;
        this.rentalType = rentalType;
        this.genre = genre;
        this.loanType = loanType;
        this.copy = copy;
        this.fee = fee;
        if(copy > 0 ){
            this.status = true;
        } else {this.status = false;}
    }

    //Methods
    public String getID() {return ID;}
    protected void setID(String input) {
        //               012345678
        //Valid ID Form 'Ixxx-yyyy'
        while(true){
            if(input.length() != 9) {break;}
            char[] ID =input.toCharArray();
            int index;
            if(ID[0] != 'I'){break;}
            for(index = 1; index < 4; index++){
                if(!Character.isDigit(ID[index])){break;}
            }
            if(ID[4] != '-'){break;}
            String year = null;
            for(index = 5; index < 9; index++){
                if(!Character.isDigit(ID[index])){break;}
                year += ID[index];
            }
            if(Integer.parseInt(year) > 2022 || Integer.parseInt(year) < 1890){break;}
            this.ID = input;
            return;
        }
        System.out.println("Invalid input for ID!");
    }

    public String getTitle() {return title;}
    protected void setTitle(String title) {this.title = title;}

    public String getRentalType() {return rentalType;}

    protected void setRentalType(String rentalType) {
        String[] validType = {"Record", "DVD", "Game"};
        for(String str:validType){
            if(str.equals(rentalType)){
                this.rentalType = rentalType;
                return;
            }
        }
        System.out.println("Invalid input for rental type!");
    }

    public String getGenre() {return genre;}

    protected void setGenre(String genre) {
        String[] validGenre = {"Action", "Horror", "Drama", "Comedy"};
        if(this.getRentalType() == "Game"){System.out.println("Game doesn't have genre!"); return;}
        for(String str:validGenre){
            if(str.equals(genre)){
                this.genre = genre;
                return;
            }
        }
        System.out.println("Invalid input for genre!");
    }

    public String getLoanType() {return loanType;}

    protected void setLoanType(String loanType) {
        String[] validLoanType = {"2-day", "1-week"};
        for(String str:validLoanType) {
            if (str.equals(loanType)) {
                this.loanType = loanType;
                return;
            }
        }
        System.out.println("Invalid input for loan type!");
    }

    public int getCopy() {return copy;}
    protected void setCopy(int copy) {
        this.copy = copy;
        if(copy > 0 ){
            this.status = true;
        } else {this.status = false;}
    }

    public float getFee() {return fee;}
    protected void setFee(float fee) {this.fee = fee;}

    public boolean isStatus() {return status;}

    @Override
    public String toString() {
        return "Item.Item{" +
                "ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", rentalType='" + rentalType + '\'' +
                ", genre='" + genre + '\'' +
                ", loanType='" + loanType + '\'' +
                ", copy=" + copy +
                ", fee=" + fee +
                ", status=" + status +
                '}';
    }

    public static Item createItem(){
        Scanner scanner = new Scanner(System.in);
        Item item = new Item();
        boolean valid = true;

        while(valid) {
            System.out.print("Enter the ID of the new item: ");
            String ID = scanner.next();
            item.setID(ID);
            if (item.getID() == null) {
                valid = false;
            }

            System.out.print("Enter the title of item " + ID + ": ");
            String title = scanner.next();
            item.setTitle(title);

            System.out.print("Enter the rental type of item " + ID + ": ");
            String rentalType = scanner.next();
            item.setRentalType(rentalType);
            if (item.getRentalType() == null) {
                valid = false;
            }

            System.out.print("Enter the loan type of item " + ID + ": ");
            String loanType = scanner.next();
            item.setLoanType(loanType);
            if (item.getLoanType() == null) {
                valid = false;
            }

            System.out.print("Enter the genre of item " + ID + ": ");
            String genre = scanner.next();
            item.setGenre(genre);
            if (item.getGenre() == null) {
                valid = false;
            }

            System.out.print("Enter the number of copies of item " + ID + ": ");
            int copies = scanner.nextInt();
            scanner.nextLine();
            item.setCopy(copies);

            System.out.print("Enter the rental fee of item " + ID + ": ");
            float fee = scanner.nextFloat();
            scanner.nextLine();
            item.setFee(fee);

            return item;
        }
        return null;
    }

    public boolean update(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an attribute you wanted to update: ");
        String attribute = scanner.next();
        switch(attribute){
            case "ID":
                System.out.print("Enter the new ID: ");
                String ID = scanner.next();
                this.setID(ID);
                if (this.getID() != null) {System.out.println("Successfully update the ID.");}
                break;

            case "title":
                System.out.print("Enter the title: ");
                String title = scanner.next();
                this.setTitle(title);
                System.out.println("Successfully update the title.");
                break;

            case "rental type":
                System.out.print("Enter the rental type: ");
                String rentalType = scanner.next();
                this.setRentalType(rentalType);
                if (this.getRentalType() != null) {System.out.println("Successfully update the rental type.");}
                break;

            case "genre":
                System.out.print("Enter the genre: ");
                String genre = scanner.next();
                this.setGenre(genre);
                if (this.getGenre() != null) {System.out.println("Successfully update the genre.");}
                break;

            case "loan type":
                System.out.print("Enter the loan type: ");
                String loanType = scanner.next();
                this.setLoanType(loanType);
                if (this.getLoanType() != null) {System.out.println("Successfully update the loan type.");}
                break;

            case "copy":
                System.out.print("Enter the new number of copies: ");
                int copy = scanner.nextInt();
                this.setCopy(copy);
                System.out.println("Successfully update the number of copies.");
                break;

            case "fee":
                System.out.print("Enter the new number of copies: ");
                float fee = scanner.nextFloat();
                this.setFee(fee);
                System.out.println("Successfully update the rental fee.");
                break;

            default:
                System.out.println("Invalid attribute");
                return false;
        }
        return true;
    }

    public void modifyCopies(int copies){
        this.setCopy(this.getCopy() + copies);
    }
}
