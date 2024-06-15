package coaching.service;

import coaching.service.impl.BatchServiceImpl;
import coaching.service.impl.FeedbackServiceImpl;
import coaching.service.impl.UserServiceImpl;

public interface ReplyService {

    void getReply(String phoneNo);
    void getAllReply(BatchServiceImpl batchService);
     String giveFeedbackReply(String batchId, String phoneNo, FeedbackServiceImpl feedbackService, BatchServiceImpl batchService);
}
