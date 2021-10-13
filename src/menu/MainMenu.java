package menu;

import answers.Answer;
import java.util.Arrays;
import java.util.Scanner;
import questions.Question;

public class MainMenu {

    private Scanner scanner;

    // for the Menu print loop boolean value to decide if we want to print the menu again.
    private boolean doWeWantToContinue;
    // predefined questions, so that we have already some data when we start off.
    public static Question first = new Question("Some question text.", "Agris", "first");
    public static Question second = new Question("What is you favorite color?", "Agris", "second");
    public static Question third = new Question("What is the meaning of life?", "Agris", "third");
    public static Question[] qArray = {first, second, third, null, null, null, null};

    // the counter for actually existing questions
    public static int numberOfQuestions = 3;

    public boolean isDoWeWantToContinue() {
        return doWeWantToContinue;
    }

    public MainMenu() {
        scanner = new Scanner(System.in);
        doWeWantToContinue = true;
    }

    public void printMenuAndCallSelectedAction() {
        System.out.println(String.format(
            "Hello! Welcome to the Question APP %n"
                + "Please select a action from below, by writing in the number: %n"
                + "1: See existing questions %n"
                + "2: See existing answers %n"
                + "3: Create a new question. %n"
                + "4: Answer a question %n"
                + "5: Change and existing answer %n"
                + "6: Search a word in answers %n"
                + "7: Add labels to an answer %n"
                + "0: Exit %n"));

        int inputSelection = scanner.nextInt();
        scanner.nextLine();

        switch (inputSelection) {
            case 1:
                System.out.println("Here will be questions");
                System.out.println(Arrays.toString(qArray));
                break;
            case 2:
                printOutAllAnswers(inputSelection);
                break;
            case 3:
                createNewQuestion();
                break;
            case 4:
                answerMenu();
                break;
            case 5:
                answerUpdateMenu();
                break;
            case 7:
                addLabelToAnswer();
            case 0:
                exit();
                break;
            default:
                System.out.println("Did not recognize this selection, please try again!");
                break;
        }
    }

    private void addLabelToAnswer() {
        //TODO implement it later
    }

    private void answerUpdateMenu() {
        System.out.println("For which question do you want to change the answer? [1-" + numberOfQuestions + "]");
        int inputSelection = scanner.nextInt() - 1;
        scanner.nextLine();

        if (inputSelection >= 0
            && inputSelection <= numberOfQuestions - 1) {
            System.out.println(Arrays.toString(qArray[inputSelection].getAnswer()));

            System.out.println(String.format(
                "For which answer do you want to change the information? [1-%d]", qArray[inputSelection].getAnswer().length));
            int answerSelection = scanner.nextInt() - 1;
            scanner.nextLine();
            Answer selectedAnswer = qArray[inputSelection].getAnswer()[answerSelection];
            if (selectedAnswer != null) {
                System.out.println("What is the number of likes?");
                answerSelection = scanner.nextInt();
                scanner.nextLine();
                selectedAnswer.setLikes(answerSelection);

                System.out.println("What is the number of dislikes?");
                answerSelection = scanner.nextInt();
                scanner.nextLine();
                selectedAnswer.setDislikes(answerSelection);

                System.out.println("Is this answer the accepted one? Y/N :");
                String stringInput = scanner.nextLine();

                selectedAnswer.setAcceptedAnswer(// Yes / Y  / yes / y
                    stringInput.toLowerCase().startsWith("y"));

                System.out.println("The new version of the answer: " + selectedAnswer);
            } else {
                System.out.println("This answer does not yet exist!");
            }

        }
    }


    public void exit() {
        doWeWantToContinue = false;
    }

    public void answerMenu() {
        System.out.println("Welcome to the answer creator, what is your name: ");
        String name = scanner.nextLine();

        System.out.println(String.format("Which of the questions do you want to answer? [1-%d]", numberOfQuestions));
        int inputSelection = scanner.nextInt() - 1;
        scanner.nextLine();

        if (inputSelection >= 0
            && inputSelection <= numberOfQuestions - 1) {

            String answerText;
            Answer answer;

            System.out.println("You are answering this question: " + qArray[inputSelection]);
            System.out.println(String.format("Thank you %s, please write in your answer: ", name));
            answerText = scanner.nextLine();
            answer = new Answer(answerText, name, qArray[inputSelection].getIdentifier());
            qArray[inputSelection].setAnswer(answer);
        } else {
            System.out.println("There is no questions with this number, please try again.");
        }
    }


    public void printOutAllAnswers(int inputSelection) {
        System.out.println(String.format("Here will be answers - what question do you want to check? [1-%d]", numberOfQuestions));
        int questionSelection = scanner.nextInt() - 1;
        scanner.nextLine();
        if (questionSelection >= 0
            && inputSelection <= numberOfQuestions - 1) {
            // can be also extended with a question to user which of the answers to show (not all)
            System.out.println(Arrays.toString(qArray[questionSelection].getAnswer()));
        } else {
            System.out.println("There is no questions with this number, please try again.");
        }
    }

    public void createNewQuestion() {
        //creating new question logic
        System.out.println(numberOfQuestions);
        System.out.println(qArray.length);
        System.out.println(" ---- ");
        if (numberOfQuestions == qArray.length) {
            System.out.println("Sorry, our data space is full already.");
        } else {
            System.out.println("Welcome to the question creator, what is your name:");
            String name = scanner.nextLine();

            System.out.println(String.format("Thank you %s, please write in your question: ", name));
            String questionText = scanner.nextLine();
            Question newlyCreatedQuestion = new Question(questionText, name, "id-" + numberOfQuestions);

            qArray[numberOfQuestions] = newlyCreatedQuestion;
            numberOfQuestions++;
        }
    }
}
