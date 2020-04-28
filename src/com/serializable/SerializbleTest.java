package com.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author XZQ
 * @date 2020/4/28 23:35
 */
public class SerializbleTest {

    public static void main(String[] args) {
        try {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\text.out"));
//            Student student = new Student();
//            student.setAge(25);
//            student.setName("XZQ");
//            objectOutputStream.writeObject(student);
//            System.out.println( student.toString());
//            objectOutputStream.flush();
//            objectOutputStream.close();


            Student.gender="女";
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:\\\\text.out"));
            Student student= (Student) inputStream.readObject();
            if (student!=null){
                System.out.println(student.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
