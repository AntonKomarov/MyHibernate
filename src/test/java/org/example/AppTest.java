package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppTest 
{
    private EntityManager manager;

    @Before
    public void init(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyHibernate");
        manager = factory.createEntityManager();
        manager.getTransaction().begin();
    }
    @Test
    public void shouldStartHibernate() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "MyHibernate" );
        EntityManager entityManager = emf.createEntityManager();
    }

    @Test
    public void shouldPersistPerson(){
        Person person = new Person();
        person.setFirstName("Tanya");
        person.setLastName("Ramkova");
        manager.persist(person);
    }

    @After
    public void close(){
        if(manager.getTransaction().isActive()){
            manager.getTransaction().commit();
        }
        manager.getEntityManagerFactory().close();
        manager.close();
    }
}
