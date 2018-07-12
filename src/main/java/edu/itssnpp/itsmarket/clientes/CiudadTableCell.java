/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.clientes;

import edu.itssnpp.itsmarket.entidades.Ciudad;
import edu.itssnpp.itsmarket.entidades.Cliente;
import javafx.scene.control.TableCell;

/**
 *
 * @author fredy
 */
public class CiudadTableCell extends TableCell<Cliente, Ciudad> {
    @Override
    protected void updateItem(Ciudad item, boolean empty){
        if(!empty && item!=null){
            this.setText(item.getNombre());
        }
        else{
            this.setText("");
        }
        super.updateItem(item, empty);
   } 
}
