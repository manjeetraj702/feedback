package coaching.service;

import coaching.service.impl.ReplyServiceImpl;
import coaching.service.impl.UserServiceImpl;

public interface FeedbackService {
    String createQuestion( String questionId, String question);
    String editQuestion(String questionId,String question);

}
