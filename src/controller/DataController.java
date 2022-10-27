package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Consumable;

public class DataController {
    ArrayList<Consumable> list;
    Double consumptionTimeHours;
    int consumptionTimeDays;
    Double type1Hours ;
    Double type2Hours;
    Double type3Hours;
    int totalType1;
    int totalType2;
    int totalType3;

    public DataController() {
        list = new ArrayList<>();
        consumptionTimeHours =0.0;
        consumptionTimeDays= 0;
        type1Hours=0.0;
        type2Hours=0.0;
        type3Hours=0.0;
        totalType1 =0;
        totalType2 = 0;
        totalType3 = 0;
    }

    public void insert(Consumable consumable){
        if (!search(consumable.getIdNumber())) {
            list.add(consumable);

            consumptionTimeDays+=consumable.getDays();
            consumptionTimeHours+=consumable.getTotalhours();
            if(consumable.getType()=="Book"){
                type1Hours+=consumable.getTotalhours();
                totalType1++;
            }
            else if(consumable.getType()=="Series"){
                type2Hours+=consumable.getTotalhours();
                totalType2++;
            }
            else if(consumable.getType()=="Movie"){
                type3Hours+=consumable.getTotalhours();
                totalType3++;
            }
            
        }
        else {
            System.out.println(
                "Duplicate Entry");
        }
    }

    public boolean search(int id){
        for (Consumable c : list) {
            if (c.getIdNumber() == id) {
                return true;
            }
        }
        return false;
    }

    public void delete(int id)
    {
        Consumable consumable=null;
        for (Consumable c : list) {
            if (c.getIdNumber() == id) {
                consumable = c;
            }
        }
        if (consumable == null) {
            System.out.println("Nothing exists!!!");
        }
        else {
            list.remove(consumable);
            System.out.println(
                "Successfully removed record from the list");
        }
    }

    public void EditConsumable(int id){
        Consumable consumable=null;
        for (Consumable c : list) {
            if (c.getIdNumber() == id) {
                consumable = c;
                System.out.println(
                "What do you want to edit?");
                System.out.println(
                "1) Total Consumption Time(Hours)");
                System.out.println(
                "2) Add days:");
                System.out.println(
                "3) Change rating");
                System.out.println(
                "4) Add End Date:");
                Scanner input = new Scanner(System.in);
                int option = 0;
                option = input.nextInt();
                switch(option){
                    case 1:
                        System.out.println(
                        "Hours:");
                        double tc = input.nextDouble();
                        c.setTotalhours(c.getTotalhours()+tc);
                        consumptionTimeHours+=tc;
                        break;
                    case 2:
                        System.out.println(
                        "Days:");
                        int d = input.nextInt();
                        c.setDays(c.getDays()+d);
                        // consumptionTimeDays+=d;
                        break;
                    case 3:
                        System.out.println(
                        "Hours:");
                        double rating = input.nextDouble();
                        c.setRatings(rating);
                        break;
                    case 4:
                        if(c.getEndDate()==""){
                            System.out.println(
                        "End Date:");
                            String eDate = input.nextLine();
                            c.setEndDate(eDate);
                        }else{
                                System.out.println(
                            "You can not edit this consumable!!!");
                        }
                        break;
                    default:
                        System.out.println("\nCancelled\n");
                        break;
                }

                
            }
        }
        if(consumable==null){
            System.out.println("Nothing exists!!!");
        }else{
            System.out.println(
                "Successfully Edited!!!");
        }
    }

    public void display(String cType){
        System.out.format("%-10s%-10s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Type", "Name", "Start Date","End Date","Ratings","Total Hours","Days");
        System.out.println("------------------------------------------------------------------------------------------------");
        for(Consumable c:list){
            if(c.getType()==cType){
                System.out.format("%-10d%-10s%-15s%-15s%-15s%-15f%-15f%-15d\n", c.getIdNumber(), c.getType(), c.getName(), c.getStartDate(),c.getEndDate(),c.getRatings(),c.getTotalhours(),c.getDays());
            }
        }
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    public void statistics(){
        
        System.out.println("---------------------------------------------------");
        
        System.out.println("The total consumption time in hours across all types: "+consumptionTimeHours);
        System.out.println("Consumption time in Books: "+type1Hours+" hours");
        System.out.println("Consumption time in Series: "+type2Hours+" hours");
        System.out.println("Consumption time in Movies: "+type3Hours+" hours");
        System.out.println("The total days of consumption across all types: "+consumptionTimeDays+" days");
        System.out.println("Total number of consumable across all types: "+list.size());
        System.out.println("Total #Consumption in Books: "+totalType1);
        System.out.println("Total $Consumption in Series: "+totalType2);
        System.out.println("Total #Consumption in Movies: "+totalType3);

    }

    
    
}
