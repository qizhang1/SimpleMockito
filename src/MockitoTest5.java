/*
 * Example 5 Verify the order
 */
import java.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest5 {
	@Mock
	LinkedList<String> singleMockList;

	@Test
	public void testOrder1() {
		singleMockList.add("add first");
		singleMockList.add("add second");
		
		// create an inOrder verifier
		InOrder inOrder = inOrder(singleMockList);
		
		// verify the order
		inOrder.verify(singleMockList).add("add first");
		inOrder.verify(singleMockList).add("add second");
	}
	
	//************************************************************************************
	@Mock
	LinkedList<String> firstMockList;	
	@Mock
	LinkedList<String> secondMockList;
	
	@Test
	public void testOrder2() {
		firstMockList.add("call first");
		secondMockList.add("call second");
		
		// create inOrder object passing mocks that need to be verified in order
		InOrder inOrder = inOrder(firstMockList, secondMockList); // order does not matter here
		
		inOrder.verify(firstMockList).add("call first");
		inOrder.verify(secondMockList).add("call second");
	}
	
}