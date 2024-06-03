package coaching.service.impl;
import coaching.model.Reply;
import coaching.model.Batch;
import coaching.model.Feedback;
import coaching.repository.impl.ReplyRepositoryImpl;
import coaching.service.ReplyService;

import java.util.Scanner;


public class ReplyServiceImpl implements ReplyService {
    ReplyRepositoryImpl repository=new ReplyRepositoryImpl();
    @Override
    public void giveFeedbackReply(String batchId, String phoneNo,FeedbackServiceImpl feedbackService,BatchServiceImpl batchService) {
        Batch batch=batchService.getBatch(batchId);
        Scanner sc=new Scanner(System.in);
        if(batch!= null )
        {
            for(String questionId : batch.getBatchQuestions())
            {
                for(Feedback feedback:feedbackService.getFeedbackList())
                {
                    if(feedback.getQuestionId().equals(questionId))
                    {
                        System.out.println(feedback.getQuestion());
                        String reply=sc.nextLine();
                       Reply reply1=new Reply(batchId,questionId,phoneNo,reply);
                       repository.saveReply(reply1);
                    }
                }
            }

        }
        else {
            System.out.println("Batch doesn't exist");
        }
    }



    @Override
    public void getReply(String phoneNo) {
        repository.getByphone(phoneNo);
    }
    public void getReplyByBatchId(String batchId)
    {
            repository.getAll(batchId);

    }

    @Override
    public void getAllReply(BatchServiceImpl batchService) {
            for(Batch batch:batchService.getBatchList())
            {
                System.out.println(batch.getBatchId());
                repository.getAll(batch.getBatchId());
            }


    }

}
