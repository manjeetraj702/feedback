package coaching.service;

import coaching.service.impl.ReplyServiceImpl;
import coaching.service.impl.UserServiceImpl;

public interface FeedbackService {
    void createQuestion(String batchId, String questionId, String question, String AdminPhoneNo, UserServiceImpl userService);
    void editQuestion(String batchId,String questionId,String question,String AdminPhoneNo,UserServiceImpl userService);
    void deleteQuestion(String batchId, String questionId, String AdminPhoneNo, UserServiceImpl userService, ReplyServiceImpl replyService);
}
