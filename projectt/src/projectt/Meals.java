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
public class Meals {
    private String mealName;
    private int mealPrice;
    private String mealDes;
    Scanner input = new Scanner(System.in);
    
    public Meals () {}
    
    public Meals(String mealname , int mealprice , String mealdes)
    {
        this.mealName = mealname;
        this.mealPrice = mealprice;
        this.mealDes = mealdes;
    }

    public String getMealName() {
        return mealName;
    }
    
    public void addMeal(resOwner owner)
    {
        System.out.println("Enter Meal Name");
        mealName = input.next();
        System.out.println("Enter Meal Price");
        mealPrice = input.nextInt();
        System.out.println("Enter Meal Description");
        mealDes = input.next();
        
        owner.mealsNum++;
    }
    
    
    public void editMeal(int m , resOwner owner)
    {
        if (m+1 < owner.mealsNum)
        {
            System.out.println("The meal dosen't exist");
        }
        else{
        System.out.println("Enter new Meal's name");
        owner.m[m].mealName = input.next();
        System.out.println("Enter new Meal's Price");
        owner.m[m].mealPrice = input.nextInt();
       System.out.println("Enter new Meal's Description");
        owner.m[m].mealDes = input.next();
        }
    }
    public void reMeal(int m , resOwner owner)
    {
        if (m+1 < owner.mealsNum)
        {
            System.out.println("The meal dosen't exist");
        }
        else{
            owner.m[m].mealName = "no meal";
            owner.m[m].mealPrice = 0;
            owner.m[m].mealDes = "no descreption";
        }
    }
    public void showMeal()
    {
        System.out.println("Meal Name : " + mealName);
        System.out.println("Meal Price : " + mealPrice);
        System.out.println("Meal Description : " + mealDes);
    }
    public int getMealPrice() {
        return mealPrice;
    }
}
