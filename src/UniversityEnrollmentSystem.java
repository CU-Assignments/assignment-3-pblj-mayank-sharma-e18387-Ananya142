import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private String[] completedCourses;
    private int courseCount;

    public Student(String name, int maxCourses) {
        this.name = name;
        this.completedCourses = new String[maxCourses];
        this.courseCount = 0;
    }

    public String getName() {
        return name;
    }

    public void completeCourse(String courseCode) {
        if (courseCount < completedCourses.length) {
            completedCourses[courseCount++] = courseCode;
        }
    }

    public boolean hasCompleted(String courseCode) {
        for (int i = 0; i < courseCount; i++) {
            if (completedCourses[i].equals(courseCode)) {
                return true;
            }
        }
        return false;
    }
}

class Course {
    private String courseCode;
    private int capacity;
    private int enrolledStudents;
    private String[] prerequisites;
    private Student[] enrolled;

    public Course(String courseCode, int capacity, String prerequisitesInput) {
        this.courseCode = courseCode;
        this.capacity = capacity;
        this.enrolledStudents = 0;
        this.enrolled = new Student[capacity];

        if (prerequisitesInput.isEmpty()) {
            this.prerequisites = new String[0]; // No prerequisites
        } else {
            this.prerequisites = prerequisitesInput.split(",");
        }
    }

    public String getCourseCode() {
        return courseCode;
    }

    public boolean hasSpace() {
        return enrolledStudents < capacity;
    }

    public boolean checkPrerequisites(Student student) {
        for (String prerequisite : prerequisites) {
            if (!student.hasCompleted(prerequisite.trim())) {
                return false;
            }
        }
        return true;
    }

    public void enrollStudent(Student student) throws CourseFullException, PrerequisiteNotMetException {
        if (!hasSpace()) {
            throw new CourseFullException("Enrollment failed: Course " + courseCode + " is full.");
        }
        if (!checkPrerequisites(student)) {
            throw new PrerequisiteNotMetException("Enrollment failed: Prerequisites not met for " + courseCode);
        }

        enrolled[enrolledStudents++] = student;
        System.out.println(student.getName() + " has successfully enrolled in " + courseCode);
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student[] students = new Student[numStudents];

        // Input students and their completed courses
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter completed courses (comma-separated, or leave blank): ");
            String completedCourses = scanner.nextLine();

            students[i] = new Student(name, 10); // Max 10 completed courses

            if (!completedCourses.isEmpty()) {
                String[] courses = completedCourses.split(",");
                for (String course : courses) {
                    students[i].completeCourse(course.trim());
                }
            }
        }

        // Get number of courses
        System.out.print("\nEnter the number of courses: ");
        int numCourses = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Course[] courses = new Course[numCourses];

        // Input courses and their prerequisites
        for (int i = 0; i < numCourses; i++) {
            System.out.print("\nEnter course code: ");
            String courseCode = scanner.nextLine();

            System.out.print("Enter course capacity: ");
            int capacity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter prerequisites (comma-separated, or leave blank): ");
            String prerequisites = scanner.nextLine();

            courses[i] = new Course(courseCode, capacity, prerequisites);
        }

        // Enroll students in courses
        System.out.print("\nEnter the number of enrollments: ");
        int numEnrollments = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numEnrollments; i++) {
            System.out.print("\nEnter student name: ");
            String studentName = scanner.nextLine();

            System.out.print("Enter course code to enroll in: ");
            String courseCode = scanner.nextLine();

            // Find student and course objects
            Student student = null;
            Course course = null;

            for (Student s : students) {
                if (s.getName().equals(studentName)) {
                    student = s;
                    break;
                }
            }

            for (Course c : courses) {
                if (c.getCourseCode().equals(courseCode)) {
                    course = c;
                    break;
                }
            }

            // Attempt to enroll
            if (student != null && course != null) {
                try {
                    course.enrollStudent(student);
                } catch (CourseFullException | PrerequisiteNotMetException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid student or course name.");
            }
        }

        scanner.close();
    }
}
