package com.HibernateQueryCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
        Student student=null;
        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  

        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
          
        SessionFactory sf=meta.getSessionFactoryBuilder().build();  
        
        Session session1=sf.openSession();
        session1.beginTransaction();
        
        Query  query11=session1.createQuery("from Student where sid=0");
        query11.setCacheable(true);
        student = (Student) query11.uniqueResult();
        System.out.println(student);
        //first level cache 
        
        
       Query query12=session1.createQuery("from Student where sid=0");
       query12.setCacheable(true);
        student = (Student) query12.uniqueResult();
        System.out.println(student);
        session1.getTransaction().commit();
        session1.close();
        
        
        Session session2=sf.openSession();
        session2.beginTransaction();
        //second level cache
        Query query2=session2.createQuery("from Student where sid=0");
        query2.setCacheable(true);
        student = (Student) query2.uniqueResult();
        System.out.println(student);
        session2.getTransaction().commit();
        session2.close();
    }
}
