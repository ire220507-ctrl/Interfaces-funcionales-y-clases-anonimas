package ejercicio4;

public class Main {

    public static void main(String[] args) {

        //CALSE ANONIMA 
        Operacion<Integer> doble = new Operacion<Integer>() {
            @Override
            public Integer ejecutar(Integer valor) {
                return valor * 2;
            }
        };
        System.out.println("Doble: " + doble.ejecutar(10));

        //CLASE NORMAL 
        Operacion<String> mayus = new OperacionMayus();
        System.out.println("Mayúsculas: " + mayus.ejecutar("hola"));
    }

    @FunctionalInterface
    public interface Operacion<T> {
        T ejecutar(T valor);
    }
}
