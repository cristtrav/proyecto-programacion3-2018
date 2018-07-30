
package edu.itssnpp.itsmarket.productos;

import edu.itssnpp.itsmarket.entidades.Marca;
import javafx.scene.control.ListCell;

public class MarcasListCell  extends ListCell<Marca>{
    @Override
    protected void updateItem(Marca m, boolean empty){
        super.updateItem(m, empty);
        if (!empty){
            this.setText(m.getNombre());
        }else{
            this.setText("");
        }
    }
    
}
