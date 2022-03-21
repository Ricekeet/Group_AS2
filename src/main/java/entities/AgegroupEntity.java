package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "agegroup", schema = "canadacensusdb", catalog = "")
public class AgegroupEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ageGroupID")
    private int ageGroupId;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "agegroupByAgeGroup")
    private Collection<AgeEntity> agesByAgeGroupId;

    public int getAgeGroupId() {
        return ageGroupId;
    }

    public void setAgeGroupId(int ageGroupId) {
        this.ageGroupId = ageGroupId;
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
        AgegroupEntity that = (AgegroupEntity) o;
        return ageGroupId == that.ageGroupId && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ageGroupId, description);
    }

    public Collection<AgeEntity> getAgesByAgeGroupId() {
        return agesByAgeGroupId;
    }

    public void setAgesByAgeGroupId(Collection<AgeEntity> agesByAgeGroupId) {
        this.agesByAgeGroupId = agesByAgeGroupId;
    }
}
