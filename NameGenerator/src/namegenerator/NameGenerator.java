/*
TODO
add names to db
random name
*/
package namegenerator;

import java.util.Scanner;

public class NameGenerator {
    private static char option;
    private static Scanner input = new Scanner(System.in);
    private static String line;  

    public static void main(String[] args) {
        System.out.println("Hello! This is name generator!");
        DataBase db = new DataBase();
        do{      
            showOptions();
            line = input.nextLine();
            option = line.charAt(0);
            
           switch(option){
               case '1':{
                   System.out.println("All names:");
                   db.getDataFromBase("SELECT name FROM names");
                   System.out.println();
                   break;
               }
               
               case '2':{
                   System.out.println("Names for man: ");
                   db.getDataFromBase("SELECT name FROM names WHERE sex = 1");
                   System.out.println();
                   break;
               }
               
               case '3':{
                   System.out.println("Names for women: ");
                   db.getDataFromBase("SELECT name FROM names WHERE sex = 0");
                   System.out.println();
                   break;
               }
            
            }    
        } while (option!='q');
    } 
    
        public static void showOptions(){
            System.out.println("1. Show all names");
            System.out.println("2. Show names for men");
            System.out.println("3. Show names for women");
            System.out.println("q - EXIT"); 
        }
    
}

