package de.fhws.simplex.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {

    public boolean existsByName(String name);

    public List<Score> findByName(String name);

    @Query("select max(s.rating) from Score s")
    public Integer findMaxRating();

}
