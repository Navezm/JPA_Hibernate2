package be.technobel.formation.iris.hibernate.model.entity;

import be.technobel.formation.iris.hibernate.model.enums.Categories;
import be.technobel.formation.iris.hibernate.model.embedded.Edition;
import be.technobel.formation.iris.hibernate.model.listeners.MangaLogListener;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Entity(name = "manga")
@EntityListeners(MangaLogListener.class)
@NamedQuery(name = "Manga.findByCategory", query = "SELECT m FROM manga m WHERE m.category LIKE :category")
public class Manga {

    @Id
    @GeneratedValue(generator = "sequence-generator2")
    @GenericGenerator(
            name = "sequence-generator2",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "manga_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Categories category;

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
    @OneToMany(mappedBy = "manga", fetch = FetchType.LAZY)
    private Set<Character> characterSet = new HashSet<>();

    @ManyToMany(mappedBy = "mangas")
    private List<Author> authors = new ArrayList<>();

    public Manga() {
    }

    public Manga(String title, Categories category, LocalDate releaseDate){
        this.title = title;
        this.category = category;
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Author author) {
        this.authors.add(author);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Manga{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", category=").append(category);
        sb.append(", edition=").append(edition);
        sb.append(", bookAge=").append(getBookAge());
        sb.append(", releaseDate=").append(releaseDate);
        sb.append("\nCharacters=").append(characterSet == null ? null : characterSet.stream().map(Character::toStringWithoutAssociation).collect(Collectors.joining()));
        sb.append("\nAuthors=").append(authors == null ? null : authors.stream().map(Author::toStringWithoutAssociation).collect(Collectors.joining()));
        sb.append('}');
        return sb.toString();
    }

    public String toStringWithoutAssociation() {
        final StringBuilder sb = new StringBuilder("Manga{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", category=").append(category);
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
        return bookAge == manga.bookAge && Objects.equals(id, manga.id) && Objects.equals(title, manga.title) && category == manga.category && Objects.equals(edition, manga.edition) && Objects.equals(releaseDate, manga.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, category, edition, bookAge, releaseDate);
    }
}
