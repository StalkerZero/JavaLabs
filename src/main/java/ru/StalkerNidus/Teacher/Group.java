package ru.StalkerNidus.Teacher;

public class Group {
    private String title;
    private int studentCount;

    public Group(String title, int studentCount) {
        this.title = title;
        this.studentCount = studentCount;
    }

    @Override
    public String toString() {
        return "Group{" +
                "title='" + title + '\'' +
                ", studentCount=" + studentCount +
                '}';
    }

    public String getTitle() {
        return title;
    }
    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
