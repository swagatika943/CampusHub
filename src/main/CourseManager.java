package main;

public class CourseManager {
    private Course[] courses = new Course[10];
    private int courseCount = 0;
    public CourseManager() {
        courses[0] = new Course("C001", "Java");
        courses[1] = new Course("C002", "HTML");
        courses[2] = new Course("C003", "SQL");
        courses[3] = new Course("C004", "CSS");
        courseCount = 4;
    }
    public void viewCourses() {
        for (int i = 0; i < courseCount; i++) {
            System.out.println(
                    courses[i].getCourseId() + ": "
                            + courses[i].getCourseName()
            );
        }
    }
    public int findCourse(String courseId) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseId().equals(courseId)) {
                return i;
            }
        }
        return -1;
    }
    public String getCourseDetails(int index) {
        return courses[index].getCourseId() + ": " + courses[index].getCourseName();
    }
    public void searchCourse(String courseId) {
        int index = findCourse(courseId);
        if (index == -1) {
            System.out.println("Course not found!");
        } else {
            System.out.println("Course ID: " + courses[index].getCourseId());
            System.out.println("Course Name: " + courses[index].getCourseName());
        }
    }
    public boolean addCourse(String courseId, String courseName) {
        if (courseCount >= courses.length) {
            System.out.println("Course limit reached!");
            return false;
        }
        if (!isValidCourseId(courseId)) {
            System.out.println("Invalid Course ID!");
            return false;
        }
        if (findCourse(courseId) != -1) {
            System.out.println("Course ID already exists!");
            return false;
        }
        courses[courseCount] = new Course(courseId, courseName);
        courseCount++;

        System.out.println("Course added successfully!");
        return true;
    }
    public boolean deleteCourse(String courseId) {
        int index = findCourse(courseId);
        if (index == -1) {
            System.out.println("Course not found!");
            return false;
        }
        for (int i = index; i < courseCount - 1; i++) {
            courses[i] = courses[i + 1];
        }
        courseCount--;
        courses[courseCount] = null;
        System.out.println("Course deleted successfully!");
        return true;
    }
    public boolean updateCourse(String courseId, String newCourseName) {
        int index = findCourse(courseId);
        if (index == -1) {
            System.out.println("Course not found!");
            return false;
        }
        courses[index].setCourseName(newCourseName);
        System.out.println("Course updated successfully!");
        return true;
    }
    public Course[] getCourses() {
        return courses;
    }
    public int getCourseCount() {
        return courseCount;
    }
    public void clearCourses() {
        for (int i = 0; i < courses.length; i++) {
            courses[i] = null;
        }
        courseCount = 0;
    }
    public void loadCourse(String id, String name) {
        if (courseCount < courses.length) {
            courses[courseCount] = new Course(id, name);
            courseCount++;
        }
    }
    public boolean isValidCourseId(String id) {
        if (id == null || !id.startsWith("C") || id.length() != 4) {
            return false;
        }
        for (int i = 1; i < id.length(); i++) {
            if (!Character.isDigit(id.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

