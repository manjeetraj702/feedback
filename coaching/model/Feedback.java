package coaching.model;


public class Feedback {
    String questionId;
    String question;

    public Feedback( String questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    public String getQuestionId() {
        return questionId;
    }
    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
