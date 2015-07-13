/*
 * Example 6 Test interaction
 */
import java.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest6 {
	@Mock private LinkedList<String> mockListOne;
	@Mock private LinkedList<String> mockListTwo;
	@Mock private LinkedList<String> mockListThree;

	@Test
	public void testInteraction1() {
		mockListOne.add("one");

		verify(mockListOne).add("one");
		verify(mockListOne, never()).add("two");

		// verify that other mocks were not interacted
		verifyZeroInteractions(mockListTwo, mockListThree);
	}

	@Test
	public void testInteraction2() {
		mockListOne.add("one");
		mockListOne.add("two");

		verify(mockListOne).add("one");
		// following verification will fail
		// Use it only when it's relevant. Abusing it leads to overspecified, less maintainable tests.
		verifyNoMoreInteractions(mockListOne);
	}

}