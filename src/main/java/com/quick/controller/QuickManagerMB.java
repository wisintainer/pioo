package com.quick.controller;

import com.quick.dao.MassageadoDao;
import com.quick.dao.QuickDao;
import com.quick.dao.impl.MassageadoDaoImpl;
import com.quick.dao.impl.QuickDaoImpl;
import com.quick.exception.NoDataException;
import com.quick.model.Massageado;
import com.quick.model.Quick;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class QuickManagerMB implements Serializable {

    private Quick massagem;
    private boolean listavazia;
    private Massageado massageadoSelecionado;
    private List<Massageado> postergados;

    public QuickManagerMB() {
        this.massagem = new Quick();
        this.listavazia = false;
        this.massageadoSelecionado = new Massageado();
        this.postergados = new ArrayList<Massageado>();
    }

    public Quick getMassagem() {
        return massagem;
    }

    public List<Massageado> getPostergados() {
        return postergados;
    }

    public void setPostergados(List<Massageado> postergados) {
        this.postergados = postergados;
    }

    public Massageado getMassageadoSelecionado() {
        return massageadoSelecionado;
    }

    public void setMassageadoSelecionado(Massageado massageadoSelecionado) {
        this.massageadoSelecionado = massageadoSelecionado;
    }

    public boolean isListavazia() {
        return listavazia;
    }

    public void setListavazia(boolean listavazia) {
        this.listavazia = listavazia;
    }

    public void setMassagem(Quick massagem) {
        this.massagem = massagem;
    }

    public void sorteio() throws InterruptedException {
        QuickDao qd = new QuickDaoImpl();
        this.massagem.setMassageados(qd.sortearMassageados());
        Thread.sleep(5000);

    }

    public void confirmarMassagem() throws NoDataException, ParseException {
        try {
            MassageadoDao md = new MassageadoDaoImpl();
            for (int i = 0; i < this.massagem.getMassageados().size(); i++) {
                this.massagem.getMassageados().get(i).setUltimamassagem(new java.util.Date());
                md.atualizar(this.massagem.getMassageados().get(i));
                System.out.println("Atualizado data da massagem de: " + this.massagem.getMassageados().get(i).getNome() + " para: " + massagem.getMassageados().get(i).getUltimamassagem());
            }
            for (int i = 0; i < this.postergados.size(); i++) {
                SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy/MM/dd");
                Date date1 = dateformat3.parse("1950/01/01");
                this.postergados.get(i).setUltimamassagem(date1);
                md.atualizar(this.postergados.get(i));
            }
            this.massagem = new Quick();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Massagem confirmada!", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao confirmar massagem", ""));
            e.printStackTrace();
        }

    }

    public void adiarMassagem() throws NoDataException, ParseException {
        System.out.println("entrou no adiar");
        try {
            MassageadoDao md = new MassageadoDaoImpl();
            SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy/MM/dd");
            Date date1 = dateformat3.parse("2090/01/01");
            this.massageadoSelecionado.setUltimamassagem(date1);
            md.atualizar(this.massageadoSelecionado);
            this.postergados.add(massageadoSelecionado);
            this.massagem = new Quick();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Adiada massagem de " + this.massageadoSelecionado.getNome(), ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao adiantar, entre em contato com um administrador do sistema", ""));
            e.printStackTrace();
        }

    }

}
