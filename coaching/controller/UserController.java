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
    
    public void SignUp(String userName,String phoneNO,String password,String role)
    {
        userService.signUp(userName,phoneNO,password,role);
    }
    public String signIn(String phoneNo, String password)
    {
        return userService.signIn(phoneNo,password);
    }
    public User findByPhoneNO(String phoneNo)
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
    public String addQuestion(String bathcId,String questionId)
    {
        return  null;
    }

    public void replyFeedback(String batchId,String phoneNo){
//        feedbackService.replyFeedback(batchId,phoneNo,replyService,batchService);
    }
    public  void assignBatch(String batchId,String phoneNo)
    {
        batchService.addStudent(batchId,phoneNo);
    }
    public void getAllReply(){
        replyService.getAllReply(batchService);
    }
    public void getReply(String phoneNo)
    {
        replyService.getReply(phoneNo);
    }




    }
