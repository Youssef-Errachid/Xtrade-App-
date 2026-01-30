import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Stock> stocks;
    private List<CryptoCurrency> cryptoCurrencies;
    private Trader trader;

    public Portfolio(Trader trader){
        this.trader = trader;
        this.stocks = new ArrayList<>();
        this.cryptoCurrencies = new ArrayList<>();
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

    public void removeCrypto(String name){
        cryptoCurrencies.removeIf(c -> c.getName().equals(name));
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
}
