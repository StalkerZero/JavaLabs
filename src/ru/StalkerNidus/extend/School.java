package ru.StalkerNidus.extend;

import java.util.Arrays;

public class School extends Building {
    private int index;
    private String title;
    private Teacher[] teachers;
    private Student[] students;

    public School(String address, int floorCount, int index, String title, Teacher[] teachers, Student[] students) {
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
                ", teachers=" + Arrays.toString(teachers) +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    public  int nextYearAll(){
        int n=0;
        for (int i=0; i<students.length; i++){
            students[i].nextYear();
            if (students[i].getLevel()>5){
                students[i]=null;
                n++;
            }
        }
        for (int i=0; i<teachers.length; i++){
            teachers[i].nextYear();
            if (teachers[i].getAge()>65){
                teachers[i]=null;
                n++;
            }
        }
        return n;
    }

    public boolean addEntity(Human human){
        if (human instanceof Teacher){
            for (int i=0; i<teachers.length; i++){
                if (teachers[i]==null){
                    teachers[i]= (Teacher) human;
                    return true;
                }
            }
            return false;
        }
        else if (human instanceof Student){
            for (int i=0; i<students.length; i++){
                if (students[i]==null){
                    students[i]= (Student) human;
                    return true;
                }
            }
            return false;
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

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

}
