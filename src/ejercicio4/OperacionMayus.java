package ejercicio4;

public class OperacionMayus implements Main.Operacion<String>{
    @Override
    public String ejecutar(String valor) {
        return valor.toUpperCase();
    }
}
