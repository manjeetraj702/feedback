package coaching.repository.impl;

import coaching.model.Reply;
import coaching.repository.ReplyRepository;

import java.util.ArrayList;
import java.util.List;

public class ReplyRepositoryImpl implements ReplyRepository {
    private List<Reply> replyList=new ArrayList<>();
    @Override
    public void saveReply(Reply reply) {
        replyList.add(reply);
    }

    public void deleteReplies(String batchId,String quesitonId) {
         for(int i=0;i<replyList.size();i++)
       {
           Reply reply=replyList.get(i);
           if(quesitonId.equals(reply.getQuesitionId()) && reply.getBatchId().equals(batchId))
           {
               replyList.remove(reply);
           }
       }
    }

    @Override
    public void getByphone(String phoneNo) {
        for(Reply reply:replyList)
        {
            if(phoneNo.equals(reply.getPhoneNo()))
            {
                System.out.println(reply.getReply());
            }
        }
    }

    @Override
    public void getAll(String batchId) {
        for(Reply reply:replyList)
        {
            if(batchId.equals(reply.getBatchId())) {
                System.out.println(reply.getQuesitionId() + " " + reply.getReply());
            }
        }
    }




}
