package com.example.hrms.entities.concretes;

import com.example.hrms.core.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
@Table(name = "employers")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Employer extends User {

    @NotNull(message = "Şirket ismi boş bırakılamaz")
    @Column(name = "company_name")
    private String companyName;

    @NotNull(message = "Telefon numarası boş bırakılamaz")
    @Column(name = "telephone_number")
    private String telephoneNumber;

    @NotNull(message = "Web Site alanı boş bırakılamaz")
    @Column(name = "web_site")
    private String website;

    @NotNull(message = "Şifre tekrar alanı boş bırakılamaz")
    private String passwordRepeat;

    @Column(name = "is_confirm")
    @JsonIgnore
    private boolean isConfirm;

    @OneToMany(mappedBy = "employer")
    private List<Jobİlan> jobİlans;

    @Column(name="history")
    @Type(type="jsonb")
    private Map<String, Object> history;

}