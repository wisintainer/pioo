package com.quick.controller;

import com.quick.dao.MassageadoDao;
import com.quick.dao.impl.MassageadoDaoImpl;
import com.quick.model.Massageado;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class MassageadoManagerMB implements Serializable {
    
    private Massageado massageado;
    private Massageado massageadoselecionado;
    private List<Massageado> massageados;
    
    public MassageadoManagerMB() {
        this.massageado = new Massageado();
        buscarTodosMassageados();
    }
    
    public Massageado getMassageadoselecionado() {
        return massageadoselecionado;
    }
    
    public void setMassageadoselecionado(Massageado massageadoselecionado) {
        this.massageadoselecionado = massageadoselecionado;
    }
    
    public List<Massageado> getMassageados() {
        return massageados;
    }
    
    public void setMassageados(List<Massageado> massageados) {
        this.massageados = massageados;
    }
    
    public Massageado getMassageado() {
        return massageado;
    }
    
    public void setMassageado(Massageado massageado) {
        this.massageado = massageado;
    }
    
    public void cadastrarMassageado() {
        try {
            MassageadoDao md = new MassageadoDaoImpl();
            SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy/MM/dd");
            Date date1 = dateformat3.parse("1950/01/01");
            this.massageado.setUltimamassagem(date1);
            md.cadastrar(this.massageado);
            this.massageado = new Massageado();
            buscarTodosMassageados();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Massageado criado com sucesso!", ""));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar massageado", e.getMessage()));
        }
    }
    
    public void alterarMassageado() {
        try {
            System.out.println("Entrou no atualizar");
            MassageadoDao md = new MassageadoDaoImpl();
            md.atualizar(this.massageadoselecionado);
            System.out.println("passou por atualizar");
            this.massageadoselecionado = new Massageado();
            buscarTodosMassageados();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Massageado atualizado com sucesso!", ""));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar massageado", e.getMessage()));
        }
    }
    
    public void excluirMassageado() {
        try {
            MassageadoDao md = new MassageadoDaoImpl();
            md.remover(this.massageadoselecionado);
            this.massageadoselecionado = new Massageado();
            buscarTodosMassageados();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Massageado excluído com sucesso!", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir massageado", e.getMessage()));
        }
    }
    
    public void buscarTodosMassageados() {
        MassageadoDao md = new MassageadoDaoImpl();
        this.massageados = md.pesquisarTodos(new Massageado());
    }
    
}
