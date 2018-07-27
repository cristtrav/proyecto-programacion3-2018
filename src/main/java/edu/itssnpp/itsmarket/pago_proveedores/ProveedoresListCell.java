
package edu.itssnpp.itsmarket.pago_proveedores;

import edu.itssnpp.itsmarket.entidades.Proveedor;
import javafx.scene.control.ListCell;


public class ProveedoresListCell extends ListCell <Proveedor> {
       @Override
      protected void updateItem(Proveedor item, boolean empty){
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
