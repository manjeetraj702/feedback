package coaching;
import coaching.controller.UserController;

import java.util.Scanner;

public class Ui {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserController userController=new UserController();
        loop : while (true){
            System.out.println("For Sign Up Press '1' ");
            System.out.println("For Sign In/Login Press '2' ");
            System.out.println("Press '0' For Exiting This Program ");
            System.out.print("Enter Your Choice : ");
            int choice= sc.nextInt();
            System.out.println("\n");
            if(choice == 1){
                System.out.print("Enter Your Name : ");
                String name= sc.next();
                System.out.print("Enter Your Phone Number : ");
                String pno= sc.next();
                System.out.print("Enter Your PassWord : ");
                String pass= sc.next();
                System.out.print("Enter Your Role : ");
                String role= sc.next();
                userController.SignUp(name,pno,pass,role);
            } else if (choice == 3) {
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
                if(k.equals("Successfully Login")){
                      while (true) {
                        System.out.println("Press '0' For Exiting Program");
                        System.out.println("Press '1' For Creating Batch ");
                        System.out.println("Press '2' For Adding Student To A Batch");
                        System.out.println("Press '3' For Assigning Batch To A Student");
                        System.out.println("Press '4' For Creating Question");
                        System.out.println("Press '5' For Editing Question");
                        System.out.println("Press '6' For Deleting  Question");
                        System.out.println("Press '7' For Replying FeedBack Question");
                        System.out.println("Press '8' For Viewing Reply By Phone Number");
                        System.out.println("Press '9' For Viewing All Reply Of Students");
                        System.out.println("Press '10' For Viewing Reply By Batch");
                        System.out.print("Enter Your Choice : ");
                        int inp = sc.nextInt();
                        switch (inp) {
                            case 0:
                                System.out.println("Exiting This Program ............ ");
                                break loop;
                            case 1:
                                System.out.print("Enter Batch ID : ");
                                String batchID=sc.next();
                                System.out.print("Enter Admin Phone Number : ");
                                String admnPno=sc.next();
                                userController.createBatch(batchID,admnPno);
                                break ;
                            case 2:
                                System.out.print("Enter Batch ID : ");
                                batchID=sc.next();
                                System.out.print("Enter Student Phone Number : ");
                                String Pno=sc.next();
                                System.out.print("Enter Admin Phone Number : ");
                                admnPno=sc.next();
                                userController.addStudent(batchID,Pno,admnPno);
                                break ;
                            case 3:
                                System.out.print("Enter Batch ID : ");
                                batchID=sc.next();
                                System.out.print("Enter Student Phone Number : ");
                                Pno=sc.next();
                                System.out.print("Enter Admin Phone Number : ");
                                admnPno=sc.next();
                                userController.assignBatch(batchID,Pno,admnPno);
                                break ;
                            case 4:
                                System.out.print("Enter Batch ID : ");
                                batchID=sc.next();
                                System.out.print("Enter Question ID : ");
                                String qID=sc.next();
                                System.out.print("Enter Your Question : ");
                                String ques=sc.next();
                                System.out.print("Enter Admin Phone Number : ");
                                admnPno=sc.next();
                                userController.createQuestion(batchID,qID,ques,admnPno);
                                break ;
                            case 5:
                                System.out.print("Enter Batch ID : ");
                                batchID=sc.next();
                                System.out.print("Enter Question ID : ");
                                qID=sc.next();
                                System.out.print("Enter Your Question : ");
                                ques=sc.next();
                                System.out.print("Enter Admin Phone Number : ");
                                admnPno=sc.next();
                                userController.editQuestion(batchID,qID,ques,admnPno);
                                break ;
                            case 6:
                                System.out.print("Enter Batch ID : ");
                                batchID=sc.next();
                                System.out.print("Enter Question ID : ");
                                qID=sc.next();
                                System.out.print("Enter Admin Phone Number : ");
                                admnPno=sc.next();
                                userController.deleteQuestion(batchID,qID,admnPno);
                                break ;
                            case 7:
                                System.out.print("Enter Batch ID : ");
                                batchID=sc.next();
                                System.out.print("Enter Student Phone Number : ");
                                Pno=sc.next();
                                userController.replyFeedback(batchID,Pno);
                                break ;
                            case 8:
                                System.out.print("Enter Student Phone Number : ");
                                Pno=sc.next();
                                userController.findByPhoneNO(Pno);
                                break ;
                            case 9:
                                System.out.print("Enter Admin Phone Number : ");
                                admnPno=sc.next();
                                userController.getAllReply(admnPno);
                                break ;
                            case 10:
                                System.out.print("Enter Student Phone Number : ");
                                Pno=sc.next();
                                System.out.print("Enter Batch ID : ");
                                batchID=sc.next();
                                userController.batchReply(Pno,batchID);
                                break ;
                            default:
                                System.out.println("Invalid Input Provided ");
                        }
                    }



                }


            }
            else {
                System.out.println("Invalid Input Provided, Please Re Enter Your Choice");
                System.out.println();
                System.out.println();
            }
        }
    }
}
