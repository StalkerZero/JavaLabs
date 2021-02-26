package ru.StalkerNidus.Teacher;

import java.util.Arrays;

public class Teacher {
    String name;
    String subject;
    int exp;
    Group[] groups;

    public Teacher(){}

    public Teacher(String name, String subject, int exp, Group[] g) {
        this.name = name;
        this.subject = subject;
        this.exp = exp;
        this.groups = g;
    }

    public  boolean hasGroup(String g){
        for (int i=0; i<groups.length; i++){
            if(groups[i]==null) return false;
            else if(groups[i].getTitle().equals(g)) return true;
        }
        return false;
    }

    public  boolean removeGroup(String g){
        for (int i=0; i<groups.length; i++){
            if(groups[i]!=null) {
                if(groups[i].getTitle().equals(g)) {
                    groups[i].setTitle("null");
                    return true;
                }
            }
        }
        return false;
    }

    public  boolean addGroup(String g){
        for (int i=0; i<groups.length; i++){
            if(groups[i]==null) {
                groups[i].setTitle(g);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", exp=" + exp +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
