package com.quick.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author adrianowisintainer
 */
@Entity
@DiscriminatorValue(value = "A")
public abstract class Analista extends Funcionario {
    private String area;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
