package microservices.com.multiplication.service;

import microservices.com.multiplication.domain.Multiplication;

import org.springframework.beans.factory.annotation.Autowired;

public class MultiplicationServiceImpl implements MultiplicationService{
    
    @Autowired
    private RandomGeneratorService randomGeneratorService;



    @Override
    public Multiplication createRandomMultiplication(){
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();

        return new Multiplication(factorA, factorB);

    }
} 
