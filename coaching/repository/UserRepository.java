package coaching.repository;

import coaching.model.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    User find(String phoneNo);

    List<User> getUserList();
}
