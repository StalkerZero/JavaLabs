package ru.StalkerNidus.extend;

public class Student extends Human{
    protected int level;

    public Student(String firstname, String surname, String patronymic, Gender gender, int age, int level) {
        super(firstname, surname, patronymic, gender, age);
        this.level = level;
    }

    @Override
    public void nextYear() {
        super.nextYear();
        level++;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", level=" + level +
                '}';
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
