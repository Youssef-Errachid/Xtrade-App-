import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Stock> stocks;
    private List<CryptoCurrency> cryptoCurrencies;
    private List<Transaction> transactions;
    private Trader trader;

    public Portfolio(Trader trader){
        this.trader = trader;
        this.stocks = new ArrayList<>();
        this.cryptoCurrencies = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }
    public void addStock(Stock stock){

        stocks.add(stock);
    }
    public void addCrypto(CryptoCurrency crypto){

        cryptoCurrencies.add(crypto);
    }
    public void removeStock(String name){

        stocks.removeIf(s -> s.getName().equals(name));
    }
    public void removeCrypto(String name) {

        cryptoCurrencies.removeIf(c -> c.getName().equals(name));
    }
    public void  addTransaction(Transaction transaction) {

        transactions.add(transaction);
    }
    public void displayPortfolio(){
        System.out.println("Portfolio of Trader: " + trader.getName());
        if(stocks.isEmpty() && cryptoCurrencies.isEmpty()){
            System.out.println("Portfolio is empty");
            return;
        }
        for(Stock s : stocks){
            System.out.println("Stock: " + s.getName() + " | Quantity: " + s.getQuantity() + " | Price: " + s.getPrice());
        }
        for(CryptoCurrency c : cryptoCurrencies){
            System.out.println("Crypto: " + c.getName() + " | Quantity: " + c.getQuantity() + " | Price: " + c.getPrice());
        }
    }
    public void transactionHistorique() {

        for(Transaction transaction : transactions){
            System.out.println("Trader : " +transaction.getTrader().getName());
            System.out.println("Asset : " +transaction.getAsset().getName());
            System.out.println("Quantity : " +transaction.getQuantity());
            System.out.println("Transaction Type : " + transaction.getType());
            System.out.println("Total Price : " +transaction.getTotalPrice());
            System.out.println( "Date " + transaction.getDateTime());
        }
    }
    public  double CalculationTheTotalVolumeTradedPerTrader(Trader trader) {
        return transactions.stream()
                .filter(t -> t.getTrader().equals(trader))
                .mapToDouble(Transaction::getTotalPrice)
                .sum();
    }
    public long CalculatingTheTotalNumberfoOrdersPlaced(Trader trader) {
        return transactions.stream()
                .filter(t -> t.getTrader().equals(trader))
                .count();
    }
}
