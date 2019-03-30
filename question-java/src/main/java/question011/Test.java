package question011;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/3/30 10:26
 **/
public class Test implements Cloneable, Serializable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void createByNew() {
        Test test = new Test();
        System.out.println(test);
    }

    public static void createByClassNewInstance() throws Exception {
        Test test = (Test) Class.forName("question011.Test").newInstance();
        System.out.println(test);
    }

    public static void createByConstructorNewInstance() throws Exception {
        Constructor<Test> constructor = Test.class.getConstructor();
        Test test = constructor.newInstance();
        System.out.println(test);
    }

    public static void createByClone() throws Exception {
        Test test1 = new Test();
        Test test2 = (Test) test1.clone();
        System.out.println(test2);
    }

    public static void createBySerialize() throws Exception {
        Test test1 = new Test();
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("/file1.txt"));
        outputStream.writeObject(test1); // 序列化，写入文件
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("/file.txt"));
        Test test2 = (Test) stream.readObject(); // 读文件，反序列化
        System.out.println(test2);
    }

    public static void main(String[] args) throws Exception {
        createByNew();
        createByClassNewInstance();
        createByConstructorNewInstance();
        createByClone();
        createBySerialize();
    }


}
