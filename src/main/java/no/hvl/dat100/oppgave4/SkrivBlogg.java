package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		try {
            PrintWriter skriver = new PrintWriter(filnavn);
            String toText = samling.toString();
            skriver.println(toText);
            skriver.close();
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
	}
}
