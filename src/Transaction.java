import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {
    private Trader trader;
    private Asset asset;
    private int quantity;
    private double totalPrice;
    private String type;
    private LocalDate dateTime;

    public Transaction(Trader trader, Asset asset, int quantity, String type){
        this.trader = trader;
        this.asset = asset;
        this.quantity = quantity;
        this.type = type;
        this.totalPrice = asset.getPrice() * quantity;
        this.dateTime = LocalDate.now();
    }


    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
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
