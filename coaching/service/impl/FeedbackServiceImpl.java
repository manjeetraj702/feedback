package coaching.service.impl;
import coaching.model.Feedback;
import coaching.repository.impl.FeedbackRepositoryImpl;
import coaching.service.FeedbackService;

import java.util.List;


public class FeedbackServiceImpl implements FeedbackService {
    FeedbackRepositoryImpl feedbackRepository=new FeedbackRepositoryImpl();
    @Override
    public String  createQuestion( String questionId, String question) {
        questionId=questionId.trim();
        if(questionId.isEmpty())
        {
            return "Question ID is blank";
        }
        question=question.trim();
        if(question.isEmpty())
        {
            return "Question is blank";
        }
        List<Feedback> feedbackList=feedbackRepository.getFeedbackList();
        for(Feedback feedback:feedbackList)
        {
            if(feedback.getQuestionId().equals(questionId))
            {
                return  "QuestionId Already exist";
            }
        }
            Feedback feedback=new Feedback(questionId,question);
            feedbackRepository.createQuesiton(feedback);
            return "question created";

    }

    @Override
    public String editQuestion( String questionId, String question) {
        questionId=questionId.trim();
        if(questionId.isEmpty())
        {
            return "QuestionId is blank";
        }
        question=question.trim();
        if(question.isEmpty())
        {
            return "Question is blank";
        }
            feedbackRepository.editQuestion(questionId,question);
        return "Question Successfully changed";

    }


    public List<Feedback> getFeedbackList() {
        return feedbackRepository.getFeedbackList();
    }
}
