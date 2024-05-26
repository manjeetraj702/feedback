package coaching.service;

import coaching.service.impl.ReplyServiceImpl;
import coaching.service.impl.UserServiceImpl;

public interface FeedbackService {
    void createQuestion( String questionId, String question);
    void editQuestion(String questionId,String question);

}
