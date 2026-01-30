public class CryptoCurrency extends Asset{
    public CryptoCurrency(String name, String id, double price, String AssetType, int quantity) {
        super(name,id,price,AssetType,quantity);

    }
    public String getname(){
        return this.getName();
    }
    public String getid(){
        return this.getId();
    }
    public double getprice(){
        return this.getPrice();
    }
    public String getAssettype(){
        return this.getAssetType();
    }
    public int getquantity(){
        return this.getQuantity();
    }

}
