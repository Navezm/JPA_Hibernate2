package be.technobel.formation.iris.hibernate.model.entity;

import be.technobel.formation.iris.hibernate.model.Categories;
import be.technobel.formation.iris.hibernate.model.Edition;
import be.technobel.formation.iris.hibernate.model.listeners.MangaLogListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "manga")
@EntityListeners(MangaLogListener.class)
@NamedQuery(name = "Manga.findByCategory", query = "SELECT m FROM manga m WHERE m.category LIKE :category")
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Categories category;

    @Basic()
    private String author;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "edition_name")),
            @AttributeOverride(name = "locationPlace", column = @Column(name = "edition_location"))
    })
    private Edition edition;

    @Transient  // Permet à ce que cette donnée ne soit pas insérée dans la table
    private int bookAge;

    @Column(name = "release_date", columnDefinition = "DATE")
//    @Temporal(TemporalType.DATE)
    private LocalDate releaseDate;

    // ASSOCIATION
    @OneToMany(mappedBy = "manga")
    private Set<Character> characterSet = new HashSet<>();

    public Manga() {
    }

    public Manga(String title, Categories category, String author, LocalDate releaseDate){
        this.title = title;
        this.category = category;
        this.author = author;
        if (releaseDate == null) {
            this.releaseDate = LocalDate.now();
        } else {
            this.releaseDate = releaseDate;
        }
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

    public Set<Character> getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(Character character) {
        this.characterSet.add(character);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Manga{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", category=").append(category);
        sb.append(", author='").append(author).append('\'');
        sb.append(", edition=").append(edition);
        sb.append(", bookAge=").append(getBookAge());
        sb.append(", releaseDate=").append(releaseDate);
        sb.append("\nCharacters=").append(characterSet.stream().map(Character::toStringWithoutAssociation).collect(Collectors.joining()));
        sb.append('}');
        return sb.toString();
    }

    public String toStringWithoutAssociation() {
        final StringBuilder sb = new StringBuilder("Manga{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", category=").append(category);
        sb.append(", author='").append(author).append('\'');
        sb.append(", edition=").append(edition);
        sb.append(", bookAge=").append(getBookAge());
        sb.append(", releaseDate=").append(releaseDate);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return bookAge == manga.bookAge && Objects.equals(id, manga.id) && Objects.equals(title, manga.title) && category == manga.category && Objects.equals(author, manga.author) && Objects.equals(edition, manga.edition) && Objects.equals(releaseDate, manga.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, category, author, edition, bookAge, releaseDate);
    }
}
