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
    public void signIn(String phoneNo,String password)
    {
        userService.signIn(phoneNo,password);
    }
    public User findByPhoneNO(String phoneNo)
    {
        return  userService.findByPhoneNO(phoneNo);
    }
    public void createBatch(String batchId,String adminPhone)
    {
        batchService.createBatch(batchId,adminPhone,userService);
    }
    public void addStudent(String batchId,String phoneNo,String adminPhoneNo)
    {
        batchService.addStudent(batchId,phoneNo,adminPhoneNo,userService);
    }

    public  void createQuestion(String batchId,String questionId,String question,String adminPhoneNo)
    {
        feedbackService.createQuestion(batchId,questionId,question,adminPhoneNo,userService);
    }
    public void editQuestion(String batchId, String questionId, String question,String adminPhoneNo)
    {
        feedbackService.editQuestion(batchId,questionId,question,adminPhoneNo,userService);
    }
    public void deleteQuestion(String batchId, String questionId,String adminPhoneNo) {
        feedbackService.deleteQuestion(batchId,questionId,adminPhoneNo,userService,replyService);
    }
    public void replyFeedback(String batchId,String phoneNo){
        feedbackService.replyFeedback(batchId,phoneNo,replyService,batchService);
    }
    public  void assignBatch(String batchId,String phoneNo,String adminPhoneNo)
    {
        batchService.addStudent(batchId,phoneNo,adminPhoneNo,userService);
    }
    public void getAllReply(String adminPhoneNO){
        replyService.getAllReply(adminPhoneNO,userService,batchService);
    }
    public void getReply(String phoneNo)
    {
        replyService.getReply(phoneNo);
    }
    public void batchReply(String phoneNo,String batchId)
    {
        replyService.batchReply(phoneNo,batchId,userService);
    }



    }
