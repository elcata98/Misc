package org.elcata98.misc.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class GsonTester {

    private static final GsonBuilder GSON_BUILDER = new GsonBuilder().setPrettyPrinting();
    private static final String JSON_STRING = "{\"name\":\"Coppola\", \"age\":40}";


    public static void main(String[] args) {

        first();
        second();
        third();
        fourth();
    }

    private static void first() {

        Gson gson = GSON_BUILDER.create();

        Student student = gson.fromJson(JSON_STRING, Student.class);
        System.out.println(student);

        String jsonString = gson.toJson(student);
        System.out.println(jsonString);
    }

    private static void second() {

        GsonTester tester = new GsonTester();

        try {
            Student student = new Student();
            student.setAge(40);
            student.setName("Coppola");

            tester.writeJSON(student);

            Student student1 = tester.readJSON();
            System.out.println(student1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void third() {

        Gson gson = GSON_BUILDER.create();
        String name = "Lord Coppola";
        long rollNo = 1;
        boolean verified = false;
        int[] marks = {100, 90, 85};

        //Serialization
        System.out.println("{");
        System.out.println("name: " + gson.toJson(name) + ",");
        System.out.println("rollNo: " + gson.toJson(rollNo) + ",");
        System.out.println("verified: " + gson.toJson(verified) + ",");
        System.out.println("marks:" + gson.toJson(marks));
        System.out.println("}");

        //De-serialization
        name = gson.fromJson("\"Lord Coppola\"", String.class);
        rollNo = gson.fromJson("1", Long.class);
        verified = gson.fromJson("false", Boolean.class);
        marks = gson.fromJson("[100,90,85]", int[].class);

        System.out.println("name: " + name);
        System.out.println("rollNo: " + rollNo);
        System.out.println("verified: " + verified);
        System.out.println("marks:" + Arrays.toString(marks));
    }

    private static void fourth() {

        Gson gson = GSON_BUILDER.create();

        Student student = new Student();
        student.setAge(40);
        student.setName("Coppola");

        String jsonString = gson.toJson(student);
        System.out.println(jsonString);

        Student student1 = gson.fromJson(jsonString, Student.class);
        System.out.println(student1);
    }

    private void writeJSON(Student student) throws IOException {

        Gson gson = GSON_BUILDER.create();

        FileWriter writer = new FileWriter("student.json");
        writer.write(gson.toJson(student));
        writer.close();
    }

    private Student readJSON() throws FileNotFoundException {

        Gson gson = GSON_BUILDER.create();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("student.json"));

        return gson.fromJson(bufferedReader, Student.class);
    }
}

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}