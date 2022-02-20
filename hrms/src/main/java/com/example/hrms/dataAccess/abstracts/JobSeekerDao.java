package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {
    DataResult<JobSeeker> getByEmail(String email);
    DataResult<JobSeeker> getByIdentityNumber(String tc);

    /*@Query("select new kodlamaio.hrms.entities.dtos.candidateCvDto(cd,cvl,s,sp,t,we) from Candidate cd inner join Education e on e.candidateId =cd.user_id join School s on s.id = e.schoolId inner join SchoolPart sp on sp.id = e.schoolPartId inner join CandidateTechnology ct on ct.candidateId = cd.user_id inner join Technology t on t.id = ct.technologyId inner join CoverLetter cvl on cvl.candidateId = cd.user_id inner join WorkExperience we on we.candidateId = cd.user_id")
    List<candidateCvDto> getDetails();
*/

    @Query("from JobSeeker c where c.jobSeekerId=:userId")
    JobSeeker getByUser_id(int userId);
}
