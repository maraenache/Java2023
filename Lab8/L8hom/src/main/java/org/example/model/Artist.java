package org.example.model;


public class Artist extends AbstractEntity {

    private String name;

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
