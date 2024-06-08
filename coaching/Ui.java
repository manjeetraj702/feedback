package coaching;

import coaching.controller.UserController;

import java.util.Scanner;

public class Ui {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserController userController=new UserController();
        String role = null;
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
                System.out.print("Enter Your Phone Number : ");
                String pno= sc.next();
                System.out.print("Enter Your PassWord : ");
                String pass= sc.next();
                System.out.print("Enter Your Role : ");
                role= sc.next();
                System.out.println(userController.SignUp(name,pno,pass,role));
            } else if (choice == 0) {
                System.out.println("Process Finished, Exiting The Program ..................");
                break loop;
            } else if (choice == 2) {
                System.out.print("Enter Your Phone Number : ");
                String pno= sc.next();
                System.out.print("Enter Your PassWord : ");
                String pass= sc.next();
                String k=userController.signIn(pno,pass);
                System.out.println(k);
                System.out.println("\n");
                if(k.equals("Successfully Login")||k.equals("Successfully Login as Admin")){
                    if(role.equals("ADMIN")){
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
                                    String batchID=sc.next();
                                    userController.createBatch(batchID);
                                    System.out.println("\n");
                                    break ;
                                case 2:
                                    System.out.print("Enter Batch ID : ");
                                    batchID=sc.next();
                                    System.out.print("Enter Student Phone Number : ");
                                    String Pno=sc.next();
                                    userController.addStudent(batchID,Pno);
                                    System.out.println("\n");
                                    break ;
                                case 3:
                                    System.out.print("Enter Batch ID : ");
                                    batchID=sc.next();
                                    System.out.print("Enter Student Phone Number : ");
                                    Pno=sc.next();
                                    userController.assignBatch(batchID,Pno);
                                    System.out.println("\n");
                                    break ;
                                case 4:
                                    System.out.print("Enter Question ID : ");
                                    String qID=sc.next();
                                    System.out.print("Enter Your Question : ");
                                    String ques=sc.next();
                                    userController.createQuestion(qID,ques);
                                    System.out.println("\n");
                                    break ;
                                case 5:
                                    System.out.print("Enter Question ID : ");
                                    qID=sc.next();
                                    System.out.print("Enter Your Question : ");
                                    ques=sc.next();
                                    userController.editQuestion(qID,ques);
                                    System.out.println("\n");
                                    break ;
                                case 6:
                                    System.out.print("Enter Batch ID : ");
                                    batchID=sc.next();
                                    System.out.print("Enter Question ID : ");
                                    qID=sc.next();
                                    userController.addQuestion(batchID,qID);
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
                                    System.out.print("Enter Student Phone Number : ");
                                    String Pno = sc.next();
                                    userController.giveFeedbackReply(batchID, Pno);
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
