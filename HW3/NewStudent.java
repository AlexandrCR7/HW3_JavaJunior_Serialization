package HW3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class NewStudent implements Externalizable {

    private String name;
    private Integer age;
    @JsonIgnore
    transient Double gpa;

    public NewStudent() {
    }

    public NewStudent(String name, Integer age, Double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getGpa() {
        return gpa;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = (Integer) in.readObject();
    }
}