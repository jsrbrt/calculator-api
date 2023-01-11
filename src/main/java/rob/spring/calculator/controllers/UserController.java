package rob.spring.calculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rob.spring.calculator.entities.Operation;
import rob.spring.calculator.repository.OperationRepository;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private OperationRepository operationRepository;

    @GetMapping("/operations")
    public List<Operation> returnOperations(){
        System.out.println(operationRepository.getOperations());
        return operationRepository.getOperations();
    }

    @GetMapping("/sum/{values}")
    public String returnSum(@PathVariable double[] values) {
        return operationRepository.formatOperation(values, " + ")
                + operationRepository.executeOperation(operationRepository.getCalculation(" + "), values);
    }

    @GetMapping("/subtraction/{values}")
    public String returnSubtraction(@PathVariable double[] values) {
        return operationRepository.formatOperation(values, " - ")
                + operationRepository.executeOperation(operationRepository.getCalculation(" - "), values);
    }

    @GetMapping("/multiplication/{values}")
    public String returnMultiplication(@PathVariable double[] values) {
        return operationRepository.formatOperation(values, " * ")
                + operationRepository.executeOperation(operationRepository.getCalculation(" * "), values);
    }

    @GetMapping("/division/{values}")
    public String returnDivision(@PathVariable double[] values) {
        return operationRepository.formatOperation(values, " / ")
                + operationRepository.executeOperation(operationRepository.getCalculation(" / "), values);
    }
}
