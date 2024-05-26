package coaching.service.impl;

import coaching.model.User;
import coaching.repository.impl.UserRepositoryImpl;
import coaching.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepositoryImpl userRepository=new UserRepositoryImpl();
    @Override
    public void signUp(String userName, String phoneNo,String password, String role) {
        User user=new User(userName,phoneNo,password,role);
        userRepository.save(user);
        System.out.println("User Added Successfully");
    }

    @Override
    public String signIn(String phoneNo, String password) {
        User user=userRepository.find(phoneNo);
        if(user!=null && user.getPassword().equals(password) )
        {
            return "Successfully Login";
        }
        else{
            return "Invalid Phone Number Or PassWord";
        }
    }

    @Override
    public User findByPhoneNO(String phoneNo) {
        List<User> userList=userRepository.getUserList();
        for(User user:userList)
        {
            if(user.getRole().equals("ADMIN") && user.getPhoneNo().equals(phoneNo))
            {
                return  user;
            }
        }
        return  null;
    }
    public User findByUser(String phoneNo) {
        List<User> userList=userRepository.getUserList();
        for(User user:userList)
        {
            if(user.getPhoneNo().equals(phoneNo))
            {
                return  user;
            }
        }
        return  null;
    }
}
