package com.example.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cvs")
public class Cv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "cover_letter")
	@NotBlank
	@NotNull
	private String coverLetter;

	@Column(name = "url")
	private String url;

	@Column(name = "linkedin")
	@NotBlank
	@NotNull
	private String linkedin;

	@Column(name = "github")
	@NotBlank
	@NotNull
	private String github;

	@OneToOne()
	@JoinColumn(name = "jobSeeker_id")
	private JobSeeker jobSeeker;

	@OneToMany(mappedBy = "cv")
	private List<School> schools;

	/*
	@OneToMany(mappedBy = "resume")
	private List<JobExperience> jobExperiences;

	@OneToMany(mappedBy = "resume")
	private List<Language> languages;

	@OneToMany(mappedBy = "resume")
	private List<Technologie> technologies;
*/
}
