package com.quick.controller;

import com.quick.dao.UsuarioDao;
import com.quick.dao.impl.UsuarioDaoImpl;
import com.quick.model.Usuario;
import com.quick.util.Util;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adrianow
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

    private Usuario usuario;

    public UsuarioBean() {
        this.usuario = new Usuario();
    }

    public String verificarUsuario() {
        UsuarioDaoImpl ud = new UsuarioDaoImpl();

        if (Invoker.validarUsuario(usuario)) {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            request.getSession().setAttribute("usuariologado", usuario);
            System.out.println("Passou no Login");
            this.usuario = new Usuario();
            return "/seguro/inicial.jsf";
        } else {
            System.out.println("nao passou");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário e/ou senha inválidos"));
            this.usuario = new Usuario();
            return null;
        }
    }

    public String logout() throws IOException {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        this.usuario = new Usuario();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Logout", "Logout realizado com sucesso"));
        return "/entrada.jsf";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
