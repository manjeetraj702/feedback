package coaching.repository;

import coaching.model.Feedback;

public interface FeedbackRepository {
    void createQuesiton(Feedback feedback);
    void editQuestion(String quesitonId,String question);
}
