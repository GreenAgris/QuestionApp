package menu;

public class Menu {


    public static void main(String[] args) {
        do { // printing out and doing some action on the printed out menu
            MainMenu.printMenuAndCallSelectedAction();
        } while (MainMenu.doWeWantToContinue);

        System.out.println("Thank you for using this program!");
    }

}
