public class Stock extends Asset{
    Stock(String name, String id, double price, String AssetType) {
        super(name,id,price,AssetType);

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

}
