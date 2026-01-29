import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Market
{
    private static List<Trader> traders = new ArrayList<>();
    private static List<CryptoCurrency> cryptos = new ArrayList<>();
     static List<Stock> stocks = new ArrayList<>();
     static Scanner sc = new Scanner(System.in);


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
        int counter = 1;
       for(Trader trader:traders){
           System.out.println("Trader " + counter++ );
           System.out.println("Trader name : " + trader.getName());
           System.out.println("Trader ID : " + trader.getId());
           System.out.println("Trader balance : " + trader.getBalance());
       }
    }
    public static Trader findTrader(int id){
    for (Trader trader:traders) {
        if(trader.getId() == id){
            return trader;
        }
    }
    return null;
    }
    public static Stock findStock(String name){
        for (Stock stock:stocks) {
            if(stock.getname().equals(name)){
                return stock;
            }
        }
        return null;
    }
    public static void findCrypto(String name){

    }
    public static void addStock(Stock stock ,String name){
        Stock existingStock = findStock(name);

        if(existingStock != null){
            System.out.println("Stock already exists, add the quantity only");
            int quantity = stock.getquantity();
            int newquantity = existingStock.getquantity() + quantity;
            stock.setQuantity(newquantity);
            stocks.add(stock);
            System.out.println("Stock added successfully");
        }
        else{
           stocks.add(stock);
           System.out.println("Stock added successfully");
        }
    }


    public static void desplaystok() {
        int counter = 1 ;
        for(Stock s : stocks){
            System.out.println("stock "+ counter++);
            System.out.println("stock name : "+ s.getname());
            System.out.println("stock id : " + s.getid());
            System.out.println("stock price : "+ s.getprice());
            System.out.println("stock type : " + s.getAssettype());
        }
    }

    public static void removeStock(String name) {
        Stock stock = findStock(name);
        if(stock != null){
            stocks.remove(stock);
            System.out.println("Stock removed successfully");
        }
    }

    public static void removeCrypto(String name) {

    }
}
