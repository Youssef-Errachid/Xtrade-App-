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
        System.out.println("3. Change the price of Asset");
        System.out.println("4. Add Asset");
        System.out.println("5. Remove Trader");
        System.out.println("6. Remove Asset");
        System.out.println("7. Exit");
        int choice = getchoice("Enter your choice between 1 and 7");
        AdminController(choice);
    }
    public static void AdminController(int choice){
        switch(choice){
            case 1:
                System.out.println("Enter Trader Name:");
                 addTrader();
                break;
            case 2:
                displayTraders();
                break;
            case 3:
                //changeThepriceofasset();
                break;
            case 4:
                //addAsset();
                break;
            case 5:
                removeTreader();
                break;
            case 6:
                //remouveAsset();
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


        }
    }
    public static void desplaystock(){

        Market.desplaystok();
    }

    public static void main(String[] args) {
        Market.stocks.add(new Stock("Apple Inc.", "AAPL", 175.50, "Stock"));
        Market.stocks.add(new Stock("Microsoft Corp.", "MSFT", 310.20, "Stock"));
        Market.stocks.add(new Stock("Amazon.com Inc.", "AMZN", 145.75, "Stock"));
        Market.stocks.add(new Stock("Alphabet Inc. (Google)", "GOOGL", 2800.75, "Stock"));
        Market.stocks.add(new Stock("Meta Platforms Inc.", "META", 350.40, "Stock"));
        Market.stocks.add(new Stock("Tesla Inc.", "TSLA", 720.10, "Stock"));
        Market.stocks.add(new Stock("NVIDIA Corp.", "NVDA", 650.25, "Stock"));
        Market.stocks.add(new Stock("Walmart Inc.", "WMT", 155.40, "Stock"));
        Market.stocks.add(new Stock("McDonald's Corp.", "MCD", 280.75, "Stock"));
        Market.stocks.add(new Stock("Coca-Cola Co.", "KO", 60.10, "Stock"));
        Market.stocks.add(new Stock("PepsiCo Inc.", "PEP", 175.80, "Stock"));
        Market.stocks.add(new Stock("Netflix Inc.", "NFLX", 590.80, "Stock"));
        Market.stocks.add(new Stock("Adobe Inc.", "ADBE", 520.30, "Stock"));
        Market.stocks.add(new Stock("Intel Corp.", "INTC", 45.60, "Stock"));
        Market.stocks.add(new Stock("Cisco Systems Inc.", "CSCO", 55.20, "Stock"));
        Market.stocks.add(new Stock("Oracle Corp.", "ORCL", 115.40, "Stock"));
        Market.stocks.add(new Stock("IBM Corp.", "IBM", 140.75, "Stock"));
        Market.stocks.add(new Stock("Qualcomm Inc.", "QCOM", 130.25, "Stock"));
        Market.stocks.add(new Stock("PayPal Holdings Inc.", "PYPL", 72.90, "Stock"));
        Market.stocks.add(new Stock("Salesforce Inc.", "CRM", 240.10, "Stock"));
        Market.stocks.add(new Stock("Shopify Inc.", "SHOP", 65.80, "Stock"));
        Market.stocks.add(new Stock("Uber Technologies Inc.", "UBER", 58.40, "Stock"));
        Market.stocks.add(new Stock("Lyft Inc.", "LYFT", 12.75, "Stock"));
        Market.stocks.add(new Stock("Zoom Video Communications", "ZM", 70.50, "Stock"));
        Market.stocks.add(new Stock("Spotify Technology", "SPOT", 180.25, "Stock"));
        Market.stocks.add(new Stock("Snap Inc.", "SNAP", 15.30, "Stock"));
        Market.stocks.add(new Stock("Twitter (X)", "TWTR", 45.00, "Stock"));
        Market.stocks.add(new Stock("Berkshire Hathaway Inc.", "BRK.A", 540000.00, "Stock"));
        Market.stocks.add(new Stock("Johnson & Johnson", "JNJ", 165.20, "Stock"));
        Market.stocks.add(new Stock("Pfizer Inc.", "PFE", 38.40, "Stock"));
        char tryagain = 'y';
        do{
            menuPrincipal();
            desplaystock();
            int choice = getchoice("Enter your choice 1 or 2 ");
            controller(choice);
            System.out.println("do you want to continue? y/n");
            tryagain = sc.next().charAt(0);

        }while(tryagain == 'y' || tryagain == 'Y');

    }
}