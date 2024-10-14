/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package color.block.system;

/**
 *
 * @author angel
 */
import java.util.ArrayList;
public class Registration  {
    // Search for courses based on subject and block
    public ArrayList<Course> searchCourses(String subject, String block, ArrayList<Course> allCourses) {
        ArrayList<Course> filteredCourses = new ArrayList<>();
        for (Course course : allCourses) {
            if (course.getSubjectArea().equalsIgnoreCase(subject) && course.getBlock().equalsIgnoreCase(block)) {
                filteredCourses.add(course);
            }
        }
        return filteredCourses;
    }

     
    public void addCourse(Student student, Course course) {
        student.addCourse(course);
    }

    // Delete course from student
    public void deleteCourse(Student student, Course course) {
        student.removeCourse(course);
    }

    
}
