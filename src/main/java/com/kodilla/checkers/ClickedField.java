package com.kodilla.checkers;

public class ClickedField {

    private static Field field;

    public static Field getField() {
        return field;
    }

    public static void setField(Field field) {
        ClickedField.field = field;
    }
}
