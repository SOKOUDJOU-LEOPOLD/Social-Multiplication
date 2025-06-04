package microservices.com.multiplication.domain;
/*
 * This class represents a multiplication problem.
 */
public class Multiplication {
    private final int factorA;
    private final int factorB;
    // The result is A*B
    public Multiplication(int factorA, int factorB){
        this.factorA = factorA;
        this.factorB = factorB;
    }
    public int getFactorA() {
        return factorA;
    }
    public int getFactorB() {
        return factorB;
    }
    public int getResult() {
        return factorA * factorB;
    }

    @Override
    public String toString() {
        return "Multiplication{" +
                "factorA=" + factorA +
                ", factorB=" + factorB +
                ", result(A*B)=" + getResult() + 
                "}";
    }
    
}
