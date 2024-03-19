package pjAula4;

public abstract class OperacaoMatematica {
	public abstract double calcular(double a, double b);
	
	public void getTipo() {
		System.out.println("Escolhido " + this.getClass().getName());
	}
}
