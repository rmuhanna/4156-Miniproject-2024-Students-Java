package dev.coms4156.project.individualproject;

import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RouteController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class RouteControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void routeControllerIndexStringContainsWelcome() throws Exception {
        ResultActions response = mockMvc.perform(get("/"));
        response.andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome")));
    }


    @Test
    public void routeControllerRetrieveDepartmentFound() throws Exception {
        ResultActions response = mockMvc.perform(get("/retrieveDept")
                .param("deptCode", "COMS"));
        response.andExpect(status().isOk())
                .andExpect(content().string(containsString("COMS")));
    }


    @Test
    public void routeControllerRetrieveDepartmentNotFound() throws Exception {
        ResultActions response = mockMvc.perform(get("/retrieveDept")
                .param("deptCode", "MATH"));
        response.andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Department Not Found")));
    }


    @Test
    public void routeControllerRetrieveCourseFound() throws Exception {
        ResultActions response = mockMvc.perform(get("/retrieveCourse")
                .param("deptCode", "COMS")
                .param("courseCode", "1004"));
        response.andExpect(status().isOk());
    }


    @Test
    public void routeControllerRetrieveCourseNotFound() throws Exception {
        ResultActions response = mockMvc.perform(get("/retrieveCourse")
                .param("deptCode", "COMS")
                .param("courseCode", "999"));
        response.andExpect(status().isNotFound());
    }


    @Test
    public void routeControllerIsCourseFullNotFull() throws Exception {
        ResultActions response = mockMvc.perform(get("/isCourseFull")
                .param("deptCode", "COMS")
                .param("courseCode", "1004"));
        response.andExpect(status().isOk());
    }


    @Test
    public void routeControllerIsCourseFullFull() throws Exception {
        ResultActions response = mockMvc.perform(get("/isCourseFull")
                .param("deptCode", "COMS")
                .param("courseCode", "3134"));
        response.andExpect(status().isOk());
    }


    @Test
    public void routeControllerGetMajorCountFromDeptFound() throws Exception {
        ResultActions response = mockMvc.perform(get("/getMajorCountFromDept")
                .param("deptCode", "COMS"));
        response.andExpect(status().isOk())
                .andExpect(content().string(containsString("majors in the department")));
    }


    @Test
    public void routeControllergetMajorCountFromDeptNotFound() throws Exception {
        ResultActions response = mockMvc.perform(get("/getMajorCountFromDept")
                .param("deptCode", "MATH"));
        response.andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Department Not Found")));
    }


    @Test
    public void routeControllerFindCourseLocationFound() throws Exception {
        ResultActions response = mockMvc.perform(get("/findCourseLocation")
                .param("deptCode", "COMS")
                .param("courseCode", "1004"));
        response.andExpect(status().isOk())
                .andExpect(content().string(containsString("is where the course is located")));
    }


    @Test
    public void routeControllerFindCourseLocationNotFound() throws Exception {
        ResultActions response = mockMvc.perform(get("/findCourseLocation")
                .param("deptCode", "COMS")
                .param("courseCode", "999"));
        response.andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Course Not Found")));
    }


    @Test
    public void routeControllerFindCourseInstructorFound() throws Exception {
        ResultActions response = mockMvc.perform(get("/findCourseInstructor")
                .param("deptCode", "COMS")
                .param("courseCode", "1004"));
        response.andExpect(status().isOk())
                .andExpect(content().string(containsString("is the instructor")));
    }


    @Test
    public void routeControllerFindCourseInstructorNotFound() throws Exception {
        ResultActions response = mockMvc.perform(get("/findCourseInstructor")
                .param("deptCode", "COMS")
                .param("courseCode", "999"));
        response.andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Course Not Found")));
    }


    @Test
    public void routeControllerFindCourseTimeFound() throws Exception {
        ResultActions response = mockMvc.perform(get("/findCourseTime")
                .param("deptCode", "COMS")
                .param("courseCode", "1004"));
        response.andExpect(status().isOk())
                .andExpect(content().string(containsString("The course meets at")));
    }


    @Test
    public void routeControllerFindCourseTimeNotFound() throws Exception {
        ResultActions response = mockMvc.perform(get("/findCourseTime")
                .param("deptCode", "COMS")
                .param("courseCode", "999"));
        response.andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Course Not Found")));
    }


    @Test
    public void routeControllerAddMajorToDeptFound() throws Exception {
        ResultActions response = mockMvc.perform(patch("/addMajorToDept")
                .param("deptCode", "COMS"));
        response.andExpect(status().isOk())
                .andExpect(content().string(containsString("Attribute was updated successfully")));
    }


    @Test
    public void routeControllerAddMajorToDeptNotFound() throws Exception {
        ResultActions response = mockMvc.perform(patch("/addMajorToDept")
                .param("deptCode", "MATH"));
        response.andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Department Not Found")));
    }


    @Test
    public void routeControllerRemoveMajorFromDeptFound() throws Exception {
        ResultActions response = mockMvc.perform(patch("/removeMajorFromDept")
                .param("deptCode", "COMS"));
        response.andExpect(status().isOk())
                .andExpect(content().string(containsString("Attribute was updated")));
    }


    @Test
    public void routeControllerRemoveMajorFromDeptNotFound() throws Exception {
        ResultActions response = mockMvc.perform(patch("/removeMajorFromDept")
                .param("deptCode", "MATH"));
        response.andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Department Not Found")));
    }


    @Test
    public void routeControllerDropStudentFound() throws Exception {
        ResultActions response = mockMvc.perform(patch("/dropStudentFromCourse")
                .param("deptCode", "COMS")
                .param("courseCode", "1004"));
        response.andExpect(status().isOk())
                .andExpect(content().string(containsString("Student has been dropped")));
    }
}
