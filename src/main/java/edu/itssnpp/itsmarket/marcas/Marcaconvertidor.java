/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.marcas;

import edu.itssnpp.itsmarket.entidades.Marca;
import javafx.scene.control.ListCell;

/**
 *
 * @author User
 */
public class Marcaconvertidor extends ListCell <Marca>{
    @Override
    protected void updateItem(Marca m, boolean e){
        if(!e){
            this.setText(m.getNombre());
        }else{
            this.setText("");
        }
        super.updateItem(m, e);
    }
}
