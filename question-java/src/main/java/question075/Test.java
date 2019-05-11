package question075;

import java.io.*;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/5/11 15:24
 **/
public class Test {

    public static void main(String[] args) {
        String file = "test.txt";
        User user = new User("poldi", "123456");
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(user);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            User userRead = (User) inputStream.readObject();
            System.out.println(userRead.getUserName());
            System.out.println(userRead.getPassword()); // null
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

class User implements Serializable {
    private String userName;
    private transient String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

}
