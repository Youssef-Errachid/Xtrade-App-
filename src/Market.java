import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Market
{
    static List<Trader> traders = new ArrayList<>();
    static List<CryptoCurrency> cryptos = new ArrayList<>();
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
    public static <T extends Asset> T findAsset(String name, List<T> assetList) {
        for (T asset : assetList) {
            if (asset.getName().equalsIgnoreCase(name)) {
                return asset;
            }
        }
        return null;
    }
    public static <T extends Asset> void addAsset(T asset, List<T> assetList,String assetType){
        T existting = findAsset(asset.getName(), assetList);
        if (existting != null) {
            System.out.println(assetType + " already exists. Updating quantity...");
            int newQuantity = existting.getQuantity() + asset.getQuantity();
            existting.setQuantity(newQuantity);
            System.out.println(assetType + " quantity updated to " + newQuantity);
        } else {
            assetList.add(asset);
            System.out.println(assetType + " added successfully: " + asset.getName());
        }
    }

    public static Stock findStock(String name){
        return findAsset(name,stocks);
    }
    public static CryptoCurrency findCrypto(String name){
     return findAsset(name,cryptos);
    }

    public static void addStock(Stock stock){
     addAsset(stock, stocks, "Stock");
    }
     public static void addCrypto(CryptoCurrency crypto) {
     addAsset(crypto, cryptos, "Cryptocurrency");
    }
       public static <T extends Asset> void displayAssets(List<T> assetList, String assetType) {
        if (assetList.isEmpty()) {
            System.out.println("No " + assetType + "s available");
            return;
        }

        int counter = 1;
        for (T asset : assetList) {
            System.out.println("\n" + assetType + " " + counter++);
            System.out.println("  Name: " + asset.getName());
            System.out.println("  ID: " + asset.getId());
            System.out.println("  Price: $" + asset.getPrice());
            System.out.println("  Type: " + asset.getAssetType());
            System.out.println("  Available Quantity: " + asset.getQuantity());
        }
    }
    public static void displayStock() {
       displayAssets(stocks, "Stock");
    }
     public static void desplayCryptoCrruncy() {
        displayAssets(cryptos, "Cryptocurrency");
    }
      public static <T extends Asset> void removeAsset(String name, List<T> assetList, String assetType) {
        T asset = findAsset(name, assetList);
        if (asset != null) {
            assetList.remove(asset);
            System.out.println(assetType + " removed successfully: " + name);
        } else {
            System.out.println(assetType + " not found: " + name);
        }
    }
    public static void removeStock(String name) {
      removeAsset(name, stocks, "Stock");
    }
    public static void removeCrypto(String name) {
      removeAsset(name, cryptos, "Cryptocurrency");
    }

    public static void changethepiceofCrypto(String name,double newPrice) {
        CryptoCurrency crypto = findCrypto(name);
        if(crypto != null){
            crypto.setPrice(newPrice);
            System.out.println("the price changed successfully");
        }
        else{
            System.out.println("the crypto not found");
        }
    }
    public static void changethepriceofStock(String name,double newPrice) {
        Stock stock = findStock(name);
        if(stock != null){
            stock.setPrice(newPrice);
            System.out.println("the price changed successfully");
        }
        else{
            System.out.println("the stock not found");
        }
    }
}
