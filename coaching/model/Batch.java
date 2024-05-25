package coaching.model;

import java.util.ArrayList;
import java.util.List;

public class Batch {
    private String batchId;
    private List<String> students =new ArrayList<>();



    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudent(String student) {
        this.students.add( student);
    }

    public Batch(String batchId) {
        this.batchId = batchId;
    }

}
