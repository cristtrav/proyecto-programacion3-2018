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
    public static final Modulo MODULO_CATEGORIA_PRODUCTO = new Modulo();
    public static final Modulo MODULO_COMPRA = new Modulo();
    

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
    //Funcionalidades
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
        // Se incializa los modulos
        MODULO_PRODUCTO.setIdmodulo(3);
        MODULO_PRODUCTO.setNombre("Producto");

        MODULO_CATEGORIA_PRODUCTO.setIdmodulo(4);
        MODULO_CATEGORIA_PRODUCTO.setNombre("Categoría de Producto");

        //se inicia las funcionalidades
        FUNCIONALIDAD_REGISTRAR_PRODUCTO.setIdfuncionalidad(4);
        FUNCIONALIDAD_REGISTRAR_PRODUCTO.setNombre("Registrar");
        FUNCIONALIDAD_REGISTRAR_PRODUCTO.setModulo(MODULO_PRODUCTO);
    }
    
    //Funcionalidades
    public static final Funcionalidad FUNCIONALIDAD_MODIFICAR_PRODUCTO = new Funcionalidad();

    static {

        //inicializa los modulos
        MODULO_PRODUCTO.setIdmodulo(3);
        MODULO_PRODUCTO.setNombre("Producto");

        //Se inicializa las Funcionalidades
        FUNCIONALIDAD_MODIFICAR_PRODUCTO.setIdfuncionalidad(5);
        FUNCIONALIDAD_MODIFICAR_PRODUCTO.setNombre("Modificar");
        FUNCIONALIDAD_MODIFICAR_PRODUCTO.setModulo(MODULO_PRODUCTO);
    }
    
    //Funcionalidades
     public static final Funcionalidad FUNCIONALIDAD_ELIMINAR_PRODUCTO= new Funcionalidad();

    static {

        //Incializa los modulos
        MODULO_CLIENTES.setIdmodulo(3);
        MODULO_CLIENTES.setNombre("Producto");
        

        //Se inicializa las Funciones 
        FUNCIONALIDAD_ELIMINAR_PRODUCTO.setIdfuncionalidad(6);
        FUNCIONALIDAD_ELIMINAR_PRODUCTO.setNombre("Eliminar");
        FUNCIONALIDAD_ELIMINAR_PRODUCTO.setModulo(MODULO_PRODUCTO);

    }
    
    
    //Funcionalidades
    public static final Funcionalidad FUNCIONALIDAD_REGISTRAR_COMPRA = new Funcionalidad();
    static {

        //Inicializa los modulos
        MODULO_CLIENTES.setIdmodulo(5);
        MODULO_CLIENTES.setNombre("Compra");

        //Se inicializan las funcionalidades
        FUNCIONALIDAD_REGISTRAR_COMPRA.setIdfuncionalidad(7);
        FUNCIONALIDAD_REGISTRAR_COMPRA.setNombre("Registrar");
        FUNCIONALIDAD_REGISTRAR_COMPRA.setModulo(MODULO_COMPRA);
    }
    
    
      public static final Funcionalidad FUNCIONALIDAD_MODIFICAR_COMPRA = new Funcionalidad();

    static {

        //inicializa los modulos
        MODULO_PRODUCTO.setIdmodulo(5);
        MODULO_PRODUCTO.setNombre("Compra");

        //Se inicializa las Funcionalidades
        FUNCIONALIDAD_MODIFICAR_COMPRA.setIdfuncionalidad(8);
        FUNCIONALIDAD_MODIFICAR_COMPRA.setNombre("Modificar");
        FUNCIONALIDAD_MODIFICAR_COMPRA.setModulo(MODULO_COMPRA);
    }


    public static void verificarModulos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(MODULO_CLIENTES);
        em.merge(MODULO_CATEGORIA_CLIENTES);
        em.merge(MODULO_PRODUCTO);
        em.merge(MODULO_CATEGORIA_PRODUCTO);
        em.merge(MODULO_COMPRA);

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
        em.merge(FUNCIONALIDAD_MODIFICAR_PRODUCTO);
        em.merge(FUNCIONALIDAD_ELIMINAR_PRODUCTO);
        em.merge(FUNCIONALIDAD_REGISTRAR_COMPRA);
        em.merge(FUNCIONALIDAD_MODIFICAR_COMPRA);

        em.getTransaction().commit();
    }

}
