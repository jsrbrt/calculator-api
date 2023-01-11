package rob.spring.calculator.repository;

import org.springframework.stereotype.Repository;
import rob.spring.calculator.entities.Operation;
import rob.spring.calculator.interfaces.Calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OperationRepository {
    List<Operation> operations = new ArrayList<>();
    public List<Operation> getOperations() {
        return operations;
    }
    public Calculation getCalculation(String operator){
        //Calculation calculation =
        return (values) ->
        {
            double result = 0;
            if (values.length > 0){
                result = values[0];
                for (int i = 1; i < values.length; i++) {
                    switch (operator) {
                        case " + " -> result += values[i];
                        case " - " -> result -= values[i];
                        case " * " -> result *= values[i];
                        case " / " -> result /= values[i];
                    }
                }
                String fullOperation = formatOperation(values, operator)+ result;
                operations.add(new Operation(fullOperation));
            }
            return result;
        };
    }
    public double executeOperation(Calculation calculation, double... values){
        return calculation.toCalculate(values);
    }
    public String formatOperation(double[] values, String operator){
        return Arrays.stream(values).boxed().map(Object::toString).collect(Collectors.joining(operator)) + " = ";
    }
}
