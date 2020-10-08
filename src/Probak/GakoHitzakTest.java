package Probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webkudeaketa.GakoHitz;
import webkudeaketa.GakoHitzKatalogoa;
import webkudeaketa.WebOrri;

public class GakoHitzakTest {
	GakoHitzKatalogoa gakoHitzak=GakoHitzKatalogoa.getNireGakoHitzak();
	GakoHitz gak,gak1;
	@Before
	public void setUp() throws Exception {
		gak=new GakoHitz("'ll");
		gak1=new GakoHitz("'re");
	}

	@After
	public void tearDown() throws Exception {
		gakoHitzak=null;
		gak=null;
	}

	@Test
	public void testGetNireGakoHitzak() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testListaKargatu() {
		gakoHitzak.listaKargatu();
		GakoHitz gak2=gakoHitzak.bilatuWebOrri("'ll");
		assertEquals(gak2.getHitza(),gak.getHitza());
		GakoHitz gak3=gakoHitzak.bilatuWebOrri("'re");
		assertEquals(gak3.getHitza(),gak1.getHitza());
	}
}
