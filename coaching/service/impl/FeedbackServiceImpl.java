package coaching.service.impl;
import coaching.model.Feedback;
import coaching.repository.impl.FeedbackRepositoryImpl;
import coaching.service.FeedbackService;

import java.util.List;


public class FeedbackServiceImpl implements FeedbackService {
    FeedbackRepositoryImpl feedbackRepository=new FeedbackRepositoryImpl();
    @Override
    public void createQuestion( String questionId, String question) {
            Feedback feedback=new Feedback(questionId,question);
            feedbackRepository.createQuesiton(feedback);
            System.out.println("question created");

    }

    @Override
    public void editQuestion( String questionId, String question) {
            feedbackRepository.editQuestion(questionId,question);

    }


    public List<Feedback> getFeedbackList() {
        return feedbackRepository.getFeedbackList();
    }
}
