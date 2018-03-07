/*
TODO
add names to db
*/
package namegenerator;

import java.sql.SQLException;
import java.util.Scanner;

public class NameGenerator {
    private static char option;
    private static Scanner input = new Scanner(System.in);
    private static String line;  
    private static DataBase db;
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Hello! This is name generator!");
        db = new DataBase();
        
        do{      
            showOptions();
            line = input.nextLine();
            option = line.charAt(0);
            
           switch(option){
               case '1':{
                   option("All names:", "SELECT * FROM _all ORDER BY name");
                   break;
               }
               
               case '2':{
                   option("Names for man:", "SELECT * FROM men ORDER BY name");
                   break;
               }
               
               case '3':{
                   option("Names for women:", "SELECT * FROM women ORDER BY name");
                   break;
               }
               
               case '4':{
                   option("Random name for man:", "SELECT * FROM men ORDER BY RAND() LIMIT 1");
                   break;
               }
               
               case '5':{
                   option("Random name for woman:", "SELECT * FROM women ORDER BY RAND() LIMIT 1");
                   break;
               }
               
               case '6':{
                   addToDB();
                   break;
               }
            
            }    
        } while (option!='q');
        db.closeConnection();
    } 
    
    public static void option(String text, String query) throws SQLException{
        System.out.println(text);
        db.showDataFromBase(query);
        System.out.println(); 
    }
    
    public static void addToDB() throws SQLException{
        db.addToDataBase(inputName(), inputSex());
    }
    
    public static String inputName(){
        System.out.print("Insert name: ");
        return input.nextLine();
    }
    
    public static int inputSex(){
        System.out.print("Chose sex: (0-woman / 1-man): ");
        return input.nextInt();
    }
     
    public static void showOptions(){
        System.out.println("1. Show all names");
        System.out.println("2. Show names for men");
        System.out.println("3. Show names for women");
        System.out.println("4. Random name for man");
        System.out.println("5. Random name for woman");
        System.out.println("6. Add name");
        System.out.println("q - EXIT"); 
    }   
}

