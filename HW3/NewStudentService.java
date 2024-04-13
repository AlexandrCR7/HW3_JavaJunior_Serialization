package HW3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewStudentService {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void saveStudentInfo(String fileName, String fileName1, String fileName2, NewStudent student)
            throws IOException {
        List<NewStudent> students = Arrays.asList(student);
        List<String> listFiles = Arrays.asList(fileName, fileName1, fileName2);
        for (String str : listFiles) {
            try {
                if (str.contains(".json")) {
                    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                    objectMapper.writeValue(new File(str), students);
                } else if (str.contains(".bin")) {
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(str))) {
                        oos.writeObject(students);
                    }
                } else if (str.contains(".xml")) {
                    xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                    xmlMapper.writeValue(new File(str), students);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void loadFromFile(String fileName) {
        List<NewStudent> studList = new ArrayList<>();
        File file1 = new File(fileName);
        try {
            if (file1.exists()) {
                if (fileName.endsWith(".json")) {
                    studList = objectMapper.readValue(file1, objectMapper.getTypeFactory().constructCollectionType(List.class, NewStudent.class));
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file1))) {
                        studList = (List<NewStudent>) ois.readObject();
                    }
                }
                else if (fileName.endsWith(".xml")) {
                    studList = xmlMapper.readValue(file1, xmlMapper.getTypeFactory().constructCollectionType(List.class, NewStudent.class));
                }
            }
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(studList);
    }
}
