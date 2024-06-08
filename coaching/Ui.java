package coaching;

import coaching.controller.UserController;

import java.util.Scanner;

public class Ui {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserController userController=new UserController();
        String pno=null;
        String role= "User";
        loop : while (true){
            System.out.println("For Sign Up Press '1' ");
            System.out.println("For Sign In/Login Press '2' ");
            System.out.println("Press '0' For Exiting This Program ");
            System.out.print("Enter Your Choice : ");
            int choice= sc.nextInt();
            System.out.println("\n");
            if(choice == 1){
                System.out.print("Enter Your Name : ");
                sc.nextLine();
                String name= sc.nextLine();
                // Phone Number Handling
                while (true) {
                    System.out.print("Enter Your Phone Number : ");
                    pno = sc.next();
                    boolean validLenght = pno.length() ==10;
                    boolean hasDigit=true;
                    for (int i = 0; i < pno.length(); i++) {
                        if (!Character.isDigit(pno.charAt(i))) {
                            hasDigit = false;
                        }
                    }
                    if(validLenght && hasDigit){
                        break ;
                    }
                    else {
                        System.out.println("Invalid Phone Number Please Enter A Correct Phone Number. ");
                        System.out.println("\n");
                    }
                }
                System.out.print("Enter Your PassWord : ");
                sc.nextLine();
                String pass= sc.nextLine();
                System.out.println("Choose Your Role : ");
                System.out.println("Press '1' ==> ADMIN");
                System.out.println("Press Any Digit ==> USER");
                int a= sc.nextInt();
                if(a==1){
                    role="ADMIN";
                }
                System.out.println(userController.SignUp(name,pno,pass,role));
            } else if (choice == 0) {
                System.out.println("Process Finished, Exiting The Program ..................");
                break loop;
            } else if (choice == 2) {
                System.out.print("Enter Your Phone Number : ");
                pno= sc.next();
                System.out.print("Enter Your PassWord : ");
                String pass= sc.next();
                String k=userController.signIn(pno,pass);
                System.out.println(k);
                System.out.println("\n");
                if(k.equals("Successfully Login")||k.equals("Successfully Login as Admin")){
                    if(k.equals("Successfully Login as Admin")){
                        loop2 : while (true) {
                            System.out.println("Press '-1' For Exiting The Application ");
                            System.out.println("For Sign Out Press '0' ");
                            System.out.println("Press '1' For Creating Batch ");
                            System.out.println("Press '2' For Adding Student To A Batch");
                            System.out.println("Press '3' For Assigning Batch To A Student");
                            System.out.println("Press '4' For Creating Question");
                            System.out.println("Press '5' For Editing Question");
                            System.out.println("Press '6' For Adding Question To A Batch");
                            System.out.println("Press '7' For Viewing Reply By Phone Number");
                            System.out.println("Press '8' For Viewing All Reply Of Students");
                            System.out.println("Press '9' For Getting Reply Of Student By Phone Number");

                            System.out.print("Enter Your Choice : ");
                            int inp = sc.nextInt();
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
                                    System.out.print("Enter Batch ID : ");
                                    sc.nextLine();
                                    String batchID=sc.nextLine();
                                    System.out.println(userController.createBatch(batchID));
                                    System.out.println("\n");
                                    break ;
                                case 2:
                                    System.out.print("Enter Batch ID : ");
                                    sc.nextLine();
                                    batchID=sc.nextLine();
                                    System.out.print("Enter Student Phone Number : ");
                                    String Pno=sc.next();
                                    System.out.println(userController.addStudent(batchID,Pno));
                                    System.out.println("\n");
                                    break ;
                                case 3:
                                    System.out.print("Enter Batch ID : ");
                                    batchID=sc.next();
                                    System.out.print("Enter Student Phone Number : ");
                                    Pno=sc.next();
                                    System.out.println(userController.assignBatch(batchID,Pno));
                                    System.out.println("\n");
                                    break ;
                                case 4:
                                    System.out.print("Enter Question ID : ");
                                    String qID=sc.next();
                                    sc.nextLine();
                                    System.out.print("Enter Your Question : ");
                                    String ques=sc.nextLine();
                                    System.out.println(userController.createQuestion(qID,ques));
                                    System.out.println("\n");
                                    break ;
                                case 5:
                                    System.out.print("Enter Question ID : ");
                                    qID=sc.next();
                                    System.out.print("Enter Your Question : ");
                                    ques=sc.nextLine();
                                    System.out.println(userController.editQuestion(qID,ques));
                                    System.out.println("\n");
                                    break ;
                                case 6:
                                    System.out.print("Enter Batch ID : ");
                                    batchID=sc.nextLine();
                                    System.out.print("Enter Question ID : ");
                                    qID=sc.nextLine();
                                    System.out.println(userController.addQuestion(batchID,qID));
                                    System.out.println("\n");
                                    break ;
                                case 7:
                                    System.out.print("Enter Student Phone Number : ");
                                    Pno=sc.next();
                                    userController.findByPhoneNo(Pno);
                                    System.out.println("\n");
                                    break ;
                                case 8:
                                    System.out.print("Loading All The Replies Of The Feedback........ ");
                                    userController.getAllReply();
                                    System.out.println("\n");
                                    break ;
                                case 9:
                                    System.out.print("Enter Student Phone Number : ");
                                    Pno=sc.next();
                                    userController.getReplyByStudentPhoneNo(Pno);
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
                            System.out.println("\n");
                            System.out.println("Press '-1' For Exiting The Application ");
                            System.out.println("For Sign Out Press '0' ");
                            System.out.println("Press '1' For Filling FeedBack Question");
                            System.out.print("Enter Your Choice : ");
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

    }
}
