/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.productos;

import edu.itssnpp.itsmarket.entidades.CategoriaProducto;
import javafx.scene.control.ListCell;

/**
 *
 * @author User
 */
public class CategoriaListCell  extends ListCell<CategoriaProducto>{
    @Override
    protected void updateItem(CategoriaProducto m, boolean empty){
        super.updateItem(m, empty);
        if (!empty){
            this.setText(m.getNombre());
        }else{
            this.setText("");
        }
    }
    
}
