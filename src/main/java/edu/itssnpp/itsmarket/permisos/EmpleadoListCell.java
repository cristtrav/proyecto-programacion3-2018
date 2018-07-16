
package edu.itssnpp.itsmarket.permisos;

import edu.itssnpp.itsmarket.entidades.Empleado;
import javafx.scene.control.ListCell;


public class EmpleadoListCell extends ListCell <Empleado> {
       @Override
      protected void updateItem(Empleado item, boolean empty){
          if(!empty){
              
              this.setText(item.getNombres());
          }
          else
          {
              this.setText("");
          }
          super.updateItem(item, empty);
      }
    
}
