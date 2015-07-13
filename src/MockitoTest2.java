/*
 * Example 2 how to use stub
 */
import java.util.*;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// use the Mockito test runner
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest2 {
	@Mock
	LinkedList<String> mockList;

	@Test
	public void testFirst() {
		// stubbing
		when(mockList.get(0)).thenReturn("first");
		// actual execution
		assertEquals("first", mockList.get(0));
	}

	@Test
	public void testNull() {
		// if not stubbed, mock returns null
		assertEquals(null, mockList.get(2));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testRunTimeEx1() {
		when(mockList.get(1)).thenThrow(new RuntimeException());
		thrown.expect(RuntimeException.class);
		mockList.get(1);
	}

	// Stubbing methods with exceptions
	@Test
	public void testRunTimeEx2() {
		doThrow(new RuntimeException()).when(mockList).clear();
		thrown.expect(RuntimeException.class);
		mockList.clear();
	}

	// iterator-style stubbing
	@Test
	public void testIteratively() {
		when(mockList.get(1)).thenReturn("one").thenReturn("two");
		// when(mockList.get(1)).thenReturn("one", "two");

		System.out.println(mockList.get(1)); // "foo"
		System.out.println(mockList.get(1)); // "bar"

		// Any consecutive call prints "bar" (last stubbing wins).
		System.out.println(mockList.get(1));
	}
}
