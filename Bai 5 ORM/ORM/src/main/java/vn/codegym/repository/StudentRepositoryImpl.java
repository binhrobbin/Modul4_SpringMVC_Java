package vn.codegym.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Student;

import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements IStudentRepository {

    @Override
    public List<Student> findAll() {
        Session session = null;
        List<Student> studentList = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            studentList = session.createQuery("FROM Student").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(student);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
