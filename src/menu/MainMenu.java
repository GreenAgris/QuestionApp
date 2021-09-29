package menu;

import answers.Answer;
import java.util.Arrays;
import java.util.Scanner;
import questions.Question;

public class MainMenu {

    public static Question first = new Question("Some question text.", "Agris", "first");
    public static Question second = new Question("What is you favorite color?", "Agris", "second");
    public static Question third = new Question("What is the meaning of life?", "Agris", "third");
    public static final String GREEN = "\033[0;32m";
    public static final String WHITE = "\033[0;37m";
    public static boolean doWeWantToContinue = true;
    public static Question[] qArray = {first, second, third, null, null, null, null};
    public static int numberOfQuestions = 3;
    public static Answer afirst = new Answer("This is a test answer", "testUser", "identifier");

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
                System.out.println(Arrays.toString(qArray));

                break;
            case 2:
                System.out.println("Here will be answers - what question do you want to check? [1- " + numberOfQuestions + "]");
                int questionSelection = scanner.nextInt() - 1;
                scanner.nextLine();
                if (questionSelection >= 0
                    && inputSelection <= numberOfQuestions - 1) {
                    // can be also extended with a question to user which of the answers to show (not all)
                    System.out.println(Arrays.toString(qArray[questionSelection].getAnswer()));
                } else {
                    System.out.println("There is no questions with this number, please try again.");
                }
                break;
            case 3:
                //creating new question logic
                System.out.println(numberOfQuestions);
                System.out.println(qArray.length);
                System.out.println(" ---- ");
                if (numberOfQuestions == qArray.length) {
                    System.out.println("Sorry, our data space is full already.");
                } else {
                    qArray[numberOfQuestions] = createNewQuestion(scanner);
                    numberOfQuestions++;
                }
                break;
            case 4:
                answerMenu(scanner);
                break;
            case 0:
                exit();
                break;
            default:
                System.out.println("Did not recognize this selection, please try again!");
                break;
        }
    }

    public static void exit() {
        doWeWantToContinue = false;
    }

    public static void answerMenu(Scanner scanner) {
        System.out.println("Welcome to the answer creator, what is your name: ");
        String name = scanner.nextLine();

        System.out.println("Which of the questions do you want to answer? [1-" + numberOfQuestions + "]");
        int inputSelection = scanner.nextInt() - 1;
        scanner.nextLine();

        if (inputSelection >= 0
            && inputSelection <= numberOfQuestions - 1) {

            String answerText;
            Answer answer;

            System.out.println("You are answering this question: " + qArray[inputSelection]);
            System.out.println("Thank you " + name + " , please write in your answer: ");
            answerText = scanner.nextLine();
            answer = new Answer(answerText, name, qArray[inputSelection].identifier);
            qArray[inputSelection].setAnswer(answer);
        } else {
            System.out.println("There is no questions with this number, please try again.");
        }
    }

    public static Question createNewQuestion(Scanner scanner) {
        System.out.println("Welcome to the question creator, what is your name:");
        String name = scanner.nextLine();

        System.out.println("Thank you " + name + ", please write in your question: ");
        String questionText = scanner.nextLine();

        return new Question(questionText, name, "id-" + numberOfQuestions);
    }
}
