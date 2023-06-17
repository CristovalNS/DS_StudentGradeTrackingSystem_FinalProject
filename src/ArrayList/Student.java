/**
 * Student class represents a student with a name and a grade.
 */

package ArrayList;
class Student {
    private String name;
    private int grade;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
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