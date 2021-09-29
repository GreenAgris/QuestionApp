package menu;

public class Menu {

    public static void main(String[] args) {
        do {
            MainMenu.printMenu();
        } while (MainMenu.doWeWantToContinue);

        System.out.println("Thank you for using this program!");
    }

}
