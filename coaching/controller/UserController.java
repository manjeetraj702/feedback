package coaching.controller;

import coaching.model.User;
import coaching.service.impl.BatchServiceImpl;
import coaching.service.impl.FeedbackServiceImpl;
import coaching.service.impl.ReplyServiceImpl;
import coaching.service.impl.UserServiceImpl;

public class UserController {
    UserServiceImpl userService=new UserServiceImpl();
    BatchServiceImpl batchService=new BatchServiceImpl();
    FeedbackServiceImpl feedbackService=new FeedbackServiceImpl();
    ReplyServiceImpl replyService=new ReplyServiceImpl();
    
    public void SignUp(String userName,String phoneNo,String password,String role)
    {
        userService.signUp(userName,phoneNo,password,role);
    }
    public String signIn(String phoneNo, String password)
    {
        return userService.signIn(phoneNo,password);
    }
    public User findByPhoneNo(String phoneNo)
    {
        return  userService.findByPhoneNO(phoneNo);
    }
    public void createBatch(String batchId)
    {
        batchService.createBatch(batchId);
    }
    public void addStudent(String batchId,String phoneNo)
    {
        batchService.addStudent(batchId,phoneNo);
    }

    public  void createQuestion(String questionId,String question)
    {
        feedbackService.createQuestion(questionId,question);
    }
    public void editQuestion( String questionId, String question)
    {
        feedbackService.editQuestion(questionId,question);
    }
    public String addQuestion(String batchId,String questionId)
    {
        return batchService.addQuestion(batchId,questionId);
    }

    public void giveFeedbackReply(String batchId,String phoneNo){
        replyService.giveFeedbackReply(batchId,phoneNo,feedbackService,batchService);
    }
    public  void assignBatch(String batchId,String phoneNo)
    {
        batchService.addStudent(batchId,phoneNo);
    }
    public void getAllReply(){
        replyService.getAllReply(batchService);
    }
    public void getReplyByStudentPhoneNo(String phoneNo)
    {
        replyService.getReply(phoneNo);
    }




    }
