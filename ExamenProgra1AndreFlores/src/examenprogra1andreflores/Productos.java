
package examenprogra1andreflores;

public class Productos {
    String nombreProducto;
    int idProducto;
    int cantidadProducto;
    double precioUnit;
    boolean estadoProd;

    public Productos(String nombreProducto, int idProducto, int cantidadProducto, double precioUnit, boolean estadoProd) {
        this.nombreProducto = nombreProducto;
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioUnit = precioUnit;
        this.estadoProd = estadoProd;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public boolean isEstadoProd() {
        return estadoProd;
    }

    public void setEstadoProd(boolean estadoProd) {
        this.estadoProd = estadoProd;
    }
        @Override
    public String toString() {
        String estado="";
        if(this.estadoProd){
            estado="Disponible";
        }else{
            estado="Agotado";
        }
        return  idProducto+" ->"+nombreProducto+ " ( "+estado+" )";
    }
    
}

