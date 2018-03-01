/*
TODO
connect with database
add names to db
random name
*/
package namegenerator;

public class NameGenerator {

    public static void main(String[] args) {
        System.out.println("Hello! This is name generator!");
        DataBase db = new DataBase("SELECT name FROM names");
        
    }
    
}
