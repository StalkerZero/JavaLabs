package ru.StalkerNidus.Database.Service;

import java.sql.Timestamp;

public class ClientServiceJoin {
    private int ID;
    private String Title;
    private double Cost;
    private String FirstName;
    private String LastName;
    private String Patronymic;
    private Timestamp StartTime;

    @Override
    public String toString() {
        return "ClientServiceJoin{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Cost=" + Cost +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Patronymic='" + Patronymic + '\'' +
                ", StartTime=" + StartTime +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public Timestamp getStartTime() {
        return StartTime;
    }

    public void setStartTime(Timestamp startTime) {
        StartTime = startTime;
    }

    public ClientServiceJoin(int ID, String title, double cost, String firstName, String lastName, String patronymic, Timestamp startTime) {
        this.ID = ID;
        Title = title;
        Cost = cost;
        FirstName = firstName;
        LastName = lastName;
        Patronymic = patronymic;
        StartTime = startTime;
    }
}
