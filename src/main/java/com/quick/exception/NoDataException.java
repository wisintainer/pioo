/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quick.exception;

/**
 *
 * @author adrianowisintainer
 */
public class NoDataException extends Exception{

    public NoDataException() {
    }

    public NoDataException(String string) {
        super(string);
    }

    public NoDataException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public NoDataException(Throwable thrwbl) {
        super(thrwbl);
    }

    public NoDataException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
