
import java.util.Random;
import java.util.Scanner;


public class LaxmiATM {
     

    private int accountnumber;
    private int pin;
    private double deposit_balance;
    private int choice;             //this one if user wants to select another feature of ATM again //

    /*Used random class to create a scenario of different bank balance for learning*/

    Random random = new Random();

    // storing it in the user balance
    double user_balance = random.nextDouble(5000);

    //Parameterised constructors

    LaxmiATM(int accountnumber, int pin){

        this.accountnumber = accountnumber;
        this.pin = pin;
        
    }

    //getters

    public int getAccountNumber(){

        return accountnumber;
    }

    public int getPin(){

        return pin;
    }

    public void checkBalance(){

        double current_cash = user_balance + deposit_balance;
        System.out.println("Your current cash is Rs " + current_cash);
    }

     public void withdraw(){

        //ATM policy, balance must exceed Rs 2000 to withdraw!
        if(user_balance > 2000){

            System.out.println("You can withdraw the money");
            System.out.println("Enter the amount and collect it");
        }

        else{

            System.out.println("......Balance insufficient ......, Read the ATM guidelines");
        }
    }


    /* While testing my code, I found an error, with balance shown as Rs 0.
     Must be the scope of variable, on searching, I decided to pass a parameter
     */

    public void deposit(double amount){ 

        deposit_balance = amount;

        System.out.println("You have deposited  Rs  " + deposit_balance);
    }


    public static void main (String[] args){

        // The first thing user has to enter his account number and pin

        Scanner  sc = new Scanner(System.in); // For realistic scenario, like users will have different accountnum;

        System.out.println("Please enter your accountnumber");
        int accountnumber = sc.nextInt();

        System.out.println("Please enter your pin");
        int pin = sc.nextInt();

        // Now the users can start with their ATM service

        System.out.println("Welcome to LaxmiATM");
        System.out.println("Enter 1 to start and 0 to exit");

        //Creation of objects to call the method//
        LaxmiATM service = new LaxmiATM(accountnumber, pin);

        // Since, there is no scanner method for char, used the int 
        int choice = sc.nextInt();

        if (choice == 1){

            System.out.println("How can the Laxmi ATM help you?");
            System.out.println(" LaxmiATM Services list");

            System.out.println("1 : Deposit money straight into your account");
            System.out.println("2 : Load the current balance");
            System.out.println("3 : Withdraw some cash");
            System.out.println("4 : Customer service ");

            System.out.println("Enter the service you like");
            int options = sc.nextInt();

            switch(options){

                case 1:

                System.out.println("You have decided to deposit, enter the amount please!");
                double deposit_balance = sc.nextDouble();
                service.deposit(deposit_balance);  //Passed the value, it was showing error with no parameter inside.
                break;

                case 2:

                System.out.println("Loading ..............");
                service.checkBalance();
                break;

                case 3:

                System.out.println("Your money will be withdrawn if sufficient enough");
                service.withdraw();
                break;

                case 4:

                System.out.println("Fill the form, give it to the bank services");
                System.out.println("Always open to feedback");
                break;

                default:
                System.out.println("OOPS ! A wrong button was pressed");

            }
        }

        else if (choice == 0){

            System.out.println("Revisit us again");
        }

        else{

            System.out.println("Follow what's said in the portal");
        }

        
        System.out.println("Thank you for visiting Shree Laxmi ATM");
        System.out.println("Remain prosperous !!!");



            


        }



        
        

    }


