package org.example.OnClass.Entity;


public class Position {
    public int id;
    public PositionName name;
    public enum PositionName {
        Dev, Test, Scrum_Master, PM
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
