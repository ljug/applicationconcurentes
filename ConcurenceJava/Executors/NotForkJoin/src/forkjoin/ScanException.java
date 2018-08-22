/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forkjoin;

/**
 *
 * @author pascalfares
 */
class ScanException extends Exception {

    ScanException(String chemin_à_scanner_non_valide_vide_ou_null_) {
        super(chemin_à_scanner_non_valide_vide_ou_null_);
    }
    
}
