package org.example;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.BDDMockito.given;
import static sun.nio.cs.Surrogate.is;

public class StudentTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private StudentDataObject studentDataObject;

    @Mock
    private InstructorDataObject instructorDataObject;

    @Mock
    private ClassDataObject classDataObject;

    @InjectMocks
    private StudentTestImpl studentTestImpl;

    public StudentTest() {
    }

    @Test
    public void studentClass(){
        Student studentJoy = Student("Joy Ma", "Spanish");
        Student studentJulio = Student("Julio Hernandez", "Algebra");
        Student studentJenny = Student("Jenny Jones", "Calculus");
        List<Student> students = Arrays.asList(studentJoy, studentJenny, studentJulio);
        given(studentDataObject.getAllStudents()).willReturn(students);

        List<String> mathStudents = studentTestImpl.getAllStudentsBySubject("math");

        assertThat(mathStudents.size(), is(2));
        assertThat(mathStudents, hasItems(studentJenny, studentJulio));
    }

    @Test
    public void inactiveClass(){
        Class geometry = new Class("Geometry", "Summer 2022");
        Class enviroSci = new Class("Environmental Science", "Fall 2022");
        Class compLit = new Class("Comparative Literature", "Spring 2023");
        List<Class> classList = Arrays.asList(geometry, enviroSci, compLit);

        studentTestImpl.makeClassInactive();

        verify(classDataObject).makeInactive(geometry);
        verify(classDataObject, Mockito.never()).makeInactive(enviroSci);
        verify(classDataObject, Mockito.never()).makeInactive(compLit);
        verify(classDataObject, Mockito.times(1)).markInactive(geometry);

    }

    @Captor
    ArgumentCaptor<Class> classArgumentCaptor;

    @Test
    public void testInactiveClass_argumentCaptor(){
        Class geometry = new Class("Geometry", "Summer 2022");
        Class enviroSci = new Class("Environmental Science", "Fall 2022");
        Class compLit = new Class("Comparative Literature", "Spring 2023");
        List<Class> classList = Arrays.asList(geometry, enviroSci, compLit);

        given(classDataObject.getAllClasses()).willReturn(classList);

        studentTestImpl.makeClassInactive();

        verify(classDataObject).makeInactive(classArgumentCaptor.capture());
        assertEquals(geometry, classArgumentCaptor.getValue());
    }
}
