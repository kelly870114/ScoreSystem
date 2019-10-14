//資管二甲 405401140 黃嬿羽
package myscorelist;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class MyScoreList {

    public static LinkedList<Score> theList = new LinkedList<Score>();

    public static void main(String[] args) {
        readFile();        
        System.out.println("Please enter your choice:");
        System.out.println("1: 查詢  " + "2: 新增  " + "3: 刪除  " + "4: 列出  " + "5: 離開  ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt(); //read in command
        while (choice != 5) {
            if (choice == 1) {
                enquiry();
                System.out.println(" Please enter your choice: ");
            } 
            else if (choice == 2) {
                addNewScore();
                System.out.println(" Please enter your choice: ");
            }
            else if (choice == 3) {
                deleteScore();
                System.out.println(" Please enter your choice: ");
            } 
            else if (choice == 4) {
                listAllScore();
                System.out.println(" Please enter your choice: ");
            } 
            else {
                System.out.println("Invalid choice. Please enter your choice: ");
            }
            choice = input.nextInt();
        }
    }

    public static void readFile() {
        String nameSt;
        String stLine;
        int credit;
        int score;
        Score theNode;
        try {
            File inFile = new File("/Users/apple/Desktop/score.txt");
            Scanner sc = new Scanner(inFile);
            while (sc.hasNext()) {
                stLine = sc.nextLine();
                Scanner sc2 = new Scanner(stLine);
                while (sc2.hasNext()) {
                    nameSt = sc2.next();
                    System.out.println(nameSt);
                    credit = sc2.nextInt();
                    System.out.println(credit);
                    score = sc2.nextInt();
                    System.out.println(score);
                    theNode = new Score(nameSt, credit, score);
                    theList.add(theNode);
                }
            }
            sc.close();
        } catch (IOException e) {
        }
    }

    public static void enquiry() {
        Scanner input = new Scanner(System.in);
        System.out.println("Student name: ");
        String enstu = input.nextLine();
        int count = 0;
        for(int i = 0; i < theList.size(); i++){
            if(enstu.equals(theList.get(i).getName())){
                if(count == 0){
                    System.out.println("Name: "+theList.get(i).getName());
                    System.out.println("Credit: "+theList.get(i).getCredit());
                    System.out.println("Score: "+theList.get(i).getScore());
                    
                }
                count++; 
            }
           
        }
        if(count == 0){
            System.out.println("找不到成績");
                
        }
        
    }

    public static void addNewScore() {
        Scanner input = new Scanner(System.in);
        System.out.println("Student name: ");
        String addstu = input.nextLine();
        int count = 0;
        for(int i = 0; i < theList.size(); i++){
            if(addstu.equalsIgnoreCase(theList.get(i).getName())){
                if(count == 0){
                    Score stuNode;
                    System.out.println("Student credit");
                    int newcredit = input.nextInt();
                    int addcredit = newcredit + theList.get(i).getCredit();
                    System.out.println("Student score: ");
                    int addscore = Math.round(((input.nextInt()*newcredit) + (theList.get(i).getScore() * theList.get(i).getCredit()))
                            /addcredit);
                    stuNode = new Score(theList.get(i).getName(), addcredit, addscore);
                    theList.remove(i);
                    theList.add(stuNode);
                }    
                count++;
            }
            
        }
        if(count == 0){
            System.out.println("Not on the list");
            Score scoreNode;
            System.out.println("Student name:");
            String newstun = input.nextLine();
            System.out.println("Student credit: ");
            int newstuc = input.nextInt();
            System.out.println("Student score: ");
            int newstus = input.nextInt();
            scoreNode = new Score(newstun, newstuc, newstus);
            theList.add(scoreNode);
            System.out.println("Input!");
                   
            }
	
    }

    public static void deleteScore() {
        Scanner input = new Scanner(System.in);
        System.out.println("Student name: ");
        String destu = input.nextLine();
        int count = 0;
        for(int i = 0; i < theList.size(); i++){
            if(destu.equals(theList.get(i).getName())){
                if(count == 0){
                    System.out.println("Name: "+theList.get(i).getName());
                    System.out.println("Credit: "+theList.get(i).getCredit());
                    System.out.println("Score: "+theList.get(i).getScore());
                    theList.remove(i);
                    System.out.println("已刪除");
                    count++;
                }
                
            }
            
        }
        if(count == 0){
            System.out.println("沒有成績");
            count ++;
        }
    }

    public static void listAllScore() {
        for(int i = 0; i < theList.size(); i++){
            System.out.println("Name: "+theList.get(i).getName());
            System.out.println("Credit: "+theList.get(i).getCredit());
            System.out.println("Score: "+theList.get(i).getScore());
        }
    }
}
