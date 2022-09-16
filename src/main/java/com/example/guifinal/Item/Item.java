package com.example.guifinal.Item;

import javafx.scene.control.Button;

public class Item {
    //Attributes
    private String id;
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
        this.id = ID;
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
    public String getId() {return id;}
    public void setId(String input) {
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
            this.id = input;
            return;
        }
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getRentalType() {return rentalType;}

    public void setRentalType(String rentalType) {
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

    public void setGenre(String genre) {
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

    public void setLoanType(String loanType) {
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
    public void setCopy(int copy) {
        this.copy = copy;
        if(copy > 0 ){
            this.status = true;
        } else {this.status = false;}
    }

    public float getFee() {return fee;}
    public void setFee(float fee) {this.fee = fee;}

    public boolean isStatus() {return status;}

    @Override
    public String toString() {
        String str = id + "," +
                    title + "," +
                    rentalType + "," +
                    loanType + "," +
                    copy + "," +
                    fee;
        if (genre == "") {
            str += "\r\n";
        } else {
            str += "," + genre + "\r\n";
        }
        return str;
    }
}
