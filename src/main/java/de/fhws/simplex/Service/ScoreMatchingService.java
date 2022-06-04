package de.fhws.simplex.Service;

import de.fhws.simplex.Repository.ScoreMatching;
import de.fhws.simplex.Repository.ScoreMatchingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ScoreMatchingService {

    @Autowired
    private ScoreMatchingRepository scoreMatchingRepository;

    @Transactional
    public String createScoreMatching(ScoreMatching score) {
        try {
            scoreMatchingRepository.save(score);
            return "ScoreMatching record created successfully.";
        } catch (Exception e) {
            throw e;
        }
    }

    public List<ScoreMatching> readScoreMatchings() {
        return scoreMatchingRepository.findAll();
    }

    @Transactional
    public String updateScoreMatching(ScoreMatching score) {
        if (scoreMatchingRepository.existsByIp(score.getIp())) {
            try {
                List<ScoreMatching> scores = scoreMatchingRepository.findByIp(score.getIp());
                scores.stream().forEach(s -> {
                    ScoreMatching scoreToBeUpdate = scoreMatchingRepository.findById(s.getId()).get();
                    scoreToBeUpdate.setIp(score.getIp());
                    scoreToBeUpdate.setTime(score.getTime());
                    scoreMatchingRepository.save(scoreToBeUpdate);
                });
                return "ScoreMatching record updated.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Ip does not exists in the database.";
        }
    }

    @Transactional
    public String deleteScoreMatching(ScoreMatching score) {
        if (scoreMatchingRepository.existsByIp(score.getIp())) {
            try {
                List<ScoreMatching> scores = scoreMatchingRepository.findByIp(score.getIp());
                scores.stream().forEach(s -> {
                    scoreMatchingRepository.delete(s);
                });
                return "ScoreMatching record deleted successfully.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "ScoreMatching does not exist";
        }
    }
}
