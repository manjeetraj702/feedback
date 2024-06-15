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
  
    public String SignUp(String userName,String phoneNo,String password,String role)
    {
       return userService.signUp(userName,phoneNo,password,role);
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
        return  userService.findByPhoneNo(phoneNo);
    }
    public String createBatch(String batchId)
    {
        return batchService.createBatch(batchId);
    }
//    public String addStudent(String batchId,String phoneNo)
//    {
//        return batchService.addStudent(batchId,phoneNo);
//    }

    public  String createQuestion(String questionId,String question)
    {
        return feedbackService.createQuestion(questionId,question);
    }
    public String editQuestion( String questionId, String question)
    {
        return feedbackService.editQuestion(questionId,question);
    }
    public String addQuestion(String batchId,String questionId)
    {
        return batchService.addQuestion(batchId,questionId);
    }

    public String giveFeedbackReply(String batchId,String phoneNo){
        return replyService.giveFeedbackReply(batchId,phoneNo,feedbackService,batchService);
    }
    public  String assignBatch(String batchId,String phoneNo)
    {
        return batchService.addStudent(batchId,phoneNo,userService);
    }
    public void getAllReply(){
        replyService.getAllReply(batchService);
    }
    public void getReplyByStudentPhoneNo(String phoneNo)
    {
        replyService.getReply(phoneNo);
    }




    }
