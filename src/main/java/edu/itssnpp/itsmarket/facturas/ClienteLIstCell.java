/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.facturas;

import edu.itssnpp.itsmarket.entidades.Cliente;
import javafx.scene.control.ListCell;

/**
 *
 * @author equinox766
 */
public class ClienteLIstCell  extends ListCell<Cliente>{

    @Override
    protected void updateItem(Cliente p, boolean empty){
        super.updateItem(p, empty);
        if (!empty){
            this.setText(p.getNombres()+ " " +p.getApellidos());
            
        } else{
            this.setText(" ");
        }
    }
    
}
