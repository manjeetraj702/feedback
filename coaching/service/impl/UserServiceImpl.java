package coaching.service.impl;
import coaching.model.User;
import coaching.repository.impl.UserRepositoryImpl;
import coaching.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepositoryImpl userRepository=new UserRepositoryImpl();
    @Override
    public void signUp(String userName, String phoneNo,String password, String role) {
        User user1=userRepository.findByPhoneNo(phoneNo);
        if(user1==null){
        User user=new User(userName,phoneNo,password,role);
        userRepository.saveUser(user);
        System.out.println("User Added Successfully");
        }
        else
        {
            System.out.println("This phone no already exist");
        }
    }

    @Override
    public String signIn(String phoneNo, String password) {
        User user=userRepository.findByPhoneNo(phoneNo);
        if(user!=null )
        {
            if(user.getPassword().equals(password)) {
                if(user.getRole().equals("ADMIN")) {
                    return "Successfully Login as Admin";
                }
                else {
                    return "Successfully Login";
                }
            }
            else{
                return  "Invalid password";
            }
        }
        else{
            return "Invalid Phone Number ";
        }
    }

    @Override
    public User findByPhoneNO(String phoneNo) {
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
