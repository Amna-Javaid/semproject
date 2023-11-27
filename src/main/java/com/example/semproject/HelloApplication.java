package com.example.semproject;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.application.Platform;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;



public class HelloApplication extends Application {

    ArrayList<Person> person = new ArrayList<>();
    GridPane grid1 = new GridPane();
    Scene sc1 = new Scene(grid1, 500, 400, Color.LIGHTGRAY);
    GridPane adminDashboardGrid = new GridPane();
    Scene adminDashboardScene = new Scene(adminDashboardGrid, 500, 500);
    Management management=new Management();
    ArrayList<Center> centersList = management.centers;
    Center[] centersArray = centersList.toArray(new Center[0]);
    ArrayList<Center> centersList2 = management.centers2;
    ArrayList<Center> centersList3 = management.centers3;
    int verificationCode;



    @Override
    public void start(Stage stage) throws IOException {

        loadUserData();

        homeScreen(stage);
    }

    private void homeScreen(Stage stage) {
        stage.setResizable(false);
        stage.setTitle(" Covid Vaccine Center");


        HBox b1=new HBox();
        Image logoImage = new Image("img_2.png");
        ImageView logoImageView = new ImageView(logoImage);

        logoImageView.setFitWidth(100);
        logoImageView.setFitHeight(100);
        b1.getChildren().add(logoImageView);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(12);
        grid1.getColumnConstraints().addAll(column1);

        Text title2 = new Text("COVID\nVACCINATION\nCENTER");
        title2.setFont(Font.font("Times New Roman", 20));
        title2.setFill(Color.DARKBLUE);
        title2.setTextAlignment(TextAlignment.CENTER);
        b1.getChildren().add(title2);

        grid1.add(b1,1,0);

        grid1.setPadding(new Insets(10, 10, 10, 10));
        GridPane.setMargin(grid1, new Insets(50, 0, 0, 0)); // Add top margin

        grid1.setHgap(5);
        grid1.setVgap(5);

        Button userLogin = new Button("User Login");
        Button adminLogin = new Button("Admin login");
        Button signUp = new Button("User SignUp");

        userLogin.setPrefHeight(20);
        userLogin.setPrefWidth(150);
        userLogin.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                        +
                        "-fx-text-fill: white;"
        );
        adminLogin.setPrefHeight(20);
        adminLogin.setPrefWidth(150);

        adminLogin.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);" +
                        "-fx-text-fill: white;"
        );

        signUp.setPrefHeight(20);
        signUp.setPrefWidth(150);
        signUp.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                        +
                        "-fx-text-fill: white;"
        );

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER); // center the HBox
        hBox.setSpacing(10);
        GridPane.setMargin(hBox, new Insets(20, 0, 0, 0));
        hBox.getChildren().addAll(userLogin, adminLogin, signUp);
        grid1.add(hBox, 0, 2, 2, 1); // span 2 columns

        userLogin.setOnAction(p -> userlogin(stage));
        adminLogin.setOnAction(p -> adminlogin(stage));
        signUp.setOnAction(p -> signUp(stage));
        fadeIn(grid1);

        // Add fade-in animation to buttons
        fadeIn(userLogin);
        fadeIn(adminLogin);
        fadeIn(signUp);


        stage.setScene(sc1);
        stage.show();

    }
    private void fadeIn(Node node) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), node);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    private void userlogin(Stage stage) {
        GridPane userLoginGrid = new GridPane();
        Scene scene2 = new Scene(userLoginGrid, 500, 500);
        Text email = new Text("Email Id:");
        Text password = new Text("Password:");
        fadeIn(userLoginGrid);

        TextField t1 = new TextField();


        PasswordField p1 = new PasswordField();
        HBox hBox2 = new HBox();
        hBox2.setAlignment(Pos.CENTER); // center the HBox
        hBox2.setSpacing(10);

        userLoginGrid.setPadding(new Insets(10, 10, 10, 10));

        userLoginGrid.setHgap(5);
        userLoginGrid.setVgap(5);

        hBox2.getChildren().addAll(email, t1);
        hBox2.getChildren().addAll(password, p1);


        userLoginGrid.add(hBox2, 0, 2, 2, 1);

        Button b1 = new Button("Login");
        Button b2 = new Button("Exit");

        b1.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                        +
                        "-fx-text-fill: white;"
        );
        b2.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                        +
                        "-fx-text-fill: white;"
        );
        b1.setPrefHeight(10);
        b1.setPrefWidth(100);
        b2.setPrefHeight(10);
        b2.setPrefWidth(100);
        userLoginGrid.add(b1, 0, 10);
        userLoginGrid.add(b2, 1, 10);

        b2.setOnAction(e -> {
            Platform.exit();

        });

        b1.setOnAction(e -> {
            String emailText = t1.getText();
            String passwordText = p1.getText();
            boolean loggedIn = false;

            for (Person p : person) {
                if (isValidEmail(emailText) && isValidPassword(passwordText)) {
                    if (emailText.equals(p.email) && passwordText.equals(p.password)) {
                        Text t3 = new Text("Logged in successfully.");
                        userLoginGrid.add(t3, 1, 6);
                        loggedIn = true;
                        loginInterface(stage);
                        break; // exit the loop once a match is found
                    }
                }
            }

            if (!loggedIn) {
                Text wrongEntry = new Text("Login failed. Please check your credentials.");
                userLoginGrid.add(wrongEntry, 1, 6);
            }
        });




        stage.setScene(scene2);
        stage.show();


    }

    private void adminlogin(Stage stage) {

        GridPane adminLoginGrid = new GridPane();
        Scene scene4 = new Scene(adminLoginGrid, 500, 500);
        Text email = new Text("Email Id:");
        Text password = new Text("Password:");
        fadeIn(adminLoginGrid);

        TextField t1 = new TextField();
        PasswordField p1 = new PasswordField();
        HBox hBox2 = new HBox();
        hBox2.setAlignment(Pos.CENTER); // center the HBox
        hBox2.setSpacing(10);
        adminLoginGrid.setPadding(new Insets(10, 10, 10, 10));

        adminLoginGrid.setHgap(5);
        adminLoginGrid.setVgap(5);

        hBox2.getChildren().addAll(email, t1);
        hBox2.getChildren().addAll(password, p1);

        adminLoginGrid.add(hBox2, 0, 2, 2, 1);

        Button b1 = new Button("Login");
        Button b2 = new Button("Exit");

        b1.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color:blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                        +
                        "-fx-text-fill: white;"
        );
        b2.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                        +
                        "-fx-text-fill: white;"
        );
        Button backButton = new Button("Back");
        backButton.setOnAction(m -> stage.setScene(sc1)); // Set the appropriate scene here


        backButton.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                        +
                        "-fx-text-fill: white;"
        );
        adminLoginGrid.add(backButton, 2, 10);
        backButton.setPrefHeight(10);
        backButton.setPrefWidth(100);
        b1.setPrefHeight(10);
        b1.setPrefWidth(100);
        b2.setPrefHeight(10);
        b2.setPrefWidth(100);
        adminLoginGrid.add(b1, 0, 10);
        adminLoginGrid.add(b2, 1, 10);

        b2.setOnAction(e -> {
            Platform.exit();

        });


        b1.setOnAction(p -> {
            Text result = new Text();
            String getEmail = t1.getText();
            String getPassword = p1.getText();

            // span 2 columns
            if (isValidAdminEmail(getEmail) && isValidAdminPassword(getPassword)) {
                result.setText("Log in successful");
                adminLoginGrid.add(result, 0, 9, 2, 1); // span 2 columns
                GridPane.setHalignment(result, HPos.CENTER);
                adminDashboard(stage);

            } else {
                result.setText("Invalid email or password");
                adminLoginGrid.add(result, 0, 9, 2, 1); // span 2 columns
                GridPane.setHalignment(result, HPos.CENTER);
            }

        });



        stage.setScene(scene4);
        stage.show();

    }
    private boolean isValidAdminEmail(String email) {
        return email.equals("Admin123@gmail.com");
    }

    private boolean isValidAdminPassword(String password) {
        return password.equals("Admin123");
    }


    private void signUp(Stage stage) {
        GridPane signUpGrid = new GridPane();
        Scene scene5 = new Scene(signUpGrid, 500, 500, Color.LIGHTGRAY);
        fadeIn(signUpGrid);

        Text titleText = new Text("Sign Up");
        titleText.setFont(Font.font("Times new Roman", 20));
        titleText.setTextAlignment(TextAlignment.CENTER);
        signUpGrid.add(titleText, 0, 0, 2, 1); // span 2 columns
        GridPane.setHalignment(titleText, HPos.CENTER); // center horizontally
        GridPane.setMargin(titleText, new Insets(20, 0, 20, 0));

        TextField nameField = new TextField();
        TextField cnicField = new TextField();
        TextField emailField = new TextField();
        PasswordField passwordField = new PasswordField();
        TextField ageField = new TextField();
        TextField mobileNumberField = new TextField();
        TextField sexField = new TextField();

        signUpGrid.add(new Text("Name:"), 0, 1);
        signUpGrid.add(nameField, 1, 1);

        signUpGrid.add(new Text("CNIC:"), 0, 2);
        signUpGrid.add(cnicField, 1, 2);

        signUpGrid.add(new Text("Email:"), 0, 3);
        signUpGrid.add(emailField, 1, 3);

        signUpGrid.add(new Text("Password:"), 0, 4);
        signUpGrid.add(passwordField, 1, 4);

        signUpGrid.add(new Text("Age:"), 0, 5);
        signUpGrid.add(ageField, 1, 5);

        signUpGrid.add(new Text("Mobile Number:"), 0, 6);
        signUpGrid.add(mobileNumberField, 1, 6);

        signUpGrid.add(new Text("Sex:"), 0, 7);
        signUpGrid.add(sexField, 1, 7);

        Button confirmButton = new Button("Confirm");
        signUpGrid.add(confirmButton, 0, 8, 2, 1); // span 2 columns
        GridPane.setHalignment(confirmButton, HPos.CENTER);
        confirmButton.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                        +
                        "-fx-text-fill: white;"
        );

        Text resultText = new Text();
        signUpGrid.add(resultText, 0, 9, 2, 1); // span 2 columns
        GridPane.setHalignment(resultText, HPos.CENTER);
        signUpGrid.setHgap(20);
        signUpGrid.setVgap(20);
        signUpGrid.setPadding(new Insets(0, 0, 0, 10));
        Button backButton = new Button("Back");
        backButton.setOnAction(m -> stage.setScene(sc1)); // Set the appropriate scene here


        backButton.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                        +
                        "-fx-text-fill: white;"
        );
        signUpGrid.add(backButton, 0, 8);
        confirmButton.setOnAction(e -> {

            String name = nameField.getText();
            String cnic = cnicField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            int age = Integer.parseInt(ageField.getText());
            String mobileNumber = mobileNumberField.getText();
            String sex = sexField.getText();

            if (name.isEmpty() || cnic.isEmpty() || email.isEmpty() || password.isEmpty() || ageField.getText().isEmpty() || mobileNumber.isEmpty() || sex.isEmpty()) {
                resultText.setText("Please fill in all fields");
            } else if (password.length() < 6) {
                resultText.setText("Password must be at least 6 characters long");
            } else if (!email.contains("@") || !email.endsWith("gmail.com")) {
                resultText.setText("Invalid email format. Please use a Gmail account.");
            } else {
                Person newPerson = Person.signUp(name, cnic, email, password, age, mobileNumber, sex);

                // Add the new person to the list
                person.add(newPerson);
                resultText.setText("Sign Up Successful");
                saveUserData();
            }
            confirmButton.setStyle(
                    "-fx-border-color: black;" +
                            "-fx-border-width: 1px;" +
                            "-fx-border-radius: 5px;" +
                            "-fx-background-color: lightblue;" +
                            "-fx-padding: 10px;" +
                            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                            +
                            "-fx-text-fill: white;"
            );


        });

        stage.setScene(scene5);
        stage.show();
    }
    public void adminDashboard(Stage stage) {

        adminDashboardGrid.setPadding(new Insets(30, 10, 10, 10));
        adminDashboardGrid.setVgap(20);
        adminDashboardGrid.setHgap(20);
        // Create HBox for logo and title
        HBox logoTitleBox = new HBox(10);
        logoTitleBox.setAlignment(Pos.CENTER);
        logoTitleBox.setSpacing(20);
        fadeIn(adminDashboardGrid);

        Image logoImage1 = new Image("img_2.png");
        ImageView logoImageView = new ImageView(logoImage1);
        logoImageView.setFitWidth(100);
        logoImageView.setFitHeight(100);
        logoTitleBox.getChildren().add(logoImageView);

        Text title2 = new Text("COVID\nVACCINATION\nCENTER");
        title2.setFont(Font.font("Times New Roman", 20));
        title2.setFill(Color.DARKBLUE);
        title2.setTextAlignment(TextAlignment.CENTER);
        logoTitleBox.getChildren().add(title2);

        adminDashboardGrid.add(logoTitleBox, 1, 1, 4, 1);

        Button userList = new Button("User List");
        Button centerInfo = new Button("Center List");
        userList.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color:blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                        +
                        "-fx-text-fill: white;"
        );
        centerInfo.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                        +
                        "-fx-text-fill: white;"
        );
        Button addVaccineButton = new Button("Add Vaccine");
        addVaccineButton.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);"
                        +
                        "-fx-text-fill: white;"
        );
        Button backButton2 = new Button("Back");
        backButton2.setPrefHeight(30);
        backButton2.setPrefWidth(100);
        backButton2.setOnAction(e -> stage.setScene(sc1)); // Set the appropriate scene here

        backButton2.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);" +
                        "-fx-text-fill: white;"
        );

        addVaccineButton.setPrefHeight(30);
        addVaccineButton.setPrefWidth(100);
        userList.setPrefHeight(30);
        userList.setPrefWidth(100);
        centerInfo.setPrefHeight(30);
        centerInfo.setPrefWidth(100);
        adminDashboardGrid.add(userList, 1, 3);
        adminDashboardGrid.add(centerInfo, 2, 3);
        adminDashboardGrid.add(addVaccineButton, 3, 3);
        adminDashboardGrid.add(backButton2, 4, 3);

        adminDashboardGrid.setVgap(20);


        userList.setOnAction(p->{
            GridPane userListGrid = new GridPane();
            userListGrid.setHgap(30);
            userListGrid.setVgap(20);



            Scene userListScene = new Scene(userListGrid,600,500);
            // Create TableView
            TableView<Person> tableView = new TableView<>();

            TableColumn<Person, String> nameColumn = new TableColumn<>("Name");
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

            TableColumn<Person, String> emailColumn = new TableColumn<>("Email");
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

            TableColumn<Person, String> mobileColumn = new TableColumn<>("Mobile");
            mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));

            TableColumn<Person, String> cnicColumn = new TableColumn<>("CNIC");
            cnicColumn.setCellValueFactory(new PropertyValueFactory<>("cnic"));

            TableColumn<Person, Boolean> vaccinationStatusColumn = new TableColumn<>("Dose 1 Status");
            vaccinationStatusColumn.setCellValueFactory(new PropertyValueFactory<>("vaccinated1"));

            TableColumn<Person, Boolean> vaccinationStatusColumn2 = new TableColumn<>("Dose 2 Status");
            vaccinationStatusColumn2.setCellValueFactory(new PropertyValueFactory<>("vaccinated2"));

            tableView.getColumns().addAll(nameColumn, emailColumn, mobileColumn, cnicColumn, vaccinationStatusColumn,vaccinationStatusColumn2);

            ObservableList<Person> observableUserList = FXCollections.observableArrayList(person);
            tableView.setItems(observableUserList);

            userListGrid.add(new Region(), 0, 2);

            userListGrid.add(tableView, 1, 3, 4, 1); // Span 4 columns
            userListGrid.setVgap(20);
            // Add spacer between the table and the button
            userListGrid.add(new Region(), 1, 9);



            Button backButton = new Button("Back");
            backButton.setPrefHeight(30);
            backButton.setPrefWidth(100);
            backButton.setOnAction(e -> stage.setScene(adminDashboardScene)); // Set the appropriate scene here
            userListGrid.add(backButton, 2, 8, 4, 1);
            backButton.setStyle(
                    "-fx-border-color: black;" +
                            "-fx-border-width: 1px;" +
                            "-fx-border-radius: 5px;" +
                            "-fx-background-color: blue;" +
                            "-fx-padding: 10px;" +
                            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);" +
                            "-fx-text-fill: white;"
            );

            tableView.setPlaceholder(new Text("No data available")); // Set placeholder text when the table is empty
            tableView.setEditable(true);
            tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Constrain column resizing
            tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // Enable multiple selections

            Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> throwable.printStackTrace());
            stage.setScene(userListScene);
            stage.show();
        });

        centerInfo.setOnAction(p->{
            centerList(stage);
        });
        addVaccineButton.setOnAction(p->{
            vaccineListInfo(stage);
        });



        stage.setScene(adminDashboardScene);
        stage.show();
    }
    public void centerList(Stage stage) {
        GridPane centerListGrid = new GridPane();
        Scene centerListScene = new Scene(centerListGrid, 800, 600);
        fadeIn(centerListGrid);

        centerListGrid.setVgap(30);
        centerListGrid.setHgap(20);
        centerListGrid.setPadding(new Insets(0,0,0,30));
        // ComboBox for selecting the city
        Label cityLabel = new Label("Select City:");
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("All Cities", "Lahore", "Faisalabad", "Sahiwal");
        cityComboBox.setValue("All Cities"); // Default selection

        // TableView for displaying centers
        TableView<Center> centerTable = new TableView<>();

        TableColumn<Center, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setMinWidth(50);

        TableColumn<Center, String> pincodeColumn = new TableColumn<>("Pincode");
        pincodeColumn.setCellValueFactory(new PropertyValueFactory<>("pincode"));
        pincodeColumn.setMinWidth(50);

        TableColumn<Center, String> locationColumn = new TableColumn<>("Location");
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        locationColumn.setMinWidth(50);

        TableColumn<Center, Integer> serialNumberColumn = new TableColumn<>("Serial Number");
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        serialNumberColumn.setMinWidth(50);

        centerTable.getColumns().addAll(serialNumberColumn, nameColumn, pincodeColumn, locationColumn);
        Button backButton = new Button("Back");
        backButton.setPrefHeight(30);
        backButton.setPrefWidth(100);
        backButton.setOnAction(e -> stage.setScene(adminDashboardScene)); // Set the appropriate scene here

        backButton.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);" +
                        "-fx-text-fill: white;"
        );


        // Button for adding a new center
        Button addCenterButton = new Button("Add Center");
        addCenterButton.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);" +
                        "-fx-text-fill: white;"
        );

        addCenterButton.setOnAction(event -> {
            String selectedCity = cityComboBox.getValue();

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Add Center");
            dialog.setHeaderText("Enter Center Details");

            GridPane dialogGrid = new GridPane();
            dialogGrid.setHgap(10);
            dialogGrid.setVgap(10);

            TextField nameField = new TextField();
            nameField.setPromptText("Name");

            TextField pincodeField = new TextField();
            pincodeField.setPromptText("Pincode");

            TextField locationField = new TextField();
            locationField.setPromptText("Location");

            TextField serialField = new TextField();
            locationField.setPromptText("Serial Number");



            dialogGrid.add(new Label("Name:"), 0, 0);
            dialogGrid.add(nameField, 1, 0);
            dialogGrid.add(new Label("Pincode:"), 0, 1);
            dialogGrid.add(pincodeField, 1, 1);
            dialogGrid.add(new Label("Location:"), 0, 2);
            dialogGrid.add(locationField, 1, 2);
            dialogGrid.add(new Label("SerialNumber:"), 0, 3);
            dialogGrid.add(serialField, 1, 3);

            dialog.getDialogPane().setContent(dialogGrid);

            Optional<String> result= dialog.showAndWait();

            result.ifPresent(buttonType -> {
                String name = nameField.getText();
                String pincode = pincodeField.getText();
                String location = locationField.getText();
                int serialNo = Integer.parseInt(serialField.getText());


                if (name.isEmpty() || pincode.isEmpty() || location.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill in all fields");
                    alert.showAndWait();
                } else {
                    // Add the new center to the combined list
                    Center newCenter = new Center(name, pincode, location,serialNo);
                    ObservableList<Center> combinedList = centerTable.getItems();
                    combinedList.add(newCenter);

                    // Add the new center to the respective city's list
                    switch (selectedCity) {
                        case "Lahore":
                            centersList.add(newCenter);
                            break;
                        case "Faisalabad":
                            centersList2.add(newCenter);
                            break;
                        case "Sahiwal":
                            centersList3.add(newCenter);
                            break;

                    }

                    // Update the tables
                    updateCenterTable(centerTable, cityComboBox.getValue());
                }

            });
        });

        // Update the tables when the city selection changes
        cityComboBox.setOnAction(event -> updateCenterTable(centerTable, cityComboBox.getValue()));

        centerTable.setPlaceholder(new Text("No data available")); // Set placeholder text when the table is empty
        centerTable.setEditable(true);
        centerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Constrain column resizing
        centerTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // Enable multiple selections

        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> throwable.printStackTrace());

        serialNumberColumn.setPrefWidth(50);
        nameColumn.setPrefWidth(200);
        pincodeColumn.setPrefWidth(100);
        locationColumn.setPrefWidth(250);

        // Add components to the grid
        centerListGrid.add(cityLabel, 0, 0);
        centerListGrid.add(cityComboBox, 1, 0);
        centerListGrid.add(centerTable, 0, 1, 2, 1); // Span the table across two columns
        centerListGrid.add(addCenterButton, 1, 2);
        centerListGrid.add(backButton, 2, 2);
        centerListGrid.setHgap(20);
        centerListGrid.setVgap(30);

        stage.setScene(centerListScene);
        stage.show();
    }

    private void updateCenterTable(TableView<Center> centerTable, String selectedCity) {
        List<Center> selectedList;
        switch (selectedCity) {
            case "All Cities":
                selectedList = new ArrayList<>(centersList);
                selectedList.addAll(centersList2);
                selectedList.addAll(centersList3);
                break;
            case "Lahore":
                selectedList = new ArrayList<>(centersList);
                break;
            case "Faisalabad":
                selectedList = new ArrayList<>(centersList2);
                break;
            case "Sahiwal":
                selectedList = new ArrayList<>(centersList3);
                break;
            default:
                selectedList = new ArrayList<>(); // Handle other cases as needed
        }

        ObservableList<Center> observableCenterList = FXCollections.observableArrayList(selectedList);
        centerTable.setItems(observableCenterList);
    }
    public void vaccineListInfo(Stage stage){
        GridPane vaccineGrid = new GridPane();
        Scene vaccineScene = new Scene(vaccineGrid, 600, 500);

        // Create TableView for vaccines
        TableView<Vaccine> vaccineTable = new TableView<>();

        TableColumn<Vaccine, String> nameColumn = new TableColumn<>("Vaccine Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Vaccine, Integer> stockColumn = new TableColumn<>("Stock");
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

        vaccineTable.getColumns().addAll(nameColumn, stockColumn);

        // Add existing vaccines to the table
        List<Vaccine> vaccines = Arrays.asList(
                new Vaccine("Pfizer", 50),
                new Vaccine(" Moderna", 30),
                new Vaccine(" Novavax", 20),
                new Vaccine(" Sinovac", 40),
                new Vaccine(" Sinofam", 20)
        );

        ObservableList<Vaccine> observableVaccineList = FXCollections.observableArrayList(vaccines);
        vaccineTable.setItems(observableVaccineList);

        Button backButton2 = new Button("Back");
        backButton2.setPrefHeight(30);
        backButton2.setPrefWidth(100);
        backButton2.setOnAction(e -> stage.setScene(adminDashboardScene)); // Set the appropriate scene here

        backButton2.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);" +
                        "-fx-text-fill: white;"
        );

        // Add vaccine button functionality
        Button addVaccineButton2 = new Button("Add Vaccine");
        addVaccineButton2.setPrefHeight(30);
        addVaccineButton2.setPrefWidth(150);
        addVaccineButton2.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Add Vaccine");
            dialog.setHeaderText("Enter Vaccine Details");

            GridPane dialogGrid = new GridPane();
            dialogGrid.setHgap(10);
            dialogGrid.setVgap(10);

            TextField nameField = new TextField();
            nameField.setPromptText("Vaccine Name");

            TextField stockField = new TextField();
            stockField.setPromptText("Stock");

            dialogGrid.add(new Label("Vaccine Name:"), 0, 0);
            dialogGrid.add(nameField, 1, 0);
            dialogGrid.add(new Label("Stock:"), 0, 1);
            dialogGrid.add(stockField, 1, 1);

            dialog.getDialogPane().setContent(dialogGrid);

            Optional<String> result = dialog.showAndWait();

            result.ifPresent(buttonText -> {

                String vaccineName = nameField.getText();
                int stock = Integer.parseInt(stockField.getText());

                if (vaccineName.isEmpty() || stock < 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill in all fields and ensure stock is non-negative");
                    alert.showAndWait();
                } else {
                    Vaccine newVaccine = new Vaccine(vaccineName, stock);
                    observableVaccineList.add(newVaccine);
                }

            });
        });

        // Style the "Add Vaccine" button
        addVaccineButton2.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1px;" +
                        "-fx-border-radius: 5px;" +
                        "-fx-background-color: blue;" +
                        "-fx-padding: 10px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 0);" +
                        "-fx-text-fill: white;"
        );

        vaccineGrid.add(vaccineTable, 1, 3, 4, 1); // Span 4 columns
        vaccineGrid.setVgap(20);
        vaccineGrid.setHgap(20);

        // Add spacer between the table and the buttons
        vaccineGrid.add(new Region(), 1, 9);
        vaccineGrid.add(addVaccineButton2, 1, 8);

        // Add "Back" button
        vaccineGrid.add(backButton2, 2, 8);


        stage.setScene(vaccineScene);
        stage.show();


    }






    public boolean checkVaccinationStatus(String cnic) {
        for (Person person : person) {
            if (person.cnic.equals(cnic)) {
                if(person.isVaccinated1) {
                    return true;
                }
            }
        }
        return false; // Person not found
    }


    private boolean isValidEmail(String email) {
        if (email != null && email.contains("@") && email.endsWith("gmail.com")) {
            for (Person p : person) {
                if (p.email.equals(email)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidPassword(String password) {
        if( password != null && !password.trim().isEmpty() && password.length() >= 6){
            for (Person p : person) {
                if (p.password.equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
    public void setupCenterTable(GridPane grid4,Stage stage, ArrayList<Center> centersArray,String data1,String data2,String data3,String data4,String data5,String data6,Scene scene) {

        TableView<Center> centerTable = new TableView<>();
        centerTable.setEditable(false);

        TableColumn<Center, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setMinWidth(50);

        TableColumn<Center, String> pincodeColumn = new TableColumn<>("Pincode");
        pincodeColumn.setCellValueFactory(new PropertyValueFactory<>("pincode"));
        pincodeColumn.setMinWidth(50);

        TableColumn<Center, String> locationColumn = new TableColumn<>("Location");
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        locationColumn.setMinWidth(50);

        TableColumn<Center, Integer> serialNumberColumn = new TableColumn<>("Serial Number");
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        serialNumberColumn.setMinWidth(50);

        centerTable.getColumns().addAll(serialNumberColumn, nameColumn, pincodeColumn, locationColumn);
        centerTable.getItems().addAll(centersArray);

        TableColumn<Center, Void> actionColumn = new TableColumn<>("Actions");

        actionColumn.setCellFactory(param -> new TableCell<Center, Void>() {
            private final Button addButton = new Button("Add Slots");

            {
                addButton.setOnAction(event -> {

                    GridPane grid5 = new GridPane();
                    Scene scene5 = new Scene(grid5, 650, 500);
                    grid5.setPadding(new Insets(0,0,0,20));
                    grid5.setStyle("-fx-border-color: darkblue; -fx-border-width: 5px;");
                    grid5.setPadding(new Insets(20,0,0,20));
                    Center selectedCenter = getTableView().getItems().get(getIndex());
                    String name=selectedCenter.getName();
                    Text nametext=new Text(name);
                    nametext.setFont(Font.font("times new roman",20));
                    grid5.add(nametext,1,0);

                    Text time=new Text("Select suitable time to be vaccinated:");
                    time.setFont(Font.font("times new roman",15));


                    RadioButton firstRadioButton = new RadioButton("9am-12pm");
                    RadioButton secondRadioButton = new RadioButton("1pm-4pm");
                    RadioButton thirdRadioButton = new RadioButton("4pm-9pm");
                    firstRadioButton.setFont(Font.font("times new roman",15));
                    secondRadioButton.setFont(Font.font("times new roman",15));
                    thirdRadioButton.setFont(Font.font("times new roman",15));

                    ToggleGroup toggleGroup1 = new ToggleGroup();
                    firstRadioButton.setToggleGroup(toggleGroup1);
                    secondRadioButton.setToggleGroup(toggleGroup1);
                    thirdRadioButton.setToggleGroup(toggleGroup1);

                    VBox radioButtons3 = new VBox(10); // You can adjust the spacing between buttons as needed
                    radioButtons3.getChildren().addAll(firstRadioButton,secondRadioButton,thirdRadioButton);


                    VBox vbox = new VBox(10);
                    Text timeText = new Text();
                    Label selectDateLabel = new Label("Select suitable date to be vaccinated:");
                    DatePicker datePicker = new DatePicker();
                    datePicker.setOnAction(e -> {
                        String selectedDate = datePicker.getValue().toString();
                        timeText.setText("Date of vaccination: " + selectedDate);
                    });

                    vbox.getChildren().addAll(selectDateLabel, datePicker);



                    Button confirm=new Button("Confirm");
                    confirm.setStyle("-fx-background-color: derive(DARKBLUE, 20%); -fx-background-radius: 20;");
                    confirm.setTextFill(Color.WHITE);


                    grid5.add(time,0,1);
                    grid5.add(radioButtons3,1,1);
                    grid5.add(vbox,0,2);
                    grid5.add(confirm,1,3);

                    grid5.setHgap(20);
                    grid5.setVgap(20);

                    confirm.setOnAction(o->{

                        GridPane gridv=new GridPane();
                        Scene scenev=new Scene(gridv,900,650);
                        gridv.setPadding(new Insets(0,0,0,20));

                        Button back=new Button("Back");
                        back.setStyle("-fx-background-color: derive(DARKBLUE, 20%); -fx-background-radius: 20;");
                        back.setTextFill(Color.WHITE);
                        gridv.add(back,0,12);

                        back.setOnAction(a->{
                            stage.setScene(scene); // Set the scene to the initial scene (grid1)
                            stage.show();
                        });

                        gridv.setStyle("-fx-border-color: darkblue; -fx-border-width: 5px;");
                        Random random = new Random();

                        verificationCode = 1000 + random.nextInt(9000);

                        for (Person person : person) {
                            if (person.cnic.equals(data4)) {
                                person.code=verificationCode;
                            }
                        }

                        String vaccineName="";
                        int age = Integer.parseInt(data2);

                        if(age>5 && age<15){
                            vaccineName="Moderna";
                        }
                        if(age>15 && age<30){
                            vaccineName="Pfizer";
                        }
                        if(age>30 && age<50){
                            vaccineName="Sinovac";
                        }

                        AtomicReference<String> selectedSlot = new AtomicReference<>(""); // Initialize the selectedSlot variable
                        toggleGroup1.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
                            if (toggleGroup1.getSelectedToggle() != null) {
                                RadioButton selectedRadioButton = (RadioButton) toggleGroup1.getSelectedToggle();
                                selectedSlot.set(selectedRadioButton.getText()); // Update the selectedSlot variable
                            }
                        });


                        String timme2=timeText.getText();

                        Text slipText = new Text("YOUR VACCINATION SLIP " );
                        gridv.add(slipText,0,0);
                        slipText.setFont(Font.font("times new Roman",20));
                        slipText.setFill(Color.DARKBLUE);



                        Text nameText = new Text("Your name: " +data1 );
                        Text cnicText = new Text("Your CNIC: " +data4 );
                        Text cityText = new Text("CITY: " + data3);
                        Text ageText = new Text("Your Age: " + data2);
                        Text phonetext = new Text("Your phone number: " + data5);
                        Text addresstext = new Text("Your Address: " + data6);
                        Text timeText4 = new Text("Date of vaccination: " +timme2);
                        Text vaccineText = new Text("Vaccine: " + vaccineName);
                        Text allocatedCenter = new Text("Allocated Vaccination Center: " + name);
                        Text verificationText = new Text("Your Verification Code: " + verificationCode);

                        nameText.setFont(Font.font("times new Roman",20));
                        cnicText.setFont(Font.font("times new Roman",20));
                        cityText.setFont(Font.font("times new Roman",20));
                        ageText.setFont(Font.font("times new Roman",20));
                        phonetext.setFont(Font.font("times new Roman",20));
                        addresstext.setFont(Font.font("times new Roman",20));
                        timeText4.setFont(Font.font("times new Roman",20));
                        vaccineText.setFont(Font.font("times new Roman",20));
                        allocatedCenter.setFont(Font.font("times new Roman",20));
                        verificationText.setFont(Font.font("times new Roman",20));

                        gridv.add(nameText,0,1);
                        gridv.add(cnicText,0,2);
                        gridv.add(cityText,0,3);
                        gridv.add(ageText,0,4);
                        gridv.add(phonetext,0,5);
                        gridv.add(addresstext,0,6);

                        gridv.add(timeText4,0,7);
                        gridv.add(vaccineText,0,8);
                        gridv.add(allocatedCenter,0,9);
                        gridv.add(verificationText,0,10);



                        gridv.setHgap(20);
                        gridv.setVgap(20);
                        stage.setScene(scenev);
                        stage.show();

                    });


                    stage.setScene(scene5);
                    stage.show();
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(addButton);
                }
            }



        });

        actionColumn.setPrefWidth(100);
        centerTable.getColumns().add(actionColumn); // Add the action column to the TableView


        grid4.add(centerTable, 0, 3);

        serialNumberColumn.setPrefWidth(100);
        nameColumn.setPrefWidth(200);
        pincodeColumn.setPrefWidth(100);
        locationColumn.setPrefWidth(250);

    }

    public void loginInterface(Stage stage){
        GridPane grid1=new GridPane();
        Scene scene=new Scene(grid1,900,650);
        grid1.setVgap(10);
        grid1.setHgap(10);
        Rectangle r1=new Rectangle();
        r1.setHeight(20);
        r1.setWidth(900);
        r1.setFill(Color.DARKBLUE);
        grid1.add(r1,0,0);

        Text contact=new Text("Contact us: 1234-5678");
        grid1.add(contact,0,0);

        Text status=new Text("      Check your vaccination status here:");
        Text enroll=new Text("      Get yourself Enroll for vaccination here:");
        Text verify=new Text("      Verify yourself for vaccinated here:");
        grid1.add(status,0,3);
        grid1.add(enroll,0,4);
        grid1.add(verify,0,5);
        status.setFont(Font.font("times new roman",15));
        enroll.setFont(Font.font("times new roman",15));
        verify.setFont(Font.font("times new roman",15));


        Button status1=new Button("Status");
        Button enroll1=new Button("Enroll");
        Button verify1=new Button("Verify");

        verify1.setOnAction(d->{
            GridPane grid7 = new GridPane();
            Scene scene7 = new Scene(grid7, 600, 500);
            grid7.setPadding(new Insets(0,0,0,20));
            grid7.setStyle("-fx-border-color: darkblue; -fx-border-width: 5px;");
            grid7.setPadding(new Insets(20,0,0,20));

            grid7.setVgap(20);
            grid7.setHgap(20);

            Text verifycheck=new Text("=== VERIFY YOUR STATUS === ");
            grid7.add(verifycheck,1,0);
            verifycheck.setFont(Font.font("times new roman",15));
            Text cnic=new Text("CNIC:");
            cnic.setFont(Font.font("times new roman",12));
            TextField cnictext=new TextField();
            grid7.add(cnic,0,1);
            grid7.add(cnictext,1,1);
            Text code=new Text("CODE:");
            cnic.setFont(Font.font("times new roman",12));
            TextField codetext=new TextField();
            grid7.add(code,0,2);
            grid7.add(codetext,1,2);
            Button verify2=new Button("Verify");
            grid7.add(verify2,1,3);
            Button back=new Button("Back");
            back.setStyle("-fx-background-color: derive(DARKBLUE, 20%); -fx-background-radius: 20;");
            back.setTextFill(Color.WHITE);
            grid7.add(back,1,4);
            back.setOnAction(l->{
                stage.setScene(scene); // Set the scene to the initial scene (grid1)
                stage.show();
            });
            verify2.setStyle("-fx-background-color: derive(DARKBLUE, 20%); -fx-background-radius: 20;");
            verify2.setTextFill(Color.WHITE);
            verify2.setOnAction(v->{
                String CNIC=cnictext.getText();
                String code2=codetext.getText();
                int pCode2 = Integer.parseInt(code2);
                boolean found = false;
                for (Person person : person) {

                    if (person.cnic.equals(CNIC) && person.code==pCode2) {
                        Text vaccinated = new Text("You are verified ");
                        vaccinated.setFont(Font.font("times new roman", 12));
                        grid7.add(vaccinated, 1, 5);
                        person.isVaccinated1=true;
                        found=true;
                        break;
                    }

                }
                if (!found) {
                    Text notVaccinated = new Text("Invalid code or CNIC");
                    notVaccinated.setFont(Font.font("Times New Roman", 12));
                    grid7.add(notVaccinated, 1, 5);
                }

            });


            stage.setScene(scene7);
            stage.show();

        });





        status1.setOnAction(c->{

            GridPane grid7 = new GridPane();
            Scene scene7 = new Scene(grid7, 600, 500);
            grid7.setPadding(new Insets(0,0,0,20));
            grid7.setStyle("-fx-border-color: darkblue; -fx-border-width: 5px;");
            grid7.setPadding(new Insets(20,0,0,20));

            Text statuscheck=new Text("=== CHECK YOUR STATUS === ");
            grid7.add(statuscheck,1,0);

            statuscheck.setFont(Font.font("times new roman",15));
            Text cnic=new Text("CNIC:");
            cnic.setFont(Font.font("times new roman",12));
            TextField cnictext=new TextField();
            grid7.add(cnic,0,1);
            grid7.add(cnictext,1,1);
            Button check=new Button("Check Status");
            grid7.add(check,1,2);
            check.setStyle("-fx-background-color: derive(DARKBLUE, 20%); -fx-background-radius: 20;");
            check.setTextFill(Color.WHITE);



            check.setOnAction(h->{
                String CNIC=cnictext.getText();

                for (Person person : person) {
                    if (person.cnic.equals(CNIC) && person.isVaccinated1 &&  !person.isVaccinated2) {
                        Text vaccinated = new Text("You are already vaccinated with first dose .");
                        vaccinated.setFont(Font.font("times new roman", 12));
                        grid7.add(vaccinated, 1, 4);

                    }
                    else if (person.cnic.equals(CNIC) && person.isVaccinated2 && person.isVaccinated1 ) {
                        Text vaccinated = new Text("You are already vaccinated with both dose .");
                        vaccinated.setFont(Font.font("times new roman", 12));
                        grid7.add(vaccinated, 1, 4);

                    }
                    else if (person.cnic.equals(CNIC) && !person.isVaccinated1 && !person.isVaccinated2) {

                        Text notvaccinated=new Text("You are not vaccinated.");
                        notvaccinated.setFont(Font.font("times new roman",12));
                        grid7.add(notvaccinated,1,4);
                    }
                }

            });


            Button back=new Button("Back");
            back.setStyle("-fx-background-color: derive(DARKBLUE, 20%); -fx-background-radius: 20;");
            back.setTextFill(Color.WHITE);
            grid7.add(back,1,3);

            back.setOnAction(a->{
                stage.setScene(scene); // Set the scene to the initial scene (grid1)
                stage.show();
            });

            grid7.setHgap(20);
            grid7.setVgap(20);

            stage.setScene(scene7);
            stage.show();

        });

        enroll1.setOnAction(w->{
            GridPane grid2=new GridPane();
            Scene scene2=new Scene(grid2,400,300);
            grid2.setStyle("-fx-border-color: darkblue; -fx-border-width: 5px;");

            grid2.setHgap(20);
            grid2.setVgap(20);
            grid2.setPadding(new Insets(10,0,0,20));

            Text enrollement=new Text("ENROLLENT FOR VACCINATION");
            grid2.add(enrollement,0,0);
            enrollement.setFont(Font.font("times new roman",15));
            Text cnic=new Text("CNIC:");
            cnic.setFont(Font.font("times new roman",12));
            TextField codetext=new TextField();

            Text question=new Text("Do you want to get yourslf enrolled for vaccination");
            question.setFont(Font.font("times new roman",12));
            grid2.add(question,0,2);


            HBox cnicBox=new HBox(10);
            cnicBox.getChildren().addAll(cnic,codetext);
            grid2.add(cnicBox,0,1); //


            RadioButton yesRadioButton=new RadioButton("Yes");
            RadioButton noRadioButton=new RadioButton("No");

            ToggleGroup toggleGroup=new ToggleGroup();
            yesRadioButton.setToggleGroup(toggleGroup);
            noRadioButton.setToggleGroup(toggleGroup);

            VBox radioButtons=new VBox(10); // You can adjust the spacing between buttons as needed
            radioButtons.getChildren().addAll(yesRadioButton,noRadioButton);
            grid2.add(radioButtons,0,3);

            yesRadioButton.setOnAction(e->{

                String enteredCNIC = codetext.getText();

                for (Person person : person ) {
                    if (person.cnic.equals(enteredCNIC) && person.isVaccinated1) {
                        Text v1 = new Text("Please enter the correct CNIC");
                        grid2.add(v1, 0, 4);
                    }
                    else if (person.cnic.equals(enteredCNIC) && !person.isVaccinated1){

                        GridPane grid3=new GridPane();
                        Scene scene3=new Scene(grid3,900,650);
                        grid3.setPadding(new Insets(0,0,0,20));
                        grid3.setStyle("-fx-border-color: darkblue; -fx-border-width: 5px;");

                        grid3.setHgap(20);
                        grid3.setVgap(20);

                        Text enrollement2=new Text("ENROLLENT FOR VACCINATION");
                        enrollement2.setFont(Font.font("times new roman",20));
                        grid3.add(enrollement2,0,0);
                        Text name=new Text("Name:");
                        name.setFont(Font.font("times new roman",15));
                        TextField name1=new TextField();

                        HBox h1=new HBox();
                        Text age=new Text("age:");
                        age.setFont(Font.font("times new roman",15));
                        TextField age1=new TextField();
                        h1.getChildren().addAll(age,age1);

                        HBox h2=new HBox();
                        Text city=new Text("City:");
                        city.setFont(Font.font("times new roman",15));
                        TextField city1=new TextField();
                        h2.getChildren().addAll(city,city1);

                        HBox h3=new HBox();
                        Text cnic2=new Text("CNIC:");
                        cnic2.setFont(Font.font("times new roman",15));
                        TextField codetext1=new TextField();
                        h3.getChildren().addAll(cnic2,codetext1);
                        VBox v1=new VBox();
                        v1.getChildren().addAll(h3,h1,h2);
                        v1.setSpacing(20);
                        Text gender=new Text("Gender:");
                        gender.setFont(Font.font("times new roman",15));
                        Text phone=new Text("Phone number:");
                        phone.setFont(Font.font("times new roman",15));
                        TextField phone1=new TextField();
                        Text address=new Text("Address:");
                        address.setFont(Font.font("times new roman",15));
                        TextField address1=new TextField();
                        Text text1=new Text("Select your nearest vaccination center:");
                        text1.setFont(Font.font("times new roman",15));
                        Button Select=new Button("Select");
                        HBox h5=new HBox();
                        h5.getChildren().addAll(text1,Select);
                        Select.setStyle("-fx-background-color: derive(DARKBLUE, 20%); -fx-background-radius: 20;");
                        Select.setTextFill(Color.WHITE);

                        RadioButton maleRadioButton=new RadioButton("Male");
                        RadioButton femaleRadioButton=new RadioButton("Female");
                        maleRadioButton.setFont(Font.font("times new roman",15));
                        femaleRadioButton.setFont(Font.font("times new roman",15));

                        ToggleGroup toggleGroup1=new ToggleGroup();
                        maleRadioButton.setToggleGroup(toggleGroup1);
                        femaleRadioButton.setToggleGroup(toggleGroup1);

                        VBox radioButtons2=new VBox(10); // You can adjust the spacing between buttons as needed
                        radioButtons2.getChildren().addAll(femaleRadioButton,maleRadioButton);


                        Button back=new Button("Back");
                        back.setStyle("-fx-background-color: derive(DARKBLUE, 20%); -fx-background-radius: 20;");
                        back.setTextFill(Color.WHITE);
                        grid3.add(back,0,11);

                        back.setOnAction(a->{
                            stage.setScene(scene); // Set the scene to the initial scene (grid1)
                            stage.show();
                        });

                        grid3.add(name,0,1);
                        grid3.add(name1,0,2);

                        grid3.add(v1,0,3);


                        grid3.add(address,0,4);
                        GridPane.setColumnSpan(address1,2);
                        grid3.add(address1,0,5);
                        grid3.add(phone,0,6);
                        GridPane.setColumnSpan(phone1,2);
                        grid3.add(phone1,0,7);

                        grid3.add(gender,0,8);
                        grid3.add(radioButtons2,0,9);
                        grid3.add(h5,0,10);


                        Select.setOnAction(x->{

                            String data1=name1.getText();
                            String data2=age1.getText();
                            String data3=city1.getText();
                            String data4=codetext1.getText();
                            String data5=phone1.getText();
                            String data6=address1.getText();

                            if(data1.isEmpty() || data2.isEmpty() || data3.isEmpty() || data4.isEmpty() || data5.isEmpty() || data6.isEmpty() ){
                                Text t1=new Text("Please fill all the text fields");
                                t1.setFill(Color.RED);
                                t1.setFont(Font.font("times new roman",15));
                                grid3.add(t1,2,10);

                            }
                            else {
                                GridPane grid4 = new GridPane();
                                Scene scene4 = new Scene(grid4, 900, 650);
                                grid4.setStyle("-fx-border-color: darkblue; -fx-border-width: 5px;");
                                grid4.setPadding(new Insets(10, 0, 0, 20));

                                HBox hb = new HBox();
                                Image logoImage1 = new Image("img_2.png");
                                ImageView logoImageView = new ImageView(logoImage1);

                                logoImageView.setFitWidth(100);
                                logoImageView.setFitHeight(100);

                                Text title2 = new Text("\nCOVID\nVACCINATION\nCENTER");
                                title2.setFont(Font.font("Times New Roman", 20));
                                title2.setFill(Color.DARKBLUE);
                                title2.setTextAlignment(TextAlignment.CENTER);
                                hb.getChildren().addAll(logoImageView, title2);
                                hb.setSpacing(20);
                                hb.setPadding(new Insets(10, 0, 0, 100));
                                grid4.add(hb, 0, 0);

                                Label cityLabel = new Label("Select your city");

                                ComboBox<String> cityComboBox = new ComboBox<>();
                                cityComboBox.getItems().addAll("Lahore", "Faisalabad", "sahiwal");

                                cityComboBox.setOnAction(a -> {
                                    String selectedCity = cityComboBox.getSelectionModel().getSelectedItem();
                                    if (selectedCity != null && selectedCity.equals("Lahore")) {

                                        setupCenterTable(grid4, stage, centersList,data1,data2,data3,data4,data5,data6,scene);

                                    } else if (selectedCity != null && selectedCity.equals("Faisalabad")) {

                                        setupCenterTable(grid4, stage, centersList2,data1,data2,data3,data4,data5,data6,scene);

                                    } else if (selectedCity != null && selectedCity.equals("sahiwal")) {

                                        setupCenterTable(grid4, stage, centersList3,data1,data2,data3,data4,data5,data6,scene);

                                    }
                                });

                                VBox vbox = new VBox(10);
                                vbox.getChildren().addAll(cityLabel, cityComboBox);

                                grid4.add(vbox, 0, 1);


                                grid4.setVgap(20);
                                grid4.setHgap(20);
                                stage.setScene(scene4);
                                stage.show();
                            }

                        });


                        stage.setScene(scene3);
                        stage.show();

                    }
                }

            });
            stage.setScene(scene2);
            stage.show();
        });


        grid1.add(status1,7,3);
        grid1.add(enroll1,7,4);
        grid1.add(verify1,7,5);
        status1.setTextFill(Color.WHITE);
        enroll1.setTextFill(Color.WHITE);
        verify1.setTextFill(Color.WHITE);

        status1.setStyle("-fx-background-color: derive(DARKBLUE, 20%); -fx-background-radius: 20;");
        enroll1.setStyle("-fx-background-color: derive(DARKBLUE, 20%); -fx-background-radius: 20;");
        verify1.setStyle("-fx-background-color: derive(DARKBLUE, 20%); -fx-background-radius: 20;");


        Image logoImage=new Image("img_2.png");
        ImageView logoImageView=new ImageView(logoImage);

        logoImageView.setFitWidth(100);
        logoImageView.setFitHeight(100);
        grid1.add(logoImageView,5,1);

        ColumnConstraints column1=new ColumnConstraints();
        column1.setPercentWidth(12);
        grid1.getColumnConstraints().addAll(column1);

        Text title2=new Text("COVID\nVACCINATION\nCENTER");
        title2.setFont(Font.font("Times New Roman",20));
        title2.setFill(Color.DARKBLUE);
        title2.setTextAlignment(TextAlignment.CENTER);
        grid1.add(title2,7,1);

        Button back=new Button("Back");
        back.setStyle("-fx-background-color: derive(DARKBLUE, 20%); -fx-background-radius: 20;");
        back.setTextFill(Color.WHITE);
        grid1.add(back,1,6);
        back.setOnAction(l->{
            stage.setScene(sc1); // Set the scene to the initial scene (grid1)
            stage.show();
        });



        HBox h1=new HBox();
        h1.setSpacing(30);
        h1.setPadding(new Insets(20,0,0,80));

        // Inside the start method after creating ImageViews

        Image i1=new Image("img_4.png");
        ImageView imageView1=new ImageView(i1);
        imageView1.setFitWidth(200); // Set width
        imageView1.setFitHeight(200); // Set height

        Image i2=new Image("img_1.png");
        ImageView imageView2=new ImageView(i2);
        imageView2.setFitWidth(200); // Set width
        imageView2.setFitHeight(200); // Set height

        Image i3=new Image("img_5.png"); // Replace "img_3.png" with your third image path
        ImageView imageView3=new ImageView(i3);
        imageView3.setFitWidth(200); // Set width
        imageView3.setFitHeight(200); // Set height


        Rectangle separator1=new Rectangle(20,200,Color.TRANSPARENT);
        separator1.setStroke(Color.TRANSPARENT);
        Rectangle separator2=new Rectangle(20,200,Color.TRANSPARENT);

        h1.setSpacing(30);
        h1.setPadding(new Insets(20,0,0,80));
        h1.getChildren().addAll(imageView1,separator1,imageView2,separator2,imageView3);

        grid1.add(h1,0,7);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    private static final String USER_DATA_FILE = "src/main/resources/user_data.txt"; // Replace with your file path

    private void loadUserData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(";");
                if (userData.length == 9) {
                    Person newUser = new Person(userData[0], userData[1], userData[2], userData[3],
                            Integer.parseInt(userData[4]), userData[5], userData[6],
                            Boolean.parseBoolean(userData[7]), Boolean.parseBoolean(userData[8]));
                    person.add(newUser);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void saveUserData() {
        File file = new File(USER_DATA_FILE);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Person p : person) {
                String userData = String.format("%s;%s;%s;%s;%d;%s;%s;%b;%b\n",
                        p.getName(), p.getCnic(), p.getEmail(), p.getPassword(), p.getAge(),
                        p.getMobileNumber(), p.getSex(), p.isVaccinated1(), p.isVaccinated2());
                writer.write(userData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void stop() throws Exception {
        super.stop();
        saveUserData(); // Save user data when the application stops
    }


    public static void main(String[] args) {
        launch();
    }
}