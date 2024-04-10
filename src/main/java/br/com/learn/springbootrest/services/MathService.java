package br.com.learn.springbootrest.services;


import br.com.learn.springbootrest.exceptions.IllegalMathOperation;
import org.springframework.stereotype.Service;

@Service
public class MathService {
    public MathService() {
    }

    public Double sum(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new IllegalMathOperation("Please use only numeric values");
        }


        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public Double subtract(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new IllegalMathOperation("Please use only numeric values");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    public Double multiply(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new IllegalMathOperation("Please use only numeric values");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    public Double divide(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new IllegalMathOperation("Please use only numeric values");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    public Double mean(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new IllegalMathOperation("Please use only numeric values");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    public Double sqrt(String numberOne) {
        if (!isNumeric(numberOne)) {
            throw new IllegalMathOperation("Please use only numeric values");
        }
        return Math.sqrt(convertToDouble(numberOne));
    }

    private Double convertToDouble(String stringValue) {
        if (stringValue == null || stringValue.isEmpty()) {
            throw new RuntimeException("Null or empty stringValue");
        }
        String standardValue = stringValue.replaceAll(",", ".");
        if (isNumeric(standardValue)) return Double.valueOf(standardValue);
        return 0D;
    }

    private boolean isNumeric(String stringValue) {
        if (stringValue == null || stringValue.isEmpty()) {
            throw new RuntimeException("Null or empty number");
        }
        String standardValue = stringValue.replaceAll(",", ".");
        return standardValue.matches("-?\\d+(\\.\\d+)?");
    }
}
