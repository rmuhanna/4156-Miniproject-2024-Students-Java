package dev.coms4156.project.individualproject;

import java.io.Serial;
import java.io.Serializable;


/**
 * Represents a course that can be offered by a departmet.
 * This class stores information about the course, including its instructor name,
 * location, timeSlot, and capacity.
 */
public class Course implements Serializable {

  /**
   * Constructs a new Course object with the given parameters. Initial count starts at 0.
   *
   * @param instructorName     The name of the instructor teaching the course.
   * @param courseLocation     The location where the course is held.
   * @param timeSlot           The time slot of the course.
   * @param capacity           The maximum number of students that can enroll in the course.
   */
  public Course(String instructorName, String courseLocation, String timeSlot, int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("Negative capacity are not allowed");
    }
    this.courseLocation = courseLocation;
    this.instructorName = instructorName;
    this.courseTimeSlot = timeSlot;
    this.enrollmentCapacity = capacity;
    this.enrolledStudentCount = 0;
  }

  /**
   * Enrolls a student in the course if there is space available.
   *
   * @return true if the student is successfully enrolled, false otherwise.
   */
  public boolean enrollStudent() {
    if (enrolledStudentCount < enrollmentCapacity) {
      enrolledStudentCount++;
      return true;
    }
    return false;
  }

  /**
   * Drops a student from the course if a student is enrolled.
   *
   * @return true if the student is successfully dropped, false otherwise.
   */
  public boolean dropStudent() {
    if (enrolledStudentCount > 0) {
      enrolledStudentCount--;
      return true;
    }
    return false;
  }


  public String getCourseLocation() {
    return this.courseLocation;
  }


  public String getInstructorName() {
    return this.instructorName;
  }


  public String getCourseTimeSlot() {
    return this.courseTimeSlot;
  }

  public int getEnrolledStudentCount() {
    return this.enrolledStudentCount;
  }

  /**
   * Returns a string representation of the course, including its instructor name, location,
   * and the time its offered.
   *
   * @return A string representing the course.
   */
  @Override
  public String toString() {
    return "\nInstructor: " + instructorName
            +  "; Location: "  + courseLocation
            +  "; Time: " + courseTimeSlot;
  }


  public void reassignInstructor(String newInstructorName) {
    this.instructorName = newInstructorName;
  }


  public void reassignLocation(String newLocation) {
    this.courseLocation = newLocation;
  }


  public void reassignTime(String newTime) {
    this.courseTimeSlot = newTime;
  }

  /**
   * Sets the enrolled student count for the course.
   * The count must be non-negative and not exceed the enrollment capacity.
   *
   * @param count The number of students to set as enrolled.
   * @throws IllegalArgumentException if the provided count is negative.
   */
  public void setEnrolledStudentCount(int count) {
    if (count < 0) {
      throw new IllegalArgumentException("Negative Enrolled student count are not allowed.");
    }
    if (count <= enrollmentCapacity) {
      this.enrolledStudentCount = count;
    }
  }



  public boolean isCourseFull() {
    return enrolledStudentCount >= enrollmentCapacity;
  }

  @Serial
  private static final long serialVersionUID = 123456L;
  private final int enrollmentCapacity;
  private int enrolledStudentCount;
  private String courseLocation;
  private String instructorName;
  private String courseTimeSlot;
}
