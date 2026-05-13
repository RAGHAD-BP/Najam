/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 *
 * @author rawan
 */
public class Project_tast {

    /**
     * @param args the command line arguments
     */
             
             
    public static void main(String[] args) {
        // TODO code application logic here
        Najam obj=new Najam();
//        ArrayList<Integer> list=new ArrayList();
//        
//obj.removeDouple(list);
//        
try{
    obj.timePlan();
}  
catch (InputMismatchException i){
 System.out.println("Check Your Input!\t"+i.getMessage());
}
    }}
