/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.facturas;

import edu.itssnpp.itsmarket.entidades.Producto;
import javafx.scene.control.ListCell;

/**
 *
 * @author equinox766
 */
public class CargaPrecioLIstCell extends ListCell<Producto>{
    @Override
    protected void updateItem(Producto p, boolean empty){
        super.updateItem(p, empty);
        if (!empty){
            this.setText(p.getIdproducto()+ "-" +p.getPrecioVenta());
        } else{
            this.setText(" ");
        }
    }
}
