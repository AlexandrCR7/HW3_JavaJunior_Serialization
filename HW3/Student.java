package HW3;

import java.io.Serializable;

/*
Разработайте класс HW3.Student с полями String name, int age, transient double GPA (средний балл).
Обеспечьте поддержку сериализации для этого класса.
Создайте объект класса HW3.Student и инициализируйте его данными.
Сериализуйте этот объект в файл.
Десериализуйте объект обратно в программу из файла.
Выведите все поля объекта, включая GPA, и ответьте на вопрос,
почему значение GPA не было сохранено/восстановлено.

2. * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
 */
public class Student implements Serializable {

    private String name;
    private Integer age;
    private transient Double GPA;

    public  Student (String name, Integer age, Double GPA){
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public String getName(){
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getGPA() {
        return GPA;
    }
}
