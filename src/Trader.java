public class Trader extends Person {
    private double balance;
    Portfolio portfolio;

 public  Trader(String name, int id, double balance){
  super(name,id);
     this.balance = 0;
 }

 @Override
    public String toString(){
     return "Trader{" + "name=" + this.getName() + ", ID=" + this.getId() + ", balance=" + balance + '}';
 }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
