package Probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webkudeaketa.WebOrri;
import webkudeaketa.WebOrriak;

public class WebOrriakTest {
	
	WebOrriak weborriak=WebOrriak.getNireWebOrriak();
	WebOrri web,web1;
	@Before
	public void setUp() throws Exception {
		web=new WebOrri("0-00.pl",0);
		web1=new WebOrri("0-100editions.net",2);
	}

	@After
	public void tearDown() throws Exception {
		weborriak=null;
		web=null;
		web1=null;
	}

	@Test
	public void testGetNireWebOrriak() {
		fail("Not yet implemented");
	}

	@Test
	public void testListaKargatu() {
		weborriak.listaKargatu();
		WebOrri web2=weborriak.bilatuWebOrri("0-00.pl");
		assertEquals(web2.getUrl(),web.getUrl());
		WebOrri web3=weborriak.bilatuWebOrri("0-100editions.net");
		assertEquals(web3.getUrl(),web1.getUrl());
	}

	@Test
	public void testIrakurriZenb() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}
