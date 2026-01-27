public class Asset {
    private String name;
    private String id;
    private double price;
    private String assetType;
    public Asset(String name, String id, double price, String assetType) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.assetType = assetType;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        assetType = assetType;
    }

    @Override
    public String toString() {

        return "Asset{name='" + name + "', id='" + id + "', price=" + price + ", type='" + assetType + "'}";
    }


}
