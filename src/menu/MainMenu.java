package menu;

import answers.Answer;
import java.util.Scanner;
import questions.Question;

public class MainMenu {

    public static Question first = new Question("Some question text.", "Agris", "first");
    public static Question second = new Question("What is you favorite color?", "Agris", "second");
    public static Question third = new Question("What is the meaning of life?", "Agris", "third");
    public static Question fourth;
    public static final String GREEN = "\033[0;32m";
    public static final String WHITE = "\033[0;37m";

    public static Answer afirst = new Answer("This is a test answer", "testUser","identifier");

    public static void printMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Welcome to the Question APP");

        System.out.println("Please select a action from below, by writing in the number:");
        System.out.println("1: See existing questions");
        System.out.println("2: See existing answers");
        System.out.println("3: Create a new question.");
        System.out.println("4: Answer a question");
        System.out.println("0: Exit");

        int inputSelection = scanner.nextInt();
        scanner.nextLine();

        switch (inputSelection) {
            case 1:
                System.out.println("Here will be questions");
                System.out.println(GREEN);
                System.out.println(first);
                System.out.println(second);
                System.out.println(third);
                System.out.println(fourth);
                System.out.println(WHITE + "----");

                break;
            case 2:
                System.out.println("Here will be answers - what question do you want to check?");
                System.out.println(afirst);
                break;
            case 3:
                //creating new question logic
                fourth = createNewQuestion(scanner);
                //  Answer afirst = new Answer("This is a test answer", "testUser","identifier");
                break;
            case 4:
                answerMenu(scanner);
                break;
            case 0:
                return;
            default:
                System.out.println("Did not recognize this selection, please try again!");
                break;
        }
        printMenu();
    }

    public static void exit() {

    }

    public static void answerMenu(Scanner scanner){
        System.out.println("Welcome to the answer creator, what is your name: ");
        String name = scanner.nextLine();

        System.out.println("Which of the questions do you want to answer? [1-4]");
        int inputSelection = scanner.nextInt();
        scanner.nextLine();

        String answerText;
        Answer answer;

        switch (inputSelection){
            case 1:
                System.out.println("You are answering this question: " + first);
                System.out.println("Thank you " + name + " , please write in your answer: ");
                answerText = scanner.nextLine();
                answer = new Answer(answerText,name, first.identifier);
                first.setAnswer(answer);
                break;
            case 2:
                System.out.println("You are answering this question: " + second);
                System.out.println("Thank you" + name + " , please write in your answer: ");
                answerText = scanner.nextLine();
                answer = new Answer(answerText,name, second.identifier);
                second.setAnswer(answer);
                break;
            case 3:
                System.out.println("You are answering this question: " + third);
                System.out.println("Thank you" + name + " , please write in your answer: ");
                answerText = scanner.nextLine();
                answer = new Answer(answerText,name, third.identifier);
                third.setAnswer(answer);
                break;
            case 4:
                System.out.println("You are answering this question: " + fourth);
                System.out.println("Thank you" + name + " , please write in your answer: ");
                answerText = scanner.nextLine();
                answer = new Answer(answerText,name, fourth.identifier);
                fourth.setAnswer(answer);
                break;
            default:
                break;
        }
    }

    public static Question createNewQuestion(Scanner scanner){
        System.out.println("Welcome to the question creator, what is your name:");
        String name = scanner.nextLine();

        System.out.println("Thank you" + name + ", please write in your question: ");
        String questionText = scanner.nextLine();

       return new Question(questionText, name);
    }
}
