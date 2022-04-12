package firstAPI.example.firstAPI;

import java.util.Date;

public class Student {
    Integer id;
    String name;
    Date DOB;
    Integer age;

    public Student(Integer id, String name, Date DOB, Integer age) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.age = age;
    }

    public Student(String name, Date DOB, Integer age) {
        this.name = name;
        this.DOB = DOB;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
