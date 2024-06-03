package coaching.repository.impl;

import coaching.model.User;
import coaching.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private List<User> userList =new ArrayList<>();

    @Override
    public void saveUser(User user) {
        userList.add(user);
    }

    @Override
    public User findByPhoneNo(String phoneNo) {
        for(User user:userList)
        {
            if(user.getPhoneNo().equals(phoneNo))
            {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUserList() {
        return userList;
    }
}
