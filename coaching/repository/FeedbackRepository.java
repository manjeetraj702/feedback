package coaching.repository;

import coaching.model.Feedback;

public interface FeedbackRepository {
    void createQuesiton(Feedback feedback);
    Feedback deleteQuestion(String batchId,String quesitonId);
    void editQuestion(String batchId,String quesitonId,String question);
}
