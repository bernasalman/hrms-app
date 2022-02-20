package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name="workings")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdverts" })
public class Working {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="working")
	@NotBlank
	@NotNull
	private String workTime;
	
	@OneToMany
	private List<Jobİlan> jobİlans;
}
