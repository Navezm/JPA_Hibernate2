package be.technobel.formation.iris.hibernate.model.entity;

import be.technobel.formation.iris.hibernate.model.Categories;
import be.technobel.formation.iris.hibernate.model.listeners.MangaLogListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "manga")
@EntityListeners(MangaLogListener.class)
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Categories category;

    @Basic()
    private String author;

    @Transient  // Permet à ce que cette donnée ne soit pas insérée dans la table
    private int bookAge;

    @Column(name = "release_date", columnDefinition = "DATE")
//    @Temporal(TemporalType.DATE)
    private LocalDate releaseDate;

    public Manga() {
    }

    public Manga(String title, Categories category, String author, LocalDate releaseDate){
        this.title = title;
        this.category = category;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getBookAge() {
        return LocalDate.now().getYear() - releaseDate.getYear();
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Manga{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", releaseDate=").append(releaseDate);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Objects.equals(id, manga.id) && Objects.equals(title, manga.title) && Objects.equals(author, manga.author) && Objects.equals(releaseDate, manga.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, releaseDate);
    }
}
