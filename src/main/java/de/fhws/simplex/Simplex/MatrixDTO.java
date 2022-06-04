package de.fhws.simplex.Simplex;

public class MatrixDTO {
}
/*
use MatrixDTO in Controller
Convert MatrixDTO to Matrix (aka convert that String Matrix to either BigFraction or BigDecimal)
Just use business logic as per usual with Matrix
once done convert Matrix to MatrixDTO
send MatrixDTO to user

e.g. need String Constructor for BigFraction

Only use BigFraction in logic,
conversion to BigDecimal only in MatrixDTO,
no need for two different views (one Fraction/one Decimal),
just allow user to input both but only output Fraction
*/
