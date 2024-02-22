package com.myskdias.api.test;

import org.bukkit.Color;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {

    public static void main(String[] args) {
        ClassTest ct = new ClassTest();
        System.out.println(Color.BLUE.toString());
        try {
            Field f = ClassTest.class.getDeclaredField("bo");
            f.setAccessible(true);
            f.setBoolean(ct, false);
            System.out.println(ct.isBo());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    static void modifyPrivate(Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.PRIVATE);

        field.set(null, newValue);
    }



}
