/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.clientes;

import edu.itssnpp.itsmarket.entidades.CategoriaCliente;
import javafx.scene.control.ListCell;

/**
 *
 * @author fredy
 */
public class CategoriaClienteListCell extends ListCell <CategoriaCliente> {
    @Override
    protected void updateItem(CategoriaCliente item,boolean empty){
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
