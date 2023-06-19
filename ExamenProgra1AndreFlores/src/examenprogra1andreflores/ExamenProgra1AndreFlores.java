package examenprogra1andreflores;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ExamenProgra1AndreFlores {

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        ArrayList<Productos> productos = new ArrayList();

        while (true) {
            System.out.println("Este es el menu del inventario");
            System.out.println("1. Agregar productos  \n2. Definir estado \n3.imprimir productos \n4.Actualizar datos.\n5.Listar productos\n6.Salir ");
            System.out.println("->Ingrese que desea hacer :");
            int op = lea.nextInt();
            if (op == 1) {
                System.out.println("Agregar productos");
                //Agregar personas a la lista.
                Productos newprod = agregarProducto();
                productos.add(newprod);
                GenerarProd(newprod);
                System.out.println("");
                System.out.println("Producto registrado.");
                System.out.println("");

            } else if (op == 2) {
                System.out.println("Marcar como agotado: ");
                productos = Marcaragotado(productos);

            } else if (op == 3) {
                System.out.println("Imprimir productos");
                System.out.println("Ingrese el numero de id: ");
                int identidad = lea.nextInt();
                for (int i = 0; i < productos.size(); i++) {
                    if (productos.get(i).idProducto == identidad) {
                        GenerarProd(productos.get(i));
                    }
                }

            } else if (op == 4) {
                System.out.println("Actualizar datos");
                productos = actualizarDatos(productos);
                
            } else if (op == 5) {
                System.out.println("Productos: ");
   
                listarProductos(productos);
            } else if (op == 6) {
                System.out.println("Saliendo....");
                break;
            } else {
                System.out.println("No valido");
            }
        }

    }

    public static Productos agregarProducto() {
        Scanner entrada = new Scanner(System.in);
        Random num = new Random();
        //Obteniendo datos del bebe de la consola 
        System.out.println("Ingrese el nombre del producto: ");
        String nombreProducto = entrada.nextLine();
        System.out.println("Ingrese la cantidad del producto: ");
        int cantidadProducto = entrada.nextInt();
        System.out.println("Ingrese el precio unitario del producto: ");
        double precioUnit = entrada.nextDouble();

        boolean estadoProd = true;
        int idProducto = num.nextInt(1000);

        Productos newproducto = new Productos(nombreProducto, idProducto, cantidadProducto, precioUnit, estadoProd);

        return newproducto;
    }

    public static void listarProductos(ArrayList<Productos> productos) {
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(productos.get(i));
        }
    }

    public static void GenerarProd(Productos coso) {
        String estadoProd = "";
        if (coso.estadoProd) {
            estadoProd = "Disponible";
        } else {
            estadoProd = "Agotado";
        }

        System.out.println("Nombre : " + coso.nombreProducto.toUpperCase());
        System.out.println("Identidad: " + coso.idProducto);
        System.out.println("Estado: " + estadoProd.toUpperCase());
    }

    public static ArrayList<Productos> Marcaragotado(ArrayList<Productos> productos) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el numero de ID del producto que quiere marcar como agotado: ");
        int identidad = entrada.nextInt();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).idProducto == identidad) {
                productos.get(i).setEstadoProd(false);
                System.out.println("El producto se registro como agotado. ");
            }

        }
        return productos;
    }

    public static ArrayList<Productos> actualizarDatos(ArrayList<Productos> productos) {
        Scanner lea = new Scanner(System.in);
        System.out.println("Ingrese el numero de ID: ");
        int identidad = lea.nextInt();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).idProducto == identidad) {
                System.out.println("Ingrese el nombre del producto (otro si lo quiere cambiar): ");
                lea.nextLine();
                String nombreProducto = lea.nextLine();
                System.out.println("Ingrese la nueva cantidad: ");
                int cantidadProducto = lea.nextInt();
                System.out.println("Ingrese la disponibilidad del producto. \n 1) Disponible  2) Agotado");
                int estadoTemp = lea.nextInt();
                boolean estado = estadoTemp != 2;
                //Generar datos automaticamente 
                productos.get(i).cantidadProducto = cantidadProducto;
                productos.get(i).nombreProducto = nombreProducto;

                productos.get(i).estadoProd = estado;
            }
        }
        return productos;
    }
}

}
