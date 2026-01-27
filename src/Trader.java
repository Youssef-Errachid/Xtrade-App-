public class Trader {
    private String name;
    private int ID;
    private double balance;
 public  Trader(String name, int ID,  double balance){
     this.name = name;
     this.ID = ID;
     this.balance = 0;
 }
 public int  getID(){
     return ID;
 }
 public double getBalance(){
     return balance;
 }
 public String getName(){
     return name;
 }
 @Override
    public String toString(){
     return "Trader{" + "name=" + name + ", ID=" + ID + ", balance=" + balance + '}';
 }

}
