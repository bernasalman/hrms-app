package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schools")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "resume" })
public class School { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "school_name")
	@NotBlank
	@NotNull
	private String schoolName;

	@Column(name = "school_episode")
	@NotBlank
	@NotNull
	private String schoolEpisode;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;


	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Cv cv;
	

}
