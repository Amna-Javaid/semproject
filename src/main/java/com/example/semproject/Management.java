package com.example.semproject;
import java.util.ArrayList;
public class Management {

        ArrayList<Center> centers = new ArrayList<>();
        ArrayList<Center> centers2 = new ArrayList<>();
        ArrayList<Center> centers3 = new ArrayList<>();
        Management(){
            centers.add(new Center("Mio Hospital", "12345", "Johar Town Block J1",1));
            centers.add(new Center("General Hospital", "23456", "Wapda Town Block C",2));
            centers.add(new Center("Services Hospital", "34567", "Near Punjab Society",3));
            centers.add(new Center("Expo center", "45678", "Bhatti Gate Lahore",4));
            centers.add(new Center("Doctor Hospital", "56789", "Gulberg near Sapphire",5));
            centers.add(new Center("Zubaida hospital", "30567", "Near Punjab Society",6));
            centers.add(new Center("Sheikh Zaid Hospital", "45278", "Bhatti Gate Lahore",7));
            centers.add(new Center("Asia Hospital", "56989", "Gulberg near Sapphire",8));

            centers2.add(new Center("Shifa Hospital", "12345", "Johar Town Block J1",1));
            centers2.add(new Center("Rubina Hospital", "23456", "Wapda Town Block C",2));
            centers2.add(new Center("Faisal Hospital", "34567", "Near Punjab Society",3));
            centers2.add(new Center("National center", "45678", "Bhatti Gate Lahore",4));
            centers2.add(new Center("Aziz Fatima Hospital", "45678", "Bhatti Gate Lahore",4));
            centers2.add(new Center("Mujahid center", "45678", "Bhatti Gate Lahore",4));

            centers3.add(new Center("City Hospital", "56789", "Gulberg near Sapphire",5));
            centers3.add(new Center("Waseem Chest hospital", "30567", "Near Punjab Society",6));
            centers3.add(new Center("Life Care Hospital", "45278", "Bhatti Gate Lahore",7));
            centers3.add(new Center("Ail memorial Hospital", "56989", "Gulberg near Sapphire",8));




        }
    }

