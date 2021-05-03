package ru.StalkerNidus.ListSchool;

public class Teacher extends Human {
    protected String subject;
    protected int exp;

    public Teacher(String firstname, String surname, String patronymic, Gender gender, int age, String subject, int exp) {
        super(firstname, surname, patronymic, gender, age);
        this.subject = subject;
        this.exp = exp;
    }

    @Override
    public void nextYear() {
        super.nextYear();
        exp++;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                ", exp=" + exp +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
