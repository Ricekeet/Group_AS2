package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "household", schema = "canadacensusdb", catalog = "")
public class HouseholdEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "geographicArea")
    private int geographicArea;
    @Basic
    @Column(name = "householdType")
    private short householdType;
    @Basic
    @Column(name = "householdSize")
    private short householdSize;
    @Basic
    @Column(name = "householdsByAgeRange")
    private short householdsByAgeRange;
    @Basic
    @Column(name = "householdEarners")
    private short householdEarners;
    @Basic
    @Column(name = "totalIncome")
    private short totalIncome;
    @Basic
    @Column(name = "censusYear")
    private int censusYear;
    @Basic
    @Column(name = "numberReported")
    private int numberReported;
    @ManyToOne
    @JoinColumn(name = "geographicArea", referencedColumnName = "geographicAreaID", nullable = false, insertable = false, updatable = false)
    private GeographicareaEntity geographicareaByGeographicArea;
    @ManyToOne
    @JoinColumn(name = "householdType", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private HouseholdtypeEntity householdtypeByHouseholdType;
    @ManyToOne
    @JoinColumn(name = "householdType", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private HouseholdtypeEntity householdtypeByHouseholdType_0;
    @ManyToOne
    @JoinColumn(name = "householdSize", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private HouseholdsizeEntity householdsizeByHouseholdSize;
    @ManyToOne
    @JoinColumn(name = "householdsByAgeRange", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private HouseholdsbyagerangeEntity householdsbyagerangeByHouseholdsByAgeRange;
    @ManyToOne
    @JoinColumn(name = "householdEarners", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private HouseholdearnersEntity householdearnersByHouseholdEarners;
    @ManyToOne
    @JoinColumn(name = "totalIncome", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private TotalincomeEntity totalincomeByTotalIncome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeographicArea() {
        return geographicArea;
    }

    public void setGeographicArea(int geographicArea) {
        this.geographicArea = geographicArea;
    }

    public short getHouseholdType() {
        return householdType;
    }

    public void setHouseholdType(short householdType) {
        this.householdType = householdType;
    }

    public short getHouseholdSize() {
        return householdSize;
    }

    public void setHouseholdSize(short householdSize) {
        this.householdSize = householdSize;
    }

    public short getHouseholdsByAgeRange() {
        return householdsByAgeRange;
    }

    public void setHouseholdsByAgeRange(short householdsByAgeRange) {
        this.householdsByAgeRange = householdsByAgeRange;
    }

    public short getHouseholdEarners() {
        return householdEarners;
    }

    public void setHouseholdEarners(short householdEarners) {
        this.householdEarners = householdEarners;
    }

    public short getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(short totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getCensusYear() {
        return censusYear;
    }

    public void setCensusYear(int censusYear) {
        this.censusYear = censusYear;
    }

    public int getNumberReported() {
        return numberReported;
    }

    public void setNumberReported(int numberReported) {
        this.numberReported = numberReported;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseholdEntity that = (HouseholdEntity) o;
        return id == that.id && geographicArea == that.geographicArea && householdType == that.householdType && householdSize == that.householdSize && householdsByAgeRange == that.householdsByAgeRange && householdEarners == that.householdEarners && totalIncome == that.totalIncome && censusYear == that.censusYear && numberReported == that.numberReported;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, geographicArea, householdType, householdSize, householdsByAgeRange, householdEarners, totalIncome, censusYear, numberReported);
    }

    public GeographicareaEntity getGeographicareaByGeographicArea() {
        return geographicareaByGeographicArea;
    }

    public void setGeographicareaByGeographicArea(GeographicareaEntity geographicareaByGeographicArea) {
        this.geographicareaByGeographicArea = geographicareaByGeographicArea;
    }

    public HouseholdtypeEntity getHouseholdtypeByHouseholdType() {
        return householdtypeByHouseholdType;
    }

    public void setHouseholdtypeByHouseholdType(HouseholdtypeEntity householdtypeByHouseholdType) {
        this.householdtypeByHouseholdType = householdtypeByHouseholdType;
    }

    public HouseholdtypeEntity getHouseholdtypeByHouseholdType_0() {
        return householdtypeByHouseholdType_0;
    }

    public void setHouseholdtypeByHouseholdType_0(HouseholdtypeEntity householdtypeByHouseholdType_0) {
        this.householdtypeByHouseholdType_0 = householdtypeByHouseholdType_0;
    }

    public HouseholdsizeEntity getHouseholdsizeByHouseholdSize() {
        return householdsizeByHouseholdSize;
    }

    public void setHouseholdsizeByHouseholdSize(HouseholdsizeEntity householdsizeByHouseholdSize) {
        this.householdsizeByHouseholdSize = householdsizeByHouseholdSize;
    }

    public HouseholdsbyagerangeEntity getHouseholdsbyagerangeByHouseholdsByAgeRange() {
        return householdsbyagerangeByHouseholdsByAgeRange;
    }

    public void setHouseholdsbyagerangeByHouseholdsByAgeRange(HouseholdsbyagerangeEntity householdsbyagerangeByHouseholdsByAgeRange) {
        this.householdsbyagerangeByHouseholdsByAgeRange = householdsbyagerangeByHouseholdsByAgeRange;
    }

    public HouseholdearnersEntity getHouseholdearnersByHouseholdEarners() {
        return householdearnersByHouseholdEarners;
    }

    public void setHouseholdearnersByHouseholdEarners(HouseholdearnersEntity householdearnersByHouseholdEarners) {
        this.householdearnersByHouseholdEarners = householdearnersByHouseholdEarners;
    }

    public TotalincomeEntity getTotalincomeByTotalIncome() {
        return totalincomeByTotalIncome;
    }

    public void setTotalincomeByTotalIncome(TotalincomeEntity totalincomeByTotalIncome) {
        this.totalincomeByTotalIncome = totalincomeByTotalIncome;
    }
}
