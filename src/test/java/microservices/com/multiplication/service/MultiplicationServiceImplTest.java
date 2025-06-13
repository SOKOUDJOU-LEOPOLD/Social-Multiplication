package microservices.com.multiplication.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import microservices.com.multiplication.domain.Multiplication;

// Using Mockito for Unit Testing
// This allows us to create a mock of the RandomGeneratorService
// and inject it into the MultiplicationServiceImpl
// so we can test the createRandomMultiplication method without relying on the actual RandomGeneratorService implementation.


public class MultiplicationServiceImplTest {
    @Mock
    private RandomGeneratorService randomGeneratorService;

    private MultiplicationServiceImpl multiplicationServiceImpl; 

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this); // initialize all mocks
        multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
        
    }
    

    @Test
    public void createRandomMultiplication() {
        // Given
        given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

        // create the multiplication
        Multiplication multiplication  = multiplicationServiceImpl.createRandomMultiplication();
        
        // Then
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
        assertThat(multiplication.getResult()).isEqualTo(1500);
    }
    
}
