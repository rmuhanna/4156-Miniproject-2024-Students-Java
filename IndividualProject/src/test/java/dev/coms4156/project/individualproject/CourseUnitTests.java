package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.*;

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
    assertThrows(IllegalArgumentException.class, () -> new Course("Gail Kaiser", "501 NWC", "Setup SDK", -1));
  }

  @Test
  public void setEnrolledStudentCountTest() {
    // Happy path
//    testCourseData.setEnrolledStudentCount(109);
//    assertEquals(109, testCourse.getEnrolledStudentCount());

    // Edge case negative argement
    assertThrows(IllegalArgumentException.class, () -> testCourse.setEnrolledStudentCount(-1));

    // Edge case: student count greater than capacity
    testCourse.setEnrolledStudentCount(300);
    assertEquals(0, testCourse.getEnrolledStudentCount());
//    assertThrows(IllegalArgumentException.class, () -> testCourse.setEnrolledStudentCount(300));
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


  public void isCourseFullTest() {
    testCourse.setEnrolledStudentCount(119); // Happy Path
    assertFalse(testCourse.isCourseFull());

    testCourse.enrollStudent(); // Edge case
    assertTrue(testCourse.isCourseFull());
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
    assertEquals(newTime,testCourseData.getCourseTimeSlot());
  }

  /** The test course instance used for testing. */
  public static Course testCourse;
  public static Course testCourseData;
}

