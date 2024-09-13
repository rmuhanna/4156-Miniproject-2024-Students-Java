package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




/**
 * Unit tests for the Department class.
 * This class resopnsible for testing the functionalities of the class Department.
 */
public class DepartmentUnitTests {

  private Department department;
  private Map<String, Course> courses;

  /**
   * Sets up for testing.
   * This method initializes a map of courses and assigns it to a department.
   * It is executed before each test case to setup for testing.
   */
  @BeforeEach
  public void setupDepartmentForTesting() {
    courses = new HashMap<>();
    courses.put("1004", new Course("Adam Cannon", "417 IAB", "11:40-12:55", 400));
    department = new Department("COMS", courses, "Luca Carloni", 2700);
  }

  @Test
  public void testGetNumberOfMajors() {
    assertEquals(2700, department.getNumberOfMajors());
  }

  @Test
  public void testGetDepartmentChair() {
    assertEquals("Luca Carloni", department.getDepartmentChair());
  }

  @Test
  public void testToString() {
    String expected = "COMS 1004: \n"
        + "Instructor: Adam Cannon; Location: 417 IAB; Time: 11:40-12:55\n";
    assertEquals(expected, department.toString());
  }

  @Test
  public void testAddPersonToMajor() {
    department.addPersonToMajor();
    assertEquals(2701, department.getNumberOfMajors());
  }

  @Test
  public void testDropPersonFromMajor() {
    department.dropPersonFromMajor();
    assertEquals(2699, department.getNumberOfMajors());
  }

  @Test
  public void testDropPersonFromMajorCaseZero() {
    department = new Department("COMS", courses, "Luca Carloni", 0);
    department.dropPersonFromMajor();
    assertEquals(0, department.getNumberOfMajors());
  }

  @Test
  public void testCreateCourse() {
    department.createCourse("3157", "Jae Lee", "417 IAB", "4:10-5:25", 400); // Happy path
    assertTrue(department.getCourseSelection().containsKey("3157"));

    assertThrows(IllegalArgumentException.class, () -> {
      department.createCourse("3157", "Jae Lee", "417 IAB", "4:10-5:25", 400); // Edge case
    });
  }
}
