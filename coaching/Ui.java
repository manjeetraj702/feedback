package coaching;

import coaching.controller.UserController;

public class Ui {

    public static void main(String[] args) {
    UserController userController=new UserController();
        userController.SignUp("rahul","1234","qwe","ADMIN");
        userController.SignUp("chotu","0000","qwe","Student");
        userController.SignUp("kishan","5468","aka","Student");
        userController.signIn("1234","qwjg");
        userController.createBatch("c4","1234");
        userController.createBatch("c1","1234");
        userController.assignBatch("c1","0000","1234");
        userController.assignBatch("c4","5468","1234");
        userController.createQuestion("c1","1","How is your class","1234");
        userController.createQuestion("c1","2","How is your teacher","1234");
        userController.createQuestion("c1","3","How is your day","1234");
        userController.createQuestion("c4","1","Do You Like Our Feedback System","1234");
        userController.replyFeedback("c1","0000");
        userController.replyFeedback("c4","5468");
        userController.deleteQuestion("c1","3","1234");
        userController.getAllReply("1234");
        userController.batchReply("0000","c1");

    }
}
