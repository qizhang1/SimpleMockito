/*
 * Example 4 Verifying exact number of invocations / at least x / never
 */
import java.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class)
public class MockitoTest4 {
	@Mock
	LinkedList<String> mockedList;
	 
	@Test
	public void testTimes()  {
		 mockedList.add("once");

		 mockedList.add("twice");
		 mockedList.add("twice");

		 mockedList.add("three times");
		 mockedList.add("three times");
		 mockedList.add("three times");
		 
		 //verify exact the number of invocations
		 verify(mockedList).add("once");  // times(1) is the default
		 //verify(mockedList, times(1)).add("once");
		 verify(mockedList, times(2)).add("twice");
		 verify(mockedList, times(3)).add("three times");
		 
		 //verify never()/times(0)
		 verify(mockedList, never()).add("never happened");
		 
		 //verification using atLeast()/atMost()
		 verify(mockedList, atLeastOnce()).add("three times");
		 verify(mockedList, atLeast(2)).add("twice");
		 verify(mockedList, atMost(3)).add("three times");
	}

	
}