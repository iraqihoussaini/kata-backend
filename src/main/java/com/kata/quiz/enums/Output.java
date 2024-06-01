package com.kata.quiz.enums;

public enum Output {
    FOO(3),
    BAR(5),
    QUIX(7);

    public final Integer number;

    private Output(Integer number) {
        this.number = number;
    }

    public static String valueOfNumber(Integer value) {
        for (Output e : values()) {
            if (e.number.equals(value)) {
                return e.toString();
            }
        }
        return "";
    }

}