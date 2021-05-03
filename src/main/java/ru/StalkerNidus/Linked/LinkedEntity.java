package ru.StalkerNidus.Linked;

public class LinkedEntity {
    private static int idCounter = 0;
    private final int id = ++idCounter;
    private LinkedEntity child;

    public LinkedEntity() {}

    public void add(LinkedEntity entity){
        if (child==null) child=entity;
        else child.add(entity);
    }

    public boolean delete(int id){
        if (child==null) return false;
        if (child.getId()==id) {
            child = child.getChild();
            return true;
        }
        else return child.delete(id);
    }

    public boolean contains(int id){
        if (child==null && this.id!=id) return false;
        else if (this.id==id) return true;
             else return child.contains(id);
    }

    @Override
    public String toString() {
        return "LinkedEntity{" +
                "id=" + id +
                ", child=" + child +
                '}';
    }

    public int size(){
        if (child==null) return 1;
        else return 1+child.size();
    }

    public int getId() {
        return id;
    }

    public LinkedEntity getChild() {
        return child;
    }

    public void setChild(LinkedEntity child) {
        this.child = child;
    }
}
