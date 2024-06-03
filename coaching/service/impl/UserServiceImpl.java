package coaching.service.impl;
import coaching.model.User;
import coaching.repository.impl.UserRepositoryImpl;
import coaching.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepositoryImpl userRepository=new UserRepositoryImpl();
    @Override
    public String signUp(String userName, String phoneNo,String password, String role) {
        User user1=userRepository.findByPhoneNo(phoneNo);
        userName=userName.trim();
        if(userName.isEmpty())
        {
            return "Username contains only space";
        }
        phoneNo=phoneNo.trim();
        if(phoneNo.isEmpty())
        {
            return "PhoneNO contains only space";
        }
        password=password.trim();
        if(password.isEmpty())
        {
            return "Password contains only space";
        }
        role=role.trim();
        if(role.isEmpty())
        {
            return "Role contains only space";
        }

        if(user1==null){
        User user=new User(userName,phoneNo,password,role);
        userRepository.saveUser(user);
        return "User Added Successfully";
        }
        else
        {
            return  "This phone no already exist";
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
