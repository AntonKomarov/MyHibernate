package org.example;

import javax.persistence.*;
import java.util.List;

public class OperationsImpl implements IOperations{
    private static EntityManagerFactory entityManagerFactory = Persistence.
            createEntityManagerFactory("MyHibernate");

    @Override
    public void addPerson(String firstName, String lastName){
        EntityManager manager = entityManagerFactory.createEntityManager();
        try{
            manager.getTransaction().begin();
            Person person = new Person();
            person.setFirstName(firstName);
            person.setLastName(lastName);
            manager.persist(person);
            manager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            manager.close();
        }
    }

    @Override
    public void getPersonById(int id){
        EntityManager manager = entityManagerFactory.createEntityManager();
        String query = "SELECT p FROM Person p WHERE p.id = :id";
        TypedQuery<Person> typedQuery = manager.createQuery(query, Person.class);
        typedQuery.setParameter("id", id);
        Person person;
        try{
            person = typedQuery.getSingleResult();
            System.out.println(person.getFirstName() + " " + person.getLastName());
        }catch (NoResultException ex){
            ex.printStackTrace();
        }
        finally {
            manager.close();
        }
    }


    @Override
    public void getPersons(){
        EntityManager manager = entityManagerFactory.createEntityManager();
        String query = "SELECT p FROM Person p WHERE p.id IS NOT NULL";
        TypedQuery<Person> typedQuery = manager.createQuery(query, Person.class);
        List<Person> persons;
        try{
            persons = typedQuery.getResultList();
            persons.forEach(person-> System.out.println(person.getFirstName() + " " + person.getLastName()));
        }catch (NoResultException ex){
            ex.printStackTrace();
        }
        finally {
            manager.close();
        }
    }

    @Override
    public void updatePersonName(int id, String firstName){
        EntityManager manager = entityManagerFactory.createEntityManager();
        Person person;
        try{
            manager.getTransaction().begin();
            person = manager.find(Person.class, id);
            person.setFirstName(firstName);
            manager.persist(person);
            manager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            manager.close();
        }
    }

    @Override
    public void deletePersonById(int id){
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction;
        Person person;
        try{
            manager.getTransaction().begin();
            person = manager.find(Person.class, id);
            manager.remove(person);
            manager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            manager.close();
        }
    }
}