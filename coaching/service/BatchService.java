package coaching.service;

import coaching.model.Batch;
import coaching.service.impl.UserServiceImpl;

public interface BatchService {
    void createBatch(String batchId, String adminPhone, UserServiceImpl userService);
    void addStudent(String batchId,String phoneNo,String adminPhoneNo, UserServiceImpl userService);
    Batch checkStudent(String bathcId, String phoneNo);
}
