package de.fhws.simplex.Service;

import de.fhws.simplex.Repository.Score;
import de.fhws.simplex.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public String createScore(Score score) {
        try {
            scoreRepository.save(score);
            return "Score record created successfully.";
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Score> readScores() {
        return scoreRepository.findAll();
    }

    @Transactional
    public String updateScore(Score score) {
        if (scoreRepository.existsByName(score.getName())) {
            try {
                List<Score> scores = scoreRepository.findByName(score.getName());
                scores.stream().forEach(s -> {
                    Score scoreToBeUpdate = scoreRepository.findById(s.getId()).get();
                    scoreToBeUpdate.setName(score.getName());
                    scoreToBeUpdate.setRating(score.getRating());
                    scoreRepository.save(scoreToBeUpdate);
                });
                return "Score record updated.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Name does not exists in the database.";
        }
    }

    @Transactional
    public String deleteScore(Score score) {
        if (scoreRepository.existsByName(score.getName())) {
            try {
                List<Score> scores = scoreRepository.findByName(score.getName());
                scores.stream().forEach(s -> {
                    scoreRepository.delete(s);
                });
                return "Score record deleted successfully.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "Score does not exist";
        }
    }
}
