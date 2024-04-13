package HW3;

/*
2. * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
 */

import java.io.*;
import static HW3.NewStudentService.*;
public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student("Alexandr", 32, 99.9);
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Average mark: " + student.getGPA());

        try (FileOutputStream fileOutputStream = new FileOutputStream("studentData.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(student);
            System.out.println("Сериализация прошла успешно.");
        }

        try (FileInputStream fileInputStream = new FileInputStream("studentData.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            student = (Student) objectInputStream.readObject();
            System.out.println("Объект успешно десериализован.");
        }

        NewStudent newStudent = new NewStudent("Marina", 26, 9.4);
        saveStudentInfo("Marinka.json", "Marinka.xml", "Marinka.bin", newStudent);
        loadFromFile("Marinka.xml");
    }
}
