package coaching;

import coaching.controller.UserController;

import java.util.Scanner;

public class Ui {
    static  Scanner sc = new Scanner(System.in);
    static UserController userController=new UserController();
    public static void main(String[] args) {
        int choice=0;
        String pno=null;
        loop : while (true){
            System.out.println("For Sign Up Press '1' ");
            System.out.println("For Sign In/Login Press '2' ");
            System.out.println("Press '0' For Exiting This Program ");
            System.out.print("Enter Your Choice : ");
            try {
                choice= sc.nextInt();
            }
            catch (Exception e){
                sc.nextLine();
                System.out.println("Invalid entry");
                continue ;
            }
            System.out.println("\n");
            if(choice == 1){
                System.out.print("Enter Your Name : ");
                sc.nextLine();
                String name= sc.nextLine();
                System.out.print("Enter Your Phone Number : ");
                pno = sc.next();
                validatePhoneNo(pno);
                System.out.print("Enter Your PassWord : ");
                sc.nextLine();
                String pass= sc.nextLine();
                System.out.println(userController.SignUp(name,pno,pass,getRoleFromUser()));
            } else if (choice == 0) {
                System.out.println("Process Finished, Exiting The Program ..................");
                break loop;
            } else if (choice == 2) {
                System.out.print("Enter Your Phone Number : ");
                pno= sc.next();
                System.out.print("Enter Your PassWord : ");
                sc.nextLine();
                String pass= sc.nextLine();
                String k=userController.signIn(pno,pass);
                System.out.println(k);
                System.out.println("\n");
                if(k.equals("Successfully Login")||k.equals("Successfully Login as Admin")){
                    if(k.equals("Successfully Login as Admin")){
                        loop2 : while (true) {
                            dispalyAdminMenu();
                            int inp=0;
                            try {
                                inp = sc.nextInt();
                            }
                            catch (Exception e){
                                sc.nextLine();
                                System.out.println("Invalid entry");
                                continue ;
                            }
                            switch (inp) {
                                case -1:
                                    System.out.println("Leaving The Program .............  ");
                                    System.out.println("\n");
                                    break loop;
                                case 0:
                                    System.out.println("Moving To Sign Up / Sign In Page ............ ");
                                    System.out.println("\n");
                                    break loop2;
                                case 1:
                                    System.out.print("Enter Batch Name : ");
                                    sc.nextLine();
                                    String batchID=sc.nextLine();
                                    System.out.println(userController.createBatch(batchID));
                                    System.out.println("\n");
                                    break ;
                                case 2:
                                    // the phone number which does not exist is also added in batch
                                    System.out.print("Enter Batch Name : ");
                                    batchID=sc.next();
                                    System.out.print("Enter Student Phone Number : ");
                                    String Pno=sc.next();
                                    // Admin phone Number Not Allowed


                                        System.out.println(userController.assignBatch(batchID, Pno));

                                    System.out.println("\n");
                                    break ;
                                case 3:
                                    System.out.print("Enter Question ID : ");
                                    String qID=sc.next();
                                    sc.nextLine();
                                    System.out.print("Enter Your Question : ");
                                    String ques=sc.nextLine();
                                    System.out.println(userController.createQuestion(qID,ques));
                                    System.out.println("\n");
                                    break ;
                                case 4:
                                    //Does Not Chect Question Exists OR Not
                                    System.out.print("Enter Question ID : ");
                                    qID=sc.next();
                                    sc.nextLine();
                                    System.out.print("Enter Your Question : ");
                                    ques=sc.nextLine();
                                    System.out.println(userController.editQuestion(qID,ques));
                                    System.out.println("\n");
                                    break ;
                                case 5:
                                    System.out.print("Enter Batch Name : ");
                                    batchID=sc.next();
                                    System.out.print("Enter Question ID : ");
                                    qID=sc.next();
                                    System.out.println(userController.addQuestion(batchID,qID));
                                    System.out.println("\n");
                                    break ;
                                case 6:
                                    System.out.println("Loading All The Replies Of The Feedback........ ");
                                    userController.getAllReply();
                                    System.out.println("\n");
                                    break ;
                                case 7:
                                    System.out.print("Enter Student Phone Number : ");
                                    Pno=sc.next();
                                    if(Pno.equals(pno)){
                                        System.out.println("You Can't Enter Your Own Phone Number");
                                    }
                                    else {
                                        userController.getReplyByStudentPhoneNo(Pno);
                                    }
                                    System.out.println("\n");
                                    break ;
                                default:
                                    System.out.println("Invalid Input Provided, Please Enter A Valid Input");
                                    System.out.println("\n");
                                    break ;
                            }
                        }
                    }
                    else {
                        loop3 : while (true){
                           displayUserMenu();
                            int inp = sc.nextInt();
                            switch (inp) {
                                case -1:
                                    System.out.println("Leaving The Program .............  ");
                                    System.out.println("\n");
                                    break loop;
                                case 0:
                                    System.out.println("Moving To Sign Up / Sign In Page ............ ");
                                    System.out.println("\n");
                                    break loop3;
                                case 1:
                                    // Agar Glt batch Id Enter kiya jaaye to kuch show nhi ho rha hai
                                    System.out.print("Enter Batch ID : ");
                                    String batchID = sc.next();
                                    userController.giveFeedbackReply(batchID, pno);
                                    System.out.println("\n");
                                    break;
                                default:
                                    System.out.println("Invalid Input Provided, Please Enter A Valid Input");
                                    System.out.println("\n");
                                    break ;
                            }
                        }
                    }
                }


            }
            else {
                System.out.println("Invalid Input Provided, Please Re Enter Your Choice");
                System.out.println("\n");
            }
        }
        // Closing The Scanner
        sc.close();
    }



    ///// Methods
    static String getRoleFromUser() {
        System.out.println("Choose Your Role: ");
        System.out.println("Press '1' ==> ADMIN");
        System.out.println("Press Any Digit ==> STUDENT");
        int roleChoice = sc.nextInt();
        return roleChoice == 1 ? "ADMIN" : "STUDENT";
    }
    static void displayUserMenu() {
        System.out.println("\n");
        System.out.println("Press '-1' For Exiting The Application ");
        System.out.println("For Sign Out Press '0' ");
        System.out.println("Press '1' For Filling FeedBack Question");
        System.out.print("Enter Your Choice : ");
    }
    static void dispalyAdminMenu(){
        System.out.println("");
        System.out.println("Press '-1' For Exiting The Application ");
        System.out.println("For Sign Out Press '0' ");
        System.out.println("Press '1' For Creating Batch ");
        System.out.println("Press '2' For Assigning Batch To A Student");
        System.out.println("Press '3' For Creating Question");
        System.out.println("Press '4' For Editing Question");
        System.out.println("Press '5' For Adding Question To A Batch");
        System.out.println("Press '6' For Viewing All Reply Of Students");
        System.out.println("Press '7' For Getting Reply Of Student By Phone Number");
        System.out.print("Enter Your Choice : ");
    }
    static void validatePhoneNo(String phone){
        while (true){
            boolean validLenght = phone.length() ==10;
            boolean hasDigit=true;
            for (int i = 0; i < phone.length(); i++) {
                if (!Character.isDigit(phone.charAt(i))) {
                    hasDigit = false;
                }
            }
            if(validLenght && hasDigit){
                break ;
            }
            else {
                System.out.println("Invalid Phone Number Please Enter A Correct Phone Number. ");
                System.out.println();
                System.out.print("Re Enter Your Phone Number : ");
                phone = sc.next();
            }
        }
    }
}

