import java.util.ArrayList;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        ArrayList<String> studentsName = new ArrayList<>();
        ArrayList<ArrayList<Float>> studentsGrade = new ArrayList<>();
        ArrayList<Integer> studentsId = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isrunning = true;


        while(isrunning) {
            System.out.println("=================================");
            System.out.println("===== STUDENT GRADE TRACKER =====");
            System.out.println("---------------------------------");
            System.out.println("1. Add Student");
            System.out.println("2. View Report");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
            System.out.println("=================================");
            System.out.print("Which option would you like to choose? (Numbers Only): ");
            int options = scanner.nextInt();
            scanner.nextLine(); // remove this and you will face problems from that classic scanner bug on terminal 

            switch(options) {
                case 1 -> addStudent(studentsName, studentsId, studentsGrade, scanner);
                case 2 -> viewReport(studentsName, studentsId, studentsGrade, scanner);
                case 3 -> removeStudent(studentsName, studentsId, studentsGrade, scanner);
                case 4 -> isrunning = false;
                default -> System.out.println("You have to input something related to the options.");
            }
        }
    }

    public static void addStudent(ArrayList<String> studentsName, ArrayList<Integer> studentsId, ArrayList<ArrayList<Float>> studentsGrade, Scanner scanner) {
        System.out.println("---------------------------------");

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        studentsName.add(name);

        System.out.print("Enter student ID: ");
        int idStudents = scanner.nextInt();
        studentsId.add(idStudents);

        ArrayList<Float> grades = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            System.out.print("Enter grade: " + i + ": ");
            float grade = scanner.nextFloat();
            grades.add(grade);
        }

        studentsGrade.add(grades);

        System.out.println("---------------------------------");
        System.out.println("INFO ADDED SUCCESFULLY");
        
    }

    public static void viewReport(ArrayList<String> studentsName, ArrayList<Integer> studentsId, ArrayList<ArrayList<Float>> studentsGrade, Scanner scanner) {

        System.out.println("---------------------------------");
        for(int i = 0; i < studentsName.size(); i++){
            System.out.println((i + 1) + ". " + studentsName.get(i));

        }
        System.out.println("---------------------------------");
        System.out.print("Which student do you wanna get info? (Number Only): ");
        int choice = scanner.nextInt() - 1;
        scanner.nextLine();

        String name = studentsName.get(choice);
        int id = studentsId.get(choice);
        ArrayList<Float> grades = studentsGrade.get(choice);
        
        float sumAllGrades = 0;
        for(float g : grades) {
            sumAllGrades += g;
        }
        float average = sumAllGrades / grades.size();
        String status = average >= 7 ? "Approved" : "Failed";

            System.out.println("\n REPORT");
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Grades: " + grades);
            System.out.println("Average: " + average);
            System.out.println("Status: " + status);
        
    }

    public static void removeStudent(ArrayList<String> studentsName, ArrayList<Integer> studentsId, ArrayList<ArrayList<Float>> studentsGrade, Scanner scanner) {
        // display all students reports 
        // choose one of them
        // delete the option selected

        System.out.println("---------------------------------");
        System.out.println();
        for(int i = 0; i < studentsName.size(); i++) {
            System.out.println((i + 1) + ". " + studentsName.get(i));
        }

        System.out.println("---------------------------------");
        System.out.print("Pick a number you would like to delete: ");
        int choiceToDelete = scanner.nextInt();
        scanner.nextLine();

        if(choiceToDelete > 0 && choiceToDelete <= studentsName.size()) {
            int indexToRemove = choiceToDelete - 1;

            studentsGrade.remove(indexToRemove);
            studentsId.remove(indexToRemove);
            studentsName.remove(indexToRemove);

            System.out.println("---------------------------------");
            System.out.println("Student information removed succesfully!");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}



/*
 * student grade tracker FEATURES
 * - 5 options menu (add student, add grades, view report, remove student, exit)
 * - add student must have a name and a student id as input
 * - add grade must have 3 options to input the users grade
 * - the view report option will have name, id, grades, grades average and their status (passed or not)
 * - add a feedback message after finish every single part
 */