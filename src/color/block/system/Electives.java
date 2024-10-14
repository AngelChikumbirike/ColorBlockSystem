/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package color.block.system;

/**
 *
 * @author angel
 */
    public class Electives extends Course {
    private String type;

    public Electives(String courseID, String courseName, String subjectArea, String block, String type) {
        super(courseID, courseName,subjectArea, block);
        this.type = type;
    }

    // Additional methods specific to Electives...
}


