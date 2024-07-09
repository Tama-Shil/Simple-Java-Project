import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MainQuiz {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("./src/main/resources/users.json"));

        //login setup

        System.out.println("Enter your username");
        String username = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();

        JSONObject adminobj = (JSONObject) jsonArray.get(0);
        JSONObject userobj = (JSONObject) jsonArray.get(1);
        if ((adminobj.get("username")).equals(username) && adminobj.get("password").equals(password)) {
            System.out.println("Welcome admin! Please create new questions in the question bank.");
            //admin task
            questionset();
        } else if (userobj.get("username").equals(username) && userobj.get("password").equals(password)) {
            //user task
            takeQuiz(username);

        } else {
            System.out.println("Invalid input, please try again");
        }

    }

    public static void questionset() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        char optout;
        do {
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("./src/main/resources/quiz.json"));
            JSONObject quizobj = new JSONObject();
            System.out.println(" Input your question");
            String question = scanner.nextLine();
            quizobj.put("question", question);

            System.out.println("Input option 1:");
            String option1 = scanner.nextLine();
            quizobj.put("option 1", option1);

            System.out.println("Input option 2:");
            String option2 = scanner.nextLine();
            quizobj.put("option 2", option2);

            System.out.println("Input option 3:");
            String option3 = scanner.nextLine();
            quizobj.put("option 3", option3);

            System.out.println("Input option 4:");
            String option4 = scanner.nextLine();
            quizobj.put("option 4", option4);

            System.out.println("What is the answer key?");
            String option = scanner.nextLine();
            quizobj.put("answerkey", option);

            jsonArray.add(quizobj);
            FileWriter fileWriter = new FileWriter("./src/main/resources/quiz.json");
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
            fileWriter.close();

            System.out.println("Saved successfully! Do you want to add more questions? (press s for start and q for quit)");
            optout = scanner.next().charAt(0);
            scanner.nextLine();

        } while (optout == 's');

    }

    public static void takeQuiz(String username) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        String fileName = "./src/main/resources/quiz.json";
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(fileName));
        System.out.println("Welcome " + username + " to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. " +
                "Are you ready? Press 's' for start.");
        char choice = scanner.next().charAt(0);
        while (choice == 's') {
            int marks = 0;
            int max = jsonArray.size();
            int min = 0;
            for (int i = 1; i <= 10; i++) {
                int random = new Random().nextInt(max - min + 1) + min;

                JSONObject quesObj = (JSONObject) jsonArray.get(random);

                String question = (String) quesObj.get("question");
                String option1 = (String) quesObj.get("option 1");
                String option2 = (String) quesObj.get("option 2");
                String option3 = (String) quesObj.get("option 3");
                String option4 = (String) quesObj.get("option 4");
                String answerkey = (String) quesObj.get("answerkey");

                System.out.println("\n[Question " + i + "] " + question);
                System.out.println("1. " + option1);
                System.out.println("2. " + option2);
                System.out.println("3. " + option3);
                System.out.println("4. " + option4);

                String answer = scanner.next();

                if (answer.equals(answerkey)) {
                    marks++;
                }
            }
            if (marks >= 8) {
                System.out.println("\nExcellent! You have got " + marks + " out of 10");
            } else if (marks >= 5) {
                System.out.println("\nGood. You have got " + marks + " out of 10");
            } else if (marks >= 2) {
                System.out.println("\nVery poor! You have got " + marks + " out of 10");
            } else {
                System.out.println("\nVery sorry you are failed. You have got " + marks + " out of 10");
            }

            System.out.println("\nWould you like to start again? press s for start or q for quit");
            choice = scanner.next().charAt(0);

        }

    }

}


