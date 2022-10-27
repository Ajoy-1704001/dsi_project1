import java.util.ArrayList;
import java.util.Scanner;

import controller.DataController;
import model.Consumable;

public class App {
    public static void main(String[] args) throws Exception {
        DataController dataController = new DataController();
        dataController.insert(new Consumable(1,"Dark","Series","","",10.0,10.5,5));
        dataController.insert(new Consumable(2,"Dark","Series","1999-12-01","",10.0,10.5,5));
        Scanner input = new Scanner(System.in);
        int choice = 0;
        do{
            menu();
            choice = input.nextInt();

            switch(choice){
                case 1:
                    System.out.println("\nAdd Consumable\n");
                    Consumable consumable = AddConsumable();
                    dataController.insert(consumable);
                    break;
                case 2:
                    System.out.println("\nEdit Consumable\n");
                    System.out.println("Enter Id:");
                    int idToEdit = input.nextInt();
                    dataController.EditConsumable(idToEdit);
                    break;
                case 3:
                    System.out.println("\nDelete Consumable\n");
                    int toDelete = input.nextInt();
                    dataController.delete(toDelete);
                    break;
                case 4:
                    System.out.println("\nSee the list of consumables and individually\n");
                    String cType = displayTypeWise();
                    dataController.display(cType);
                    break;
                case 5:
                    System.out.println("\nSee the overall info\n");
                    dataController.statistics();
                    break;
                default:
                    System.out.println("\nInvalid input\n");
                    break;
            }
        }while(choice!=6);
    }

    public static void menu()
    {
        System.out.println("######Your Productivity Tool#######");
        System.out.println("----------------------------------");
        System.out.println("1. Add a consumable");
        System.out.println("2. Edit a consumable");
        System.out.println("3. Delete a consumable");
        System.out.println("4. See the list of consumables and individually");
        System.out.println("5. See overall info");
        System.out.println("6. Exit");
        System.out.println("----------------------------------");
    }



    public static Consumable AddConsumable(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Id:");
        int id = input.nextInt();

        System.out.println("Enter Type of Consumable:(Book=1, Series=2, Movie=3");
        int t = input.nextInt();
        String type="";
        if(t==1){
            type = "Book";
        }else if(t==2){
            type ="Series";
        }else if(t==3){
            type ="Movie";
        }
        input.nextLine();
        System.out.println("Enter Name");
        String cName = input.nextLine();

        System.out.println("Enter Starting date:(optional)");
        String startDate = input.nextLine();

        System.out.println("Enter Ending Date:(optional)");
        String endDate = input.nextLine();

        System.out.println("Enter Total consumption time in hours:");
        Double hours = input.nextDouble();

        System.out.println("Enter Rating out of 10");
        Double rating = input.nextDouble();

        System.out.println("Total Days of Consumption");
        int days = input.nextInt();


        startDate = startDate==null? "":startDate;
        endDate = endDate==null?"":endDate;
        hours = hours==null? 0.0: hours;
        rating = rating==null?0.0:rating;
        // days = days=?0.0:days;

        Consumable consumable = new Consumable(id,cName,type,startDate,endDate,hours,rating,days);
        return consumable;
    }



    public static String displayTypeWise(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Type of Consumable:(Book=1, Series=2, Movie=3)");
        int t = input.nextInt();
        if(t==1){
            return "Book";
        }else if(t==2){
            return "Series";
        }else if(t==3){
            return "Movie";
        }else{
            System.out.println("Not available!!!");
            return "";
        }
    }
}
