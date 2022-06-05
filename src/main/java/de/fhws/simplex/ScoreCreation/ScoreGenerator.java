package de.fhws.simplex.ScoreCreation;

import de.fhws.simplex.Repository.ScoreMatching;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class ScoreGenerator {
    final static int ONE_MINUTE = 60*1000;
    final static int FIVE_MINUTES = 5*60*1000;
    final static int TEN_MINUTES = 10*60*1000;

    public static void main(String[] args){
        ScoreGenerator s = new ScoreGenerator();
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(startTime);
        s.generateScore(startTime);
    }

    public static void generateScore(ScoreMatching scoreMatching){
        generateScore(scoreMatching.getTime());
    }

    public static void generateScore(LocalDateTime startTime){
        generateScore(startTime, LocalDateTime.now());
    }

    public static void generateScore(LocalDateTime startTime, LocalDateTime endTime) //System.currentTimeMillis()
    {
        Duration duration = Duration.between(startTime,endTime);


        int difference_In_Seconds
                = duration.toSecondsPart();

        long difference_In_Minutes
                = duration.toMinutesPart();
        if(duration.toMillis()<FIVE_MINUTES)
            duration = duration.minus(duration).plus(5, ChronoUnit.MINUTES);

        System.out.println("Your Score: "+ (15000-duration.toMillis()/60));
        System.out.println("It took "+ difference_In_Minutes+" minutes "+"and "+ difference_In_Seconds+ " seconds");

    }
}
