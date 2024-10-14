/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package color.block.system;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 *
 * @author angel
 */
public class ColorBlockSystem extends Application {
    private ArrayList<Student> studentsList = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane= new BorderPane();
        pane.setTop(getHBox());
   pane.setCenter(getImage());
        
        
        Scene scene =new Scene(pane,600,600);
        primaryStage.setTitle("Mascot Slugger the Banana Slug");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
private StackPane getImage(){
    StackPane Stack= new StackPane();
    Stack.setPadding(new Insets(30,10,10,10));
    Image image= new Image("file:///C:/Users/angel/Documents/NetBeansProjects/Color%20Block%20System/src/color/block/system/student-in-the-classroom-isolated-vector.jpg");
    ImageView imageview= new ImageView(image);
    imageview.setFitWidth(700);
       imageview.setFitHeight(500);
       Stack.getChildren().add(imageview);
    return Stack ;
}
    private HBox getHBox(){
       HBox hbox = new HBox(15);
        hbox.setPadding(new Insets(15, 15, 15, 15));
        hbox.setStyle("-fx-background-color: gold");

        Button login = new Button("Log In");
        login.setOnAction(e -> studentLogin());

        Button signup = new Button("Sign-Up");
        signup.setOnAction(e -> studentSignUp());

        hbox.getChildren().addAll(login, signup);

        return hbox;
    }
    private void studentSignUp(){
        Stage stage= new Stage();
        stage.setTitle("Sign-Up Page");
        GridPane pane= new GridPane();
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.setPadding(new Insets(30));
        
        
        TextField Name= new TextField();
        TextField Email= new TextField();
        TextField ID= new TextField();
        TextField year= new TextField();
        TextField Pass= new TextField();
        pane.add(new Label(" Name:"),0,0);
        pane.add(Name,1,0);
        pane.add(new Label(" Email Address:"),0,1);
        pane.add(Email,1,1);
        pane.add(new Label(" Student ID:"),0,2);
        pane.add(ID,1,2);
        pane.add(new Label(" What Student Year are you in:"),0,3);
        pane.add(year,1,3);
        pane.add(new Label(" Create Password:"),0,4);
        pane.add(Pass,1,4);
        Button Submit= new Button("Submit");
        Submit.setOnAction(e -> {
            
        try{
            String name = Name.getText();
            String email = Email.getText();
            String StuID = ID.getText();
            String Year= year.getText();
            String PASS= Pass.getText();
            int Yr= Integer.parseInt(Year);
            Student student= new Student(StuID,name,email,Yr,PASS);
            studentsList.add(student);
            System.out.println("New Student Created: " + student);
displayMenu(student);
                stage.close();}
            catch (NumberFormatException ex) {
                // Handle the error if the year field does not contain a valid integer
                System.out.println("Error: Year must be a valid number");
                Alert alert = new Alert(Alert.AlertType.ERROR, "Year must be a valid number", ButtonType.OK);
                alert.showAndWait();
            
            
        }
        
        
        });
        pane.add(Submit,4,5);
        Scene scene= new Scene(pane);
         stage.setScene(scene);
         stage.show();
    }
    
   private void studentLogin() {
     Stage stage = new Stage();
     GridPane pane = new GridPane();
     pane.setHgap(8);
     pane.setVgap(8);

     Label nameLabel = new Label("Name:");
     TextField nameField = new TextField();
     Label passwordLabel = new Label("Password:");
     TextField passwordField = new TextField();

     pane.add(nameLabel, 0, 0);
     pane.add(nameField, 1, 0);
     pane.add(passwordLabel, 0, 1);
     pane.add(passwordField, 1, 1);

     Button submitButton = new Button("Submit");
     submitButton.setOnAction(e -> {
         String name = nameField.getText();
         String password = passwordField.getText();
     Student student = validateLogin(name, password); // Implement validateLogin method
         if (student != null) {
             displayMenu(student);
             stage.close();
         } else {
             Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid login credentials", ButtonType.OK);
             alert.showAndWait();
         }
     });

     pane.add(submitButton, 1, 3);
     Scene scene = new Scene(pane, 600, 600);
     stage.setScene(scene);
     stage.show();
 }
 
 private Student validateLogin(String name, String password) {
     // Assume studentsList is a collection of all Student objects
     for (Student student : studentsList) {
         if (student.getName().equals(name) && student.getPassword().equals(password)) {
             return student;
         }
     }
     return null;
 }

         private void displayCourseEnrollment(Student student) {
    Stage stage = new Stage();
    GridPane pane = new GridPane();
    pane.setPadding(new Insets(20));
    pane.setHgap(10);
    pane.setVgap(10);

    Label ScienceCourseLabel = new Label("Science:");
    ComboBox<Course> ScienceComboBox = new ComboBox<>();
    ScienceComboBox.getItems().addAll(getScienceCourses()); // Populate with all available courses

    Button enrollButton = new Button("Enroll Science");
    enrollButton.setOnAction(e -> {
        Course selectedCourse = ScienceComboBox.getValue();
        if (selectedCourse != null ){
            if (student.getstudentCourses().size()<6) 
                
            enrollInCourse(student, selectedCourse);
            else {Alert alert = new Alert(Alert.AlertType.WARNING, "You can not select more than 5 Courses", ButtonType.OK);
            alert.showAndWait();}
        } else 
        {Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a course to enroll in", ButtonType.OK);
            alert.showAndWait();}
        
    });
    Button DropS =  new Button("Drop Science");
    DropS.setOnAction(e -> {
        Course selectedCourse = ScienceComboBox.getValue();
        student.removeCourse(selectedCourse);
        student.getstudentCourses();
    });
    pane.add(DropS,4,0);
    pane.add(ScienceCourseLabel, 0, 0);
    pane.add(ScienceComboBox, 1, 0);
    pane.add(enrollButton, 3, 0);
    
    Label MathCourseLabel = new Label("Math:");
    ComboBox<Course> MathComboBox = new ComboBox<>();
    MathComboBox.getItems().addAll(getMathCourses()); // Populate with all available courses

    Button enrollMathButton = new Button("Enroll Math");
    enrollMathButton.setOnAction(e -> {
        Course selectedCourse = MathComboBox.getValue();
        if (selectedCourse != null ){
            if (student.getstudentCourses().size()<6) 
                
            enrollInCourse(student, selectedCourse);
            else {Alert alert = new Alert(Alert.AlertType.WARNING, "You can not select more than 5 Courses", ButtonType.OK);
            alert.showAndWait();}
        } else 
        {Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a course to enroll in", ButtonType.OK);
            alert.showAndWait();}
        
    });
Button DropM =  new Button("Drop Math");
    DropM.setOnAction(e -> {
        Course selectedCourse = MathComboBox.getValue();
        student.removeCourse(selectedCourse);
        student.getstudentCourses();
    });
    
    pane.add(DropM, 4, 3);
    pane.add(MathCourseLabel, 0, 3);
    pane.add(MathComboBox, 1, 3);
    pane.add(enrollMathButton, 3, 3);

    

    Label EnglishCourseLabel = new Label("English:");
    ComboBox<Course> EnglishComboBox = new ComboBox<>();
    EnglishComboBox.getItems().addAll(getEnglishCourses()); // Populate with all available courses

    Button enrollEnglishButton = new Button("Enroll English");
    enrollEnglishButton.setOnAction(e -> {
        Course selectedCourse = EnglishComboBox.getValue();
        if (selectedCourse != null ){
            if (student.getstudentCourses().size()<6) 
                
            enrollInCourse(student, selectedCourse);
            else {Alert alert = new Alert(Alert.AlertType.WARNING, "You can not select more than 5 Courses", ButtonType.OK);
            alert.showAndWait();}
        } else 
        {Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a course to enroll in", ButtonType.OK);
            alert.showAndWait();}
        
    });
Button DropE =  new Button("Drop English");
    DropE.setOnAction(e -> {
        Course selectedCourse = EnglishComboBox.getValue();
        student.removeCourse(selectedCourse);
        student.getstudentCourses();
    });
    pane.add(DropE,4,4);
    pane.add(EnglishCourseLabel, 0, 4);
    pane.add(EnglishComboBox, 1, 4);
    pane.add(enrollEnglishButton, 3, 4);
    
    
    Label LanguagesCourseLabel = new Label("Languages:");
    ComboBox<Course> LanguagesComboBox = new ComboBox<>();
    LanguagesComboBox.getItems().addAll(getLanguageCourses()); // Populate with all available courses

    Button enrollLanguagesButton = new Button("Enroll Languages");
    enrollLanguagesButton.setOnAction(e -> {
        Course selectedCourse = LanguagesComboBox.getValue();
        if (selectedCourse != null ){
            if (student.getstudentCourses().size()<6) 
                
            enrollInCourse(student, selectedCourse);
            else {Alert alert = new Alert(Alert.AlertType.WARNING, "You can not select more than 5 Courses", ButtonType.OK);
            alert.showAndWait();}
        } else 
        {Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a course to enroll in", ButtonType.OK);
            alert.showAndWait();}
        
    });
Button DropL =  new Button("Drop Language");
    DropL.setOnAction(e -> {
        Course selectedCourse = LanguagesComboBox.getValue();
        student.removeCourse(selectedCourse);
        student.getstudentCourses();
    });
    
    pane.add(DropL,4,5);
    pane.add(LanguagesCourseLabel, 0, 5);
    pane.add(LanguagesComboBox, 1, 5);
    pane.add(enrollLanguagesButton, 3, 5);
    
    Label PECourseLabel = new Label("PE:");
    ComboBox<Course> PEComboBox = new ComboBox<>();
    PEComboBox.getItems().addAll(getPECourses()); // Populate with all available courses

    Button enrollPEButton = new Button("Enroll PE");
    enrollPEButton.setOnAction(e -> {
        Course selectedCourse = PEComboBox.getValue();
        if (selectedCourse != null ){
            if (student.getstudentCourses().size()<6) 
                
            enrollInCourse(student, selectedCourse);
            else {Alert alert = new Alert(Alert.AlertType.WARNING, "You can not select more than 5 Courses", ButtonType.OK);
            alert.showAndWait();}
        } else 
        {Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a course to enroll in", ButtonType.OK);
            alert.showAndWait();}
        
    });
    Button Drop =  new Button("Drop PE");
    Drop.setOnAction(e -> {
        Course selectedCourse = PEComboBox.getValue();
        student.removeCourse(selectedCourse);
        student.getstudentCourses();
    });

    
    
    pane.add(PECourseLabel, 0, 7);
    pane.add(PEComboBox, 1, 7);
    pane.add(enrollPEButton, 3, 7);
    pane.add(Drop, 4, 7);
    
     Label HistoryCourseLabel = new Label("History:");
    ComboBox<Course> HistoryComboBox = new ComboBox<>();
    HistoryComboBox.getItems().addAll(getHistoryCourses()); // Populate with all available courses

    Button enrollHistoryButton = new Button("Enroll History");
    enrollHistoryButton.setOnAction(e -> {
        Course selectedCourse = HistoryComboBox.getValue();
        if (selectedCourse != null ){
            if (student.getstudentCourses().size()<6) 
                
            enrollInCourse(student, selectedCourse);
            else if(student.getstudentCourses().size()>=6){Alert alert = new Alert(Alert.AlertType.WARNING, "You can not select more than 5 Courses", ButtonType.OK);
            alert.showAndWait();}
        } else 
        {Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a course to enroll in", ButtonType.OK);
            alert.showAndWait();}
        
    });

    Button DropH =  new Button("Drop History");
    DropH.setOnAction(e -> {
        Course selectedCourse = HistoryComboBox.getValue();
        student.removeCourse(selectedCourse);
        student.getstudentCourses();
    });
    pane.add(DropH, 4, 6);
    pane.add(HistoryCourseLabel, 0, 6);
    pane.add(HistoryComboBox, 1, 6);
    pane.add(enrollHistoryButton, 3, 6);
    
    Button Exit = new Button("Exit");
    Exit.setOnAction(e -> stage.close());
    pane.add(Exit, 4, 9);
    Scene scene = new Scene(pane,600,600);
    stage.setTitle("Course Enrollment");
    stage.setScene(scene);
    stage.show();
    }
    public void displayMenu(Student student){
        Stage stage= new Stage();
        stage.setTitle("Student Main Menu");
        VBox box = new VBox();
        box.setStyle( "-fx-background-color:gray;");
        box.setPadding(new Insets(20));
        
        Label label= new Label("WELCOME: MAIN MENU");
        label.setPadding(new Insets(12));
        label.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC,40));
        Button Enroll = new Button(" Enroll");
        Enroll.setOnAction(e -> displayCourseEnrollment(student));
        Button display = new Button("Display Available Courses");
        display.setOnAction( e ->displayCourses());
        //Button cart = new Button("Show Cart");
        //cart.setOnAction(e ->)
        Button Exit = new Button("Exit");
    Exit.setOnAction(e -> stage.close());
        
        box.getChildren().addAll(label,Enroll, display,Exit);
        Scene scene= new Scene(box,600,400);
        stage.setScene(scene);
        stage.show();
        
        
                
    }




private void displayCourses() {
     Stage stage = new Stage();
     TableView<Course> courseTable = new TableView<>();
     ObservableList<Course> allCourses = FXCollections.observableArrayList();
     
     allCourses.addAll(getMathCourses());
     allCourses.addAll(getScienceCourses());
     allCourses.addAll(getEnglishCourses());
     allCourses.addAll(getPECourses());
     allCourses.addAll(getLanguageCourses());
     allCourses.addAll(getHistoryCourses());
     
     courseTable.setItems(allCourses);
     
     TableColumn<Course, String> nameColumn = new TableColumn<>("Course Name");
     nameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));

     TableColumn<Course, String> SubjectColumn = new TableColumn<>("Subject");
     SubjectColumn.setCellValueFactory(new PropertyValueFactory<>("subjectArea"));

     courseTable.getColumns().addAll(nameColumn, SubjectColumn);
     
     
     Scene scene = new Scene(courseTable, 600, 400);
    
     
     stage.setTitle("Course List");
     stage.setScene(scene);
     stage.show();
 }


private void enrollInCourse(Student student, Course course) {
    if (course.checkPrerequisites(student)) {
        student.addCourse(course);
        System.out.println("Successfully enrolled in: " + course.getCourseName());

        // Show enrolled courses summary
        showEnrolledCoursesSummary(student);

    } else {
        System.out.println("Prerequisites not met for: " + course.getCourseName());
        Alert alert = new Alert(Alert.AlertType.ERROR, "You do not meet the prerequisites for this course", ButtonType.OK);
        alert.showAndWait();
    }
}

private void showEnrolledCoursesSummary(Student student) {
    // Create an alert with a custom content (TextFlow)
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Enrollment Summary");
    alert.setHeaderText("Courses Enrolled");

    // Create a TextFlow to hold course information with color highlighting
    TextFlow summaryContent = new TextFlow();

    // Loop through each enrolled course and create a Text object with color styling
    for (Course course : student.getstudentCourses()) {
        // Create a Text object for the course name
        Label courseLabel = new Label(course.getCourseName());
        courseLabel.setPadding(new Insets(5)); // Padding inside the label

        // Set the border color based on the course's block color
        courseLabel.setStyle("-fx-border-color: " + getColorCode(course.getBlock()) + ";"
                            + "-fx-border-width: 2;" // Adjust the width of the border
                            + "-fx-border-radius: 5;" // Optional: Rounded corners for the border
                            + "-fx-background-color: "+getColorCode(course.getBlock())+";" 
                            + "-fx-font-weight: bold;"); // Optional: Make the font bold

        // Add the styled Label to the VBox
        summaryContent.getChildren().add(courseLabel);
        
    }

    // Set the content of the alert to the TextFlow
    alert.getDialogPane().setContent(summaryContent);
    alert.showAndWait();
}

// Helper method to convert block color names to color codes
private String getColorCode(String blockColor) {
    switch (blockColor.toLowerCase()) {
        case "red":
            return "red";
        case "yellow":
            return "yellow";
        case "green":
            return "green";
        case "blue":
        case "light blue":
            return "blue";
        case "dark blue":
                return "blue";
        case "purple":
            return "purple";
        case "orange":
            return "orange";
        default:
            return "black"; // Default color if no match is found
    }
}



private ObservableList<Course> getScienceCourses() {
    ObservableList<Course> courses = FXCollections.observableArrayList();
    courses.add(new Course("PSYCH1","Psychology","Science","Red"));
    courses.add(new Course("ORG1","Organic Chemistry","Science","Red"));
    courses.add(new Course("AEST1","Astrophysics","Science","Red"));
    return courses;
}
private ObservableList<Course> getLanguageCourses() {
    ObservableList<Course> courses = FXCollections.observableArrayList();
    courses.add(new Course("MND1","Mandarin 1","Languages","Yellow"));
    
    courses.add(new Course("MND2","Mandarin 2","Languages","Yellow"));
    courses.add(new Course("GER1","German 1","Languages","Yellow"));
    courses.add(new Course("GER2","German 2","Languages","Yellow"));
    courses.add(new Course("LTN1","Latin 1","Languages","Yellow"));
    courses.add(new Course("LTN2","Latin 2","Languages","Yellow"));
    courses.add(new Course("GRK1","Greek 1","Languages","Yellow"));
    courses.add(new Course("GRK2","Greek 2","Languages","Yellow"));
    courses.add(new Course("GAE1","Gaelic 1","Languages","Yellow"));
    courses.add(new Course("GAE2","Gaelic 2","Languages","Yellow"));
    return courses;
}
private ObservableList<Course> getHistoryCourses() {
    ObservableList<Course> courses = FXCollections.observableArrayList();
    courses.add(new Course("WHSA1","World History-Southeast Asia","History","Dark Blue"));
    courses.add(new Course("WHAU1","World History-Australia","History","Light Blue"));
    courses.add(new Course("WHEA1","World History-East Asia","History","Dark Blue"));
    courses.add(new Course("WHME1","World History-Middle East","History","Light Blue"));
    courses.add(new Course("UHQH1","US History-Queer History","History","Dark Blue"));
    courses.add(new Course("USAR1","US History-a retrospectiveofprotest","History","Light Blue"));
    return courses;
}
private ObservableList<Course> getEnglishCourses() {
    ObservableList<Course> courses = FXCollections.observableArrayList();
    courses.add(new Course("","Literature and Online Speak","English","Purple"));
    courses.add(new Course("","Essay Writing for Scientific Articles","English","Green"));
    courses.add(new Course("","Citation for the Academic-avoiding plagiarism","English","Light Blue"));
    return courses;
}
private ObservableList<Course> getPECourses() {
    ObservableList<Course> courses = FXCollections.observableArrayList();
    courses.add(new Course("TT30","Table Tennis","PE","Green"));
    courses.add(new Course("UB31","Ultimate Frisbee","PE","Green"));
    
    return courses;
}
private ObservableList<Course> getMathCourses() {
    ObservableList<Course> courses = FXCollections.observableArrayList();
    courses.add(new Course("DM10","Discrete Math","Math","Red"));
    courses.add(new Course("MA11","Mathletes","Math","Red"));
    courses.add(new Course("LA12","Linear Algebra","Math","Orange"));
    return courses;
}
    public static void main(String[] args) {
        launch(args);
    }
    
}
