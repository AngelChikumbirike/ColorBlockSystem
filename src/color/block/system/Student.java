/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package color.block.system;

import java.util.ArrayList;


public class Student {
    private String studentID;
    private String name;
    private String email;
    private String password;
    private int year;
    protected ArrayList<Course> completedCourses;
    private ArrayList<Course> studentCourses;
    

    public Student(String studentID, String name,String email, int year, String password) {
        this.studentID = studentID;
        this.name = name;
        this.year = year;
        this.email= email;
        this.password=password;
        this.completedCourses = new ArrayList<>();
        this.studentCourses = new ArrayList<>();
        
        
    }

    // Add a course to student's list
    public void addCourse(Course course) {
        if (studentCourses.size() < 5 && course.checkPrerequisites(this)) {
            studentCourses.add(course);
        } else {
            System.out.println("Unable to add course: Prerequisites not met or max electives reached.");
        }
    }

    // Remove a course from student's list
    public void removeCourse(Course course) {
        studentCourses.remove(course);
    }

    // Swap two courses in the student's list
    public void swapCourse(Course oldCourse, Course newCourse) {
        int index = studentCourses.indexOf(oldCourse);
        if (index != -1 && newCourse.checkPrerequisites(this)) {
            studentCourses.set(index, newCourse);
        } else {
            System.out.println("Unable to swap course: Prerequisites not met or course not found.");
        }
    }

    // Get list of available courses based on prerequisites
    public ArrayList<Course> getAvailableCourses(ArrayList<Course> allCourses) {
     ArrayList<Course> availableCourses = new ArrayList<>();
     for (Course course : allCourses) {
         if (!studentCourses.contains(course) && course.checkPrerequisites(this)) {
             availableCourses.add(course);
         }
     }
     return availableCourses;
 }
    public boolean addCompletedCourse(Course course) {
     if (!completedCourses.contains(course)) {
         completedCourses.add(course);
         return true;
     }
     return false;
 }
 public String getEnrolledCoursesSummary() {
        StringBuilder summary = new StringBuilder("Enrolled Courses:\n");
        for (Course course : studentCourses) {
            summary.append(course.getCourseName()).append(" (").append(course.getCourseID()).append(")\n");
        }
        return summary.toString();
    }
 public boolean isCourseCompleted(Course course) {
     return completedCourses.contains(course);
 }

 public boolean isEnrolledInCourse(Course course) {
     return studentCourses.contains(course);
 }


    public ArrayList<Course> getcompletedCourses(){
        return completedCourses;
    }
    public ArrayList<Course> getstudentCourses(){
        return studentCourses;
    }
    public void setName(String Name){
        name=Name;
    }
    public void setEmail( String Email){
        email=Email;
    }
    public void setStudentID(String ID){
        studentID=ID;
    }
    public void setPassword(String Password){
        password= Password;
        
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getStudentID(){
        return studentID;
    }
    public String getPassword(){
        return password;
    }
}

 

