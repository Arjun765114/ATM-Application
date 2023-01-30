import java.util.HashMap;
import java.util.Map;

public class AtmInformation {

    private double balance;
    private double deposit;
    private double withdraw;

   Map<Double,String> statement = new HashMap<>();
    public AtmInformation(){
    }

    public AtmInformation(double balance, double deposit, double withdraw) {
        this.balance = balance;
        this.deposit = deposit;
        this.withdraw = withdraw;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }
//    Balance Check
    public void viewBalance() {
        System.out.println("Your Current Balance is : "+getBalance());
        System.out.println();
    }

//    For Widrawl
    public void withdrawAmount(double wiAmount){

        if (wiAmount>getBalance()){
            System.out.println("Insufficient Balance");
        }
        else
            statement.put(wiAmount,"Widraw Amount");
        System.out.println("Amount Widraw successfully: "+ wiAmount);
        setBalance(getBalance()-wiAmount);
        viewBalance();
    }
//    deposit Method
    public void depositAmount(double depoAmount){
        statement.put(depoAmount,"Deposit Amount");
        System.out.println("Deposite Amount Successfully: "+ depoAmount);
        setBalance(getBalance()+depoAmount);
        viewBalance();
    }
    public void transfer(double trAmount){
        if (trAmount>getBalance()){
            System.out.println("Insufficient Balance");
        }
        else
            statement.put(trAmount,"Transfer Amount");
        setBalance(getBalance()-trAmount);
        viewBalance();
    }
    public void statementQ() {
        for (Map.Entry<Double, String> s : statement.entrySet()) {
            System.out.println(s.getKey() + "" + s.getValue());
        }
    }
}

