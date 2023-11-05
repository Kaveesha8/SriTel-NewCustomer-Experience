package com.sriTel.service_issue_management.repository;
import com.sriTel.service_issue_management.model.ServiceIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceIssueRepository extends JpaRepository<ServiceIssue, Long> {
}
