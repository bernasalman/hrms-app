package com.example.hrms.entities.concretes;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_adverts")
public class Jobİlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "description")
	@NotBlank
	@NotNull
	private String description;

	@Column(name = "min_salary")
	private double minSalary;

	@Column(name = "max_salary")
	private double maxSalary;

	@Column(name = "open_position_count")
	@Min(1)
	private int openPositionCount;

	@Column(name = "create_date")
	private LocalDate createDate = LocalDate.now();

	@Column(name = "last_apply_date")
	private Date lastApplyDate;

	@Column(name = "is_active")
	private boolean isActive;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "pozisyon")
	private Pozisyon pozisyon;
	
	@ManyToOne()
	@JoinColumn(name = "working_id")
	private Working working;
}
