/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quick.controller;

import com.quick.dao.UsuarioDao;
import com.quick.dao.impl.UsuarioDaoImpl;
import com.quick.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author adrianowisintainer
 */
@ManagedBean
@ViewScoped
public class UsuarioManagerMB implements Serializable {

    private Usuario usuario;
    private Usuario usuarioselecionado;
    private List<Usuario> usuarios;

    public Usuario getUsuarioselecionado() {
        return usuarioselecionado;
    }

    public void setUsuarioselecionado(Usuario usuarioselecionado) {
        this.usuarioselecionado = usuarioselecionado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public UsuarioManagerMB() {
        this.usuario = new Usuario();
        listarTodosOsUsuarios();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void cadastrarUsuario() {
        try {
            UsuarioDao udi = new UsuarioDaoImpl();
            udi.cadastrar(this.usuario);
            this.usuario = new Usuario();
            listarTodosOsUsuarios();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário criado com sucesso!", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar usuário!", e.getMessage()));
        }

    }

    public void alterarUsuario() {
        try {
            UsuarioDao ud = new UsuarioDaoImpl();
            ud.atualizar(this.usuarioselecionado);
            this.usuarioselecionado = new Usuario();
            listarTodosOsUsuarios();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário atualizado com sucesso!", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar usuário", e.getMessage()));
        }
    }

    public void excluirUsuario() {
        try {
            UsuarioDao ud = new UsuarioDaoImpl();
            ud.remover(this.usuarioselecionado);
            this.usuarioselecionado = new Usuario();
            listarTodosOsUsuarios();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário excluído com sucesso!", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir usuário", e.getMessage()));
        }
    }

    public void listarTodosOsUsuarios() {
        UsuarioDao udi = new UsuarioDaoImpl();
        this.usuarios = udi.pesquisarTodos(usuario);
    }

}
