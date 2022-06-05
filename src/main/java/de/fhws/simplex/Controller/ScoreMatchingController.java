//package de.fhws.simplex.Controller;
//
//import de.fhws.simplex.Repository.ScoreMatching;
//import de.fhws.simplex.Service.ScoreMatchingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class ScoreMatchingController {
//
//    @Autowired
//    private ScoreMatchingService scoreMatchingService;
//
//    @GetMapping("info")
//    public String info() {
//        return "The application is up...";
//    }
//
///*    @RequestMapping(value = "createscoreMatching", method = RequestMethod.POST)
//    public String createScoreMatching(@RequestBody Score scoreMatching){
//        return scoreMatchingService.createScoreMatching(scoreMatching);
//    }*/
//
//    @GetMapping("readscoreMatchings")
//    public List<ScoreMatching> readScoreMatchings() {
//        return scoreMatchingService.readScoreMatchings();
//    }
//
///*    @RequestMapping(value = "updatescoreMatching", method = RequestMethod.PUT)
//    public String updateStudet(@RequestBody ScoreMatching scoreMatching){
//        return scoreMatchingService.updateScoreMatching(scoreMatching);
//    }
//
//    @RequestMapping(value = "deletescoreMatching", method = RequestMethod.DELETE)
//    public String deleteScoreMatching(@RequestBody ScoreMatching scoreMatching){
//        return scoreMatchingService.deleteScoreMatching(scoreMatching);
//    }*/
//}