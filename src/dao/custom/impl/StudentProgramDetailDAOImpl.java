package dao.custom.impl;

import dao.custom.StudentProgramDetailDAO;
import entity.Program;
import entity.Student;
import entity.StudentProgramDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentProgramDetailDAOImpl implements StudentProgramDetailDAO {
    @Override
    public boolean add(StudentProgramDetail studentProgramDetail) throws Exception {
        Session session=null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.save(studentProgramDetail);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            return false;
        }finally {
            session.close();
        }



    }

    @Override
    public boolean update(StudentProgramDetail object) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s_id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "DELETE FROM StudentProgramDetail WHERE student=:student";
        Query query = session.createQuery(hql);
        query.setParameter("student",session.load(Student.class,s_id));
        int i = query.executeUpdate();
        System.out.println(i);
        transaction.commit();
        session.close();

        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public StudentProgramDetail get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<StudentProgramDetail> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Program> get_programs(String s_id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT program FROM StudentProgramDetail WHERE student=:student";
        Query query = session.createQuery(hql);
        query.setParameter("student",session.get(Student.class,s_id));
        ArrayList<Program> programs = (ArrayList<Program>) query.list();

        transaction.commit();
        session.close();
        return programs;
    }

    @Override
    public boolean isExists(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT count(id) FROM StudentProgramDetail WHERE student=:student";
        Query query = session.createQuery(hql);
        query.setParameter("student",session.load(Student.class,id));
        long count = (long) query.uniqueResult();

        transaction.commit();
        session.close();
        if (count>0){
            return true;
        }else {
            return false;
        }
    }
}
