package Utilidades;

public class ValidacionEntrada {

    public static int validacionOpUsuario(int rango1, int rango2) {
        while (true) {
            try {
                int opUsuario = EntradaUsuario.entradaOpMenu();
                if (opUsuario <= rango1 || opUsuario >= rango2) {
                    Mensaje.crearMensajePersonalizado("Opcion no valida intente de nuevo");
                } else {
                    return opUsuario;
                }
            } catch (Exception e) {
                Mensaje.crearMensajePersonalizado("Opcion no valida intente de nuevo");
            }
        }
    }

    public static int validacionMayor0(String mensaje) {
        while (true) {
            try {
                int opUsuario = EntradaUsuario.entradaOpMenu();
                if (opUsuario <= 0) {
                    Mensaje.crearMensajePersonalizado(mensaje);
                } else {
                    return opUsuario;
                }
            } catch (Exception e) {
                Mensaje.crearMensajePersonalizado("Valor no valido");
            }
        }
    }

    public static int validacionStock() {
        while (true) {
            try {
                int opUsuario = EntradaUsuario.entradaOpMenu();
                if (opUsuario < 0) {
                    Mensaje.crearMensajePersonalizado("El stock no puede ser negativo");
                } else {
                    return opUsuario;
                }
            } catch (Exception e) {
                Mensaje.crearMensajePersonalizado("Valor no valido");
            }
        }
    }
    
    

    public static String validarString(){
        String texto;
        do {
            texto = EntradaUsuario.entradaString().trim();
            if (texto.isEmpty()) {
                Mensaje.crearMensajePersonalizado("Texto vacio intente denuevo");
            }
        } while (texto.isEmpty());
        return texto;
    }

    public static String validarCorreo() {
        String correoValido = "[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}";
        String correo;
        do {
            correo = validarString();
            if (!correo.matches(correoValido)) {
                Mensaje.crearMensajePersonalizado("Esto no es un correo intente denuevo");
            }
        } while (!correo.matches(correoValido));
        return correo;
    }
    
    
    

}
