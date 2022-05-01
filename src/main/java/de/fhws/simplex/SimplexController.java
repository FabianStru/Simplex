package de.fhws.simplex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SimplexController {


    @RequestMapping("/home")
    public String home(Matrix matrix)
    {
        matrix.printMatrix();
        return "App.js";
    }
}