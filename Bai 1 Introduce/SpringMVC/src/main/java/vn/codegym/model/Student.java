package vn.codegym.model;

/**
 * (C) Copyright 2023 CodeGym Da Nang. All Rights Reserved.
 *
 * @author caube
 * @version 1.0
 * @see <a href="https://danang.codegym.vn/">CodeGym Da Nang</a>
 * @since
 */
public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
