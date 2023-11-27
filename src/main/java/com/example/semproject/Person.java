package com.example.semproject;

public class Person {
    String name;
    String cnic;
    String email;
    String password;

    int age;
    String mobileNumber;
    String sex;
    boolean isVaccinated1;
    boolean isVaccinated2;
    int code;

    public Person(String name, String cnic, String email, String password, int age, String mobileNumber, String sex, boolean isVaccinated1, boolean isVaccinated2) {
        this.name = name;
        this.cnic = cnic;
        this.email = email;
        this.password = password;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.sex = sex;
        this.isVaccinated1 = isVaccinated1;
        this.isVaccinated2 = isVaccinated2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isVaccinated1() {
        return isVaccinated1;
    }

    public void setVaccinated1(boolean vaccinated1) {
        isVaccinated1 = vaccinated1;
    }

    public boolean isVaccinated2() {
        return isVaccinated2;
    }

    public void setVaccinated2(boolean vaccinated2) {
        isVaccinated2 = vaccinated2;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public static Person signUp(String name, String cnic, String email, String password, int age, String mobileNumber, String sex) {
        return new Person(name, cnic, email, password , age, mobileNumber, sex,false,false);
    }
}
