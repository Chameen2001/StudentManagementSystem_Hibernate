package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student student) throws Exception {
        Session session=null;
        try {
            session= FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            return true;
        }catch (Exception exception){
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(session.load(Student.class,s));

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student get(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, s);
        System.out.println("awaa");
        System.out.println(student.getNic());
        transaction.commit();
        session.close();
        return student;
    }

    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Student";
        Query query = session.createQuery(hql);
        ArrayList<Student> students = (ArrayList<Student>) query.list();

        transaction.commit();
        session.close();
        return students;
    }

    @Override
    public String generate_new_student_id() {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT s_id FROM Student ORDER BY s_id DESC";

        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        String id = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        try {
            int nextNumber = Integer.parseInt(id.replace("S-", "")) + 1;
            return String.format("S-%03d", nextNumber);
        } catch (NullPointerException exception) {
            return "S-001";
        }
    }
}
