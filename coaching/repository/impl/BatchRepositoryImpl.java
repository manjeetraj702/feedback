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
    public String addStudent(String batch,String phone) {
        for(Batch batch1:batchList)
        {
            if(batch1.getBatchId().equals(batch))
            {

                for(String s:batch1.getStudents())
                {
                    if(s.equals(phone))
                    {
                        return  "Student Already present in Batch";
                    }
                }
                batch1.addStudent(phone);
                return  "Student added in Batch";
            }
        }
        return "Batch not found";
    }
    public String addQuestion(String batch,String questionId) {
        for(Batch batch1:batchList)
        {
            if(batch1.getBatchId().equals(batch))
            {

                for(String s:batch1.getBatchQuestions())
                {
                    if(s.equals(questionId))
                    {
                        return  "Question Already present in Batch";
                    }
                }
                batch1.addQuestion(questionId);
                return  "Question added in Batch";
            }
        }
        return "Batch not found";
    }
    public String removeQuestion(String batch,String questionId) {
        for(Batch batch1:batchList)
        {
            if(batch1.getBatchId().equals(batch))
            {

                for(String s:batch1.getBatchQuestions())
                {
                    if(s.equals(questionId))
                    {

                      batch1.removeQuestion(questionId);
                        return  "Question removed form Batch";
                    }
                }
                return  "Question not present in Batch";
            }
        }
        return "Batch not found";
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

    public Batch getBatch(String batchId) {
        for(Batch batch : batchList)
        {
            if(batchId.equals(batch.getBatchId()))
            {
                return  batch;
            }
        }
        return null;
    }
}
