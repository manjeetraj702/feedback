package coaching.service;

import coaching.model.Batch;
import coaching.service.impl.UserServiceImpl;

public interface BatchService {
    String createBatch(String batchId);
    String addStudent(String batchId,String phoneNo, UserServiceImpl userService);
    Batch checkStudent(String bathcId, String phoneNo);
}
