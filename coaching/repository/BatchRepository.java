package coaching.repository;

import coaching.model.Batch;

public interface BatchRepository {
    void saveBatch(Batch batch);
    Batch addStudent(String batchId,String phone);
    Batch checkStudent(String batchId,String phone);
}
