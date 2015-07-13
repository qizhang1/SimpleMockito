/*
 * Example 3 Argument matchers
 */
import java.util.*;

import org.hamcrest.Matcher;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class)
public class MockitoTest3 {
	@Mock
	LinkedList<String> mockList;
	 
	@Test
	public void testAny()  {
		when(mockList.get(anyInt())).thenReturn("element");
		System.out.println(mockList.get(100));
		verify(mockList).get(anyInt());
	}
	
	// stubbing using custom matcher
	@Test
	public void testCustomMatcher()  {
		when(mockList.contains(argThat(isValid()))).thenReturn(true);
	}
	private Matcher<Object> isValid() {
		// TODO Auto-generated method stub
		return null;
	}
	
}