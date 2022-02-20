package com.example.hrms.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
// Kalıtım yoluyla ortak alanları inherit eder , hem de kendi tablosunu oluşturur.
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "emailValidation" }) Bu anatasyonla da verilerin tekrarını önleyebilirsiniz. (Extra bilgi)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "email")
   /* @Email(message = "Geçerli bir email adresi değil")
    @NotBlank
    @NotNull */
    private String email;

    @Column(name = "password")
   /* @NotNull
    @NotBlank
    */
    private String password;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive = true;

    @JsonIgnore
    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @JsonIgnore
    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private Boolean isDeleted = false;

   /* @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    @JsonIgnore
    // İlişkili tablolar varsa getAll kısmında bir sorun çıkabilir.
    // Bu anatasyonla bu sorunu çözüyoruz. Bu da verilerin tekrarını önler.
    private EmailValidation emailValidation;
*/
}

