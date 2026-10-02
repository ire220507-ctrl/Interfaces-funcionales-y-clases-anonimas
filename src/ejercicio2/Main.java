package ejercicio2;

import java.util.ArrayList;
import java.util.List;

import utilidades.Utilidades;

public class Main {


	public static int menu() {
		System.out.println("* * * * * M E N U * * * * *"
				+ "\n 1.Mostrar por pantalla el número y el cliente de cada pedido."
				+ "\n 2.Mostrar un mensaje de aviso únicamente para los pedidos que no estén pagados."
				+ "\n 0.Salir");
		System.out.print("Que quieres hacer: ");
		return Utilidades.leerInt(1, 5);
	}

	public static ArrayList<Pedido> fillDataPedido() {
	    ArrayList<Pedido> lista = new ArrayList<>();
	    lista.add(new Pedido(1, "Cliente A", 120.50, true));
	    lista.add(new Pedido(2, "Cliente B", 89.99, false));
	    lista.add(new Pedido(3, "Cliente C", 45.00, true));
	    return lista;
	}
	
	public static void main(String[] args) { 
		List<Pedido> pedidos = new ArrayList<>();
		int opcion;
		//fill data para llenar el arraylist
		pedidos=fillDataPedido();
		
		do{
			opcion = menu();
			switch(opcion){
			case 1:
				
				break;
			case 2:
				for (Pedido p : pedidos) { //reocrrer la lista objeto a objeto 
	                procesarPedido(p, new AccionPedido() { //llamo al metodo y le paso le pedido actual y  una clase anonima que implementa la interfaz 
	                    @Override //sobre escribo el metodo 
	                    public void ejecutar(Pedido pedido) {
	                        if (!pedido.isPagado()) { 
	                            System.out.println("AVISO!: " + pedido.getCliente() + " no ha pagado.");
	                        }
	                    }
	                });
	            }
				break;
			}
		}while(opcion!=0);
	}
	
	public static void procesarPedido(Pedido pedido, AccionPedido accion) {
        accion.ejecutar(pedido);
    }
	
	
}