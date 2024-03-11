import java.util.*;

public class Main{

    int transactions=0;
    String t_tran="";
    Scanner sc=new Scanner(System.in);
    String username="";
    String password="";
    String password_1="";
    int acc_no;
    int balance=20000;
    int min_balance=2000;

    public void register() {
        System.out.println("Enter your name:");
        username = sc.next();
        System.out.println("Enter password:");
        password = sc.next();
        System.out.println("Enter password again:");
        password_1 = sc.next();
        if (!password.equals(password_1)) {
            System.out.println("password doesn't match");

        }
        System.out.println("Enter acc_no:");
        acc_no = sc.nextInt();
        System.out.println("You've Registered Successfully, login into your account");
    }
       public boolean login(){
       boolean islogin=false;
           System.out.println("Enter your name:");
           String user_name = sc.next();
           System.out.println("Enter password:");
          String pass_word = sc.next();
          if(user_name.equals(username) && pass_word.equals(password)){
              System.out.println("Welcome "+username);
              islogin=true;
          }
          else
              System.out.println("check your details");

return islogin;

    }
    public void withdraw(int amount){
        if((balance-amount)>=min_balance){
            balance-=amount;
            transactions++;
            t_tran+="withdrawal of amount "+amount+"\n";
            System.out.println("Withdrawal is successful");
            System.out.println("Current Balance is:"+balance);

        }
        else
            System.out.println("Insufficient Funds");


    }
    public void deposit(int amount){

            balance+=amount;
            transactions++;
            t_tran+="Deposit of amount "+amount+"\n";
        System.out.println("balance is:"+balance);
    }
    public void transfer(int amount){
        if((balance-amount)>=min_balance) {
            balance -= amount;
            transactions++;
            t_tran += "Transfer of amount " + amount + "\n";
            System.out.println("Current Balance is:"+balance);
        }
        else{
            System.out.println("Insufficient Funds");
        }

    }

    public void getBalance() {
        System.out.println("balance: " + balance);
    }

    public void trans_his() {
        System.out.println("no of Transactions are: "+transactions);
        System.out.println(t_tran);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Main m=new Main();
        System.out.println("Welcome");
        System.out.println("Please Register, if Registered already then login");
        System.out.println("1.Register \n2.Exit");
        System.out.println("Enter your choice:");
        int choice=sc.nextInt();
        if(choice==1) {

            m.register();
            while(true) {
                System.out.println("1.Login \n2.Exit");
                System.out.println("Enter your choice:");
                int ch=sc.nextInt();
                if(ch==1) {
                    if(m.login()) {
                        boolean isfinished=false;
                        while(!isfinished) {
                            System.out.println(" ");
                            System.out.println("1.Withdraw \n2.Deposit \n3.Transfer \n4.CheckBalance \n5.TransactionHistory \n6.Exit");
                            System.out.println("Enter your choice:");
                            int c=sc.nextInt();
                            switch(c) {
                                case 1:
                                    System.out.println("enter amount:");
                                    int amo=sc.nextInt();
                                    m.withdraw(amo);
                                    break;
                                case 2:
                                    System.out.println("enter deposit amount:");
                                     amo=sc.nextInt();
                                    m.deposit(amo);
                                    break;
                                case 3:
                                    System.out.println("enter amount:");
                                    amo=sc.nextInt();
                                    m.transfer(amo);
                                    break;
                                case 4:
                                    m.getBalance();
                                    break;
                                case 5:
                                   m.trans_his();
                                case 6:
                                    isfinished=true;
                                    break;
                            }
                        }
                    }
                }
                else {
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);

        }
    }
}


