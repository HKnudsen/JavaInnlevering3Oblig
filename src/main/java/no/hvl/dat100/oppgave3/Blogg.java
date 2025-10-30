package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] tabell;
    private int nesteLedig = 0;

	public Blogg() {
        this.tabell = new Innlegg[20];
    }
	public Blogg(int lengde) {
		this.tabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return this.tabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
        for (int i = 0; i < tabell.length; i++){
            if (innlegg.getId() == tabell[i].getId()) {
                return i;
            }
        }
        return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		if (this.finnInnlegg(innlegg) != -1) {
            return true;
        }
        return false;
	}

	public boolean ledigPlass() {
		for (Innlegg i : this.tabell) {
            if (i == null) {
                return true;
            }
        }
        return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
        if (ledigPlass() && !finnes(innlegg)) {
            this.tabell[nesteLedig] = innlegg;
            this.nesteLedig += 1;
            return true;
        }
        return false;
	}
	
	public String toString() {
		String returnString = "";

        for (Innlegg i : this.tabell) {
            returnString += i.toString();
        }
        return returnString;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}