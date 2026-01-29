public abstract class Asset {
    private String name;
    private String id;
    private double price;
    private String assetType;
    private int quantity;
    public Asset(String name, String id, double price, String assetType, int quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.assetType = assetType;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAssetType(String assetType) {
        assetType = assetType;
    }

    @Override
    public String toString() {

        return "Asset{name='" + name + "', id='" + id + "', price=" + price + ", type='" + assetType + "'}";
    }


}
