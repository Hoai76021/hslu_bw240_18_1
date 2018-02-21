package de.hs_lu.o2s.ueb.ue2.cardgames;


public class Kartenstapel {
	
	/**
	 * Array vom Typ Spielkarte - enth�lt alle Karten, die auf dem Stapel liegen
	 * Index: 0: unterste Karte, ..., kartenA.length-1: oberste Karte
	 */
	Spielkarte[] kartenA;
	
	/**
	 * Konstruktor zur Generierung eines Kartenstapels aus einem gegebenen Kartenspiel
	 * @param spiel erzeugtes Spiel der Klasse "Kartenspiel"
	 */
	public Kartenstapel(Kartenspiel spiel){
		kartenA = new Spielkarte[spiel.getKartenAnzahl()];
		
		int index = 0;  // Laufvariable zur Indexierung von kartenA (eindimensional)
		
		// Referenzierung: jeder Eintrag des Kartenstapels zeigt auf die im Kartenspiel 
		// angelegten Objekte vom Typ Spielkarte (im Kartenspiel referenziert aus dem zweidimensionalen
		// Array kartenAA)
		Spielkarte[][] kartenAA = spiel.getKartenAA();
		
		// mit kartenAA.length holen wir uns die L�nge des �u�eren Arrays
		for (int i = 0; i < kartenAA.length; i++){
			// mit kartenAA[0].length holen wir uns die L�nge des inneren Arrays
			for (int j = 0; j < kartenAA[0].length; j++){
				kartenA[index] = kartenAA[i][j];
				index++;
			}
		}
				
	}
	
	/**
	 * Legt die �bergebene Karte auf den Kartenstapel
	 * @param newCard die Karte, die oben auf den Stapel gelegt werden soll
	 */
	public void push(Spielkarte newCard){
		Spielkarte[] kartenNeu = new Spielkarte[kartenA.length + 1];  // ein um 1 gr��eres Array f�r den Stapel anlegen
		System.arraycopy(kartenA, 0, kartenNeu, 0, kartenA.length); // bisherige Karten in das neue Array kopieren (die Referenzen)
		kartenNeu[kartenA.length] = newCard;  // die neue Karte oben auf den Stapel legen
		kartenA = kartenNeu;  // den neuen Stapel der Objektvariablen zuweisen
	}
	
	
	/**
	 * Test vom Konstruktor und push
	 * @param args
	 */
	public static void main(String[] args) {
		Kartenspiel spiel1 = new Kartenspiel();  // ein neues Spiel wird angelegt
		Kartenstapel stapel1 = new Kartenstapel(spiel1);  // das Spiel wird auf den Stapel gelegt
		
		Spielkarte karte1 = spiel1.getKartenAA()[0][0]; // kreuz 2 (beliebige Karte)
		Spielkarte karte2 = spiel1.getKartenAA()[1][0]; // pik 2 (beliebige Karte)
		
		stapel1.push(karte1);  //  stapel 1 hat zun�chst 52 karten - nach dem push sollten es 53 sein
		stapel1.push(karte2);  // nach dem zweiten push sollten es 54 sein (Achtung: der Index startet bei 0)

	}
}



 	



	

