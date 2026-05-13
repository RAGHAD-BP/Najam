/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author rawan
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author rawan
 */
public class NewClass extends System_1 {
    ArrayList<String> Q =new ArrayList();
    ArrayList<String> A=new ArrayList();
    Scanner scan=new Scanner(System.in);
    String title;
    int numPage;
    String athouer;
    String answer;  
    ArrayList<String> days=new ArrayList(Arrays.asList("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"));
    ArrayList<String> times=new ArrayList(Arrays.asList("8:00 to 9:30","10:00 to 11:30","11:30 to 1:00","1:00 to 2:30"));
    
    
    private NewClass(String title,int num,String athouer){
        this.title=title;
        numPage=num;
        this. athouer=athouer;
    }
    
    public NewClass(){
       
        
        System.out.println("Hello again"+"  "+super.getUser());

    }
    


                              
    public void timePlan()throws InputMismatchException
    {//اسوي throws
        
        System.out.println("Enter number of total pages:");
        if(!(scan.hasNextInt()))
         throw new InputMismatchException(" Enter number!");

        int pages = scan.nextInt();

        System.out.println("Enter total time (minutes):");
        if(!(scan.hasNextInt()))
         throw new InputMismatchException(" Enter number!");
        int time = scan.nextInt();

        System.out.println("Enter break time (minutes):");
        if(!(scan.hasNextInt()))
         throw new InputMismatchException(" Enter number!");
        int breakTime = scan.nextInt();

       
        double timePerPage = (double) time / pages;

       
        System.out.println("Pages to study: " + pages);
        System.out.println("Total time: " + time + " minutes");
        System.out.printf("Spend about %.2f minutes on each page.%n", timePerPage);

        int studiedPages = 0;
        int totalTime = 0;
        int pagesBeforeBreak = (int) (60 / timePerPage); // Assume 1 break per hour

 
        while (studiedPages < pages && totalTime < time) {
            int timeLeft = time - totalTime;

            if (timeLeft >= 60) { // Study for 1 hour, then take a break
                if (studiedPages + pagesBeforeBreak <= pages) {
                    studiedPages += pagesBeforeBreak;
                    totalTime += 60; // 1 hour of study
                } else {
                    int remainingPages = pages - studiedPages;
                    totalTime += remainingPages * timePerPage;
                    studiedPages = pages;
                }

                if (studiedPages >= pages) break;

                System.out.printf("You studied %d pages. Take a %d-minute break.%n", pagesBeforeBreak, breakTime);
                totalTime += breakTime;
            } else {
               
                int remainingPages = pages - studiedPages;
                System.out.printf("Study the remaining %d pages without a break.%n", remainingPages);
                totalTime += timeLeft;
                studiedPages = pages;
            }
        }

        System.out.println("Study plan complete!");

         
     }
    
    public void activities(){
         System.out.println("Choose:\n"+"1.Math\n"+"2.programming\n"+"3.Geographically");
         if(scan.hasNextInt()){
         int input= scan.nextInt();
         switch(input){
            case 1 : math();
            
            break;
    
                case 2: programming();
                
                break;
                    case 3 :Geograph();
                           
                    
                    break;
                     default:
                          System.out.println("You made an invalid choice.");

                          break;
                        
     }}
    else
             System.out.println("input null");
    }


    @Override
    public void Geograph() {
        Q.addAll((Collection) Arrays.asList("Which is the most sacred city in Islam, located in Saudi Arabia?\n" +
"a) Medina\n" +
"b) Riyadh\n" +
"c) Mecca\n" +
"d) Jeddah\n" ,
"Which body of water is to the west of Saudi Arabia?\n" +
"a) Red Sea\n" +
"b) Arabian Sea\n" +
"c) Persian Gulf\n" +
"d) Gulf of Aden\n" ,
" What is the capital city of Saudi Arabia?\n" +
"a) Jeddah\n" +
"b) Riyadh\n" +
"c) Mecca\n" +
"d) Dammam\n" ,
"Which of the following is a traditional Saudi Arabian dish?\n" +
"a) Sushi\n" +
"b) Kabsa\n" +
"c) Tacos\n" +
"d) Pasta\n" ,
"What is the main export of Saudi Arabia?\n" +
"a) Gold\n" +
"b) Oil\n" +
"c) Diamonds\n" +
"d) Coffee\n" ,
"What is the name of the Red Sea coast city that is a major tourist destination?\n" +
"a) Jeddah\n" +
"b) Riyadh\n" +
"c) Medina\n" +
"d) Dammam\n" ,
"What type of government does Saudi Arabia have?\n" +
"a) Republic\n" +
"b) Monarchy\n" +
"c) Democracy\n" +
"d) Theocracy\n" ,
"What is the official religion of Saudi Arabia?\n" +
"a) Christianity\n" +
"b) Islam\n" +
"c) Judaism\n" +
"d) Hinduism\n" ,
"What is the currency symbol for the Saudi Riyal?\n" +
"$ )a\n" +
"€ )b\n" +
"c) SR\n" +
"¥ )d\n" ,
"What is the major river system in Saudi Arabia?\n" +
"a) Nile\n" +
"b) Tigris\n" +
" c) Wadi Hanifah\n" +
"d) Euphrates"));
        A.addAll((Collection) Arrays.asList("C","A","B","B","B","A","B","B","C","C"));
        int min=0;
        int max=9;
        boolean finish=false;
        while(! finish){
        Random ran=new Random();
        int index=min+ran.nextInt((max-min)+1);
            System.out.println(Q.get(index));
        System.out.println("enter your answer:");
        String answer=scan.next();
        if(answer.equalsIgnoreCase(A.get(index))){
            System.out.println("correct!!");
        }
        else
            System.out.println("Try again");
        
        System.out.println(" Do you want complet?");
        String answer1=scan.next();
        if(!(answer1.equalsIgnoreCase("y")||answer1.equalsIgnoreCase("yes"))){
            finish=true;
        }
        
        }
  
    }

    @Override
    public void programming() {
        Q.addAll((Collection) Arrays.asList(" Which keyword is used to create a subclass in Java?\n" +
"A) extends \n" +
"B) super\n" +
"C) implements\n" +
"D) inherits\n" ,
"What is the purpose of the final keyword in Java2?\n" +
"A) To declare constants\n" +
"B) To prevent method overriding\n" +
"C) To prevent inheritance\n" +
"D)  All of the above\n" ,
"Which method can be used to find the length of a string in Java3?\n" +
"A) size();\n" +
"B) length  ();\n" +
"C) getSize();\n" +
"D) getLength()\n" ,
"Which of the following is NOT a valid data type in Java?\n" +
"A) int\n" +
"B) float\n" +
"C) double\n" +
"D) decimal \n" ,
"In Java, which of the following is used to handle exceptions?\n" +
"A) try  -catch\n" +
"B) throw-throw\n" +
"C) assert\n" +
"D) finalize\n" ,
"Which of the following is used to declare a constant in Java?\n" +
"A) static\n" +
"B) const\n" +
"C) final \n" +
"D) immutable\n" ,
"What is the range of the byte data type in Java?\n" +
"A) -128 to 127\n" +
"B) 0 to 255\n" +
"C) -32768 to 32767\n" +
"D) -2147483648 to 2147483647\n" ,
" Which of the following is not a primitive data type in Java?\n" +
"A) int\n" +
"B) char\n" +
"C) String \n" +
"D) float\n" ,
"What is the default value of an integer variable in Java?\n" +
"A) 0  \n" +
"B) 1 \n" +
"C) null \n" +
"D) -1 \n" ,
"Which of the following is used to implement multiple inheritance in Java?\n" +
"A) Class\n" +
"B) Interface \n" +
"C) Abstract class\n" +
"D) All of the above"));
        A.addAll((Collection) Arrays.asList("A","D","B","D","A","D","A","C","A","B"));
        int min=0;
        int max=9;
        boolean finish=false;
        while(! finish){
        Random ran=new Random();
        int index=min+ran.nextInt((max-min)+1);
            System.out.println(Q.get(index));
        System.out.println("enter your answer:");
        String answer=scan.next();
        if(answer.equalsIgnoreCase(A.get(index))){
            System.out.println("correct!!");
        }
        else
            System.out.println("Try again");
        
        System.out.println(" Do you want complet?");
        String answer1=scan.next();
        if(!(answer1.equalsIgnoreCase("y")||answer1.equalsIgnoreCase("yes"))){
            finish=true;
        }
        
        }
    }

    @Override
 public void math() {
         Q.addAll((Collection) Arrays.asList("what is the multiplication of 6*8=\n" +
"1.23\n" +
"2.42\n" +
"3.89\n" +
"4.48\n" ,
"what is 5^2=\n" +
"1.30\n" +
"2.25\n" +
"3.45\n" +
"4.55\n" ,
"what is the floor of 11/4=\n" +
"1.2\n" +
"2.3\n" +
"3.7\n" +
"4.4\n" ,
" X=? 4X+3=27:\n" +
"1.X=3\n" +
"2.X=4\n" +
"3.X=9\n" +
"4.X=6\n" ,
"what is the sum of the first 3 numbers:\n" +
"1.10\n" +
"2.12\n" +
"3.7\n" +
"4.19\n" ,
"what is the value of the 4!(4 factorial)?\n" +
"1.30\n" +
"2.40\n" +
"3.24\n" +
"4.4\n" ,
"What is the square root of 121?\n" +
"1.10\n" +
"2. 12\n" +
"3.11\n" +
"4. 13\n" ,
"Y=? 240/Y=40\n" +
"1.Y=6\n" +
"2.Y=3\n" +
"3.Y=7\n" +
"4.Y=20\n" ,
"what is the value of the 5!(5 factorial)?\n" +
"1.30\n" +
"2.120\n" +
"3.500\n" +
"4.55\n" ,
"what is the ceiling of 12/5=\n" +
"1.2\n" +
"2.7\n" +
"2.4\n" +
"2.3"));
        A.addAll((Collection) Arrays.asList("4","2","1","4","1","3","3","1","2","2"));
        int min=0;
        int max=9;
        boolean finish=false;
        while(! finish){
        Random ran=new Random();
        int index=min+ran.nextInt((max-min)+1);
            System.out.println(Q.get(index));
        System.out.println("enter your answer:");
        String answer=scan.next();
        if(answer.equalsIgnoreCase(A.get(index))){
            System.out.println("correct!!");
        }
        else
            System.out.println("Try again");
        
        System.out.println(" Do you want complet?");
        String answer1=scan.next();
        if(!(answer1.equalsIgnoreCase("y")||answer1.equalsIgnoreCase("yes"))){
            finish=true;
        }
        
        }
  
    }


    
    
}

