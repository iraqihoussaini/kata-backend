package com.kata.quiz.service;

import java.time.temporal.ValueRange;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kata.quiz.enums.Output;

@Service
public class DataServiceImp implements DataService {

    @Override
    public String convertInputToOutput(Integer input)  {
        if (isValueInRange(input)) {
            String result = transformInputWhenDivisible(input) + transformInputWhenEquals(input);
            return result.length() > 0 ? result : input.toString();

        }
       return input.toString();
    }

    private boolean isValueInRange(Integer input) {
        return ValueRange.of(0, 100).isValidIntValue(input);
    }

    private String transformInputWhenDivisible(Integer input) {
        List<Integer> numbers = Arrays.asList(3, 5);
        return numbers.stream()
                .map(number -> getOutputWhenInputDevidedByParam(input, number))
                .collect(Collectors.joining());
    }

    private String transformInputWhenEquals(Integer input) {
        List<String> listParams = Arrays.asList("3", "5", "7");
        return Arrays.asList(input.toString().split("")).stream()
                .map(character -> getOutputWhenParamsContainsCharacter(character, listParams))
                .collect(Collectors.joining());
    }

    private String getOutputWhenInputDevidedByParam(Integer input, Integer param) {
        return input % param == 0 ? Output.valueOfNumber(param) : "";
    }

    private String getOutputWhenParamsContainsCharacter(String input, List<String> params) {
        return params.contains(input) ? Output.valueOfNumber(Integer.valueOf(input)) : "";
    }

}
