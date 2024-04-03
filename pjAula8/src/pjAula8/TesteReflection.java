package pjAula8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TesteReflection {
	public static void main(String[] args) {
		List<String> listaNegra = new ArrayList<String>();
		listaNegra.add("teste");
		listaNegra.add("agoravai");
		listaNegra.add("zueira");
		
		Field[] campos = NotaFiscal.class.getDeclaredFields();
		for(Field f : campos) {
			System.out.println(f.getType() + " " + f.getName());
			if(f.getName().length() <6) {
				System.err.println("Não atende ao padrão");
			}
		}
		
		Method[] metodos = NotaFiscal.class.getDeclaredMethods();
		for(Method m : metodos) {
			if(listaNegra.contains(m.getName())) {
				System.err.println(m.getName() + " não é um nome de método válido");
			}
			
			System.out.println(m.getName() + " " + m.getReturnType());
		}
		
	}

}
