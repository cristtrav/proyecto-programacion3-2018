
package edu.itssnpp.itsmarket.permisos;

import edu.itssnpp.itsmarket.entidades.Funcionalidad;
import javafx.scene.control.ListCell;

/**
 *
 * @author estela
 */
public class FuncionalidadListCell extends ListCell<Funcionalidad> {
    @Override
    protected void updateItem(Funcionalidad item, boolean empty){
        if(!empty)
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
