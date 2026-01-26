import java.util.ArrayList;
import java.util.List;

public class Market
{
    private static List<Trader> traders = new ArrayList<Trader>();
    public static void addTrader(Trader trader){
        traders.add(trader);
    }
    public static void removeTrader(Trader trader){
        traders.remove(trader);
    }
    public static void getTraders(){
       for(Trader trader:traders){
           System.out.println(trader);
       }
    }
}
