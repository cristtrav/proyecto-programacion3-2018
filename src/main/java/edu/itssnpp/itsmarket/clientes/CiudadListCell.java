/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.clientes;

import edu.itssnpp.itsmarket.entidades.Ciudad;
import javafx.scene.control.ListCell;

/**
 *
 * @author fredy
 */
public class CiudadListCell extends ListCell <Ciudad> {
    @Override
    protected void updateItem(Ciudad item,boolean empty){
        if(!empty){
            this.setText(item.getNombre());
        }
        else
        {
            this.setText("");
        }
        super.updateItem(item, empty);
    }
    
}
