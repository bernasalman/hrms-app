package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Jobİlan;
import com.example.hrms.entities.dtos.JobİlanDtoWithQuery;
import com.example.hrms.entities.dtos.JobİlanFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobİlanDao extends JpaRepository<Jobİlan, Integer> {

	@Query("Select new com.example.hrms.entities.dtos.JobİlanDtoWithQuery" +
			"(j.id, j.openPositionCount, j.createDate, j.lastApplyDate, e.companyName," +
			"jt.title, c.name, e.level, wa.workTime,wt.workType) "
			+ "From Jobİlan j Inner Join j.employer e Inner Join j.pozisyon p " +
			"Inner Join j.city c Inner Join j.level el Inner Join j.working w " +
			"Inner Join j.workType wt   Where ja.isActive='true'")
	List<JobİlanDtoWithQuery> getByIsActive();

	@Query("Select new com.example.hrms.entities.dtos.JobİlanDtoWithQuery(ja.id,ja.openPositionCount,ja.createDate,ja.lastApplyDate,e.companyName,jt.title,c.name,el.educationLevel,wa.workTime,wt.workType) "
			+ "From Jobİlan j Inner Join j.employer e Inner Join j.pozisyon jt Inner Join ja.city c Inner Join ja.educationLevel el Inner Join ja.ofWorking wa Inner Join ja.workType wt   Where ja.isActive='true' and ja.employer.id=:employerId")
	List<JobİlanDtoWithQuery> getByIsActiveAndEmployerId(int employerId);

	@Query("Select new com.example.hrms.entities.dtos.JobİlanDtoWithQuery(ja.id,ja.openPositionCount,ja.createDate,ja.lastApplyDate,e.companyName,jt.title,c.name,el.educationLevel,wa.workTime,wt.workType) "
			+ "From Jobİlan j Inner Join j.employer e Inner Join j.jobTitle jt Inner Join ja.city c Inner Join ja.educationLevel el Inner Join ja.ofWorking wa Inner Join ja.workType wt  Where ja.isActive='true' Order By ja.createDate Desc")
	List<JobİlanDtoWithQuery> getByLastApplyDate();
	
	@Query("Select j  from Jobİlan j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
			+ "and ((:#{#filter.jobTitleId}) IS NULL OR j.pozisyon.pozisyonId IN (:#{#filter.jobTitleId}))"
			+" and ((:#{#filter.workTimeId}) IS NULL OR j.working.id IN (:#{#filter.workTimeId}))"
			+" and ((:#{#filter.workTypeId}) IS NULL OR j.workType.id IN (:#{#filter.workTypeId}))"
			+ "and j.isActive = true Order By j.createDate Desc ")
	public Page<Jobİlan> getByFilter(@Param("filter") JobİlanFilter jobİlanFilter, Pageable pageable);
	
	public Jobİlan getById(int id);

}
