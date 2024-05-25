package coaching.service;

import coaching.model.User;

public interface UserService {
    void signUp(String userName,String phoneNo,String password,String role);
    void signIn(String userName,String phoneNo);

    User findByPhoneNO(String phoneNo);
}
