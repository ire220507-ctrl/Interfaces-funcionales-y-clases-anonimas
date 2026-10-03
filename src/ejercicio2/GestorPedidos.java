
package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;

public class GestorPedidos {

    //  1 BUSCAR PEDIDOS
    public static List<Pedido> buscar(List<Pedido> pedidos, Predicate<Pedido> condicion) {

        List<Pedido> resultado = new ArrayList<>();

        for (Pedido p : pedidos) {

            if (condicion.test(p)) {
                resultado.add(p);
            }

        }

        return resultado;
    }

    //  2 TRANSFORMAR PEDIDOS
    public static List<String> transformar(List<Pedido> pedidos, Function<Pedido, String> transformacion) {

        List<String> resultado = new ArrayList<>();

        for (Pedido p : pedidos) {

            resultado.add(transformacion.apply(p));

        }

        return resultado;
    }

    // 3 PROCESAR PEDIDOS
    public static void procesar(List<Pedido> pedidos, Consumer<Pedido> accion) {

        for (Pedido p : pedidos) {

            accion.accept(p);

        }

    }
}