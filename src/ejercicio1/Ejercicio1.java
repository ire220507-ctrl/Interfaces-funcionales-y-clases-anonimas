package ejercicio1;

import java.util.function.*;

public class Ejercicio1 {
	
	
/*	public class EsMayorDeEdad implements Predicate<Integer> {

	 	@Override
	 	public boolean test(Integer edad) {
	 		return edad >= 18;
	 	}
	 }
	Predicate<Integer> p = new EsMayorDeEdad();

	 System.out.println(p.test(20));*/
	
	Predicate<Integer> EsMayorDeEdad = new Predicate <Integer>(){
		@Override
		public boolean test(Integer edad) {
			return edad>=18;
		}
	};
	
	
	 Function<String, Integer> longitudTexto = new Function<String, Integer>() {
		    @Override
		    public Integer apply(String texto) {
		        return texto.length();
		    }
		};
		
		
	/*1.3
	public class MostrarTexto implements Consumer<String> {

	 	@Override
	 	public void accept(String texto) {
	 		System.out.println(texto);
	 	}
	 }*/
		
		Consumer<String> MostrarTexto=new Consumer<String>() {
			@Override
			public void accept(String texto) {
				System.out.println(texto);
			}
		};

}
