package menu;

public class Menu {


    public static void main(String[] args) {

       MainMenu menuObject = new MainMenu();

        do { // printing out and doing some action on the printed out menu
            menuObject.printMenuAndCallSelectedAction();
        } while (menuObject.isDoWeWantToContinue());

        System.out.println("Thank you for using this program!");
    }

}
