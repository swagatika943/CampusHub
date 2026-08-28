package main;

public class StudentManager {
    private Student[] students = new Student[10];

    private int studentCount = 0;
    public StudentManager() {
        students[0] = new Student("Swagatika", "CH001", "CSE");
        students[1] = new Student("Ammu", "CH002", "MCA");
        students[2] = new Student("Kookie", "CH003", "BS");
        studentCount = 3;
    }
    public int findStudent(String id) {

        for (int i = 0; i < studentCount; i++) {

            if (students[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    public void viewStudents() {
        for (int i = 0; i < studentCount; i++) {
            System.out.println(
                    students[i].getId() + ": "
                            + students[i].getName() + ": "
                            + students[i].getDepartment()
            );
        }
    }
    public void searchStudent(String id) {
        int index = findStudent(id);
        if (index == -1) {
            System.out.println("Student not found!");
        } else {
            System.out.println("Name: " + students[index].getName());
            System.out.println("ID: " + students[index].getId());
            System.out.println("Department: " + students[index].getDepartment());
        }
    }
    public boolean addStudent(String name, String id, String department) {
        if (studentCount >= students.length) {
            System.out.println("Student limit reached!");
            return false;
        }
        if (!isValidStudentId(id)) {
            System.out.println("Invalid Student ID!");
            return false;
        }
        if (findStudent(id) != -1) {
            System.out.println("Student ID already exists!");
            return false;
        }
        students[studentCount] = new Student(name, id, department);
        studentCount++;
        System.out.println("Student added successfully!");
        return true;
    }
    public boolean deleteStudent(String id) {
        int index = findStudent(id);
        if (index == -1) {
            System.out.println("Student not found!");
            return false;
        }
        for (int i = index; i < studentCount - 1; i++) {
            students[i] = students[i + 1];
        }
        studentCount--;
        students[studentCount] = null;
        System.out.println("Student deleted successfully!");
        return true;
    }
    public boolean updateStudent(String id, String newName, String newDepartment) {
        int index = findStudent(id);
        if (index == -1) {
            System.out.println("Student not found!");
            return false;
        }
        students[index].setName(newName);
        students[index].setDepartment(newDepartment);

        System.out.println("Student updated successfully!");
        return true;
    }
    public Student[] getStudents() {
        return students;
    }
    public int getStudentCount() {
        return studentCount;
    }
    public void clearStudents() {
        for (int i = 0; i < students.length; i++) {
            students[i] = null;
        }
        studentCount = 0;
    }
    public void loadStudent(String name, String id, String department) {
        if (studentCount < students.length) {
            students[studentCount] = new Student(name, id, department);
            studentCount++;
        }
    }
    public boolean isValidStudentId(String id) {
        if (id == null || !id.startsWith("CH") || id.length() != 5) {
            return false;
        }
        for (int i = 2; i < id.length(); i++) {
            if (!Character.isDigit(id.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
