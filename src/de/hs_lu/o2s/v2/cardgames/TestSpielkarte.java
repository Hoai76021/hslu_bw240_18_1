package de.hs_lu.o2s.v2.cardgames;

import junit.framework.TestCase;

public class TestSpielkarte extends TestCase {
	Spielkarte myCard;
	
	/**
	 * Setup-Methode für alle Tests
	 * Legt eine neue Karte (Kreuz As) an
	 */
	public void setUp(){
		myCard = new Spielkarte("kreuz", "as");
//		myCard.setFarbe("kreuz");  // DIES WAR DIE ERSTE VARIANTE DES TESTS
//		myCard.setWert("as"); // DIES WAR DIE ERSTE VARIANTE DES TESTS
	}
	
	/**
	 * Prüft, ob die String-Rückgabe der Karte funktioniert
	 */
	public void testToString(){
		assertEquals(myCard.toString(), "Spielkarte mit Farbe kreuz und Wert as");
	}
	
	/**
	 * Prüft, ob die Getter-Methoden funktionieren
	 */
	public void testGetMethoden(){
		assertEquals(myCard.getFarbe(), "kreuz");
		assertEquals(myCard.getWert(), "as");
		assertEquals(myCard.getPunktwert(), 11);
	}
	
	/**
	 * Prüft, ob die Setter-Methoden funktionieren
	 */
	public void testSetMethoden(){
		myCard.setFarbe("karo");
		myCard.setWert("10");
		assertEquals(myCard.getFarbe(), "karo");
		assertEquals(myCard.getWert(), "10");
	}
	
	/**
	 * Testet den Objektvergleich
	 */
	public void testEquals(){
		Spielkarte myCard1 = new Spielkarte("kreuz", "as");
		Spielkarte myCard2 = new Spielkarte("karo", "10");
		
		// Achtung: assertEquals verwendet intern "==" für den Vergleich
		// das funktioniert dann nicht, weil die Karten ja unterschiedliche
		// Objekte sind!
		assertTrue(myCard.equals(myCard1));
		assertFalse(myCard == myCard1);
		assertFalse(myCard.equals(myCard2));
	}

}
