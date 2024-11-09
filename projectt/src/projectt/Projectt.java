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
public class Projectt {
    
   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //array of owners
        resOwner[] resowner = new resOwner[100];
        for (int i=0; i < 100; i++){
           resowner[i] = new resOwner();
        }
        
        //array of customers
        customer[] customers = new customer[200];
        for (int i=0; i < 200; i++){
           customers[i] = new customer();
        }
        
        mainMenu(customers , resowner);
       
        input.close();
        
    }
    
    
    
    
    
    
    
    public static void mainMenu(customer[] customers , resOwner[] resowner)
    {
        
        Scanner input = new Scanner(System.in);
         //menu
        System.out.println("Welcome to Talabat \n \n");
        System.out.println("if you are customer enter (1)");
        System.out.println("if you are resturant owner enter (2)");
        int check1 = input.nextInt();
        
        
        //-------------Customer--------------------------
        if (check1 == 1){
            registerCustomerMenu(resowner , customers);
        }
        //-------------OWNER--------------------------
        if (check1 == 2){
            registerOwnerMenu(resowner , customers);
        }
        input.close();
    }
    
    
    
     public static void registerCustomerMenu(resOwner[] owner3 ,customer[] customers){
         Scanner input = new Scanner(System.in);
            System.out.println("enter (1) to REGISTER");
            System.out.println("enter (2) to LOGIN");
            System.out.println("enter (3) to go to Main menu");
            int check = input.nextInt();
            if (check == 1){
                customers[0].Register(customers[customer.customerNum]);
                registerCustomerMenu(owner3 , customers);
            }
            else if (check == 2){
                customers[0].login(customers);
                System.out.println("Welcome " + customers[customer.loggincust].username);
                customerMenu(owner3 , customers);
            }
            else{
                mainMenu(customers , owner3);
            }
            input.close();

     }
    
    
    public static void registerOwnerMenu(resOwner[] owner3 ,customer[] customers){
        Scanner input = new Scanner(System.in);
            System.out.println("enter (1) to REGISTER");
            System.out.println("enter (2) to LOGIN");
            System.out.println("enter (3) to go to Main menu");
            int check = input.nextInt();
            if (check == 1){
                owner3[0].Register(owner3[resOwner.numRes]);
                registerOwnerMenu(owner3 , customers);
            }
            else if (check == 2){
                 owner3[0].login(owner3);
                 System.out.println("Welcome " + owner3[resOwner.loggedinUser].username);
                 OwnerMenu(owner3 , customers);
            }
            else
            {
                mainMenu(customers , owner3);
            }
            input.close();

    }
    
    
    
    
    
    
    
    
    
    
    public static void OwnerMenu(resOwner[] owner3 ,customer[] customers){
        Scanner input = new Scanner(System.in);
                System.out.println("enter (1) to add meal to your resturant");
                System.out.println("enter (2) Edit meal");
                System.out.println("enter (3) Remove meal");
                System.out.println("enter (4) to brwose resturant's orders");
                System.out.println("enter (5) to logout");
                int check2 = input.nextInt();
                if (check2 == 1){
                    owner3[resOwner.loggedinUser].m[owner3[resOwner.loggedinUser].mealsNum].addMeal(owner3[resOwner.loggedinUser]);
                    OwnerMenu(owner3, customers);
                }
                else if (check2 == 2){
                    System.out.println("enter The number of the meal you want to edit");
                    int check3 = input.nextInt();
                    check3--;
                    owner3[resOwner.loggedinUser].m[check3].editMeal(check3, owner3[resOwner.loggedinUser]);
                    OwnerMenu(owner3, customers);
                }
                else if (check2 == 3){
                    System.out.println("enter The number of the meal you want to delete");
                    int check3 = input.nextInt();
                    check3--;
                    owner3[resOwner.loggedinUser].m[check3].reMeal(check3, owner3[resOwner.loggedinUser]);
                    OwnerMenu(owner3, customers);
                }
                else if (check2 == 4){
                    owner3[resOwner.loggedinUser].browse_orders();
                    OwnerMenu(owner3, customers);
                }
                else{
                    registerOwnerMenu(owner3 , customers);
                }
                input.close();

    }
    
    
     public static void customerMenu(resOwner[] owner3 ,customer[] customers){
          Scanner input = new Scanner(System.in);
                System.out.println("enter (1) browse all avilable resturants");
                System.out.println("enter (2) browse all meals in specific resturant");
                System.out.println("enter (3) make an order");
                System.out.println("enter (4) to browse all your orders");
                System.out.println("enter (5) to logout");
                int check2 = input.nextInt();
                if (check2 == 1){
                    customers[customer.loggincust].browseRes(owner3);
                    customerMenu(owner3, customers);
                }
                else if (check2 == 2){
                    customers[customer.loggincust].browseMeal(owner3);
                    customerMenu(owner3, customers);
                }
                else if (check2 == 3){
                    customers[customer.loggincust].order(owner3);
                    customerMenu(owner3, customers);
                }
                else if (check2 == 4){
                    owner3[resOwner.loggedinUser].browse_orders();
                    OwnerMenu(owner3, customers);
                }
                else{
                    registerCustomerMenu(owner3 , customers);
                }
                input.close();

     }
}
