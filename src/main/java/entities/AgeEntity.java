package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "age", schema = "canadacensusdb", catalog = "")
public class AgeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ageID")
    private int ageId;
    @Basic
    @Column(name = "ageGroup")
    private int ageGroup;
    @Basic
    @Column(name = "censusYear")
    private int censusYear;
    @Basic
    @Column(name = "geographicArea")
    private int geographicArea;
    @Basic
    @Column(name = "combined")
    private int combined;
    @Basic
    @Column(name = "male")
    private int male;
    @Basic
    @Column(name = "female")
    private int female;
    @ManyToOne
    @JoinColumn(name = "ageGroup", referencedColumnName = "ageGroupID", nullable = false, insertable = false, updatable = false)
    private AgegroupEntity agegroupByAgeGroup;
    @ManyToOne
    @JoinColumn(name = "censusYear", referencedColumnName = "censusYearID", nullable = false, insertable = false, updatable = false)
    private CensusyearEntity censusyearByCensusYear;
    @ManyToOne
    @JoinColumn(name = "geographicArea", referencedColumnName = "geographicAreaID", nullable = false, insertable = false, updatable = false)
    private GeographicareaEntity geographicareaByGeographicArea;

    public int getAgeId() {
        return ageId;
    }

    public void setAgeId(int ageId) {
        this.ageId = ageId;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    public int getCensusYear() {
        return censusYear;
    }

    public void setCensusYear(int censusYear) {
        this.censusYear = censusYear;
    }

    public int getGeographicArea() {
        return geographicArea;
    }

    public void setGeographicArea(int geographicArea) {
        this.geographicArea = geographicArea;
    }

    public int getCombined() {
        return combined;
    }

    public void setCombined(int combined) {
        this.combined = combined;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgeEntity ageEntity = (AgeEntity) o;
        return ageId == ageEntity.ageId && ageGroup == ageEntity.ageGroup && censusYear == ageEntity.censusYear && geographicArea == ageEntity.geographicArea && combined == ageEntity.combined && male == ageEntity.male && female == ageEntity.female;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ageId, ageGroup, censusYear, geographicArea, combined, male, female);
    }

    public AgegroupEntity getAgegroupByAgeGroup() {
        return agegroupByAgeGroup;
    }

    public void setAgegroupByAgeGroup(AgegroupEntity agegroupByAgeGroup) {
        this.agegroupByAgeGroup = agegroupByAgeGroup;
    }

    public CensusyearEntity getCensusyearByCensusYear() {
        return censusyearByCensusYear;
    }

    public void setCensusyearByCensusYear(CensusyearEntity censusyearByCensusYear) {
        this.censusyearByCensusYear = censusyearByCensusYear;
    }

    public GeographicareaEntity getGeographicareaByGeographicArea() {
        return geographicareaByGeographicArea;
    }

    public void setGeographicareaByGeographicArea(GeographicareaEntity geographicareaByGeographicArea) {
        this.geographicareaByGeographicArea = geographicareaByGeographicArea;
    }
}
