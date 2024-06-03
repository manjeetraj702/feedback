package coaching.repository;

import coaching.model.User;

import java.util.List;

public interface UserRepository {
    void saveUser(User user);
    User findByPhoneNo(String phoneNo);

    List<User> getUserList();
}
