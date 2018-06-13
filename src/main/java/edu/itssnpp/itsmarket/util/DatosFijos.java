package edu.itssnpp.itsmarket.util;

import edu.itssnpp.itsmarket.entidades.Funcionalidad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import edu.itssnpp.itsmarket.entidades.Modulo;

public class DatosFijos {

    //Modulos
    public static final Modulo MODULO_CLIENTES = new Modulo();
    public static final Modulo MODULO_CATEGORIA_CLIENTES = new Modulo();
    public static final Modulo MODULO_PRODUCTO = new Modulo();
    
    //Funcionalidades
    public static final Funcionalidad FUNCIONALIDAD_REGISTRAR_CLIENTES = new Funcionalidad();

    static {

        //Inicializa los modulos
        MODULO_CLIENTES.setIdmodulo(1);
        MODULO_CLIENTES.setNombre("Cliente");

        MODULO_CATEGORIA_CLIENTES.setIdmodulo(2);
        MODULO_CATEGORIA_CLIENTES.setNombre("Categoría de Clientes");

        //Se inicializan las funcionalidades
        FUNCIONALIDAD_REGISTRAR_CLIENTES.setIdfuncionalidad(1);
        FUNCIONALIDAD_REGISTRAR_CLIENTES.setNombre("Registrar");
        FUNCIONALIDAD_REGISTRAR_CLIENTES.setModulo(MODULO_CLIENTES);
    }
    //Funcionles
    public static final Funcionalidad FUNCIONALIDAD_MODIFICAR_CLIENTES = new Funcionalidad();

    static {

        //inicializa los modulos
        MODULO_CLIENTES.setIdmodulo(1);
        MODULO_CLIENTES.setNombre("Cliente");

        //Se inicializa las Funcionalidades
        FUNCIONALIDAD_MODIFICAR_CLIENTES.setIdfuncionalidad(2);
        FUNCIONALIDAD_MODIFICAR_CLIENTES.setNombre("Modificar");
        FUNCIONALIDAD_MODIFICAR_CLIENTES.setModulo(MODULO_CLIENTES);
    }

    public static final Funcionalidad FUNCIONALIDAD_ELIMINAR_CLIENTES = new Funcionalidad();

    static {

        //Incializa los modulos
        MODULO_CLIENTES.setIdmodulo(1);
        MODULO_CLIENTES.setNombre("Cliente");

        //Se inicializa las Funciones 
        FUNCIONALIDAD_ELIMINAR_CLIENTES.setIdfuncionalidad(3);
        FUNCIONALIDAD_ELIMINAR_CLIENTES.setNombre("Eliminar");
        FUNCIONALIDAD_ELIMINAR_CLIENTES.setModulo(MODULO_CLIENTES);

    }

    public static final Funcionalidad FUNCIONALIDAD_REGISTRAR_PRODUCTO = new Funcionalidad();

    static {

        MODULO_PRODUCTO.setIdmodulo(3);
        MODULO_PRODUCTO.setNombre("Producto");

        FUNCIONALIDAD_REGISTRAR_PRODUCTO.setIdfuncionalidad(4);
        FUNCIONALIDAD_REGISTRAR_PRODUCTO.setNombre("Registrar");
        FUNCIONALIDAD_REGISTRAR_PRODUCTO.setModulo(MODULO_PRODUCTO);
    }

    public static void verificarModulos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(MODULO_CLIENTES);
        em.merge(MODULO_CATEGORIA_CLIENTES);
        em.merge(MODULO_PRODUCTO);

        em.getTransaction().commit();
    }

    public static void verificarFuncionalidades() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.merge(FUNCIONALIDAD_REGISTRAR_CLIENTES);
        em.merge(FUNCIONALIDAD_MODIFICAR_CLIENTES);
        em.merge(FUNCIONALIDAD_ELIMINAR_CLIENTES);
        em.merge(FUNCIONALIDAD_REGISTRAR_PRODUCTO);

        em.getTransaction().commit();
    }

}
