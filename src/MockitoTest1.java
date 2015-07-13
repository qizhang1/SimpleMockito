/*
 * Example 1 how to set Mockito up
 */
import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


// use the Mockito test runner
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest1  {

  // 1. create mock object based on the @Mock annotation or static mock() method call
  @Mock
  List<String> mockList;  
//  List mockedList = mock(List.class);

  @Test
  public void testQuery()  {
	// using mock object - it does not throw any "unexpected interaction" exception
	mockList.add("one");

	// ensure that a method was called once
	Mockito.verify(mockList).add("one");
  }
} 