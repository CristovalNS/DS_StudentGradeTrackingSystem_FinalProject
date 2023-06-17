package HashMap;

import java.util.HashMap;

public class DS_HashMapTracker {
    private String className;
    private HashMap<String, Student> studentList;

    public DS_HashMapTracker() {
        studentList = new HashMap<>();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void addStudent(Student student) {
        studentList.put(student.getName(), student);
    }

    public void removeStudent(Student student) {
        studentList.remove(student.getName());
    }

    public boolean removeStudent(String studentName) {
        studentList.remove(studentName);
        return false;
    }

    public void printStudentGrades() {
        if (studentList.isEmpty()) {
            System.out.println("No students in the class.");
        } else {
            System.out.println("Student Grades (HashMap):");
            for (Student student : studentList.values()) {
                System.out.println(student.getName() + ": " + student.getGrade());
            }
        }
    }

    public HashMap<String, Student> getStudents() {
        return studentList;
    }

    public Student getStudent(String studentName) {
        return studentList.get(studentName);
    }
}
