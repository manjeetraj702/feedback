package coaching.service;

import coaching.service.impl.BatchServiceImpl;
import coaching.service.impl.UserServiceImpl;

public interface ReplyService {
    void createReply(String batchId,String questionId,String phoneNo,String reply);
    void deleteReply(String batchId,String questionId);
    void getReply(String phoneNo);
    void getAllReply(String adminPhoneNO, UserServiceImpl userService, BatchServiceImpl batchService);
}
