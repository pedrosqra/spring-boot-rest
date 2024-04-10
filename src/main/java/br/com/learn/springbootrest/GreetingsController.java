package br.com.learn.springbootrest;

import br.com.learn.springbootrest.services.MathService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingsController {

    private final MathService mathService;

    private final AtomicLong counter = new AtomicLong();

    public GreetingsController(MathService mathService) {
        this.mathService = mathService;
    }

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double sum(@PathVariable(name = "numberOne") String numberOne,
                      @PathVariable(name = "numberTwo") String numberTwo) {
        return mathService.sum(numberOne, numberTwo);
    }

    @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double subtract(@PathVariable(name = "numberOne") String numberOne,
                           @PathVariable(name = "numberTwo") String numberTwo) {
        return mathService.subtract(numberOne, numberTwo);
    }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double multiply(@PathVariable(name = "numberOne") String numberOne,
                           @PathVariable(name = "numberTwo") String numberTwo) {
        return mathService.multiply(numberOne, numberTwo);
    }

    @RequestMapping(value = "/divide/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double divide(@PathVariable(name = "numberOne") String numberOne,
                         @PathVariable(name = "numberTwo") String numberTwo) {
        return mathService.divide(numberOne, numberTwo);
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double mean(@PathVariable(name = "numberOne") String numberOne,
                       @PathVariable(name = "numberTwo") String numberTwo) {
        return mathService.mean(numberOne, numberTwo);
    }

    @RequestMapping(value = "/sqrt/{numberOne}",
            method = RequestMethod.GET)
    public Double sqrt(@PathVariable(name = "numberOne") String numberOne) {
        return mathService.sqrt(numberOne);
    }
}
