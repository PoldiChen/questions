package question076;

/**
 * @author poldi.chen
 * @className TrainInvoke
 * @description TODO
 * @date 2019/6/7 13:55
 **/
public class TrainInvoke {

    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1).setName("poldi").setAddress("shenzhen");
        System.out.println(student.getAddress());
    }
}

class Student {

    private int id;
    private String name;
    private String address;

    public int getId() {
        return id;
    }

    public Student setId(int id) {
        this.id = id;
        return this; // set方法返回对象本身
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Student setAddress(String address) {
        this.address = address;
        return this;
    }
}