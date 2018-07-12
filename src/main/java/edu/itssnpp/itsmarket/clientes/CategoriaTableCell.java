/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.clientes;

import edu.itssnpp.itsmarket.entidades.CategoriaCliente;
import edu.itssnpp.itsmarket.entidades.Cliente;
import javafx.scene.control.TableCell;

/**
 *
 * @author fredy
 */
public class CategoriaTableCell extends TableCell<Cliente, CategoriaCliente> {
    @Override
    protected void updateItem(CategoriaCliente item, boolean empty){
        if(!empty && item!=null){
            this.setText(item.getNombre());
        }
        else{
            this.setText("");
        }
        super.updateItem(item, empty);
   } 
}
