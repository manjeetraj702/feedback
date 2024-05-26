package coaching.model;

public class User {
    private String userName;
    private String phoneNo;
    private String role;
    private String password;

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userName, String phoneNo, String password, String role) {
        this.userName = userName;
        this.phoneNo = phoneNo;
        this.password=password;
        this.role = role.toUpperCase();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role.toUpperCase();
    }
}
