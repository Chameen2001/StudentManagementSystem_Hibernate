package dao.custom.impl;

import dao.custom.StudentProgramDetailDAO;
import entity.Program;
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
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
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

        String hql = "SELECT program FROM StudentProgramDetail";
        Query query = session.createQuery(hql);
        ArrayList<Program> programs = (ArrayList<Program>) query.list();

        transaction.commit();
        session.close();
        return programs;
    }
}
