package ru.StalkerNidus.ListSchool;

import java.util.List;

public class School extends Building {
    private int index;
    private String title;
    private List<Teacher> teachers;
    private List<Student> students;

    public School(String address, int floorCount, int index, String title, List<Teacher> teachers, List<Student> students) {
        super(address, floorCount);
        this.index = index;
        this.title = title;
        this.teachers = teachers;
        this.students = students;
    }

    @Override
    public String toString() {
        return "School{" +
                "address='" + address + '\'' +
                ", floorCount=" + floorCount +
                ", index=" + index +
                ", title='" + title + '\'' +
                ", teachers=" + teachers +
                ", students=" + students +
                '}';
    }

    public  int nextYearAll(){
        int n=0;
        for (int i=students.size()-1; i>=0; i--){
            Student stud = students.get(i);
            stud.nextYear();
            if (stud.getLevel()>5){
                students.remove(i);
                n++;
            }
        }
        for (int i=teachers.size()-1; i>=0; i--){
            Teacher teach = teachers.get(i);
            teach.nextYear();
            if (teach.getAge()>65){
                teachers.remove(i);
                n++;
            }
        }
        return n;
    }

    public boolean addEntity(Human human){
        if (human instanceof Teacher){
            teachers.add((Teacher) human);
            return true;
        }
        else if (human instanceof Student){
            students.add((Student) human);
            return true;
        }
        System.out.println("not a school entity" + human);
        return false;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
