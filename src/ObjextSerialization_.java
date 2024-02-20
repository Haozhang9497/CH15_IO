import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.nio.file.Files;

public class ObjextSerialization_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student stu1 = new Student("Hao", "M", 20);
        Student stu2 = new Student("Qin", "F", 23);


        // to output the students objs to a file
        File outputFile = new File("C:\\Users\\zhang\\Desktop\\CST8288 Java\\ObjectSerializationTest");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile));

        oos.writeObject(stu1);
        oos.writeObject(stu2);

        oos.close();


        // to read back the students objs from the file
        File inputFile = new File("C:\\Users\\zhang\\Desktop\\CST8288 Java\\ObjectSerializationTest");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile));

        // use try-catch to detect the final of the file and end the loop
        try{
            while(true){
                Student record = (Student)ois.readObject();
                System.out.println(record);
            }
        }catch(EOFException e){

        }finally{
            ois.close();
        }



    }
}


// to be serialized, the object class must be serializable!!!
class Student implements Serializable{
    private String name;
    private String sex;
    private int age;

    public Student(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

}
