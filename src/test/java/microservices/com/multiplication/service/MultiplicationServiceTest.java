package microservices.com.multiplication.service;

import microservices.com.multiplication.domain.Multiplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


//Using the Spring Test Context for Unit Testing
// This allows us to use the @Autowired annotation to inject the MultiplicationService
// and the @MockBean annotation to create a mock of the RandomGeneratorService

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {
    @MockBean
    private RandomGeneratorService randomGeneratorService;

    @Autowired
    private MultiplicationService multiplicationService;

    @Test
    public void createRandomMultiplication(){
        //given (our mocked RendomGeneratorservice will return 50 then 30)
        given(randomGeneratorService.generateRandomFactor()).willReturn(50,30);

        // when 
        Multiplication  multiplication = multiplicationService.createRandomMultiplication();

        // then
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
        assertThat(multiplication.getResult()).isEqualTo(1500);

    }    

}
