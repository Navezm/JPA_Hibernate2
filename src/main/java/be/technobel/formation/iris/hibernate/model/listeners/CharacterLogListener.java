package be.technobel.formation.iris.hibernate.model.listeners;

import be.technobel.formation.iris.hibernate.model.entity.Character;

import javax.persistence.*;

public class CharacterLogListener {

    @PrePersist
    public void beforePersistAction(Character entity) {
        System.out.println("Tentative d'ajout du " + entity.getClass().getSimpleName() + " : " + entity.getName());
    }

    @PostPersist
    public void afterPersistAction(Character entity) {
        System.out.println("Ajout réussi");
    }

    @PreUpdate
    public void beforeUpdateAction(Character entity) {
        System.out.println("Tentative d'update du " + entity.getClass().getSimpleName() + " : " + entity.getName());
    }

    @PostUpdate
    public void afterUpdateAction(Character entity) {
        System.out.println("Update réussi");
    }

    @PreRemove
    public void beforeRemoveAction(Character entity) {
        System.out.println("Tentative de suppression du " + entity.getClass().getSimpleName() + " : " + entity.getName());
    }

    @PostRemove
    public void afterRemoveAction(Character entity) {
        System.out.println("Suppresion réussie");
    }

}
