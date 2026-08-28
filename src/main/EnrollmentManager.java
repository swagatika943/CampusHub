package main;

public class EnrollmentManager {
    private Enrollment[] enrollments = new Enrollment[20];
    private int enrollmentCount = 0;
    private StudentManager studentManager;
    private CourseManager courseManager;
    public EnrollmentManager(StudentManager studentManager, CourseManager courseManager) {
        this.studentManager = studentManager;
        this.courseManager = courseManager;
    }
    public boolean enrollStudent(String studentId, String courseId) {
        if (studentManager.findStudent(studentId) == -1) {
            System.out.println("Student not found!");
            return false;
        }
        if (courseManager.findCourse(courseId) == -1) {
            System.out.println("Course not found!");
            return false;
        }
        for (int i = 0; i < enrollmentCount; i++) {

            if (enrollments[i].getStudentId().equals(studentId)
                    && enrollments[i].getCourseId().equals(courseId)) {

                System.out.println("Student is already enrolled in this course!");
                return false;
            }
        }
        if (enrollmentCount >= enrollments.length) {
            System.out.println("Enrollment limit reached!");
            return false;
        }
        enrollments[enrollmentCount] = new Enrollment(studentId, courseId);
        enrollmentCount++;
        System.out.println("Student enrolled successfully!");
        return true;
    }
    public void viewEnrolledCourses(String studentId) {
        boolean found = false;
        for (int i = 0; i < enrollmentCount; i++) {
            if (enrollments[i].getStudentId().equals(studentId)) {
                String courseId = enrollments[i].getCourseId();
                int courseIndex = courseManager.findCourse(courseId);
                if (courseIndex != -1) {
                    System.out.println(
                            courseManager.getCourseDetails(courseIndex)
                    );
                }
                found = true;
            }
        }
        if (!found) {
            System.out.println("No courses enrolled!");
        }
    }
    public boolean dropCourse(String studentId, String courseId) {
        int index = -1;
        for (int i = 0; i < enrollmentCount; i++) {
            if (enrollments[i].getStudentId().equals(studentId) && enrollments[i].getCourseId().equals(courseId)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Enrollment not found!");
            return false;
        }
        for (int i = index; i < enrollmentCount - 1; i++) {
            enrollments[i] = enrollments[i + 1];
        }
        enrollmentCount--;
        enrollments[enrollmentCount] = null;

        System.out.println("Course dropped successfully!");
        return true;
    }
    public void viewAllEnrollments() {

        if (enrollmentCount == 0) {
            System.out.println("No enrollments found!");
            return;
        }
        System.out.println("========================");
        System.out.println("   ENROLLMENT REPORT");
        System.out.println("========================");
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(
                    enrollments[i].getStudentId() + " → " + enrollments[i].getCourseId()
            );
        }
    }
    public Enrollment[] getEnrollments() {
        return enrollments;
    }
    public int getEnrollmentCount() {
        return enrollmentCount;
    }
    public void loadEnrollment(String studentId, String courseId) {

        if (enrollmentCount < enrollments.length) {
            enrollments[enrollmentCount] =
                    new Enrollment(studentId, courseId);

            enrollmentCount++;
        }
    }
}

