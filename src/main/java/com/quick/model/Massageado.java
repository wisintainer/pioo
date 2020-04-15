package com.quick.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author adrianowisintainer
 */
@Entity
@DiscriminatorValue(value = "M")
public class Massageado extends Analista {

    public Massageado(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;
    }

    public Massageado() {
    }

    private String telefone;
    private String email;
    private Date ultimamassagem;

    public String getTelefone() {
        return telefone;
    }

    public Date getUltimamassagem() {
        return ultimamassagem;
    }

    public String getUltimamassagemAsString() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dataAntiga = sdf.parse("1949-12-31");
        if (this.getUltimamassagem().compareTo(dataAntiga) == 0) {
            return "Transferido da última Quick";
        } else {
            return new SimpleDateFormat("dd 'de' MMMM 'de' yyyy").format(this.getUltimamassagem());
        }

    }

    public void setUltimamassagem(Date ultimamassagem) {
        this.ultimamassagem = ultimamassagem;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
