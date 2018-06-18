/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.facturas;

import edu.itssnpp.itsmarket.entidades.DetalleVenta;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.TableCell;

/**
 *
 * @author equinox766
 */
public class FechaVentaTableCell extends TableCell<DetalleVenta, Date> {
    @Override
    protected void updateItem(Date item, boolean empty){
        if(!empty){
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
            this.setText(sdf.format(item));
        }else{
            this.setText("");
        }
        super.updateItem(item, empty);
    }
}
