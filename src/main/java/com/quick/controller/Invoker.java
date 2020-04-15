package com.quick.controller;

import com.quick.model.Usuario;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author adrianowisintainer
 */
public class Invoker {

    public static Map<String, Command> comandos = new HashMap<String, Command>();

    public static boolean validarUsuario(Usuario usuario) {
        ValidarUsuarioCommand vuc = new ValidarUsuarioCommand(usuario);
        if (vuc.executar()) {
            return true;
        } else {
            return false;
        }
    }

}
