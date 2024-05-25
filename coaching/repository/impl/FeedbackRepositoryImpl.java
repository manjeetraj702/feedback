package coaching.repository.impl;

import coaching.model.Feedback;
import coaching.repository.FeedbackRepository;

import java.util.ArrayList;
import java.util.List;

public class FeedbackRepositoryImpl implements FeedbackRepository {
    private List<Feedback> feedbackList=new ArrayList<>();
    @Override
    public void createQuesiton(Feedback feedback) {
        feedbackList.add(feedback);
    }
    public List<Feedback> getFeedbackList()
{
    return feedbackList;
}
    @Override
    public Feedback deleteQuestion(String batchId, String quesitonId) {
        for(Feedback feedback1:feedbackList)
        {
            if( feedback1.getQuestionId().equals(quesitonId) && feedback1.getBatchId().equals(batchId))
            {
                feedbackList.remove(feedback1);
                return feedback1;
            }
        }
        return  null;
    }

    @Override
    public void editQuestion(String batchId, String quesitonId,String question) {
        for(Feedback feedback:feedbackList)
        {
            if(batchId.equals(feedback.getBatchId()) && quesitonId.equals(feedback.getQuestionId()))
            {
                feedback.setQuestion(question);
            }
        }
    }


}
