/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package color.block.system;

/**
 *
 * @author angel
 */
public class Subject {
    public class Math extends Course {
    public Math(String courseID, String courseName,String subjectArea, String block) {
        super(courseID, courseName,"Math", block);
    }
    // Additional Math specific methods...
}

public class English extends Course {
    public English(String courseID, String courseName,String subjectArea, String block) {
        super(courseID, courseName,"English", block);
    }
    // Additional English specific methods...
}
public class PE extends Course {
    public PE(String courseID, String courseName,String subjectArea, String block) {
        super(courseID, courseName,"PE", block);
    }
// Similarly for PE, History, Languages...
public class History extends Course {
    public History(String courseID, String courseName,String subjectArea, String block) {
        super(courseID, courseName,"History", block);
    }
}
public class Languages extends Course {
    public Languages(String courseID, String courseName,String subjectArea, String block) {
        super(courseID, courseName,"Languages", block);
    }
}
}
}



