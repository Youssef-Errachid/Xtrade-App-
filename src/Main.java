import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void menuPrincipal(){
        System.out.println("=============================");
        System.out.println("   Welcome to Xtrade app ");
        System.out.println("=============================");
        System.out.println("1. Admin section");
        System.out.println("2. Trader section");
        System.out.println("=============================");
    }
    public static void controller(int choice){
        switch(choice){
            case 1:
                menuofAdmin();
                break;
            case 2:
                menuofTrader();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static void menuofAdmin(){
        System.out.println("============================");
        System.out.println("      Administrator");
        System.out.println("============================");
        System.out.println("1. Add Trader");
        System.out.println("2. Desplay all Traders");
        System.out.println("3. Desplay Market Stock");
        System.out.println("4. Desplay Market Crypto Currency");
        System.out.println("5. Change the price of Asset");
        System.out.println("6. Add Asset");
        System.out.println("7. Remove Trader");
        System.out.println("8. Remove Asset");
        System.out.println("0. Exit");
        int choice = getchoice("Enter your choice between 1 and 7");
        AdminController(choice);
    }
    public static void AdminController(int choice){
        switch(choice){
            case 1:
                addTrader();
                break;
            case 2:
                displayTraders();
                break;
            case 3:
                desplaystockofMarket();
                break;
            case 4:
                desplaycryptoofMarket();
                break;
            case 5:
                changethepriceofAsset();
                break;
            case 6:
                addAsset();
                break;
            case 7:
                removeTreader();
                break;
            case 8:
                removeAsset();
                break;
            case 0:
                System.out.println("Exit the program");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static void menuofTrader(){
        System.out.println("============================");
        System.out.println("          Trader");
        System.out.println("============================");
        System.out.println("1. Desplay Portfolio ");
        System.out.println("2. buy an asset");
        System.out.println("3. sell an asset");
        System.out.println("4. Exit");
        int choice = getchoice("Enter your choice between 1 and 4");
        TraderController(choice);

    }
    public static void TraderController(int choice){
        switch(choice){
            case 1:
                //desplayPortfolio(();
                break;
            case 2:
                //buyanAsset();
                break;
            case 3:
                //sellanAsset();
                break;
            case 0:
                System.out.println("Exit the program");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static int getchoice(String message){
        System.out.println(message);
        int choice = sc.nextInt();
        return choice;
    }
    public static void addTrader(){
        System.out.println("=============================");
        System.out.println("        Add Trader ");
        System.out.println("=============================");
        System.out.println("Enter Trader Name:");
        String name = sc.next();
        System.out.println("Enter Treder ID ");
        int id = sc.nextInt();
        System.out.println("Enter initial balance");
        double balance = sc.nextDouble();
        Trader trader = new Trader(name,id,balance);
        Market.addTrader(trader);
    }
    private static void removeTreader() {
        System.out.println("=============================");
        System.out.println("       Remove Trader ");
        System.out.println("=============================");
        System.out.println("Enter Trader ID to remove");
        int id = sc.nextInt();
        Market.removeTrader(id);
    }
    private static void removeAsset() {
        System.out.println("=============================");
        System.out.println("       Remove Asset ");
        System.out.println("=============================");
        System.out.println("1. Remove Stock");
        System.out.println("2. Remove Crypto Currency");
        int choice = getchoice("Enter your choice between 1 and 2");
        if(choice == 1){
            remouveStockofMarket();
        }
        else if(choice == 2){
            remouveCryptoofMarket();
        }
        else{
            System.out.println("Invalid choice");
        }
    }
    public static void remouveStockofMarket(){
        System.out.println("=============================");
        System.out.println("        Remove Stock ");
        System.out.println("=============================");
        System.out.println("Enter the Stock name to remove");
        String name = sc.next();
        Market.removeStock(name);
    }
    public static void remouveCryptoofMarket(){
        System.out.println("=============================");
        System.out.println("        Remove Crypto ");
        System.out.println("=============================");
        System.out.println("Enter the Crypto name to remove");
        String name = sc.next();
        Market.removeCrypto(name);
    }
    public static void displayTraders(){
        System.out.println("=============================");
        System.out.println("       Traders info ");
        System.out.println("=============================");
        Market.getTraders();
    }
    public static void addAsset(){
        System.out.println("=============================");
        System.out.println("        Add Asset ");
        System.out.println("=============================");
        System.out.println("1. add Stock");
        System.out.println("2. add crypto currency");
        int choice =  getchoice("Enter your choice between 1 and 2");
        if(choice == 1) {
            AddStock();
        }
        else{
            addCrypto();
        }
    }
    public static void AddStock(){
        System.out.println("=============================");
        System.out.println("         Add Stock ");
        System.out.println("=============================");
        System.out.println("Enter Stock ID:");
        sc.nextLine();
        String id = sc.nextLine();
        System.out.println("Enter Stock Name:");
        String name = sc.next();
        System.out.println("Enter Stock Price:");
        double p = sc.nextDouble();
        System.out.println("Enter Stock Quantity:");
        sc.nextLine();
        int q = sc.nextInt();
        Stock stock = new Stock(name,id,p,"stock",q);
        Market.addStock(stock,name);
    }
    public static void addCrypto(){
        System.out.println("=============================");
        System.out.println("         Add Crypto currency ");
        System.out.println("=============================");
        System.out.println("Enter Crypto ID:");
        sc.nextLine();
        String id = sc.nextLine();
        System.out.println("Enter Crypto Name:");
        String name = sc.next();
        System.out.println("Enter Crypto Price:");
        double p = sc.nextDouble();
        System.out.println("Enter Crypto Quantity:");
        sc.nextLine();
        int q = sc.nextInt();
        CryptoCurrency Crypto = new CryptoCurrency(name,id,p,"Crypto",q);
        Market.addCrypto(Crypto,name);
    }
    public static void desplaystockofMarket(){
        System.out.println("=============================");
        System.out.println("         Market Stock ");
        System.out.println("=============================");
        Market.displayStock();
    }
    public static void desplaycryptoofMarket(){
        System.out.println("=============================");
        System.out.println("         Market Crypto Currency ");
        System.out.println("=============================");
        Market.desplayCryptoCrruncy();
    }
    public static void changethepriceofAsset(){
        System.out.println("=============================");
        System.out.println("        Change the Price of Asset ");
        System.out.println("=============================");
        System.out.println("1. change the stock price ");
        System.out.println("2. change the crypto price ");
        int choice =  getchoice("Enter your choice between 1 and 2");
        if(choice == 1) {
            changethepriceofStock();
        }
        else if(choice == 2){
            changethepiceofCrypto();
        }
        else{
            System.out.println("Invalid choice");
        }
    }
    private static void changethepiceofCrypto() {
        System.out.println("============================");
        System.out.println(" Change the price of Crypto");
        System.out.println("============================");
        System.out.println("Enter the name of the Crypto");
        String name = sc.next();
        System.out.println("Enter new price");
        double price = sc.nextDouble();
        Market.changethepiceofCrypto(name,price);
    }
    private static void changethepriceofStock() {
        System.out.println("============================");
        System.out.println(" Change the price of Stock");
        System.out.println("============================");
        System.out.println("Enter the name of the stock");
        String name = sc.next();
        System.out.println("Enter new price");
        double price = sc.nextDouble();
        Market.changethepriceofStock(name,price);
    }

    public static void main(String[] args) {

        //market stock
        Market.stocks.add(new Stock("Apple", "AAPL", 175.50, "Stock" ,100));
        Market.stocks.add(new Stock("Microsoft", "MSFT", 310.20, "Stock",100));
        Market.stocks.add(new Stock("Amazon", "AMZN", 145.75, "Stock",100));
        Market.stocks.add(new Stock("Alphabet", "GOOGL", 2800.75, "Stock",100));
        Market.stocks.add(new Stock("Meta", "META", 350.40, "Stock",100));
        Market.stocks.add(new Stock("Tesla", "TSLA", 720.10, "Stock",100));
        Market.stocks.add(new Stock("NVIDIA", "NVDA", 650.25, "Stock",100));
        Market.stocks.add(new Stock("Walmart", "WMT", 155.40, "Stock",100));
        Market.stocks.add(new Stock("McDonald", "MCD", 280.75, "Stock",100));
        Market.stocks.add(new Stock("Coca", "KO", 60.10, "Stock",100));

        // market crypto
        Market.cryptos.add(new CryptoCurrency("Apple", "AAPL", 175.50, "Crypto" ,100));
        Market.cryptos.add(new CryptoCurrency("Microsoft", "MSFT", 310.20, "Crypto",100));
        Market.cryptos.add(new CryptoCurrency("Amazon", "AMZN", 145.75, "Crypto",100));
        Market.cryptos.add(new CryptoCurrency("Alphabet", "GOOGL", 2800.75, "Crypto",100));
        Market.cryptos.add(new CryptoCurrency("Meta", "META", 350.40, "Crypto",100));
        Market.cryptos.add(new CryptoCurrency("Tesla", "TSLA", 720.10, "Crypto",100));
        Market.cryptos.add(new CryptoCurrency("NVIDIA", "NVDA", 650.25, "Crypto",100));
        Market.cryptos.add(new CryptoCurrency("Walmart", "WMT", 155.40, "Crypto",100));
        Market.cryptos.add(new CryptoCurrency("McDonald", "MCD", 280.75, "Crypto",100));
        Market.cryptos.add(new CryptoCurrency("Coca", "KO", 60.10, "Crypto",100));


        char tryagain = 'y';
        do{
            menuPrincipal();
            int choice = getchoice("Enter your choice 1 or 2 ");
            controller(choice);
            System.out.println("do you want to continue? y/n");
            tryagain = sc.next().charAt(0);

        }while(tryagain == 'y' || tryagain == 'Y');

    }
}