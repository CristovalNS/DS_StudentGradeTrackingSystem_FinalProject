/**
 * The DS_ArrayListTracker class is a grade tracker that uses an 'ArrayList' data structure to store student information
 */

package ArrayList;
import java.util.ArrayList;

public class DS_ArrayListTracker {
    private String className;
    private ArrayList<Student> studentList;

    public DS_ArrayListTracker() {
        studentList = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    public String getStudents() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        for (Student student : studentList) {
            stringBuilder.append("(").append(index).append(") ").append(student.getName()).append(": ").append(student.getGrade()).append("\n");
            index++;
        }
        return stringBuilder.toString();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
}