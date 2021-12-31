package util;

import entity.Program;
import entity.Student;
import entity.StudentProgramDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    public FactoryConfiguration() {
        Configuration configuration = new Configuration();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        configuration.addAnnotatedClass(Program.class).addAnnotatedClass(Student.class).addAnnotatedClass(StudentProgramDetail.class);
        sessionFactory=configuration.buildSessionFactory(serviceRegistry);
    }

    public static FactoryConfiguration getInstance(){
        return factoryConfiguration=factoryConfiguration==null?new FactoryConfiguration():factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
