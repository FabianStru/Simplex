package de.fhws.simplex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("info")
    public String info() {
        return "The application is up...";
    }

/*    @RequestMapping(value = "createscore", method = RequestMethod.POST)
    public String createScore(@RequestBody Score score){
        return scoreService.createScore(score);
    }*/

    @GetMapping("readscores")
    public List<Score> readScores() {
        return scoreService.readScores();
    }

/*    @RequestMapping(value = "updatescore", method = RequestMethod.PUT)
    public String updateStudet(@RequestBody Score score){
        return scoreService.updateScore(score);
    }

    @RequestMapping(value = "deletescore", method = RequestMethod.DELETE)
    public String deleteScore(@RequestBody Score score){
        return scoreService.deleteScore(score);
    }*/
}