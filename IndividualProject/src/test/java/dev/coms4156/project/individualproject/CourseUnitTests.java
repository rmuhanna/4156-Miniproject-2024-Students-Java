package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Unit tests for the Couse class.
 * This class resopnsible for testing the functionalities of the class Course.
 */
@SpringBootTest
@ContextConfiguration
public class CourseUnitTests {

  @BeforeAll
  public static void setupCourseForTesting() {
    testCourse = new Course("Griffin Newbold", "417 IAB", "11:40-12:55", 250);
    testCourseData = new Course("Gail Kaiser", "501 NWC", "Setup SDK", 120);
  }

  @Test
  public void testCourseWithNegativeCapacity() {
    assertThrows(IllegalArgumentException.class, ()
            -> new Course("Gail Kaiser", "501 NWC", "Setup SDK", -1));
  }

  @Test
  public void setEnrolledStudentCountTestWithenCapacity() {
    // Happy path
    testCourseData.setEnrolledStudentCount(109);
    assertEquals(109, testCourseData.getEnrolledStudentCount());
  }

  @Test
  public void setEnrolledStudentCountTestNotWithenCapacity() {
    // Edge case negative argement
    assertThrows(IllegalArgumentException.class, () -> testCourse.setEnrolledStudentCount(-1));

    // Edge case: student count greater than capacity
    testCourse.setEnrolledStudentCount(300);
    assertEquals(0, testCourse.getEnrolledStudentCount());
  }

  @Test
  public void enrollStudentTest() {
    testCourseData.setEnrolledStudentCount(109); // Happy path
    assertTrue(testCourseData.enrollStudent());
    testCourseData.setEnrolledStudentCount(120);
    assertFalse(testCourseData.enrollStudent()); // Edge case
  }

  @Test
  public void dropStudentTest() {
    testCourse.setEnrolledStudentCount(0); // Edge case
    assertFalse(testCourse.dropStudent());

    testCourse.setEnrolledStudentCount(109); // Happy path
    assertTrue(testCourse.dropStudent());
    assertEquals(108, testCourse.getEnrolledStudentCount());

  }

  @Test
  public void isCourseFullTest() {
    testCourseData.setEnrolledStudentCount(119); // Happy Path
    assertFalse(testCourseData.isCourseFull());

    testCourseData.enrollStudent(); // Edge case
    assertTrue(testCourseData.isCourseFull());
  }

  @Test
  public void toStringTest() {
    String expectedResult = "\nInstructor: Griffin Newbold; Location: 417 IAB; Time: 11:40-12:55";
    assertEquals(expectedResult, testCourse.toString());
  }

  @Test
  public void reassignTimeTest() {
    String newTime = "11:40-12:55";
    testCourseData.reassignTime(newTime);
    assertEquals(newTime, testCourseData.getCourseTimeSlot());
  }

  @Test
  public void reassignLocationTest() {
    String newLocation = "301 URIS";
    testCourseData.reassignLocation(newLocation);
    assertEquals(newLocation, testCourseData.getCourseLocation());
  }

  @Test
  public void reassignInstructorTest() {
    String newInstructor = "Adam Cannon";
    testCourseData.reassignInstructor(newInstructor);
    assertEquals(newInstructor, testCourseData.getInstructorName());
  }

  /** The test course instance used for testing. */
  public static Course testCourse;
  public static Course testCourseData;
}

