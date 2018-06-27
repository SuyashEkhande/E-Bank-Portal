/**
 *      Project Name : E Bank Solutions Portal Application
 *       Author Name : Suyash Jayendra Ekhande
 *               IDE : Netbeans
 *           License : MIT
 *              Date : 20/6/2018
 **/

package e.banksolutions;

import java.util.Scanner;

import java.util.Random;
import java.util.Date;

public class EBankSolutions {
    
        long accountNumber;            // Variable for Storing account number
        long accountNumberGenerator=0000;   // Variable for generating and assigning account number
        String AccountHolderName;     // Variable for Storing account holder name
        String AccountType;           // Variable for Storing account type in string
        int AccTypeNumVal;
        long accountBalance;          // Variable to Store Current Account Balance. 
        String password;                //27-06-2018
        //----------------------------------------------------------------------------//
    
    public void createAccount() throws InterruptedException
    {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in); // Scanner variable for accepting value from user
        System.out.println("----------------Welcome to Account Creation Portal-------------------");
        //accountNumberGenerator++; //Incrementing the account number generator var
        accountNumber=rand.nextInt(1000);; //assigning the account number
        System.out.println("Enter Your Name(Without Space Between Name) : ");
        AccountHolderName=scan.next();
        System.out.println("Enter New Password : ");                //27-06-2018
        password=scan.next();                                       //27-06-2018
        System.out.println("Enter Your Account Type Savings/Current");
        AccountType=scan.next();
        
       /* if(AccountType == "Savings"){
            AccTypeNumVal=1;
        }
        else if(AccountType == "Current"){
            AccTypeNumVal=2;
        }*/
        
    bal:System.out.println("Enter your starting balance : ");
        accountBalance=scan.nextLong();
        if(accountBalance<5000){
            System.out.println("Oops!!! Your Account balance should be minimum 5000 or more.\nYou need to fill the form again.");
            System.exit(0);
        }
        
        System.out.println("Account Created Successfully.\nYour Account Number is: "+accountNumber+" Please Note it Down.");
        System.out.println("------------------------------------------------------------");
        //Delay code below
        Thread.sleep(5000);
        System.out.flush();
    }
    
    public void DisplayAccount() throws InterruptedException
    {
        System.out.println("Displaying Account Information for Account Number : "+accountNumber);
        System.out.println("------------------------------------------------------------");
        System.out.println("Account Number  : "+accountNumber);
        System.out.println("Account Name    : "+AccountHolderName);
        System.out.println("Account Type    : "+AccountType);
        System.out.println("Account balance : "+accountBalance);
        System.out.println("Your Password   : _Hidden_"); //27-06-2018
        System.out.println("------------------------------------------------------------");
        Thread.sleep(5000);
        System.out.flush();
    }
    
    public void DepositAmount() throws InterruptedException
    {
        Scanner scan = new Scanner(System.in); // Scanner variable for accepting value from user
        long depositAmt;
        System.out.println("---------------Welcome to Deposit Portal----------------");
        System.out.println("You are Depositing amount for Account Number: "+accountNumber);
        System.out.println("\nEnter the Amount to Deposit : ");
        depositAmt=scan.nextLong();
        accountBalance=accountBalance+depositAmt;
        System.out.println("Amount Deposited Successfully.. \nUpdated Balance: "+accountBalance);
        System.out.println("------------------------------------------------------------");
        Thread.sleep(5000);
        System.out.flush();
    }
    
    
    public void WithdrawAmount() throws InterruptedException
    {
        Scanner scan = new Scanner(System.in); // Scanner variable for accepting value from user
        long withdrawAmt;
        System.out.println("---------------Welcome to Deposit Portal----------------");
        System.out.println("You are Withdrawing amount for Account Number: "+accountNumber);
        System.out.println("\nEnter the Amount to Withdraw : ");
        withdrawAmt=scan.nextLong();
        accountBalance=accountBalance-withdrawAmt;
        System.out.println("Amount Withdrawn Successfully.. \nUpdated Balance: "+accountBalance);
        System.out.println("------------------------------------------------------------");
        Thread.sleep(5000);
        System.out.flush();
    }
    
    public void login() throws InterruptedException
    {
        int ch=0;
        Scanner scan = new Scanner(System.in);
        long accNum=0;
        String passWd="0";
        System.out.println("Enter Account Number : ");
        accNum=scan.nextLong();
        System.out.println("Enter Your Password  : ");
        passWd=scan.next();           
        if (accNum==this.accountNumber && passWd==this.password) {
            System.out.println("Logged In Successfully with account number: "+accountNumber+"\n-------------------------------------");   
            System.out.println("Choose Option Number From Below Menu");
            System.out.println("1.Deposit Amount\n2.Withdraw Amount\n3.Display Account Info\n4.Close Account\n5.Exit");
            ch=scan.nextInt();
            switch(ch)
            {
                case 1: DepositAmount();
                        break;
                case 2: WithdrawAmount();
                        break;
                case 3: DisplayAccount();
                        break;
                case 4: System.out.println("You cannot close your account. Feature Coming Soon...");
                        break;
                case 5: System.exit(0);
                        break;
            }
        } 
        else if(accNum!=accountNumber && passWd!=password) {
            System.out.println("You have Entered Incorrect Account Number or Password. Please Check Again.");
            Thread.sleep(5000);
            System.out.flush();
            System.exit(0);
        }
        else{
            System.out.println("Unknown Error Occured. Try Agian Later");
            Thread.sleep(5000);
            System.out.flush();
            System.exit(0);
        }
    }
    
    
    EBankSolutions()
    {
        accountNumber=0000;
        AccountHolderName="UNDEFINED";
        AccountType="UNDEFINED";
        accountBalance=0000;
        accountNumberGenerator=0000;
        AccTypeNumVal=9;
    }
        
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in); // Scanner variable for accepting value from user
        EBankSolutions a1 = new EBankSolutions();
        int ch;
        int i=0;
        System.out.println("Welcome to Bank E Portal\n");
       while(i!=5)
       {
        System.out.println("Select any Choice Number From below menu...");
        System.out.println("1. Create Account\n2. Login\n3. Exit Portal");
        System.out.print("Enter Your Choice Code 1-4: ");
        ch=scan.nextInt();
        switch(ch)
        {
            case 1: a1.createAccount();
                    break;
                  
            case 2: a1.login();
                    break; 
                    
            case 3: System.exit(0);
                    break;
                    
        }
        
       }
    }
    
}
