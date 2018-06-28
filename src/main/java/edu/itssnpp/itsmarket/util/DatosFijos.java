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
    public static final Modulo MODULO_EMPLEADO = new Modulo();
    public static final Modulo MODULO_PROVEEDOR = new Modulo();
    public static final Modulo MODULO_VENTA= new Modulo();
    public static final Modulo MODULO_PROMOCION= new Modulo();
    public static final Modulo MODULO_TIMBRADO= new Modulo();
  
    
   

    //Funcionalidades
    public static final Funcionalidad FUNCIONALIDAD_MODIFICAR_CLIENTES = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_ELIMINAR_CLIENTES = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_REGISTRAR_CLIENTES = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_REGISTRAR_PRODUCTO = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_MODIFICAR_PRODUCTO = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_ELIMINAR_PRODUCTO = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_REGISTRAR_COMPRA = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_MODIFICAR_COMPRA = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_ELIMINAR_COMPRA = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_REGISTRAR_EMPLEADO = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_MODIFICAR_EMPLEADO = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_ELIMINAR_EMPLEADO = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_REGISTRAR_PROVEEDOR = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_MODIFICAR_PROVEEDOR = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_ELIMINAR_PROVEEDOR = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_REGISTRAR_VENTA = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_MODIFICAR_VENTA = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_ELIMINAR_VENTA = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_AGREGAR_CATEGORIA_CLIENTES = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_MODIFICAR_CATEGORIA_CLIENTES = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_ELIMINAR_CATEGORIA_CLIENTES = new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_AGREGAR_CATEGORIA_PRODUCTO= new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_MODIFICAR_CATEGORIA_PRODUCTO= new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_ELIMINAR_CATEGORIA_PRODUCTO= new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_AGREGAR_PROMOCION= new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_MODIFICAR_PROMOCION= new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_ELIMINAR_PROMOCION= new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_AGREGAR_TIMBRADO= new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_MODIFICAR_TIMBRADO= new Funcionalidad();
    public static final Funcionalidad FUNCIONALIDAD_ELIMINAR_TIMBRADO= new Funcionalidad();
    
    
    static {

        //SE INICIALIZA LOS MODULOS
        MODULO_CLIENTES.setIdmodulo(1);
        MODULO_CLIENTES.setNombre("Cliente");

        MODULO_CATEGORIA_CLIENTES.setIdmodulo(2);
        MODULO_CATEGORIA_CLIENTES.setNombre("Categoría de Clientes");
        
        MODULO_PRODUCTO.setIdmodulo(3);
        MODULO_PRODUCTO.setNombre("Producto");
        
        MODULO_CATEGORIA_PRODUCTO.setIdmodulo(4);
        MODULO_CATEGORIA_PRODUCTO.setNombre("Categoría de Producto");
        
        MODULO_COMPRA.setIdmodulo(5);
        MODULO_COMPRA.setNombre("Compra");
        
        MODULO_EMPLEADO.setIdmodulo(6);
        MODULO_EMPLEADO.setNombre("Empleado");
        
        MODULO_PROVEEDOR.setIdmodulo(7);
        MODULO_PROVEEDOR.setNombre("Proveedor");
        
        MODULO_VENTA.setIdmodulo(8);
        MODULO_VENTA.setNombre("Venta");
        
        MODULO_PROMOCION.setIdmodulo(9);
        MODULO_PROMOCION.setNombre("Promoción");
        
        MODULO_TIMBRADO.setIdmodulo(10);
        MODULO_TIMBRADO.setNombre("Timbrado");
        
        
                //SE INICIALIZA LAS FUNCIONES
        FUNCIONALIDAD_REGISTRAR_CLIENTES.setIdfuncionalidad(1);
        FUNCIONALIDAD_REGISTRAR_CLIENTES.setNombre("Registrar Clientes");
        FUNCIONALIDAD_REGISTRAR_CLIENTES.setModulo(MODULO_CLIENTES);

        FUNCIONALIDAD_MODIFICAR_CLIENTES.setIdfuncionalidad(2);
        FUNCIONALIDAD_MODIFICAR_CLIENTES.setNombre("Modificar Clientes");
        FUNCIONALIDAD_MODIFICAR_CLIENTES.setModulo(MODULO_CLIENTES);

        FUNCIONALIDAD_ELIMINAR_CLIENTES.setIdfuncionalidad(3);
        FUNCIONALIDAD_ELIMINAR_CLIENTES.setNombre("Eliminar Clientes");
        FUNCIONALIDAD_ELIMINAR_CLIENTES.setModulo(MODULO_CLIENTES);
        

        FUNCIONALIDAD_REGISTRAR_PRODUCTO.setIdfuncionalidad(4);
        FUNCIONALIDAD_REGISTRAR_PRODUCTO.setNombre("Registrar Productos");
        FUNCIONALIDAD_REGISTRAR_PRODUCTO.setModulo(MODULO_PRODUCTO);

        FUNCIONALIDAD_MODIFICAR_PRODUCTO.setIdfuncionalidad(5);
        FUNCIONALIDAD_MODIFICAR_PRODUCTO.setNombre("Modificar Productos");
        FUNCIONALIDAD_MODIFICAR_PRODUCTO.setModulo(MODULO_PRODUCTO);
 
        FUNCIONALIDAD_ELIMINAR_PRODUCTO.setIdfuncionalidad(6);
        FUNCIONALIDAD_ELIMINAR_PRODUCTO.setNombre("Eliminar Producto");
        FUNCIONALIDAD_ELIMINAR_PRODUCTO.setModulo(MODULO_PRODUCTO);

        FUNCIONALIDAD_REGISTRAR_COMPRA.setIdfuncionalidad(7);
        FUNCIONALIDAD_REGISTRAR_COMPRA.setNombre("Registrar Compra");
        FUNCIONALIDAD_REGISTRAR_COMPRA.setModulo(MODULO_COMPRA);

        FUNCIONALIDAD_MODIFICAR_COMPRA.setIdfuncionalidad(8);
        FUNCIONALIDAD_MODIFICAR_COMPRA.setNombre("Modificar Compra");
        FUNCIONALIDAD_MODIFICAR_COMPRA.setModulo(MODULO_COMPRA);

        FUNCIONALIDAD_ELIMINAR_COMPRA.setIdfuncionalidad(9);
        FUNCIONALIDAD_ELIMINAR_COMPRA.setNombre("Eliminar Compra");
        FUNCIONALIDAD_ELIMINAR_COMPRA.setModulo(MODULO_COMPRA);

        FUNCIONALIDAD_REGISTRAR_EMPLEADO.setIdfuncionalidad(10);
        FUNCIONALIDAD_REGISTRAR_EMPLEADO.setNombre("Registrar Empleado");
        FUNCIONALIDAD_REGISTRAR_EMPLEADO.setModulo(MODULO_EMPLEADO);

        FUNCIONALIDAD_MODIFICAR_EMPLEADO.setIdfuncionalidad(11);
        FUNCIONALIDAD_MODIFICAR_EMPLEADO.setNombre("Modificar Empleado");
        FUNCIONALIDAD_MODIFICAR_EMPLEADO.setModulo(MODULO_EMPLEADO);

        FUNCIONALIDAD_ELIMINAR_EMPLEADO.setIdfuncionalidad(12);
        FUNCIONALIDAD_ELIMINAR_EMPLEADO.setNombre("Eliminar Empleado");
        FUNCIONALIDAD_ELIMINAR_EMPLEADO.setModulo(MODULO_EMPLEADO);
        
        FUNCIONALIDAD_REGISTRAR_PROVEEDOR.setIdfuncionalidad(13);
        FUNCIONALIDAD_REGISTRAR_PROVEEDOR.setNombre("Registrar Proveedor");
        FUNCIONALIDAD_REGISTRAR_PROVEEDOR.setModulo(MODULO_PROVEEDOR);
        
        FUNCIONALIDAD_MODIFICAR_PROVEEDOR.setIdfuncionalidad(14);
        FUNCIONALIDAD_MODIFICAR_PROVEEDOR.setNombre("Modificar Proveedor");
        FUNCIONALIDAD_MODIFICAR_PROVEEDOR.setModulo(MODULO_PROVEEDOR);
        
                
        FUNCIONALIDAD_ELIMINAR_PROVEEDOR.setIdfuncionalidad(15);
        FUNCIONALIDAD_ELIMINAR_PROVEEDOR.setNombre("Eliminar Proveedor");
        FUNCIONALIDAD_ELIMINAR_PROVEEDOR.setModulo(MODULO_PROVEEDOR);
        
                
        FUNCIONALIDAD_REGISTRAR_VENTA.setIdfuncionalidad(16);
        FUNCIONALIDAD_REGISTRAR_VENTA.setNombre("Registrar Venta");
        FUNCIONALIDAD_REGISTRAR_VENTA.setModulo(MODULO_VENTA);
        
        FUNCIONALIDAD_MODIFICAR_VENTA.setIdfuncionalidad(17);
        FUNCIONALIDAD_MODIFICAR_VENTA.setNombre("Modificar Venta");
        FUNCIONALIDAD_MODIFICAR_VENTA.setModulo(MODULO_VENTA);
        
        FUNCIONALIDAD_ELIMINAR_VENTA.setIdfuncionalidad(18);
        FUNCIONALIDAD_ELIMINAR_VENTA.setNombre("Eliminar Venta");
        FUNCIONALIDAD_ELIMINAR_VENTA.setModulo(MODULO_VENTA);
        
        FUNCIONALIDAD_AGREGAR_CATEGORIA_CLIENTES.setIdfuncionalidad(19);
        FUNCIONALIDAD_AGREGAR_CATEGORIA_CLIENTES.setNombre("Agregar Categoria al Cliente");
        FUNCIONALIDAD_AGREGAR_CATEGORIA_CLIENTES.setModulo(MODULO_CATEGORIA_CLIENTES);
        
        
        FUNCIONALIDAD_MODIFICAR_CATEGORIA_CLIENTES.setIdfuncionalidad(20);
        FUNCIONALIDAD_MODIFICAR_CATEGORIA_CLIENTES.setNombre("Modificar Categoria al Cliente");
        FUNCIONALIDAD_MODIFICAR_CATEGORIA_CLIENTES.setModulo(MODULO_CATEGORIA_CLIENTES);
        
         
        FUNCIONALIDAD_ELIMINAR_CATEGORIA_CLIENTES.setIdfuncionalidad(21);
        FUNCIONALIDAD_ELIMINAR_CATEGORIA_CLIENTES.setNombre("Eliminar Categoria al Cliente");
        FUNCIONALIDAD_ELIMINAR_CATEGORIA_CLIENTES.setModulo(MODULO_CATEGORIA_CLIENTES);
        
         FUNCIONALIDAD_AGREGAR_CATEGORIA_PRODUCTO.setIdfuncionalidad(22);
         FUNCIONALIDAD_AGREGAR_CATEGORIA_PRODUCTO.setNombre("Agregar Categoria al Producto");
         FUNCIONALIDAD_AGREGAR_CATEGORIA_PRODUCTO.setModulo(MODULO_CATEGORIA_PRODUCTO);
        
         FUNCIONALIDAD_MODIFICAR_CATEGORIA_PRODUCTO.setIdfuncionalidad(23);
         FUNCIONALIDAD_MODIFICAR_CATEGORIA_PRODUCTO.setNombre("Modificar Categoria al Producto");
         FUNCIONALIDAD_MODIFICAR_CATEGORIA_PRODUCTO.setModulo(MODULO_CATEGORIA_PRODUCTO);
         
         FUNCIONALIDAD_ELIMINAR_CATEGORIA_PRODUCTO.setIdfuncionalidad(24);
         FUNCIONALIDAD_ELIMINAR_CATEGORIA_PRODUCTO.setNombre("Eliminar Categoria al Producto");
         FUNCIONALIDAD_ELIMINAR_CATEGORIA_PRODUCTO.setModulo(MODULO_CATEGORIA_PRODUCTO);
         
         FUNCIONALIDAD_AGREGAR_PROMOCION.setIdfuncionalidad(25);
         FUNCIONALIDAD_AGREGAR_PROMOCION.setNombre("Agregar Promoción");
         FUNCIONALIDAD_AGREGAR_PROMOCION.setModulo(MODULO_PROMOCION);
         
         FUNCIONALIDAD_MODIFICAR_PROMOCION.setIdfuncionalidad(26);
         FUNCIONALIDAD_MODIFICAR_PROMOCION.setNombre("Modificar Promoción");
         FUNCIONALIDAD_MODIFICAR_PROMOCION.setModulo(MODULO_PROMOCION);
         
         FUNCIONALIDAD_ELIMINAR_PROMOCION.setIdfuncionalidad(27);
         FUNCIONALIDAD_ELIMINAR_PROMOCION.setNombre("Eliminar Promoción");
         FUNCIONALIDAD_ELIMINAR_PROMOCION.setModulo(MODULO_PROMOCION);
         
         
         FUNCIONALIDAD_AGREGAR_TIMBRADO.setIdfuncionalidad(28);
         FUNCIONALIDAD_AGREGAR_TIMBRADO.setNombre("Agregar Timbrado");
         FUNCIONALIDAD_AGREGAR_TIMBRADO.setModulo(MODULO_TIMBRADO);
         
         FUNCIONALIDAD_MODIFICAR_TIMBRADO.setIdfuncionalidad(29);
         FUNCIONALIDAD_MODIFICAR_TIMBRADO.setNombre("Modificar Timbrado");
         FUNCIONALIDAD_MODIFICAR_TIMBRADO.setModulo(MODULO_TIMBRADO);
         
         FUNCIONALIDAD_ELIMINAR_TIMBRADO.setIdfuncionalidad(30);
         FUNCIONALIDAD_ELIMINAR_TIMBRADO.setNombre("Eliminar Timbrado");
         FUNCIONALIDAD_ELIMINAR_TIMBRADO.setModulo(MODULO_TIMBRADO);
         
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
        em.merge(MODULO_EMPLEADO);
        em.merge(MODULO_PROVEEDOR);
        em.merge(MODULO_VENTA);
        em.merge(MODULO_PROMOCION);
        em.merge(MODULO_TIMBRADO);
        

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
        em.merge(FUNCIONALIDAD_ELIMINAR_COMPRA);
        em.merge(FUNCIONALIDAD_REGISTRAR_EMPLEADO);
        em.merge(FUNCIONALIDAD_MODIFICAR_EMPLEADO);
        em.merge(FUNCIONALIDAD_ELIMINAR_EMPLEADO);
        em.merge(FUNCIONALIDAD_REGISTRAR_PROVEEDOR);
        em.merge(FUNCIONALIDAD_MODIFICAR_PROVEEDOR);
        em.merge(FUNCIONALIDAD_ELIMINAR_PROVEEDOR);
        em.merge(FUNCIONALIDAD_REGISTRAR_VENTA);
        em.merge(FUNCIONALIDAD_MODIFICAR_VENTA);
        em.merge(FUNCIONALIDAD_ELIMINAR_VENTA);
        em.merge(FUNCIONALIDAD_AGREGAR_CATEGORIA_CLIENTES);
        em.merge(FUNCIONALIDAD_MODIFICAR_CATEGORIA_CLIENTES);
        em.merge(FUNCIONALIDAD_ELIMINAR_CATEGORIA_CLIENTES);
        em.merge(FUNCIONALIDAD_AGREGAR_CATEGORIA_PRODUCTO);
        em.merge(FUNCIONALIDAD_MODIFICAR_CATEGORIA_PRODUCTO);
        em.merge(FUNCIONALIDAD_ELIMINAR_CATEGORIA_PRODUCTO);
        em.merge(FUNCIONALIDAD_AGREGAR_PROMOCION);
        em.merge(FUNCIONALIDAD_MODIFICAR_PROMOCION);
        em.merge(FUNCIONALIDAD_ELIMINAR_PROMOCION);
        em.merge(FUNCIONALIDAD_AGREGAR_TIMBRADO);
        em.merge(FUNCIONALIDAD_MODIFICAR_TIMBRADO);

        em.getTransaction().commit();
    }

}
