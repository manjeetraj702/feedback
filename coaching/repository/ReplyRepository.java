package coaching.repository;

import coaching.model.Reply;

public interface ReplyRepository {
    void saveReply(Reply reply);
    void getByphone(String phoneNo);
    void getAll(String batchId);
}
