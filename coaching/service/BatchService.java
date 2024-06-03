package coaching.service;

import coaching.model.Batch;

public interface BatchService {
    String createBatch(String batchId);
    String addStudent(String batchId,String phoneNo);
    Batch checkStudent(String bathcId, String phoneNo);
}
