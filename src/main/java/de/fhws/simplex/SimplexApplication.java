package de.fhws.simplex;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.type.StringType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Types;

/**
 * This class runs the Spring Boot application of the backend of the simplex project.
 */
@SpringBootApplication
public class SimplexApplication {
    /**
     * Main method that starts the server and runs the SimplexApplication.
     *
     * @param args optional arguments given to the server
     */
    public static void main(String[] args) {
        SpringApplication.run(SimplexApplication.class, args);
    }

}
