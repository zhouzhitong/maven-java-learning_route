package com.zzt.serialization;

import java.io.*;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/30 14:05
 */
public class SerializeToFileTest {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        Student o = new Student("1001", "张三");
        FileOutputStream os = new FileOutputStream("D:\\student.data");
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(o);
        oos.flush();
        oos.close();

        FileInputStream is = new FileInputStream("D:\\student.data");
        ObjectInputStream ois = new ObjectInputStream(is);
        Student deserialized = (Student) ois.readObject();
        System.out.println("学号：" + deserialized.getId());
        System.out.println("姓名：" + deserialized.getName());
        try {
            Student deserialized2 = (Student) ois.readObject();
        }catch (Exception e){
            System.out.println("不存在了。。");
        }
        ois.close();
    }
}
class Student implements Serializable {



    private static final long serialVersionUID = -6601903208557464574L;

    private String id;
    private String name;

    public Student() {
        super();
    }

    public Student(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}