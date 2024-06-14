package coaching.service.impl;

import coaching.model.Batch;
import coaching.model.User;
import coaching.repository.impl.BatchRepositoryImpl;
import coaching.service.BatchService;

import java.util.List;

public class BatchServiceImpl implements BatchService {
    BatchRepositoryImpl batchRepository=new BatchRepositoryImpl();
    @Override
    public String createBatch(String batchId) {
        batchId=batchId.trim();
        if(batchId.isEmpty())
        {
            return "BatchId contains only space";
        }
        List<Batch> batchList = batchRepository.getList();
        for (Batch batch:batchList)
        {
            if(batch.getBatchId().equals(batchId))
            {
                return  "Batch already exist";
            }

        }
        Batch batch=new Batch(batchId);
        batchRepository.saveBatch(batch);
        return  "Batch Created";
    }

    @Override
    public String addStudent(String bathcId,String phoneNo,UserServiceImpl userService) {
        User user=userService.findByPhoneNo(phoneNo);
        if(user==null)
        {
            return "This Phone Number Is Not registered";
        }
        if(user.isAssign()) {
            return batchRepository.addStudent(bathcId, phoneNo);
        }
        if(user.getRole().equals("ADMIN"))
        {
            return "This is Admin phoneNO";
        }
        user.setAssign(false);
        return "Student is Already Assign";
    }
    public String addQuestion(String bathcId,String questionId) {
        return batchRepository.addQuestion(bathcId,questionId);
    }
    public String removeQuestion(String bathcId,String questionId) {
        return batchRepository.removeQuestion(bathcId,questionId);
    }

    @Override
    public Batch checkStudent(String bathcId, String phoneNo) {
        return batchRepository.checkStudent(bathcId,phoneNo);
    }

    public List<Batch> getBatchList() {
        return batchRepository.getList();
    }

    public Batch getBatch(String batchId) {
        return batchRepository.getBatch(batchId);
    }
}
