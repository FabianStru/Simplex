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
    public String createScoreMatching(ScoreMatching scoreMatching) {
        try {
            if(scoreMatchingRepository.findByIp(scoreMatching.getIp()).size()==0){
                scoreMatchingRepository.save(scoreMatching);
                return "ScoreMatching record created successfully.";
            }
            else {
                updateScoreMatching(scoreMatching);
                return "ScoreMatching already existed. Instead updated old entry.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<ScoreMatching> readScoreMatchings() {
        return scoreMatchingRepository.findAll();
    }

    @Transactional
    public String updateScoreMatching(ScoreMatching scoreMatching) {
        if (scoreMatchingRepository.existsByIp(scoreMatching.getIp())) {
            try {
                List<ScoreMatching> scoreMatchings = scoreMatchingRepository.findByIp(scoreMatching.getIp());
                scoreMatchings.stream().forEach(s -> {
                    ScoreMatching scoreMatchingToBeUpdated = scoreMatchingRepository.findById(s.getId()).get();
                    scoreMatchingToBeUpdated.setIp(scoreMatching.getIp());
                    scoreMatchingToBeUpdated.setTime(scoreMatching.getTime());
                    scoreMatchingRepository.save(scoreMatchingToBeUpdated);
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
    public String deleteScoreMatching(ScoreMatching scoreMatching) {
        if (scoreMatchingRepository.existsByIp(scoreMatching.getIp())) {
            try {
                List<ScoreMatching> scoreMatchings = scoreMatchingRepository.findByIp(scoreMatching.getIp());
                scoreMatchings.stream().forEach(s -> {
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
