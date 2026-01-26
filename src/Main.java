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
    public static void controler(int choice){
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

        System.out.println("1. Admin section");
        System.out.println("2. Trader section");

    }
    public static void menuofTrader(){
        System.out.println("============================");
        System.out.println("          Trader");
        System.out.println("============================");

        System.out.println("1. Admin section");
        System.out.println("2. Trader section");
    }
    public static int getchoice(String message){
        System.out.println(message);
        int choice = sc.nextInt();
        return choice;
    }

    public static void main(String[] args) {
        menuPrincipal();
        int choice = getchoice("Enter your choice?");
        controler(choice);

    }
}