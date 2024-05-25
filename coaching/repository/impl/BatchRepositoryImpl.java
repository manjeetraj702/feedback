package coaching.repository.impl;

import coaching.model.Batch;
import coaching.repository.BatchRepository;
import java.util.ArrayList;
import java.util.List;

public class BatchRepositoryImpl implements BatchRepository {
    private List<Batch> batchList=new ArrayList<>();
    @Override
    public void saveBatch(Batch batch) {
        batchList.add(batch);
    }

    @Override
    public Batch addStudent(String batch,String phone) {
        for(Batch batch1:batchList)
        {
            if(batch1.getBatchId().equals(batch))
            {

                batch1.setStudent(phone);
                return  batch1;
            }
        }
        return null;
    }

    @Override
    public Batch checkStudent(String batchId, String phone) {
        for(Batch batch:batchList)
        {
            if(batch.getBatchId().equals(batchId) )
            {
                for(String phoneNO:batch.getStudents())
                {
                    if(phoneNO.equals(phone))
                    {
                        return batch;
                    }
                }
            }
        }
        return null;
    }

    public List<Batch> getList() {
        return  batchList;
    }
}
