package ru.Aidar.ParsingProffStandards.DB.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "generalized_work_functions", schema = "proff")
public class GeneralizedWorkFunction {
    @Id
    @Column(name = "id_gwf", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "сode_gwf", nullable = false)
    private String сodeGwf;

    @Column(name = "name_gwf", nullable = false)
    private String nameGwf;

    @Column(name = "level_of_qualification", nullable = false)
    private String levelOfQualification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proff_standards_id", nullable = false)
    private Standard standard;

    public GeneralizedWorkFunction() {
    }


    public GeneralizedWorkFunction(String сodeGwf, String nameGwf, String levelOfQualification, Standard standard) {

        this.сodeGwf = сodeGwf;
        this.nameGwf = nameGwf;
        this.levelOfQualification = levelOfQualification;
        this.standard = standard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getСodeGwf() {
        return сodeGwf;
    }

    public void setСodeGwf(String сodeGwf) {
        this.сodeGwf = сodeGwf;
    }

    public String getNameGwf() {
        return nameGwf;
    }

    public void setNameGwf(String nameGwf) {
        this.nameGwf = nameGwf;
    }

    public String getLevelOfQualification() {
        return levelOfQualification;
    }

    public void setLevelOfQualification(String levelOfQualification) {
        this.levelOfQualification = levelOfQualification;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeneralizedWorkFunction)) return false;
        GeneralizedWorkFunction that = (GeneralizedWorkFunction) o;
        return Objects.equals(id, that.id) && Objects.equals(сodeGwf, that.сodeGwf) && Objects.equals(nameGwf, that.nameGwf) && Objects.equals(levelOfQualification, that.levelOfQualification) && Objects.equals(standard, that.standard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, сodeGwf, nameGwf, levelOfQualification, standard);
    }

    @Override
    public String toString() {
        return "GeneralizedWorkFunctions{" +
                "id=" + id +
                ", сodeGwf='" + сodeGwf + '\'' +
                ", nameGwf='" + nameGwf + '\'' +
                ", levelOfQualification=" + levelOfQualification +
                ", standard=" + standard +
                '}';
    }
}
