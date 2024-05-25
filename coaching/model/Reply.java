package coaching.model;

public class Reply {
    private  String batchId;
    private  String quesitionId;
    private  String phoneNo;
    private  String reply;

    public String getQuesitionId() {
        return quesitionId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public void setQuesitionId(String quesitionId) {
        this.quesitionId = quesitionId;
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

    public Reply(String batchId, String quesitionId, String phoneNo, String reply) {
        this.batchId = batchId;
        this.quesitionId = quesitionId;
        this.phoneNo = phoneNo;
        this.reply = reply;
    }

    public Reply(String batchId) {
        this.batchId = batchId;
    }
}
