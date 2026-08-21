package main;

public class EnrollmentManager {
    private Enrollment[] enrollments = new Enrollment[20];
    private int enrollmentCount = 0;
    private StudentManager studentManager = new StudentManager();
    private CourseManager courseManager = new CourseManager();
    public void enrollStudent(String studentId, String courseId) {
        if (studentManager.findStudent(studentId) == -1) {
            System.out.println("Student not found!");
            return;
        }
        if (courseManager.findCourse(courseId) == -1) {
            System.out.println("Course not found!");
            return;
        }
        for (int i = 0; i < enrollmentCount; i++) {

            if (enrollments[i].getStudentId().equals(studentId)
                    && enrollments[i].getCourseId().equals(courseId)) {

                System.out.println("Student is already enrolled in this course!");
                return;
            }
        }
        if (enrollmentCount >= enrollments.length) {
            System.out.println("Enrollment limit reached!");
            return;
        }
        enrollments[enrollmentCount] = new Enrollment(studentId, courseId);
        enrollmentCount++;
        System.out.println("Student enrolled successfully!");
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
    public void dropCourse(String studentId, String courseId) {
        int index = -1;
        for (int i = 0; i < enrollmentCount; i++) {

            if (enrollments[i].getStudentId().equals(studentId)
                    && enrollments[i].getCourseId().equals(courseId)) {

                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Enrollment not found!");
            return;
        }
        for (int i = index; i < enrollmentCount - 1; i++) {
            enrollments[i] = enrollments[i + 1];
        }
        enrollmentCount--;
        enrollments[enrollmentCount] = null;
        System.out.println("Course dropped successfully!");
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
}
