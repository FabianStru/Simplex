package de.fhws.simplex.Controller;

import de.fhws.simplex.Repository.ScoreMatching;
import de.fhws.simplex.Service.ScoreMatchingService;
import de.fhws.simplex.Simplex.Matrix;
import de.fhws.simplex.Simplex.RankedResponse;
import de.fhws.simplex.Simplex.RankedResponseMiscalculation;
import de.fhws.simplex.Simplex.SimplexRankedTablesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This class functions as the Controller for all the Simplex applications.
 *
 * @author Anton Kaiser, Fabian Struensee
 */
@RestController
public class SimplexController {

    @Autowired
    ScoreMatchingService scoreMatchingService;

//    /**
//     * This methods enables the subdomain "/home" and enables the server to accept a GET-request
//     *
//     * @param input   string version of the JSON with normal brackets instead of square brackets
//     * @param zeilen  amount of rows in the given matrix
//     * @param spalten amount of column in the given matrix
//     * @return the matrix object generated by the inputs
//     * @author Anton Kaiser
//     */
//    @GetMapping("/home")
//    public Matrix home(@RequestParam("matrix") String input, @RequestParam("zeilen") int zeilen, @RequestParam("spalten") int spalten) {
//        Matrix matrix = new Matrix(parseInput(zeilen, spalten, input));
//        matrix.printMatrix();
//        System.out.println(matrix);
//        System.out.println("Hi");
//        return matrix;
//    }

//    /**
//     * This methods enables the subdomain "/api/matrix" and enables the server to accept a GET-request with the matrix as a JSON file
//     *
//     * @param matrix the matrix object generated by the JSON input
//     * @return the matrix object generated by the JSON inputs
//     * @author Anton Kaiser
//     */
//    @GetMapping("/api/matrix")
//    public Matrix getMatrix(@RequestBody Matrix matrix) {
//        matrix.setTableHeaders();
//        return matrix;
//    }

    /**
     * This methods enables the subdomain "/api/postMatrix" and enables the server to accept a POST-request with the matrix as a JSON file
     *
     * @param matrix the matrix object generated by Spring Boot with the JSON input of the user
     * @return the matrix object generated by the JSON input
     * @author Anton Kaiser
     */
    @PostMapping("/api/postMatrix")
    public Matrix[] postMatrix(@RequestBody Matrix matrix) {
        matrix.setTableHeaders();
        return matrix.calculateSimplex();
    }

    /**
     * This methods enables the subdomain "/api/postRanked" and enables the server to accept a POST-request with the an array of matrices as a JSON file
     *
     * @param matrices the arrays of matrices generated by Spring Boot with the JSON input of the user
     * @return the correct arrays of matrices given by the example
     * @author Anton Kaiser
     */
    @PostMapping("/api/postRanked")
    public RankedResponse postRanked(@RequestBody Matrix[] matrices) {
        Matrix tmpCopyOfFirstMatrix = matrices[0].deepCopy();
        Matrix[] correctMatrices = tmpCopyOfFirstMatrix.calculateSimplex();
        List<RankedResponseMiscalculation> miscalculations = new ArrayList<>();

        for (int matrixIndex = 0; matrixIndex < matrices.length; matrixIndex++) {
            for (Integer[] coordinate: correctMatrices[matrixIndex].compareAndCheck(matrices[matrixIndex])
                 ) {
                miscalculations.add(new RankedResponseMiscalculation(matrixIndex,coordinate));
            }
        }
        return new RankedResponse(miscalculations.toArray(new RankedResponseMiscalculation[0]));
    }


//        [[1,[3,4]],[3,[1,5]]]

    /**
     * This methods enables the subdomain "/api/postRanked" and enables the server to accept a GET-request with a random matrix as a JSON file
     *
     * @return the matrix object generated by the JSON input
     * @author Anton Kaiser
     */
    @GetMapping("/api/getRanked")
    public Matrix getRankedMatrix(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        System.out.println(request.getRemoteAddr());
        ScoreMatching scoreMatching = new ScoreMatching(ip, LocalDateTime.now());
        System.out.println(scoreMatching);
//        System.out.println(scoreMatchingService.createScoreMatching(scoreMatching));
        return SimplexRankedTablesEnum.randomSimplexRankedTablesEnum().getMatrix();
    }

    /**
     * Parse String arguments such as ((-300,-500,-36000),(1,2,170),(1,1,150),(0,3,180)) into an actual array
     *
     * @param input   string version of the JSON with normal brackets instead of square brackets
     * @param zeilen  amount of rows in the given matrix
     * @param spalten amount of column in the given matrix
     * @return an array of numbers from the given input
     * @author Anton Kaiser, Fabian Struensee
     */

    public static BigDecimal[][] parseInput(int zeilen, int spalten, String input) {
        BigDecimal[][] array = new BigDecimal[zeilen][spalten];
        String[] temp = input.split(",");
        for (int i = 0; i < temp.length; i++) {
            temp[i] = temp[i].replace("(", "");
            temp[i] = temp[i].replace(")", "");
        }
        for (int column = 0; column < spalten; column++) {
            for (int row = 0; row < zeilen; row++) {
                array[row][column] = BigDecimal.valueOf(Double.parseDouble(temp[row * spalten + column]));
            }
        }

        for (BigDecimal[] list : array) {
            for (BigDecimal b : list) {
                System.out.println(b);
            }
        }

        return array;
    }
}