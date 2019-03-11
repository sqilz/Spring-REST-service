package com.rest.voting.Project.voting.repositories;

import com.rest.voting.Project.voting.model.Project;
import com.rest.voting.Project.voting.model.Vote;
import com.rest.voting.Project.voting.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    @Query("select v from Vote v where v.project = :project and v.voter = :voter")
    Optional<Vote> voteExists(@Param("project") Optional<Project> project, @Param("voter") Optional<Voter> voter);
}
