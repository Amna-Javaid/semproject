package com.example.semproject;

public class Person {
    String name;
    String cnic;
    int code;
    String password;
    String email;
    boolean isVaccinated;
    boolean Vaccinated2;
    int age;
    String mobileNumber;
    String sex;

    public Person(String name, String cnic, String email, String password, int age, String mobileNumber, String sex, boolean isVaccinated, boolean isVaccinated2) {
        this.name = name;
        this.cnic = cnic;
        this.email = email;
        this.password = password;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.sex = sex;
        this.isVaccinated = isVaccinated;
        this.Vaccinated2= isVaccinated2;
        int code;
    }
    public static Person signUp(String name, String cnic, String email, String password, int age, String mobileNumber, String sex) {
        return new Person(name, cnic, email, password , age, mobileNumber, sex,false,false);
    }

    public String getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public int getAge() {
        return age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getSex() {
        return sex;
    }

    public boolean isVaccinated2() {
        return Vaccinated2;
    }
}
