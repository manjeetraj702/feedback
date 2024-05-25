package coaching.service.impl;

import coaching.model.Batch;
import coaching.model.Feedback;
import coaching.model.User;
import coaching.repository.impl.FeedbackRepositoryImpl;
import coaching.service.FeedbackService;

import java.util.List;
import java.util.Scanner;

public class FeedbackServiceImpl implements FeedbackService {
    FeedbackRepositoryImpl feedbackRepository=new FeedbackRepositoryImpl();
    @Override
    public void createQuestion(String batchId, String questionId, String question,String adminPhoneNO,UserServiceImpl userService) {
        User user=userService.findByPhoneNO(adminPhoneNO);
        if(user!=null && user.getRole().equals("ADMIN"))
        {
            Feedback feedback=new Feedback(batchId,questionId,question);
            feedbackRepository.createQuesiton(feedback);
            System.out.println("question created");
        }
    }

    @Override
    public void editQuestion(String batchId, String questionId, String question,String adminPhoneNo,UserServiceImpl userService) {
        User user=userService.findByPhoneNO(adminPhoneNo);
        if(user!=null && user.getRole().equals("ADMIN"))
        {
            feedbackRepository.editQuestion(batchId,questionId,question);
        }
    }

    @Override
    public void deleteQuestion(String batchId, String questionId,String adminPhoneNo,UserServiceImpl userService,ReplyServiceImpl replyService) {
        User user=userService.findByPhoneNO(adminPhoneNo);
        if(user!=null && user.getRole().equals("ADMIN"))
        {
            feedbackRepository.deleteQuestion(batchId,questionId);
            replyService.deleteReply(batchId,questionId);
            System.out.println("delete");
        }
    }
    public  void replyFeedback(String batchId,String phoneNo,ReplyServiceImpl replyService,BatchServiceImpl batchService) {
        Batch batch=batchService.checkStudent(batchId,phoneNo);
        if (batch != null ) {
            List<Feedback> feedbackList=feedbackRepository.getFeedbackList();
            for(Feedback feedback:feedbackList)
            {
                if(feedback.getBatchId().equals(batchId))
                {
                    System.out.println(feedback.getQuestion());
                    Scanner sc=new Scanner(System.in);
                    String reply=sc.nextLine();
                    replyService.createReply(batchId,feedback.getQuestionId(),phoneNo,reply);
                }
            }
            System.out.println("Thanks for feedback");
        }
    }
}
