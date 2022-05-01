package de.fhws.simplex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@RestController
public class SimplexController {


    @GetMapping("/home")
    public Matrix home(@RequestParam("matrix") String input, @RequestParam("zeilen") int zeilen, @RequestParam("spalten") int spalten) {
        Matrix matrix = new Matrix(parseInput(zeilen, spalten, input));
        matrix.printMatrix();
        System.out.println(matrix);
        System.out.println("Hi");
        return matrix;
    }

    /**
     * Parse String arguments such as ((-300,-500,-36000),(1,2,170),(1,1,150),(0,3,180)) into an actual array
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
                array[row][column] = BigDecimal.valueOf(Double.parseDouble(temp[row * spalten+column]));
            }
        }

        for(BigDecimal[] list: array){
            for(BigDecimal b : list){
                System.out.println(b);
            }
        }

        return array;
    }
}