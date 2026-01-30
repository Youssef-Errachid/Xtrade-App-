import java.time.LocalDateTime;

public class Transaction {
    private Trader trader;
    private Asset asset;
    private int quantity;
    private double totalPrice;
    private String type; // "BUY" or "SELL"
    private LocalDateTime dateTime;

    public Transaction(Trader trader, Asset asset, int quantity, String type){
        this.trader = trader;
        this.asset = asset;
        this.quantity = quantity;
        this.type = type;
        this.totalPrice = asset.getPrice() * quantity;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString(){
        return "Transaction{" +
                "trader=" + trader.getName() +
                ", asset=" + asset.getName() +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", type='" + type + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
