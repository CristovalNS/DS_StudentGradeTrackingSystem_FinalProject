/**
 * Student class represents a student with a name and a grade.
 */

package LinkedHashMap;
class Student {
    private String name;
    private int grade;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int setGrade(int grade) {
        this.grade = grade;
        return grade;
    }

    public int getGrade() {
        return grade;
    }
}