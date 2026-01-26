import javax.imageio.plugins.tiff.ExifTIFFTagSet;
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
                // addTrader();
                break;
            case 2:
                //desplayAllTraders();
                break;
            case 3:
                //changeThepriceofasset();
                break;
            case 4:
                //addAsset();
                break;
            case 5:
                //remouveTreader();
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
        System.out.println("Enter Trader Name:");
        String name = sc.next();
        System.out.println("Enter Treder ID ");
        int id = sc.nextInt();
        System.out.println("Enter initial balance");
        double balance = sc.nextDouble();


    }

    public static void main(String[] args) {
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