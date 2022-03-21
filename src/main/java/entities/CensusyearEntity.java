package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "censusyear", schema = "canadacensusdb", catalog = "")
public class CensusyearEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "censusYearID")
    private int censusYearId;
    @Basic
    @Column(name = "censusYear")
    private int censusYear;
    @OneToMany(mappedBy = "censusyearByCensusYear")
    private Collection<AgeEntity> agesByCensusYearId;

    public int getCensusYearId() {
        return censusYearId;
    }

    public void setCensusYearId(int censusYearId) {
        this.censusYearId = censusYearId;
    }

    public int getCensusYear() {
        return censusYear;
    }

    public void setCensusYear(int censusYear) {
        this.censusYear = censusYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CensusyearEntity that = (CensusyearEntity) o;
        return censusYearId == that.censusYearId && censusYear == that.censusYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(censusYearId, censusYear);
    }

    public Collection<AgeEntity> getAgesByCensusYearId() {
        return agesByCensusYearId;
    }

    public void setAgesByCensusYearId(Collection<AgeEntity> agesByCensusYearId) {
        this.agesByCensusYearId = agesByCensusYearId;
    }
}
