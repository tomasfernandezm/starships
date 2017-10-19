package edu.austral.model;

public interface Observable {

    void addObserver(EntityObserver eo);
    void deleteObserver(EntityObserver eo);
    void deleteObservers();
}
