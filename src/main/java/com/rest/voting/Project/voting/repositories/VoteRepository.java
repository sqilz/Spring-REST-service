package com.rest.voting.Project.voting.repositories;

import com.rest.voting.Project.voting.model.Project;
import com.rest.voting.Project.voting.model.Vote;
import com.rest.voting.Project.voting.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    @Query("select v from Vote v where v.project = :project and v.voter = :voter")
    Optional<Vote> voteExists(@Param("project") Project project, @Param("voter") Voter voter);
}
