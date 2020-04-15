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
public class CommitException extends Exception {

    public CommitException() {
    }

    public CommitException(String string) {
        super(string);
    }

    public CommitException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public CommitException(Throwable thrwbl) {
        super(thrwbl);
    }

    public CommitException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
