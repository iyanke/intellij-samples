 package com.jetbrains.code;

import java.util.ArrayList;
import java.util.Objects;

public class CodeGeneration {

    private int age;
    private ArrayList<String> names;
    private enum emotionalState {
        HAPPY, ECSTATIC, SAD, ANGRY
    }

    public CodeGeneration(int age, ArrayList<String> names) {
        this.age = age;
        this.names = names;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeGeneration that = (CodeGeneration) o;
        return age == that.age && Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, names);
    }

}
