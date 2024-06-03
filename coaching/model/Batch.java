package coaching.model;

import java.util.ArrayList;
import java.util.List;

public class Batch {
    private String batchId;
    private List<String> students =new ArrayList<>();
    private List<String> batchQuestions=new ArrayList<>();



    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public List<String> getStudents() {
        return students;
    }
    public List<String> getBatchQuestions() {
        return batchQuestions;
    }

    public void addStudent(String student) {
        this.students.add( student);
    }
    public void addQuestion(String questionId) {
        this.batchQuestions.add( questionId);
    }
    public void removeQuestion(String questionId) {
        this.batchQuestions.remove( questionId);
    }

    public Batch(String batchId) {
        this.batchId = batchId;
    }

}
