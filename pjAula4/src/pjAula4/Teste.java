package pjAula4;

public class Teste {
	 public static void main (String[] args) {
		 Calculadora calc = new Calculadora();
		 
		 long v1 = 45;
		 long v2 = 65;
		 System.out.println(calc.soma(v1, v2));
		 
		 int a = 123;
		 int b = 456;
		 System.out.println(calc.soma(a,  b));
		 
		 System.out.println(calc.soma("7", "5"));
		 
		 System.out.println(calc.soma(8, 4, 16));
		 
		 System.out.println(calc.soma(12,1,4,5,18, 15, -2));
		 
		 System.out.println(calc.soma("123", "546", "345", "852", "753", "951"));
	 }
}
