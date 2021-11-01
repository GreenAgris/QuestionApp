package menu;

import answers.Answer;
import answers.AnswerDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import questions.Question;
import questions.QuestionDatabase;
import util.DBHelper;

public class MainMenu {

    private Scanner scanner;
    private ArrayList<Question> qArray;

    // for the Menu print loop boolean value to decide if we want to print the menu again.
    private boolean doWeWantToContinue;
    // predefined questions, so that we have already some data when we start off.
    DBHelper helper;

    public ArrayList<Question> getqArray() {
        return qArray;
    }

    public void setqArray(ArrayList<Question> qArray) {
        this.qArray = qArray;
    }

   // public static Question first = new Question("Some question text.", "Agris", "first");
 //   public static Question second = new Question("What is you favorite color?", "Agris", "second");
   // public static Question third = new Question("What is the meaning of life?", "Agris", "third");
   // public static ArrayList<Question> qArray = new ArrayList<>(List.of(first, second, third));

    public boolean isDoWeWantToContinue() {
        return doWeWantToContinue;
    }

    public MainMenu() {
        scanner = new Scanner(System.in);
        doWeWantToContinue = true;
        helper = new DBHelper();
        this.setqArray(QuestionDatabase.getQuestionList(helper.getStatment()));
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
                System.out.println(qArray);
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
            case 6 :
                searchWord();
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

    private void searchWord() {
        System.out.println("What is the term you are searching for? ");
        String  inputText = scanner.nextLine().trim();

        if(inputText.isEmpty()){
            System.out.println("Can not find an empty term! ");
        }else {
            for (Question question: qArray){
              question.hasThisText(inputText);
                for (Answer ans : question.getAnswer().values()){
                    ans.hasThisText(inputText);
                }
            }
        }
    }

    private void addLabelToAnswer() {
        //TODO implement it later
    }

    private void answerUpdateMenu() {
        System.out.println("For which question do you want to change the answer? [1-" + qArray.size() + "]");
        int inputSelection = scanner.nextInt() - 1;
        scanner.nextLine();

        if (inputSelection >= 0
            && inputSelection <= qArray.size() - 1) {
            System.out.println(Arrays.toString(qArray.get(inputSelection).getAnswer().values().toArray(new Answer[0])));

            System.out.println(String.format(
                "For which answer do you want to change the information? [1-%d]", qArray.get(inputSelection).getAnswer().size()));
            int answerSelection = scanner.nextInt() - 1;
            scanner.nextLine();
            Answer selectedAnswer = qArray.get(inputSelection).getAnswer().get(answerSelection);
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
                //AnswerDatabase.updateAnswer(helper.getStatment(), selectedAnswer);
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

        System.out.println(String.format("Which of the questions do you want to answer? [1-%d]", qArray.size()));
        int inputSelection = scanner.nextInt() - 1;
        scanner.nextLine();

        if (inputSelection >= 0
            && inputSelection <= qArray.size() - 1) {

            String answerText;
            Answer answer;

            System.out.println("You are answering this question: " + qArray.get(inputSelection));
            System.out.println(String.format("Thank you %s, please write in your answer: ", name));
            answerText = scanner.nextLine();
            answer = new Answer(answerText, name, qArray.get(inputSelection).getIdentifier());
            AnswerDatabase.saveAnswer(helper.getStatment(), answer);
            qArray.get(inputSelection).setAnswer(answer);
        } else {
            System.out.println("There is no questions with this number, please try again.");
        }
    }


    public void printOutAllAnswers(int inputSelection) {
        System.out.println(String.format("Here will be answers - what question do you want to check? [1-%d]", qArray.size()));
        int questionSelection = scanner.nextInt() - 1;
        scanner.nextLine();
        if (questionSelection >= 0
            && inputSelection <= qArray.size() - 1) {
            // can be also extended with a question to user which of the answers to show (not all)
            System.out.println(Arrays.toString(qArray.get(questionSelection).getAnswer().values().toArray(new Answer[0])));
        } else {
            System.out.println("There is no questions with this number, please try again.");
        }
    }

    public void createNewQuestion() {
        //creating new question logic
        System.out.println(qArray.size());
        System.out.println(" ---- ");
        System.out.println("Welcome to the question creator, what is your name:");
        String name = scanner.nextLine();

        System.out.println(String.format("Thank you %s, please write in your question: ", name));
        String questionText = scanner.nextLine();
        Question newlyCreatedQuestion = new Question(questionText, name, "id-" + qArray.size());
        QuestionDatabase.saveQuestion(helper.getStatment(), newlyCreatedQuestion);
        qArray.add(newlyCreatedQuestion);

    }
}
