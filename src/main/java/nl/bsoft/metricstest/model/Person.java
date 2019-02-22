package nl.bsoft.metricstest.model;


import java.io.Serializable;


public class Person implements Serializable {

    private static final long serialVersionUID = 3214253910554454648L;

    private Integer id;
    private String firstName;
    private String lastName;
    private String geslacht;
    private int age;

    public Person() {

    }

    public Person(String firstName, String lastName, String geslacht, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.geslacht = geslacht;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", geslacht=" + geslacht + "]";
    }

}
