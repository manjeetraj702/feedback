package coaching;

import coaching.controller.UserController;

import java.util.Scanner;

public class UI_2 {
    static Scanner sc = new Scanner(System.in);
    static UserController userController = new UserController();

    public static void main(String[] args) {
        while (true) {
            displayMainMenu();
            int choice = getUserChoice();
            if (choice == 0) {
                System.out.println("Process Finished, Exiting The Program ..................");
                break;
            } else if (choice == 1) {
                handleSignUp();
            } else if (choice == 2) {
                handleLogin();
            } else {
                System.out.println("Invalid Input Provided, Please Re-enter Your Choice");
                System.out.println("\n");
            }
        }
        sc.close();
    }


    //// Methods
    static void displayMainMenu() {
        System.out.println("For Sign Up Press '1' ");
        System.out.println("For Sign In/Login Press '2' ");
        System.out.println("Press '0' For Exiting This Program ");
        System.out.print("Enter Your Choice: ");
    }

    static int getUserChoice() {
        return sc.nextInt();
    }

    static void handleSignUp() {
        sc.nextLine(); // Consume newline
        System.out.print("Enter Your Name: ");
        String name = sc.nextLine();
        String pno = validatePhoneNo();
        System.out.print("Enter Your Password: ");
        sc.nextLine();
        String password = sc.nextLine();
        String role = getRoleFromUser();
        System.out.println(userController.SignUp(name, pno, password, role));
    }
    static String validatePhoneNo(){
        String phone;
        while (true){
            System.out.print("Enter Your Phone Number: ");
            phone = sc.next();
            boolean validLength = phone.length() == 10;
            boolean hasDigit=true;
            for (int i = 0; i < phone.length(); i++) {
                if (!Character.isDigit(phone.charAt(i))) {
                    hasDigit = false;
                }
            }
            if(validLength && hasDigit){
                break ;
            }
            else {
                System.out.println("Invalid Phone Number Please Enter A Correct Phone Number. ");
                System.out.println();
            }
        }
        return phone;
    }
    static String getRoleFromUser() {
        System.out.println("Choose Your Role: ");
        System.out.println("Press '1' ==> ADMIN");
        System.out.println("Press Any Digit ==> USER");
        int roleChoice = sc.nextInt();
        return roleChoice == 1 ? "ADMIN" : "USER";
    }

    static void handleLogin() {
        System.out.print("Enter Your Phone Number: ");
        String pno = sc.next();
        System.out.print("Enter Your Password: ");
        String password = sc.next();
        String loginStatus = userController.signIn(pno, password);
        System.out.println(loginStatus);
        System.out.println("\n");
        if (loginStatus.equals("Successfully Login") || loginStatus.equals("Successfully Login as Admin")) {
            if (loginStatus.equals("Successfully Login as Admin")) {
                handleAdminActions();
            } else {
                handleUserActions(pno);
            }
        }
    }

    static void handleAdminActions() {
        while (true) {
            displayAdminMenu();
            int choice = getUserChoice();
            if (choice == -1) {
                System.out.println("Leaving The Program .............  ");
                System.out.println("\n");
                break;
            } else if (choice == 0) {
                System.out.println("Moving To Sign Up / Sign In Page ............ ");
                System.out.println("\n");
                break;
            } else {
                executeAdminAction(choice);
            }
        }
    }

    static void displayAdminMenu() {
        System.out.println("Press '-1' For Exiting The Application ");
        System.out.println("For Sign Out Press '0' ");
        System.out.println("Press '1' For Creating Batch ");
        System.out.println("Press '2' For Assigning Batch To A Student");
        System.out.println("Press '3' For Creating Question");
        System.out.println("Press '4' For Editing Question");
        System.out.println("Press '5' For Adding Question To A Batch");
        System.out.println("Press '6' For Viewing All Reply Of Students");
        System.out.println("Press '7' For Getting Reply Of Student By Phone Number");
        System.out.print("Enter Your Choice: ");
    }

    static void executeAdminAction(int choice) {
        sc.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                System.out.print("Enter Batch Name: ");
                String batchID = sc.nextLine();
                System.out.println(userController.createBatch(batchID));
                System.out.println("\n");
                break;
            case 2:
                System.out.print("Enter Batch Name: ");
                batchID = sc.next();
                System.out.print("Enter Student Phone Number: ");
                String studentPno = sc.next();
                System.out.println(userController.assignBatch(batchID, studentPno));
                System.out.println("\n");
                break;
            case 3:
                System.out.print("Enter Question ID: ");
                String qID = sc.next();
                sc.nextLine();
                System.out.print("Enter Your Question: ");
                String question = sc.nextLine();
                System.out.println(userController.createQuestion(qID, question));
                System.out.println("\n");
                break;
            case 4:
                System.out.print("Enter Question ID: ");
                qID = sc.next();
                sc.nextLine();
                System.out.print("Enter Your Question: ");
                question = sc.nextLine();
                System.out.println(userController.editQuestion(qID, question));
                System.out.println("\n");
                break;
            case 5:
                System.out.print("Enter Batch Name: ");
                batchID = sc.nextLine();
                System.out.print("Enter Question ID: ");
                qID = sc.nextLine();
                System.out.println(userController.addQuestion(batchID, qID));
                System.out.println("\n");
                break;
            case 6:
                System.out.println("Loading All The Replies Of The Feedback........ ");
                userController.getAllReply();
                System.out.println("\n");
                break;
            case 7:
                System.out.print("Enter Student Phone Number: ");
                studentPno = sc.next();
                userController.getReplyByStudentPhoneNo(studentPno);
                System.out.println("\n");
                break;
            default:
                System.out.println("Invalid Input Provided, Please Enter A Valid Input");
                System.out.println("\n");
                break;
        }
    }
    static void handleUserActions(String pno) {
        while (true) {
            displayUserMenu();
            int choice = getUserChoice();
            if (choice == -1) {
                System.out.println("Leaving The Program .............  ");
                System.out.println("\n");
                break;
            } else if (choice == 0) {
                System.out.println("Moving To Sign Up / Sign In Page ............ ");
                System.out.println("\n");
                break;
            } else if (choice == 1) {
                System.out.print("Enter Batch ID: ");
                String batchID = sc.next();
                userController.giveFeedbackReply(batchID, pno);
                System.out.println("\n");
            } else {
                System.out.println("Invalid Input Provided, Please Enter A Valid Input");
                System.out.println("\n");
            }
        }
    }
    static void displayUserMenu() {
        System.out.println("\n");
        System.out.println("Press '-1' For Exiting The Application ");
        System.out.println("For Sign Out Press '0' ");
        System.out.println("Press '1' For Filling FeedBack Question");
        System.out.print("Enter Your Choice: ");
    }
}
