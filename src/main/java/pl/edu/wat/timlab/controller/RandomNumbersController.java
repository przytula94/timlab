package pl.edu.wat.timlab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.timlab.service.RandomNumbersService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/random")
public class RandomNumbersController {


    @Autowired
    RandomNumbersService randomNumbersService;


    @RequestMapping(value = "/{amount}", method = RequestMethod.GET)
    public Map<String,Object> getRandomNumbers(@PathVariable("amount") int amount){
        Map<String,Object> model = new HashMap<>();
        List<Integer> numbers = randomNumbersService.getRandomNumbers(amount);

        model.put("numbers",numbers);

        return model;
    }
}
