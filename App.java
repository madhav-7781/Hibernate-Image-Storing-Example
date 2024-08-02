package com.Madhav.DemoHibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args) throws IOException
    {
        System.out.println("Project Started.....");
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        //Object for class Student
        Student st = new Student();
        st.setId(101);
        st.setName("Madhav");
        st.setCity("Kanpur");
        
        System.out.println(st);
        
        //Object for class Address
        Address add = new Address();
        add.setStreet("Street 2");
        add.setCity("Phagwara");
        add.setOpen(true);
        add.setAddedDate(new Date());
        add.setX(8765.4321);
        
        //Reading Image
        FileInputStream fis = new FileInputStream("src/main/java/download.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        add.setImage(data);
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(st);
        session.save(add);
        
//        session.getTransaction().commit();
        tx.commit();
        
        session.close();
        System.out.println("Done.....");
    }
}
