/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author rawan
 */
import java.io.*;
import java.util.*;

public class Users {
    private String name,pass, user;
    private static final int PP = 8;
    private boolean loggedin;
    static ArrayList<String> Users = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();

    Scanner s = new Scanner(System.in);

    public Users() {
        
        loadData(); 
        System.out.println("Hello Welcome to Najam");
        
        System.out.println("Enter your user:");
        user = s.next();
        System.out.println("Enter your password:");
        pass = s.next();

        if (!ChecklogIn(user, pass)) {
            newlogIn();
        }
    }

 public boolean ChecklogIn(String enteredUser, String enteredPassword) {  
    if(Users.indexOf(enteredUser)!=-1) { 
  if((passwords.get(Users.indexOf(enteredUser))).equals(enteredPassword)) {  
   loggedin= true;  
   return true;  
    
  }  
    else 
         System.out.println("You are E-mail or Password is not correct"); 
  System.exit(0); 
      return false; 
    } 
   
  else if(Users.contains(enteredUser)== false) 
      System.out.println("You are new user "); 
      newlogIn(); 
  return true; 
   
    
 } 

    public void newlogIn() {
        System.out.println("Enter your name:");
        name = s.next();
    
        System.out.println("Enter your user:");
        String checkuser = s.next();
        if(Users.indexOf(checkuser)==-1){
            user=checkuser;
           
            System.out.println("Enter your password:");
        String checkpassword = s.next();
        if (checkpassword.length() >=PP) {
            pass = checkpassword;
            Users.add(user);
            passwords.add(pass);
            saveData(); 
            
        } else {
            System.out.println("Your password is too short");
            System.exit(0);}
        }
        else
            System.out.println("try again your user is already exists");
            System.exit(0); 
    }

   private void saveData() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"))) {
        for (int i = 0; i < Users.size(); i++) {
            writer.write(Users.get(i) + "," + passwords.get(i));
            writer.newLine();
        }
        System.out.println("Data saved successfully."); 
    } catch (IOException e) {
        System.out.println("Error saving data: " + e.getMessage());
    }
}

    private void loadData() {
    File file = new File("users.txt");
    if (!file.exists()) {
        try {
            file.createNewFile(); 
            System.out.println("File created: " + file.getName()); 
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
        return; 
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                Users.add(parts[0]);
                passwords.add(parts[1]);
            }
        }
    } catch (IOException e) {
        System.out.println("Error loading data: " + e.getMessage());
    }
}

    public String getUser() {
        return user;
    }
 
}
 
 
 



