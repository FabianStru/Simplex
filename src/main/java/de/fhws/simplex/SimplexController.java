package de.fhws.simplex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SimplexController {


    @GetMapping("/home")
    public Matrix home(Matrix matrix) {
//        matrix.beRottisBeispiel();
        matrix.printMatrix();
        System.out.println(matrix);
        System.out.println("Hi");
        return matrix;
    }
}