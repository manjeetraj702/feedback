package coaching.service.impl;

import coaching.model.Batch;
import coaching.model.User;
import coaching.repository.impl.BatchRepositoryImpl;
import coaching.service.BatchService;

import java.util.List;

public class BatchServiceImpl implements BatchService {
    BatchRepositoryImpl batchRepository=new BatchRepositoryImpl();
    @Override
    public void createBatch(String batchId, String adminPhone,UserServiceImpl userService) {
        User user=userService.findByPhoneNO(adminPhone);
        if(user !=null && user.getRole().equals("ADMIN"))
        {
            Batch batch=new Batch(batchId);
            batchRepository.saveBatch(batch);
            System.out.println("batch created");
        }
        else
        {
            System.out.println("you are not admin");
        }

    }

    @Override
    public void addStudent(String bathcId,String phoneNo, String adminPhoneNo,UserServiceImpl userService) {
        User user=userService.findByPhoneNO(adminPhoneNo);
        if(user !=null && user.getRole().equals("ADMIN"))
        {User user1=userService.findByUser(phoneNo);
            if(user1!=null){
                Batch batch=batchRepository.addStudent(bathcId,phoneNo);
            if(batch!=null)
            {
                System.out.println("Student save");
            }
            else {
                System.out.println("Batch not exist");
            }}
            else {
                System.out.println("Student not present in user list");
            }
        }
        else {
            System.out.println("Invalid admin no");
        }
    }

    @Override
    public Batch checkStudent(String bathcId, String phoneNo) {
        return batchRepository.checkStudent(bathcId,phoneNo);
    }

    public List<Batch> getBatchList() {
        return batchRepository.getList();
    }
}
