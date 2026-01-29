import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private static List<Stock> stocks = new ArrayList<>();
    private static List<CryptoCurrency> cryptoCurrencies = new ArrayList<>();
    public Trader trader;

    public static void addStock(Stock stock){
        stocks.add(stock);
    }

}
