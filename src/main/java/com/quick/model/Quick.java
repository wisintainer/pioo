package com.quick.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author adrianowisintainer
 */
public class Quick {

    private Integer id;
    private List<Massageado> massageados;
    private Date data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Massageado> getMassageados() {
        return massageados;
    }

    public void setMassageados(List<Massageado> massageados) {
        this.massageados = massageados;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
