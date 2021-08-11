package be.technobel.formation.iris.hibernate.model.entity;

import be.technobel.formation.iris.hibernate.model.listeners.AbstractLogListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@EntityListeners(AbstractLogListener.class)
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int height;

    private int size;

    @Column(name = "birth_date", columnDefinition = "DATE")
    private LocalDate birthDate;

    public Information() {
    }

    public Information(int height, int size, LocalDate birthDate) {
        this.height = height;
        this.size = size;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Information{");
        sb.append("id=").append(id);
        sb.append(", height=").append(height);
        sb.append(", size=").append(size);
        sb.append(", birthDate=").append(birthDate);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Information that = (Information) o;
        return height == that.height && size == that.size && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, size, birthDate);
    }
}
