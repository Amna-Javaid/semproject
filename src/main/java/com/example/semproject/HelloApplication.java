package com.example.semproject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    ArrayList<Person> person = new ArrayList<>();
    GridPane grid1 = new GridPane();
    Scene scene1 = new Scene(grid1, 500, 400, Color.LIGHTGRAY);
    Management management=new Management();
    ArrayList<Center> centersList = management.centers;
    Center[] centersArray = centersList.toArray(new Center[0]);
    ArrayList<Center> centersList2 = management.centers2;
    ArrayList<Center> centersList3 = management.centers3;


    @Override
    public void start(Stage stage) throws IOException {
        Person person1 = new Person("John Doe", "12345678-90", "john.doe@gmail.com", "password123", 25, "1234567890", "Male", true);
        person.add(person1);
        Person person2 = new Person("Jane Smith", "98765432-10", "jane.smith@gmail.com", "securePass", 30, "9876543210", "Female", false);
        person.add(person2);
        Person person3 = new Person("Bob Johnson", "56789012-34", "bob.johnson@gmail.com", "pass123", 40, "5678901234", "Male", true);
        person.add(person3);
        Person person4 = new Person("Alice Williams", "34567890-12", "alice.williams@gmail.com", "myPassword", 28, "3456789012", "Female", false);
        person.add(person4);


        homeScreen(stage);
    }

    private void homeScreen(Stage stage) {
        stage.setResizable(false);
        stage.setTitle(" Covid Vaccine Center");


        // Add logo with title at the center in the first scene
        addLogoWithCenteredTitle(grid1,"C:\\Users\\AIMS TECH\\IdeaProjects\\semproject\\src\\main\\resources\\img_2.png"  ,"Vaccine Center");

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

        stage.setScene(scene1);
        stage.show();
    }

    private void addLogoWithCenteredTitle(GridPane grid, String logoPath, String title) {
        try {
            Image logoImage = new Image(new FileInputStream(logoPath));
            ImageView logoImageView = new ImageView(logoImage);
            logoImageView.setFitWidth(100); // Adjust the width as needed
            logoImageView.setFitHeight(100);
            grid.add(logoImageView, 0, 0, 2, 1); // span 2 columns
            GridPane.setHalignment(logoImageView, HPos.CENTER); // center horizontally

            Text titleText = new Text(title);
            titleText.setFont(Font.font("Times new Roman", 20));
            titleText.setTextAlignment(TextAlignment.CENTER);
            GridPane.setMargin(titleText, new Insets(20, 0, 0, 0));
            grid.add(titleText, 0, 1, 2, 1); // span 2 columns
            GridPane.setHalignment(titleText, HPos.CENTER); // center horizontally
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void userlogin(Stage stage) {
        GridPane userLoginGrid = new GridPane();
        Scene scene2 = new Scene(userLoginGrid, 500, 500);
        Text email = new Text("Email Id:");
        Text password = new Text("Password:");


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
        backButton.setOnAction(m -> stage.setScene(scene1)); // Set the appropriate scene here


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
        backButton.setOnAction(m -> stage.setScene(scene1)); // Set the appropriate scene here


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
        GridPane adminDashboardGrid = new GridPane();
        Scene adminDashboardScene = new Scene(adminDashboardGrid, 500, 500);
        adminDashboardGrid.setPadding(new Insets(30, 10, 10, 10));
        adminDashboardGrid.setVgap(20);
        adminDashboardGrid.setHgap(20);
        // Create HBox for logo and title
        HBox logoTitleBox = new HBox(10);
        logoTitleBox.setAlignment(Pos.CENTER);
        logoTitleBox.setSpacing(20);

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
        userList.setPrefHeight(30);
        userList.setPrefWidth(100);
        centerInfo.setPrefHeight(30);
        centerInfo.setPrefWidth(100);
        adminDashboardGrid.add(userList, 1, 3);
        adminDashboardGrid.add(centerInfo, 2, 3);
        adminDashboardGrid.setVgap(20);


        userList.setOnAction(p->{
            GridPane userListGrid = new GridPane();
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

            TableColumn<Person, Boolean> vaccinationStatusColumn = new TableColumn<>("Vaccination Status");
            vaccinationStatusColumn.setCellValueFactory(new PropertyValueFactory<>("vaccinated"));

            tableView.getColumns().addAll(nameColumn, emailColumn, mobileColumn, cnicColumn, vaccinationStatusColumn);

            ObservableList<Person> observablePersonList = FXCollections.observableArrayList(person);
            tableView.setItems(observablePersonList);

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


        stage.setScene(adminDashboardScene);
        stage.show();
    }
    public void centerList( Stage stage){

    }






    public boolean checkVaccinationStatus(String cnic) {
        for (Person person : person) {
            if (person.cnic.equals(cnic)) {
                if(person.isVaccinated) {
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
    public void setupCenterTable(GridPane grid4,Stage stage, ArrayList<Center> centersArray) {
//
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
                    Scene scene5 = new Scene(grid5, 600, 350);
                    grid5.setPadding(new Insets(0,0,0,20));
                    grid5.setStyle("-fx-border-color: darkblue; -fx-border-width: 5px;");
                    grid5.setPadding(new Insets(20,0,0,20));
                    Center selectedCenter = getTableView().getItems().get(getIndex());
                    String name=selectedCenter.getName();
                    Text nametext=new Text(name);
                    nametext.setFont(Font.font("times new roman",20));
                    grid5.add(nametext,1,0);

                    Text time=new Text("Select suitable time to be vaccinated:");
                    TextField time2=new TextField();
                    time.setFont(Font.font("times new roman",15));

                    Text date=new Text("Select suitable date to be vaccinated:");
                    TextField date2=new TextField();
                    date.setFont(Font.font("times new roman",15));

                    Button confirm=new Button("Confirm");
                    confirm.setStyle("-fx-background-color: derive(DARKBLUE, 20%); -fx-background-radius: 20;");
                    confirm.setTextFill(Color.WHITE);


                    grid5.add(time,0,1);
                    grid5.add(time2,1,1);
                    grid5.add(date,0,2);
                    grid5.add(date2,1,2);
                    grid5.add(confirm,1,3);

                    grid5.setHgap(20);
                    grid5.setVgap(20);

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

        enroll1.setOnAction(w->{
            GridPane grid2=new GridPane();
            Scene scene2=new Scene(grid2,400,300);
            grid2.setStyle("-fx-border-color: darkblue; -fx-border-width: 5px;");

            grid2.setHgap(20);
            grid2.setVgap(20);

            Text enrollement=new Text("ENROLLENT FOR VACCINATION");
            grid2.add(enrollement,0,0);
            enrollement.setFont(Font.font("times new roman",15));
            Text cnic=new Text("CNIC:");
            cnic.setFont(Font.font("times new roman",12));
            TextField codetext=new TextField();
            grid2.add(cnic,0,1);
            grid2.add(codetext,1,1);
            Text question=new Text("Do you want to get yourslf enrolled for vaccination");
            question.setFont(Font.font("times new roman",12));
            grid2.add(question,0,2);

            ColumnConstraints col1=new ColumnConstraints();
            col1.setPercentWidth(30);
            ColumnConstraints col2=new ColumnConstraints();
            col2.setPercentWidth(70);
            grid2.getColumnConstraints().addAll(col1,col2);

            HBox cnicBox=new HBox(10);
            cnicBox.getChildren().addAll(cnic,codetext);
            grid2.add(cnicBox,0,1,2,1); //


            RadioButton yesRadioButton=new RadioButton("Yes");
            RadioButton noRadioButton=new RadioButton("No");

            ToggleGroup toggleGroup=new ToggleGroup();
            yesRadioButton.setToggleGroup(toggleGroup);
            noRadioButton.setToggleGroup(toggleGroup);

            VBox radioButtons=new VBox(10); // You can adjust the spacing between buttons as needed
            radioButtons.getChildren().addAll(yesRadioButton,noRadioButton);
            grid2.add(radioButtons,0,3);

            yesRadioButton.setOnAction(e->{

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

                Select.setOnAction(x->{
                    GridPane grid4=new GridPane();
                    Scene scene4=new Scene(grid4,900,650);
                    grid4.setStyle("-fx-border-color: darkblue; -fx-border-width: 5px;");
                    grid4.setPadding(new Insets(10,0,0,20));

                    HBox hb=new HBox();
                    Image logoImage1=new Image("img_2.png");
                    ImageView logoImageView=new ImageView(logoImage1);

                    logoImageView.setFitWidth(100);
                    logoImageView.setFitHeight(100);

                    Text title2=new Text("\nCOVID\nVACCINATION\nCENTER");
                    title2.setFont(Font.font("Times New Roman",20));
                    title2.setFill(Color.DARKBLUE);
                    title2.setTextAlignment(TextAlignment.CENTER);
                    hb.getChildren().addAll(logoImageView,title2);
                    hb.setSpacing(20);
                    hb.setPadding(new Insets(10,0,0,100));
                    grid4.add(hb,0,0);

                    Label cityLabel=new Label("Select your city");

                    ComboBox<String> cityComboBox=new ComboBox<>();
                    cityComboBox.getItems().addAll("Lahore","Faisalabad","sahiwal");

                    cityComboBox.setOnAction(a->{
                        String selectedCity=cityComboBox.getSelectionModel().getSelectedItem();
                        if(selectedCity!=null&&selectedCity.equals("Lahore")){

                            setupCenterTable(grid4,stage,centersList);

                        }
                        else if(selectedCity!=null&&selectedCity.equals("Faisalabad")){

                            setupCenterTable(grid4,stage,centersList2);

                        }
                        else if(selectedCity!=null&&selectedCity.equals("Sahiwal")){

                            setupCenterTable(grid4,stage,centersList3);

                        }
                    });
                    VBox vbox=new VBox(10);
                    vbox.getChildren().addAll(cityLabel,cityComboBox);

                    grid4.add(vbox,0,1);


                    grid4.setVgap(20);
                    grid4.setHgap(20);
                    stage.setScene(scene4);
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


                stage.setScene(scene3);
                stage.show();

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



    public static void main(String[] args) {
        launch();
    }
}