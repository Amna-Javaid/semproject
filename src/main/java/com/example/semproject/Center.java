package com.example.semproject;

import javafx.stage.Stage;


    public class Center {
        String name;
        String pincode;
        String location;
        int serialNumber;

        public Center(String name, String pincode, String location, int serialNumber) {
            this.name = name;
            this.pincode = pincode;
            this.location = location;
            this.serialNumber = serialNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(int serialNumber) {
            this.serialNumber = serialNumber;
        }
    }

