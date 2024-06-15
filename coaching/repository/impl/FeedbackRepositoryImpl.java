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
    public void editQuestion( String quesitonId,String question) {
        for(Feedback feedback:feedbackList)
        {
            if(quesitonId.equals(feedback.getQuestionId()))
            {
                feedback.setQuestion(question);
            }
        }
    }


    public Feedback verfiyQuestionId(String questionId) {
        for(Feedback feedback:feedbackList)
        {
            if(feedback.getQuestionId().equals(questionId))
            {
                return feedback;
            }
        }
        return null;
    }
}
