package org.example;

public interface IOperations {
    public abstract void addPerson(String firstName, String lastName);
    public abstract void getPersonById(int id);
    public abstract void getPersons();
    public abstract void updatePersonName(int id, String firstName);
    public abstract void deletePersonById(int id);
}
