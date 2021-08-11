package be.technobel.formation.iris.hibernate.model.listeners;

import be.technobel.formation.iris.hibernate.model.entity.Manga;

import javax.persistence.*;

public class MangaLogListener {

    @PrePersist
    public void beforePersistAction(Manga entity) {
        System.out.println("----- Tentative d'ajout du " + entity.getClass().getSimpleName() + " : " + entity.getTitle() + " -----");
    }

    @PostPersist
    public void afterPersistAction(Manga entity) {
        System.out.println("----- " +entity.getClass().getSimpleName() + " ajouté -----");
    }

    @PreUpdate
    public void beforeUpdateAction(Manga entity) {
        System.out.println("----- Tentative de modification du " + entity.getClass().getSimpleName() + " : " + entity.getTitle() + " -----");
    }

    @PostUpdate
    public void afterUpdateAction(Manga entity) {
        System.out.println("----- " +entity.getClass().getSimpleName() + " modifié -----");
    }

    @PreRemove
    public void beforeRemoveAction(Manga entity) {
        System.out.println("----- Tentative de suppression du " + entity.getClass().getSimpleName() + " : " + entity.getTitle() + " -----");
    }

    @PostRemove
    public void afterRemoveAction(Manga entity) {
        System.out.println("----- " + entity.getClass().getSimpleName() + " supprimé -----");
    }

}
