package microservices.com.multiplication.service;


import microservices.com.multiplication.domain.Multiplication;

/*
 * Creates a Multiplication object with two randomly-generated factors
 * between 11 and 99
 * @return a Multiplication object with random factors
 */
public interface MultiplicationService {
    Multiplication createRandomMultiplication();
    
}
