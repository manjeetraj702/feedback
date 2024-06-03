package coaching.model;

public class Reply {
    private String batchId;
    private String questionId;
    private String phoneNo;
    private String reply;

    public Reply(String batchId, String questionId, String phoneNo, String reply) {
        this.batchId = batchId;
        this.questionId = questionId;
        this.phoneNo = phoneNo;
        this.reply = reply;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
