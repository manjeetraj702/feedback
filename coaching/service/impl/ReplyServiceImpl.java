package coaching.service.impl;

import coaching.model.Batch;
import coaching.model.Reply;
import coaching.model.User;
import coaching.repository.impl.ReplyRepositoryImpl;
import coaching.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {
    ReplyRepositoryImpl repository=new ReplyRepositoryImpl();
    @Override
    public void createReply(String batchId,String questionId, String phoneNo, String reply) {
        Reply reply1=new Reply(batchId,questionId,phoneNo,reply);
        repository.saveReply(reply1);
    }

    @Override
    public void deleteReply(String bathcId,String questionId) {
        repository.deleteReplies(bathcId,questionId);
    }

    @Override
    public void getReply(String phoneNo) {
        repository.getByphone(phoneNo);
    }
    public void batchReply(String phoneNo,String batchId,UserServiceImpl userService)
    {
        User user=userService.findByPhoneNO(phoneNo);
        if(user!=null)
        {
            repository.getAll(batchId);
        }
        else {
            repository.getByphone(phoneNo);
        }
    }

    @Override
    public void getAllReply(String adminPhoneNO,UserServiceImpl userService,BatchServiceImpl batchService) {
        User user=userService.findByPhoneNO(adminPhoneNO);
        if(user !=null) {
            for(Batch batch:batchService.getBatchList())
            {
                System.out.println(batch.getBatchId());
                repository.getAll(batch.getBatchId());
            }
        }
        else
        {
            System.out.println("Invalid admin No");
        }
    }

}
