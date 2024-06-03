package coaching.service;

import coaching.model.User;

public interface UserService {
    String signUp(String userName, String phoneNo,String password, String role);
    String signIn(String phoneNo, String password);
    User findByPhoneNO(String phoneNo);
}
