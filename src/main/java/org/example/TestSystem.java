package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TestSystem {
//    static EntityManagerFactory emf = Persistence
//            .createEntityManagerFactory("MyHibernate");
//
//    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
//        em.getTransaction().begin();
//
//        Person person = new Person();
//        person.setFirstName("Tanya");
//        person.setLastName("Ramkova");
//
//        Contact contact = new Contact();
//        contact.setTelephoneNumber("3542243123");
//        person.setContact(contact);
//
//        Person person2 = new Person();
//        person2.setFirstName("Katya");
//        person2.setLastName("Ramkova");
//
//        Contact contact2 = new Contact();
//        contact2.setTelephoneNumber("355675");
//        person2.setContact(contact2);
//
//        em.persist(person);
//        em.persist(person2);
//        em.flush();
//        em.getTransaction().commit();

//        Query query = em.createQuery("SELECT p FROM Person p");
//        List<Person> personList = (List<Person>) query.getResultList();
//        for (Person p : personList) {
//            System.out.println(p);
//        }

//        System.out.println(query.getResultList());

        IOperations operations = new OperationsImpl();
        operations.addPerson("Tanya", "Ramkova");
        operations.addPerson("Katya", "Ramkova");
        operations.getPersons();

//        em.close();
//        emf.close();
    }
}