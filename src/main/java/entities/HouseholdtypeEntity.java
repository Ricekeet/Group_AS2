package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "householdtype", schema = "canadacensusdb", catalog = "")
public class HouseholdtypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private short id;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "householdtypeByHouseholdType")
    private Collection<HouseholdEntity> householdsById;
    @OneToMany(mappedBy = "householdtypeByHouseholdType_0")
    private Collection<HouseholdEntity> householdsById_0;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseholdtypeEntity that = (HouseholdtypeEntity) o;
        return id == that.id && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    public Collection<HouseholdEntity> getHouseholdsById() {
        return householdsById;
    }

    public void setHouseholdsById(Collection<HouseholdEntity> householdsById) {
        this.householdsById = householdsById;
    }

    public Collection<HouseholdEntity> getHouseholdsById_0() {
        return householdsById_0;
    }

    public void setHouseholdsById_0(Collection<HouseholdEntity> householdsById_0) {
        this.householdsById_0 = householdsById_0;
    }
}
