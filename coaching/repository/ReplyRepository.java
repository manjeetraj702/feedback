package coaching.repository;

import coaching.model.Reply;

public interface ReplyRepository {
    void saveReply(Reply reply);
    void deleteReplies(String batchId,String quesitonId);
    void getByphone(String phoneNo);
    void getAll(String batchId);
}
