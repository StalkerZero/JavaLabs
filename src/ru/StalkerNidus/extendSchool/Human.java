package ru.StalkerNidus.extendSchool;

public class Human {
    protected String firstname;
    protected String surname;
    protected String patronymic;
    protected Gender gender;
    protected int age;

    public Human(String firstname, String surname, String patronymic, Gender gender, int age) {
        this.firstname = firstname;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.age = age;
    }

    public void nextYear(){
        age++;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
