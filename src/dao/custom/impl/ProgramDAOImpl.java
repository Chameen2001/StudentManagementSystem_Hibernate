package dao.custom.impl;

import dao.custom.ProgramDAO;
import entity.Program;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProgramDAOImpl implements ProgramDAO {
    @Override
    public boolean add(Program program) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(program);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Program object) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Program get(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Program WHERE name=:name";
        Query query = session.createQuery(hql);

        query.setParameter("name", s);
        Program program = (Program) query.uniqueResult();

        transaction.commit();
        session.close();
        return program;
    }

    @Override
    public ArrayList<Program> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> get_all_program_names() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT name FROM Program";
        Query query = session.createQuery(hql);
        ArrayList<String> names = (ArrayList<String>) query.list();

        transaction.commit();
        session.close();
        return names;
    }
}
