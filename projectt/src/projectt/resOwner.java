/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectt;


import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class resOwner extends Person{
    String username;
    String passwd;
    int mealsNum = 0;
    static int numRes = 0;
    boolean resAvilability = false;
    String resName;
    int orderedMeals = 0;
    orders[] orders = new orders[500];
    static int loggedinUser;
    Meals[] m = new Meals[50];
    Scanner input = new Scanner(System.in);
    
   
    resOwner() {
        for (int i=0; i <= mealsNum; i++){
           m[i] = new Meals();
        }
        for (int i=0; i < 500; i++){
           orders[i] = new orders();
        }
    }
    
    resOwner(String username , String password , String resname)
    {
        this.username = username ;
        this.passwd = password;
        this.resName = resname;
    }

    
    public void Register(resOwner res) {
        System.out.println("Enter Username");
        username = input.next();
        System.out.println("Enter Password");
        passwd = input.next();
        System.out.println("Enter restaurant name");
        res.resName = input.next();
        System.out.println("Is The resturant avilable from now ? (yes or no)");
        String s = input.next();
        if (s.equals("yes"))
        {
            res.resAvilability = true;
        }
        else{
            res.resAvilability = false;
        }
        numRes++;
    }
    
    public void login(resOwner[] s)
    {
        String userinput;
        String passinput;
        int check = 0;
        System.out.println("Enter Username");
        userinput = input.next();
        System.out.println("Enter Password");
        passinput = input.next();
        for (int i = 0; i < resOwner.numRes; i++)
        {
        if (userinput.equals(s[i].username)&&passinput.equals(s[i].passwd))
            {
                check = 1;
                loggedinUser = i;
                break;
            }
        }
        if (check != 1)
        {
            System.out.println("username or password wrong try again");
            login(s);
        }
    }


  
 public void Storing_orders(int Mealnum , int Quantity , String AdditionalNotes , String Date)
 { 
    orders[orderedMeals].mealNum = Mealnum;
    orders[orderedMeals].quantity = Quantity;
    orders[orderedMeals].notes = AdditionalNotes;
    orders[orderedMeals].Date = Date;
    
    orderedMeals++;
    }
 
 public void browse_orders()
 {
     if (orderedMeals == 0)
     {
         System.out.println("no orders yet..");
     }
     else{
         for (int i=0; i < orderedMeals; i++){
             System.out.println("Order number : " + ++i);
             System.out.println("meal number : " + ++orders[i].mealNum);
             System.out.println("Quantity : " + orders[i].quantity);
             System.out.println("Additional Notes : " + orders[i].notes);
             System.out.println("Date : " + orders[i].Date);
             System.out.println("---------------------------------------------------------");
         }
     }
 }
 
}
