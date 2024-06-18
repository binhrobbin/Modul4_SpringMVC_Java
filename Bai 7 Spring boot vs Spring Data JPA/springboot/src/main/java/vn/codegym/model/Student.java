package vn.codegym.model;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //0
    private String name; //null
    private int gender; //0
    // vì ở đây demo nên đặt khóa khoại ở student do ko có html của create class,
    // chứ đúng nghiệp vụ phải chuyển khóa từ tùy chọn (student) sang bắt buộc(account)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "account_id" , referencedColumnName = "id")
    private Account account2;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private ClassRoom classRoom2;

    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courseSet;

    public Student() {
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    public ClassRoom getClassRoom2() {
        return classRoom2;
    }

    public void setClassRoom2(ClassRoom classRoom2) {
        this.classRoom2 = classRoom2;
    }

    public Account getAccount2() {
        return account2;
    }

    public void setAccount2(Account account2) {
        this.account2 = account2;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

}
