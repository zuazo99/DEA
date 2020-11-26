package Probak2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webkudeaketa.WebOrri;
import webkudeaketa2.UnorderedCircularLinkedList;

public class UnorderedCircularLInkedListTest {
	UnorderedCircularLinkedList<Integer> l1;
	UnorderedCircularLinkedList<WebOrri> l2;
	WebOrri weborri = new WebOrri("Puente", 1);
	WebOrri weborri2 = new WebOrri("Marca", 2);
	WebOrri weborri3 = new WebOrri("pais", 2);
	@Before
	public void setUp() throws Exception {
		l1= new UnorderedCircularLinkedList<Integer>(null, 0, null);
		l2= new UnorderedCircularLinkedList<WebOrri>(null, 0, null);
	}

	@After
	public void tearDown() throws Exception {
		l1 = null;
		l2 = null;
	}
	
	@Test
	public void testAddToFront() {
		l1 = new UnorderedCircularLinkedList<Integer>(null, 0, null);
		l1.addToFront(1);
		assertTrue(1==l1.first());
		assertTrue(1==l1.last());
		assertTrue(1==l1.size());
		l1.addToFront(2);
		assertTrue(2==l1.first());
		assertTrue(2==l1.size());
		l1.addToFront(3);
		assertTrue(3==l1.first());
		assertTrue(3==l1.getLast().getHurrengoa().getData());
		l2 = new UnorderedCircularLinkedList<WebOrri>(null, 0, null);
		l2.addToFront(weborri);
		assertTrue(l2.first().equals(weborri));
		l2.addToFront(weborri2);
		assertTrue(l2.first().equals(weborri2));
		l2.addToFront(weborri3);
		assertTrue(l2.first().equals(weborri3));
		assertTrue(3==l2.size());
	}

	@Test
	public void testAddToRear() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAfter() {
		fail("Not yet implemented");
	}

}
