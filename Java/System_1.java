/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
//import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author rawan
 */
public abstract class System_1 <T>extends Users implements  ToDoList,activities {
    
    ArrayList<String> complement = new ArrayList<>();
    ArrayList<String> notComplement = new ArrayList<>();
    ArrayList<String> days = new ArrayList<>(Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"));
    ArrayList<String> times = new ArrayList<>(Arrays.asList("8:00 to 9:30", "10:00 to 11:30", "11:30 to 1:00", "1:00 to 2:30"));
    ArrayList<String> mysel = new ArrayList<>();
    Scanner scan=new Scanner(System.in);
    
    //Todo list
    public ArrayList<T> removeDouple(ArrayList<T> list){
        return new ArrayList<>(new HashSet<>(list)) ;
    }

    public void done(int index) {
        if (index >= 0 && index < notComplement.size()) {
            complement.add(notComplement.get(index));
            notComplement.remove(index);
        } else {
            System.out.println("I can not found it.");
        }
    }

    public void showToDoList() {
        if (notComplement.isEmpty()) {
            System.out.println("ToDo list is empty.");
            return;
        }

       if (notComplement.size() <= 4) { 
           System.out.println("There's only a few left you can do!:");
           for (String todo : notComplement) {
            
                System.out.println(todo);
            } }else {
           System.out.println("You can do it!");
                    for (String todo : notComplement) {
            
                System.out.println(todo);
            } 
            }
        }

    public void deletnotcom(String todo) {
        if (notComplement.contains(todo)) {
            notComplement.remove(notComplement.indexOf(todo));
        } else {
            System.out.println("Task not found.");
        }
    }
    public void deletcom(String todo) {
        if (complement.contains(todo)) {
           
            complement.remove(complement.indexOf(todo));
        } else {
            System.out.println("Task not found.");
        }
    }

    public void addtask(String todo) {
        notComplement.add(todo);
    }
    
    //Schedule
    public void schedule(){
        String subject;
        
        for (int i = 0; i < days.size(); i++) {
            System.out.println(days.get(i));
            for (int j = 0; j < times.size(); j++) {
                System.out.println(times.get(j));
                System.out.print("Enter your subject: ");
                subject = scan.nextLine();  
                mysel.add(times.get(j) + ": " + subject);
            
    }}}
            
    public void disblyschedule(){
            if(!(mysel.isEmpty())){
                System.out.println("\nYour selections:");
        for (int i = 0; i < days.size(); i++) {
            System.out.println(days.get(i));
            for (int j = 0; j < times.size(); j++) {
                System.out.println(mysel.get(i * times.size() + j)); // طباعة العناصر المدخلة
            }
        }}
                else
                    System.out.println("you does not make a schedule");
          }

}