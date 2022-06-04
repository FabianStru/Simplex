package de.fhws.simplex.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreMatchingRepository extends JpaRepository<ScoreMatching, Integer> {

    public boolean existsByIp(String ip);

    public List<ScoreMatching> findByIp(String ip);
}
