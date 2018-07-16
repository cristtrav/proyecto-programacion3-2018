
package edu.itssnpp.itsmarket.permisos;

import edu.itssnpp.itsmarket.entidades.Modulo;
import javafx.scene.control.ListCell;


public class ModulosListCell extends ListCell<Modulo> {
    @Override
     protected void updateItem(Modulo item, boolean empty){
         
         if (!empty)
         {
             this.setText(item.getNombre());
         }
         else
         {
             this.setText("");
         }
         super.updateItem(item, empty);
     }
    
    
}
