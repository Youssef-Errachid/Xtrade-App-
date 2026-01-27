import java.util.ArrayList;
import java.util.List;

public class Market
{
    private static List<Trader> traders = new ArrayList<Trader>();

    public static void addTrader(Trader trader){
        if(traders.contains(trader)){
            System.out.println("Trader already exists");
            return;
        }

            traders.add(trader);
                System.out.println("Trader added successfully");

    }
    public static void removeTrader(int id){
     Trader trader = findTrader(id);
     if(trader == null){
         System.out.println("Trader not found");
         return;
     }

         traders.remove(trader);
         System.out.println("Trader removed successfully");

    }
    public static void getTraders(){
        System.out.println("=============================");
        System.out.println("       Traders info ");
        System.out.println("=============================");
        int counter = 1;
       for(Trader trader:traders){
           System.out.println("Trader " + counter++ );
           System.out.println("Trader name : " + trader.getName());
           System.out.println("Trader ID : " + trader.getID());
           System.out.println("Trader balance : " + trader.getBalance());
       }
    }
    public static Trader findTrader(int id){
    for (Trader trader:traders) {
        if(trader.getID() == id){
            return trader;
        }
    }
    return null;
    }
}
