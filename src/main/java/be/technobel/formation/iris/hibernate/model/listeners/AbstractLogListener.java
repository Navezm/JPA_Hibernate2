package be.technobel.formation.iris.hibernate.model.listeners;

import be.technobel.formation.iris.hibernate.model.entity.Character;

import javax.persistence.*;

public class AbstractLogListener {

    @PrePersist
    public void beforePersistAction(Object entity) {
        System.out.println("----- Tentative d'ajout du " + entity.getClass().getSimpleName() + " -----");
    }

    @PostPersist
    public void afterPersistAction(Object entity) {
        System.out.println("----- Ajout réussi -----");
    }

    @PreUpdate
    public void beforeUpdateAction(Object entity) {
        System.out.println("----- Tentative d'update du " + entity.getClass().getSimpleName() + " -----");
    }

    @PostUpdate
    public void afterUpdateAction(Object entity) {
        System.out.println("----- Update réussi -----");
    }

    @PreRemove
    public void beforeRemoveAction(Object entity) {
        System.out.println("----- Tentative de suppression du " + entity.getClass().getSimpleName() + " -----");
    }

    @PostRemove
    public void afterRemoveAction(Object entity) {
        System.out.println("----- Suppresion réussie -----");
    }
}
