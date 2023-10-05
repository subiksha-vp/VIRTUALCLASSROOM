import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

import java.util.Scanner;

 

public class VirtualClassroom {

    private static Map<String, List<String>> classrooms = new HashMap<>();

    private static Map<String, List<String>> students = new HashMap<>();

    private static List<String> assignments = new ArrayList<>();

 

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

 

        while (true) {

            System.out.println("Virtual Classroom Manager Menu:");

            System.out.println("1. Add Classroom");

            System.out.println("2. Add Student");

            System.out.println("3. Schedule Assignment");

            System.out.println("4. Submit Assignment");

            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");

 

            int choice = scanner.nextInt();

            scanner.nextLine(); // Consume the newline character

 

            switch (choice) {

                case 1:

                    addClassroom(scanner);

                    break;

                case 2:

                    addStudent(scanner);

                    break;

                case 3:

                    scheduleAssignment(scanner);

                    break;

                case 4:

                    submitAssignment(scanner);

                    break;

                case 5:

                    System.out.println("Exiting Virtual Classroom Manager.");

                    scanner.close();

                    System.exit(0);

                default:

                    System.out.println("Invalid choice. Please try again.");

            }

        }

    }

 

    private static void addClassroom(Scanner scanner) {

        System.out.print("Enter the name of the classroom: ");

        String className = scanner.nextLine();

        classrooms.put(className, new ArrayList<>());

        System.out.println("Classroom Addition: \"Classroom " + className + " has been created.\"");

    }

 

    private static void addStudent(Scanner scanner) {

        System.out.print("Enter the student ID: ");

        String studentId = scanner.nextLine();

        System.out.print("Enter the name of the classroom to enroll the student: ");

        String className = scanner.nextLine();

 

        if (classrooms.containsKey(className)) {

            List<String> enrolledStudents = classrooms.get(className);

            enrolledStudents.add(studentId);

            students.put(studentId, enrolledStudents);

            System.out.println("Student Addition: \"Student " + studentId + " has been enrolled in " + className + ".\"");

        } else {

            System.out.println("Classroom not found. Please create the classroom first.");

        }

    }

 

    private static void scheduleAssignment(Scanner scanner) {

        System.out.print("Enter the name of the classroom to schedule the assignment: ");

        String className = scanner.nextLine();

        System.out.print("Enter assignment details: ");

        String assignmentDetails = scanner.nextLine();

 

        if (classrooms.containsKey(className)) {

            assignments.add(assignmentDetails);

            System.out.println("Assignment Scheduled: \"Assignment for " + className + " has been scheduled.\"");

        } else {

            System.out.println("Classroom not found. Please create the classroom first.");

        }

    }

 

    private static void submitAssignment(Scanner scanner) {

        System.out.print("Enter the student ID: ");

        String studentId = scanner.nextLine();

        System.out.print("Enter the name of the classroom: ");

        String className = scanner.nextLine();

        System.out.print("Enter assignment details: ");

        String assignmentDetails = scanner.nextLine();

 

        if (students.containsKey(studentId) && classrooms.containsKey(className)) {

            System.out.println("Assignment Submission: \"Assignment submitted by Student " + studentId + " in " + className + ".\"");

        } else {

            System.out.println("Student or classroom not found. Please check the input.");

        }

    }

}

 

 

 

 
