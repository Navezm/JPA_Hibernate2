package be.technobel.formation.iris.hibernate.model.embedded;

import javax.persistence.Embeddable;

@Embeddable
public class Weapon {

    private String name;

    private String material;

    private boolean magical;

    public Weapon() {
    }

    public Weapon(String name, String material, boolean magical) {
        this.name = name;
        this.material = material;
        this.magical = magical;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isMagical() {
        return magical;
    }

    public void setMagical(boolean magical) {
        this.magical = magical;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Weapon{");
        sb.append("name='").append(name).append('\'');
        sb.append(", material='").append(material).append('\'');
        sb.append(", magical=").append(magical);
        sb.append('}');
        return sb.toString();
    }
}
