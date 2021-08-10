package be.technobel.formation.iris.hibernate.model.entity;

import be.technobel.formation.iris.hibernate.model.Role;
import be.technobel.formation.iris.hibernate.model.Weapon;
import be.technobel.formation.iris.hibernate.model.listeners.CharacterLogListener;

import javax.persistence.*;
import java.util.Objects;

/**
 * Personnage d'un manga
 * ID
 * Nom
 * Role (Enum Role -> Principal, Secondaire, Figurant)
 * Arme (classe embeddable)
 *  - nom
 *  - matière
 *  - magique (boolean)
 *
 */

@Entity(name = "character")
@EntityListeners(CharacterLogListener.class)
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "weapon_name")),
            @AttributeOverride(name = "material", column = @Column(name = "weapon_material")),
            @AttributeOverride(name = "magical", column = @Column(name = "weapon_magical"))
    })
    private Weapon weapon;

    public Character() {
    }

    public Character(String name, Role role, Weapon weapon) {
        this.name = name;
        this.role = role;
        this.weapon = weapon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Character{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", role=").append(role);
        sb.append(", weapon=").append(weapon);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id) && Objects.equals(name, character.name) && role == character.role && Objects.equals(weapon, character.weapon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role, weapon);
    }
}
