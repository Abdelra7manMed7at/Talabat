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
public class customer extends Person{
    String username ;
    String passwd;
    String address;
    int mobileNum;
    int inputMeal;
    String inputRes;
    int checkout = 0;
    static int customerNum = 0;
    Scanner input = new Scanner(System.in);
    static int loggincust;
    orders[] orders = new orders[50];
    int orderedNum = 0;
    
    customer () {
     for (int i=0 ; i<50 ;i++)
        {
            orders[i] = new orders();
        }
    }
    
    customer(String username , String password , String address , int mobilenum)
    {
        this.username = username ;
        this.passwd = password;
        this.address = address;
        this.mobileNum = mobilenum;
    }
    


    public void Register(customer c) {
        System.out.println("Enter Username");
        username = input.next();
        System.out.println("Enter Password");
        passwd = input.next();
        System.out.println("Enter mobile number");
        c.mobileNum = input.nextInt();
        System.out.println("Enter Address");
        c.address = input.next();
        customerNum ++;
    }
    
    public void login(customer[] c)
    {
        String userinput;
        String passinput;
        int check = 0;
        System.out.println("Enter Username");
        userinput = input.next();
        System.out.println("Enter Password");
        passinput = input.next();
        for (int i = 0; i < customer.customerNum ; i++)
        {
        if (userinput.equals(c[i].username)&&passinput.equals(c[i].passwd))
            {
                check = 1;
                loggincust = i;
                break;
            }
        }
        if (check != 1)
        {
            System.out.println("username or password wrong try again");
            login(c);
        }
    }
    
    
    public void browseRes(resOwner[] res)
    {
        if(resOwner.numRes == 0)
        {
            System.out.println("No resturants avaliable" );
        }
        else{
            for (int i=0 ; i < resOwner.numRes; i++)
            {
                if(res[i].resAvilability == true)
                {
                    System.out.println("The resturant Name : " + res[i].resName);
                }
            }
        }
    }
    public void browseMeal(resOwner[] res)
    {
        int found = 0;
        System.out.println("Enter the resturant name : " );
        inputRes = input.next();
        for (int i=0 ; i<resOwner.numRes; i++)
        {
            if(res[i].resAvilability == true && res[i].resName.equals(inputRes))
            {
                found = 1;
                System.out.println("The resturant Name : " );
                System.out.println(res[i].resName);
                System.out.println("The resturant Meals : " );
                for(int j=0; j<res[i].mealsNum ; j++)
                {
                System.out.println("Meal number : " + j+1);
                res[i].m[j].showMeal();
                }
            }
        }
        if (found == 0)
        {
            System.out.println("there is no resturant called " +  inputRes);
        }
    }
    
    public void order(resOwner[] res)
    {   String date;
        int mealPrice;
        int quantity;
        String Notes;
        int resFound = 0;
        System.out.println("Enter the resturant name : " );
        inputRes = input.next();
        for (int i=0 ; i<resOwner.numRes; i++)
        {
            if(res[i].resAvilability == true && res[i].resName.equals(inputRes))
            {
                resFound = 1;
                System.out.println("Enter the meal number : " );
                inputMeal = input.nextInt();
                inputMeal--;
                if (inputMeal > res[i].mealsNum)
                {
                    System.out.println("No meals found" );
                }
                else
                {
                for(int j=0; j<res[i].mealsNum ; j++)
                    {
                        if(j == inputMeal)
                        {
                            
                        System.out.println("How many Meals : " );
                        quantity = input.nextInt();
                        mealPrice = res[i].m[j].getMealPrice();
                        //Modified line 110 l7ad 114
                        date = java.time.LocalDate.now().toString();
                        System.out.println("Any additional notes ?  , If not Write : (No Additional Notes)");
                        Notes=input.next();
                        
                        cart(res ,inputRes , inputMeal , mealPrice , quantity);
                        //Modified line 118
                        res[i].Storing_orders(j , quantity , Notes , date);
                        }
                    }
                }
            }
            if (resFound == 0)
            {
                System.out.println("No resturants found" );
            }
        }
        
    }
    public void cart(resOwner[] res ,String inputRes ,int inputMeal ,int mealPrice ,int quantity )
    {
        int totalprice;
        String check;
        totalprice = mealPrice * quantity;
        checkout += totalprice;
        System.out.println("resturant name : " + inputRes );
        System.out.println("Meal number : " + ++inputMeal);
        System.out.println("Meal price : " + mealPrice);
        System.out.println("quantity : " + quantity);
        System.out.println("price : " + totalprice);
        
        orders[orderedNum].resturantName = inputRes;
        orders[orderedNum].mealNum = inputMeal++;
        orders[orderedNum].quantity = quantity;
        orders[orderedNum].totalprice = totalprice;
        
        orderedNum++;
        
        
        System.out.println("Do you want order again (yes or no) : ");
        check = input.next();
        if (check.equals("yes") || check.equals("YES"))
        {
            order(res);
        }
        else
        {
        System.out.println("total price : " + checkout);
        }
    }
    
    public void browse_orders(){
        if (orderedNum == 0){
            System.out.println("you didn't ordered yet..");
        }
        else{
            for (int i=0; i < orderedNum; i++){
             System.out.println("resturant Name : " + orders[i].resturantName);
             System.out.println("meal number : " + orders[i].mealNum);
             System.out.println("Quantity " + orders[i].quantity);
             System.out.println("total price : " + orders[i].totalprice);
             System.out.println("---------------------------------------------------------");
            }
        }
    }
    
}
