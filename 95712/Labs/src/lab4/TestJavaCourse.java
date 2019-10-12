// Name: Qiuchen Zhang
// AndrewID: qiuchenz
package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestJavaCourse {

	static JavaCourse javaCourse;
	
	@BeforeAll 
	public static void setupClass() {
		javaCourse = new JavaCourse();
		javaCourse.loadContentsData();
		javaCourse.loadContentObjects();
	}
	
	@Test
	void testContentObjectsSize() {
		assertEquals(15, javaCourse.contentObjects.length);
	}
	
	@Test
	void testVideoContentCount() {
		assertEquals(8, Video.contentCount);
	}
	
	@Test
	void testLectureContentCount() {
		assertEquals(3, Lecture.contentCount);
	}
	
	@Test
	void testPracticeContentCount() {
		assertEquals(4, Practice.contentCount);
	}
	
	@Test
	void testContentCount() {
		assertEquals(15, Content.contentCount);
	}
	
	@Test
	void testContentTotalDuration() {
		assertEquals(403, Content.totalDuration);
	}
	
	@Test
	void testVideoTotalDuration() {
		assertEquals(48, Video.totalDuration);
	}
	@Test
	void testLectureTotalDuration() {
		assertEquals(240, Lecture.totalDuration);
	}
	@Test
	void testPracticeTotalDuration() {
		assertEquals(115, Practice.totalDuration);
	}
	@Test
	void testVideoFileSize() {
		assertEquals(94, Video.totalFileSize);
	}
	
	@Test
	void testPracticeFileSize() {
		assertEquals(29, Practice.totalFileSize);
	}
	
	@Test
	void testContentObjectsType() {
		for (Content content : javaCourse.contentObjects) {
			if (content.name.equals("Inheritance")) {
				assertTrue(content.getClass().getSimpleName().equals("Lecture"));
				break;
			}
		}
	}
	
	@Test
	void testContentObjectsDuration() {
		for (Content content : javaCourse.contentObjects) {
			if (content.name.equals("Inheritance")) {
				assertTrue(content.duration == 80);
				break;
			}
		}
	}
	
	@Test
	void testContentObjectsLearnignMode() {
		for (Content content : javaCourse.contentObjects) {
			if (content.name.equals("Inheritance")) {
				assertTrue(content.learningMode.getClass().getSimpleName().equals("LearnByAttending"));break;
			}
		}
	}
	
	@Test
	void testContentObjectsDonwloadable() {
		for (Content content : javaCourse.contentObjects) {
			if (content.name.equals("PracticeProblem-Factorial")) {
				assertTrue(content instanceof Downloadable);break;
			}
		}
	}
}
