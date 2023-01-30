import java.util.Scanner;

import com.atm.service.*;

public class ATM {

    public static void main(String[] args) {
        BalanceService balService = new BalanceService();
        StatementService statementService = new StatementService();
        DepositService depositService = new DepositService(balService,statementService);
        WidthrawService widthrawService = new WidthrawService(balService,statementService);
        TransferService transferService = new TransferService(balService,statementService);
       AuthenticationService authenticationService = new AuthenticationService();
       MenuService menuService = new MenuService();



        int count =1;
        while(!authenticationService.isAuthenticate() && count<3){
            count ++;
        }
        if(count ==3){
            System.out.println("You have exceeded the number of attempts. Please try again.");
            System.exit(0);
        }
        while (true) {
            menuService.showMenu();
            Scanner sc = new Scanner(System.in);
            int se = sc.nextInt();

            switch (se){

                case 1:
                    System.out.println("Your balance is: ");
                    System.out.println(balService.getBalance());
                    break;
                case 2:
                    System.out.println("Enter the Amount Deposite Amount: ");
                    double depoAmount = sc.nextDouble();
                    depositService.depositAmount(depoAmount);
                    System.out.println("Deposit Amount of "+ depoAmount + " Successfully deposited");
                    break;
                case 3:
                    System.out.println("Enter the Widraw amount: ");
                    double wiAmount = sc.nextDouble();
                    widthrawService.Widthraw(wiAmount);
                    break;
                case 4:
                    System.out.println("Enter the Transfer Amount: ");
                    double transferAmount = sc.nextDouble();
                    transferService.Transfer(transferAmount);
                    break;
                case 5:
                    System.out.println("*******Account Statement*******");
                    statementService.printStatement();
                    break;
                case 6:
                    System.out.println("######Thank you for Visiting########");
                    System.exit(0);
            }


        }
    }
}