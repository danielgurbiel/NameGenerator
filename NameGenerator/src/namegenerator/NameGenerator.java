/*
TODO
add names to db
random name
*/
package namegenerator;

import java.sql.SQLException;
import java.util.Scanner;

public class NameGenerator {
    private static char option;
    private static Scanner input = new Scanner(System.in);
    private static String line;  

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Hello! This is name generator!");
        DataBase db = new DataBase();
        do{      
            showOptions();
            line = input.nextLine();
            option = line.charAt(0);
            
           switch(option){
               case '1':{
                   System.out.println("All names:");
                   db.showDataFromBase("SELECT name FROM names");
                   System.out.println();
                   break;
               }
               
               case '2':{
                   System.out.println("Names for man: ");
                   db.showDataFromBase("SELECT name FROM names WHERE sex = 1");
                   System.out.println();
                   break;
               }
               
               case '3':{
                   System.out.println("Names for women: ");
                   db.showDataFromBase("SELECT name FROM names WHERE sex = 0");
                   System.out.println();
                   break;
               }
               
               case '4':{
                   System.out.println("Random name for man: ");
                   
                   
                   break;
               }
               
               case '5':{
                   System.out.print("Podaj imię do wprowadzenia: ");
                   String name = input.nextLine();
                   System.out.print("Podaj płeć: (1-M, 0-W): ");
                   boolean sex = input.nextBoolean();
                   db.addToDataBase("INSERT INTO names VALUES (10," + name + ", " + sex + ")");
                   break;
               }
            
            }    
        } while (option!='q');
        db.closeConnection();
    } 
    
        public static void showOptions(){
            System.out.println("1. Show all names");
            System.out.println("2. Show names for men");
            System.out.println("3. Show names for women");
            System.out.println("4. Random name for man");
            System.out.println("q - EXIT"); 
        }
    
}

