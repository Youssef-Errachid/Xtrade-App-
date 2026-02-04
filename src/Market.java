import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Market
{
    static List<Trader> traders = new ArrayList<>();
    static List<CryptoCurrency> cryptos = new ArrayList<>();
    static List<Stock> stocks = new ArrayList<>();
    static List<Transaction> transactions = new ArrayList<>();
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
    public static void buyCrypto(String name, int quantity, int id) {
        Trader trader = traders.get(id -1);
        if(trader.portfolio == null){
            trader.portfolio = new Portfolio(trader);
        }
        CryptoCurrency crypto = findCrypto(name);
        if(crypto != null){ trader.portfolio.addCrypto(new CryptoCurrency(crypto.getName(), crypto.getId(), crypto.getPrice(), crypto.getAssetType(), quantity));
            Transaction t = new Transaction(trader, crypto, quantity, "BUY");
            trader.portfolio.addTransaction(new Transaction(trader, crypto, quantity, "BUY"));
            transactions.add(t);
            System.out.println("Transaction added successfully");

        } else {
            System.out.println("Crypto not found");
        }
    }
    public static void buyStock(String name, int quantity, int id) {
        Trader trader = Market.traders.get(id -1);
        if(trader.portfolio == null){
            trader.portfolio = new Portfolio(trader);
        }
        Stock stock = Market.findStock(name);
        if(stock != null){
            trader.portfolio.addStock(new Stock(stock.getName(), stock.getId(), stock.getPrice(), stock.getAssetType(), quantity));
            Transaction t = new Transaction(trader, stock, quantity, "BUY");
            transactions.add(t);
            trader.portfolio.addTransaction(new Transaction(trader, stock, quantity, "BUY"));
            System.out.println("Transaction added successfully");
        }
        else {
            System.out.println("Stock not found");
        }
    }
    public static void dispalyallTransaction() {
        for(Transaction transaction : transactions){
            System.out.println("Trader : " +transaction.getTrader().getName());
            System.out.println("Asset : " +transaction.getAsset().getName());
            System.out.println("Quantity : " +transaction.getQuantity());
            System.out.println("Transaction Type : " + transaction.getType());
            System.out.println("Total Price : " +transaction.getTotalPrice());
            System.out.println( "Date " + transaction.getDateTime());
        }
    }
    public static void filterByAssetName(String name) {
        List<Transaction> filtered = transactions.stream()
                .filter(t -> t.getAsset().getName().equalsIgnoreCase(name))
                .toList();
        filtered.forEach(System.out::println);
    }
    public static void filterbyTransactiontype(String type) {
        List<Transaction> filtered = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase(type))
                .toList();
        filtered.forEach(System.out::println);
    }
    public static void filterbyDaterange(LocalDate date1, LocalDate date2) {
        List<Transaction> tr = transactions.stream()
                .filter(t -> date1.isBefore(t.getDateTime()) && t.getDateTime().isBefore(date2))
                .toList();
        tr.forEach(System.out::println);
    }
    public static void sortTransactionByDate() {
        List<Transaction>  tr = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getDateTime).reversed())
                .collect(Collectors.toList());
        tr.forEach(System.out::println);
    }
    public static void sortTransactionByAmount() {
        List<Transaction>  tr = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getTotalPrice).reversed())
                .collect(Collectors.toList());
        tr.forEach(System.out::println);
    }
}
