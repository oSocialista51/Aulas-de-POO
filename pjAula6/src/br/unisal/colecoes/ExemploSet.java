package br.unisal.colecoes;

import java.util.Collection;
import java.util.TreeSet;

public class ExemploSet {
	public static void main(String[] args) {
		Collection c = new TreeSet();
		
		c.add("Jo�o");
		c.add("Maria");
		c.add("Lucas");
		c.add("Andr�");
		c.add("Madalena");
		c.add("Barnab�");
		c.add("Ana");
		
		System.out.println(c);

	}
}
