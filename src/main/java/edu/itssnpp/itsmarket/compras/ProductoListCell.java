package edu.itssnpp.itsmarket.compras;


import edu.itssnpp.itsmarket.entidades.Producto;
import javafx.scene.control.ListCell;


public class ProductoListCell extends ListCell <Producto>{
    @Override
    protected void updateItem(Producto item,boolean empty){
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
