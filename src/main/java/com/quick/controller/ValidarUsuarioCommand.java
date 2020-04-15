package com.quick.controller;

import com.quick.dao.UsuarioDao;
import com.quick.dao.impl.UsuarioDaoImpl;
import com.quick.model.Usuario;
import com.sun.org.apache.bcel.internal.generic.AASTORE;

/**
 *
 * @author adrianowisintainer
 */
public class ValidarUsuarioCommand implements Command {

    private Usuario usuario;

    public ValidarUsuarioCommand(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean executar() {
        UsuarioDao ud = new UsuarioDaoImpl();
        
        if (ud.validaUsuario(this.usuario)) {
            return true;
        } else {
            return false;
        }

    }

}
