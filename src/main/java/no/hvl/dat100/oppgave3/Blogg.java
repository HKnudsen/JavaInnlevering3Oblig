package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.Tekst;

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
            if (tabell[i] != null) {
                if (innlegg.getId() == tabell[i].getId()) {
                    return i;
                }
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
		String returnString = String.valueOf(this.nesteLedig) + "\n";

        for (Innlegg i : this.tabell) {
            returnString += i.toString();
        }
        return returnString;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		int newLength = this.tabell.length * 2;
        Innlegg[] nyTabell = new Innlegg[newLength];
        for (int i = 0; i < this.tabell.length; i++) {
            nyTabell[i] = this.tabell[i];
        }
        this.tabell = nyTabell;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
        if (ledigPlass() && !finnes(innlegg)) {
            leggTil(innlegg);
            return true;
        } else if (!ledigPlass() && !finnes(innlegg)) {
            utvid();
            leggTil(innlegg);
            return true;
        }
		return false;
	}
	
	public boolean slett(Innlegg innlegg) {
        for (int i = 0; i < this.tabell.length; i++) {
            if (this.tabell[i] != null) {
                if (innlegg.getId() == this.tabell[i].getId()) {
                    this.tabell[i] = null;
                    return true;
                }
            }
        }

        return false;
	}
	
	public int[] search(String keyword) {
        int[] resultId;
        int antall = 0;
        int plassering = 0;

        for (int i = 0; i < this.tabell.length; i++) {
            if (tabell[i] != null) {
                antall++;
            }
        }

        resultId = new int[antall];

        for (int i = 0; i < this.tabell.length; i++) {
            if (tabell[i] != null) {
                if (tabell[i] instanceof Tekst) {
                    if (((Tekst) tabell[i]).getTekst().contains(keyword)) {
                        resultId[plassering] = tabell[i].getId();
                    }
                }
            }
        }
        return resultId;

	}
}