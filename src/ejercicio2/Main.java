
package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;

import utilidades.Utilidades;

public class Main {

    public static int menu() {

        System.out.println("\n* * * * * M E N U * * * * *"
                + "\n1. Buscar pedidos con importe superior a 1000 €."
                + "\n2. Buscar pedidos que no estén pagados."
                + "\n3. Mostrar número y cliente de cada pedido."
                + "\n4. Mostrar avisos de pedidos no pagados."
                + "\n5. Transformar pedidos a CSV."
                + "\n6. Transformar pedidos a descripción."
                + "\n0. Salir");

        System.out.print("Que quieres hacer: ");

        return Utilidades.leerInt(0, 6);
    }

    public static ArrayList<Pedido> fillDataPedido() {

        ArrayList<Pedido> lista = new ArrayList<>();

        lista.add(new Pedido(1, "Ana", 1200, true));
        lista.add(new Pedido(2, "Carlos", 350, false));
        lista.add(new Pedido(3, "Marta", 800, true));
        lista.add(new Pedido(4, "Luis", 1500, false));

        return lista;
    }

    public static void main(String[] args) {

        List<Pedido> pedidos = fillDataPedido();

        int opcion;

        do {

            opcion = menu();

            switch (opcion) {

            //  1- BUSCAR PEDIDOS SUPERIORES A 1000 €
            case 1:

                List<Pedido> pedidosImporte = GestorPedidos.buscar(pedidos, new Predicate<Pedido>() {

                    @Override
                    public boolean test(Pedido pedido) {
                        return pedido.getImporte() > 1000;
                    }

                });

                for (Pedido p : pedidosImporte) {
                    System.out.println(p);
                }

                break;

            //  1- BUSCAR PEDIDOS NO PAGADOS
            case 2:

                List<Pedido> pedidosNoPagados = GestorPedidos.buscar(pedidos, new Predicate<Pedido>() {

                    @Override
                    public boolean test(Pedido pedido) {
                        return !pedido.isPagado();
                    }

                });

                for (Pedido p : pedidosNoPagados) {
                    System.out.println(p);
                }

                break;

            //  3- MOSTRAR NUMERO Y CLIENTE
            case 3:

                GestorPedidos.procesar(pedidos, new Consumer<Pedido>() {

                    @Override
                    public void accept(Pedido pedido) {

                        System.out.println("Número: " + pedido.getNumero() + "\nCliente: " + pedido.getCliente());

                    }

                });

                break;

            //  3- AVISAR PEDIDOS NO PAGADOS
            case 4:

                GestorPedidos.procesar(pedidos, new Consumer<Pedido>() {

                    @Override
                    public void accept(Pedido pedido) {

                        if (!pedido.isPagado()) {

                            System.out.println( pedido.getCliente()+ " no ha pagado.");

                        }

                    }

                });

                break;

            //  2- TRANSFORMAR A CSV
            case 5:

                List<String> csv = GestorPedidos.transformar(pedidos, new Function<Pedido, String>() {

                    @Override
                    public String apply(Pedido pedido) {

                        return pedido.getNumero() + ";" + pedido.getCliente() + ";" + pedido.getImporte() + ";" + pedido.isPagado();

                    }

                });

                for (String linea : csv) {
                    System.out.println(linea);
                }

                break;

            //  2- TRANSFORMAR A DESCRIPCION
            case 6:

                List<String> descripciones = GestorPedidos.transformar(pedidos, new Function<Pedido, String>() {

                    @Override
                    public String apply(Pedido pedido) {

                        return "Pedido " + pedido.getNumero() + " - Cliente: " + pedido.getCliente() + " - Importe: " + pedido.getImporte() + " €";

                    }

                });

                for (String descripcion : descripciones) {
                    System.out.println(descripcion);
                }

                break;

            case 0:

                System.out.println("Saliendo del programa...");

                break;

            }

        } while (opcion != 0);

    }
}