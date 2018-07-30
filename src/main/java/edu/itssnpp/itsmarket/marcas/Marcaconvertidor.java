/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.marcas;

import edu.itssnpp.itsmarket.entidades.Marca;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author User
 */
public class Marcaconvertidor extends ListCell<Marca> {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
    private final EntityManager em = emf.createEntityManager();
    String valorAnterior = "";

    @Override
    protected void updateItem(Marca m, boolean e) {
        if (!e) {
            this.setText(m.getNombre());
        } else {
            this.setText("");
        }
        super.updateItem(m, e);
    }

    
    @Override
    public void startEdit() {
        super.startEdit();
        TextField txf = new TextField();
                    
        txf.focusedProperty().addListener((ObservableValue<? extends Boolean>obs, Boolean oldValue, Boolean newValue)->{
            if(!newValue){
                this.cancelEdit();
            }
        });
        
        txf.setOnAction((e)->{
            Marca m=new Marca();
            m.setIdmarca(this.getItem().getIdmarca());
            m.setNombre(((TextField)e.getSource()).getText());
            this.commitEdit(m);
        });
        
        this.valorAnterior = this.getText();
        txf.setText(this.getText());
        this.setText("");
        this.setGraphic(txf);
        txf.requestFocus();
        txf.selectAll();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        this.setGraphic(null);
        this.setText(valorAnterior);
    }
    
    @Override
    public void commitEdit(Marca m){
        super.commitEdit(m);
        this.setGraphic(null);
        em.getTransaction().begin();
        em.merge(m);
        em.getTransaction().commit();
    }

}
