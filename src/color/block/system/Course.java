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
    public  class Course {
    protected String courseID;
    protected String courseName;
    protected String subjectArea;
    protected String block;
    protected ArrayList<Course> prerequisites;

    public Course(String courseID, String courseName, String subjectArea, String block) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.subjectArea = subjectArea;
        this.block = block;
        this.prerequisites = new ArrayList<>();
    }

    // Check if the student meets prerequisites
    public boolean checkPrerequisites(Student student) {
        for (Course prerequisite : prerequisites) {
            if (!student.getcompletedCourses().contains(prerequisite)) {
                return false;
            }
        }
        return true;
    }

   public String getSubjectArea(){
       return subjectArea;
   }
   public String getBlock(){
       return block;
   }
   public String getCourseName(){
       return courseName;
   }
   public String getCourseID(){
       return courseID;
   }
   @Override
   public String toString() {
        return courseName;
   }
}

