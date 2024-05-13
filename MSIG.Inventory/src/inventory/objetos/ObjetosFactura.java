/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.objetos;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
public class ObjetosFactura {
    
    private int id_factura;
    private int numero_factura;
    private String serie_factura;
    private String folio_factura;
    private int id_cliente;
    private String fecha_emision_factura;
    private String dir_envio_factura;
    private float total_factura;
    private int id_empleado;
    private String nombre_empleado;
    private String estado_factura;
    private String tipo_venta;
    private String dias_de_credito;
    private float monto_credito;
    private float monto_contado;
    private float iva_factura;
    private float comision_factura;
    private float porcentaje_comision;
    private float limite_credito;
    private String tipo_cliente;
    private float credito_disponible;
    private String nombre_cliente;
    
    public int getId_factura() {
        int vId_factura = 0;
        try{
            vId_factura = id_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:GETID_FACTURA "+error);
        }
        return vId_factura;
    }

    public void setId_factura(int pId_factura){
        try{
            id_factura = pId_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:SETID_FACTURA " + error);
        }
    }
    
    public int getNumero_factura(){
        int vNumero_factura = 0;
        try{
            vNumero_factura = numero_factura;
        }catch(Error error){
            System.out.println("EC FATURA:GETNUMERO_FACTURA "+error);
        }
        return vNumero_factura;
    }
    
    public void setNumero_factura(int pNumero_factura){
        try{
            numero_factura = pNumero_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:SETNUMERO_FACTURA "+error);
        }
    }
    
    public String getSerie_factura(){
        String vSerie_factura = null;
        try{
            vSerie_factura = serie_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:GETSERIE_FACTURA "+error);
        }
        return vSerie_factura;
    }
    
    public void setSerie_factura(String pSerie_factura){
        try{
            serie_factura = pSerie_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:SETSERIE_FACTURA "+error);
        }
    }
    
    public String getFolio_factura(){
        String vFolio_factura = null;
        try{
            vFolio_factura = folio_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:GETFOLIO_FACTURA "+error);
        }
        return vFolio_factura;
    }
    
    public void setFolio_factura(String pFolio_factura){
        try{
            folio_factura = pFolio_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:SETFOLIO_FACTURA "+error);
        }
    }
    
    public int getId_cliente(){
        int vId_cliente = 0;
        try{
            vId_cliente = id_cliente;
        }catch(Error error){
            System.out.println("EC FACTURA:GETID_CLIENTE "+error);
        }
        return vId_cliente;
    }
    
    public void setId_cliente(int pId_cliente){
        try{
            id_cliente = pId_cliente;
        }catch(Error error){
            System.out.println("EC FACTURA:SETID_CLIENTE "+error);
        }
    }
    
    public String getFecha_emision_factura(){
        String vFecha_emision_factura = null;
        try{
            vFecha_emision_factura = fecha_emision_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:GETFECHA_EMISION_FACTURA "+error);
        }
        return vFecha_emision_factura;
    }
    
    public void setFecha_emision_factura(String pFecha_emision_factura){
        try{
            fecha_emision_factura = pFecha_emision_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:SETFECHA_EMISION_FACTURA "+error);
        }
    }
    
    public String getDir_envio_factura(){
        String vDir_envio_factura = null;
        try{
            vDir_envio_factura = dir_envio_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:GETDIR_ENVIO_FACTURA "+error);
        }
        return vDir_envio_factura;
    }
    
    public void setDir_envio_factura(String pDir_envio_factura){
        try{
            dir_envio_factura = pDir_envio_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:GETDIR_EVIO_FACTURA "+error);
        }
    }
    
    public float getTotal_factura(){
        float vTotal_factura = 0;
        try{
            vTotal_factura = total_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:GETTOTAL_FACTURA "+error);
        }
        return vTotal_factura;
    }
    
    public void setTotal_factura(float pTotal_factura){
        try{
            total_factura = pTotal_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:SETTOTAL_FACTURA "+error);
        }
    }
    
    public int getId_empleado() {
        int vId_empleado = 0;
        try{
            vId_empleado = id_empleado;
        }catch(Error error){
            System.out.println("EC FACTURA:getId_empleado "+error);
        }
        return vId_empleado;
    }

    public void setId_empleado(int pId_empledo){
        try{
            id_empleado = pId_empledo;
        }catch(Error error){
            System.out.println("EC FACTURA:setId_empleado " + error);
        }
    }
    
    public String getNombre_empleado(){
        String vNombre = null;
        try{
            vNombre = nombre_empleado;
        }catch(Error error){
            System.out.println("EC FACTURA:getNombre_empleado "+error);
        }
        return vNombre;
    }
    
    public void setNombre_empleado(String pNombre){
        try{
            nombre_empleado = pNombre;
        }catch(Error error){
            System.out.println("EC FACTURA:setNombre_empleado "+error);
        }
    }
    
    public String getEstado_factura(){
        String vEstado_factura = null;
        try{
            vEstado_factura = estado_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:getEstado_factura "+error);
        }
        return vEstado_factura;
    }
    
    public void setEstado_factura(String pEstado_factura){
        try{
            estado_factura = pEstado_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:setEstado_factura "+error);
        }
    }
    
    public String getTipo_venta(){
        String vTipo_venta = null;
        try{
            vTipo_venta = tipo_venta;
        }catch(Error error){
            System.out.println("EC FACTURA:getTipo_venta "+error);
        }
        return vTipo_venta;
    }
    
    public void setTipo_venta(String pTipo_venta){
        try{
            tipo_venta = pTipo_venta;
        }catch(Error error){
            System.out.println("EC FACTURA:setTipo_venta "+error);
        }
    }
    
    public String getDias_de_credito(){
        String vDias_de_credito = null;
        try{
            vDias_de_credito = dias_de_credito;
        }catch(Error error){
            System.out.println("EC FACTURA:getDias_de_credito "+error);
        }
        return vDias_de_credito;
    }
    
    public void setDias_de_credito(String pDias_de_credito){
        try{
            dias_de_credito = pDias_de_credito;
        }catch(Error error){
            System.out.println("EC FACTURA:setDias_de_credito "+error);
        }
    }
    
    public float getMonto_credito(){
        float vMonto_credito = 0;
        try{
            vMonto_credito = monto_credito;
        }catch(Error error){
            System.out.println("EC FACTURA:getMonto_credito "+error);
        }
        return vMonto_credito;
    }
    
    public void setMonto_credito(float pMonto_credito){
        try{
            monto_credito = pMonto_credito;
        }catch(Error error){
            System.out.println("EC FACTURA:setMonto_credito "+error);
        }
    }
    
    public float getMonto_contado(){
        float vMonto_contado = 0;
        try{
            vMonto_contado = monto_contado;
        }catch(Error error){
            System.out.println("EC FACTURA:getMonto_contado "+error);
        }
        return vMonto_contado;
    }
    
    public void setMonto_contado(float pMonto_contado){
        try{
            monto_contado = pMonto_contado;
        }catch(Error error){
            System.out.println("EC FACTURA:setMonto_contado "+error);
        }
    }
    
    public float getIva_factura(){
        float vIva_factura = 0;
        try{
            vIva_factura = iva_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:getIva_factura "+error);
        }
        return vIva_factura;
    }
    
    public void setIva_factura(float pIva_factura){
        try{
            iva_factura = pIva_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:setIva_factura "+error);
        }
    }
    
    public float getComision_factura(){
        float vComision_factura = 0;
        try{
            vComision_factura = comision_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:getComision_factura "+error);
        }
        return vComision_factura;
    }
    
    public void setComision_factura(float pComision_factura){
        try{
            comision_factura = pComision_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:setComision_factura "+error);
        }
    }
    
    public float getPorcentaje_comision(){
        float vComision = 0;
        try{
            vComision = porcentaje_comision;
        }catch(Error error){
            System.out.println("EC FACTURA:getPorcentaje_comision "+error);
        }
        return vComision;
    }
    
    public void setPorcentaje_comision(float pComision){
        try{
            porcentaje_comision = pComision;
        }catch(Error error){
            System.out.println("EC FACTURA:setPorcentaje_comision "+error);
        }
    }
    
    public float getLimite_credito(){
        float vLimite_credito = 0;
        try{
            vLimite_credito = limite_credito;
        }catch(Error error){
            System.out.println("EC FACTURA:getLimite_credito "+error);
        }
        return vLimite_credito;
    }
    
    public void setLimite_credito(float pLimiteCredito){
        try{
            limite_credito = pLimiteCredito;
        }catch(Error error){
            System.out.println("EC FACTURA:setLimite_credito "+error);
        }
    }
    
    public String getTipo_cliente(){
        String vTipo_cliente = null;
        try{
            vTipo_cliente = tipo_cliente;
        }catch(Error error){
            System.out.println("EC FACTURA:getTipo_cliente "+error);
        }
        return vTipo_cliente;
    }
    
    public void setTipo_cliente(String pTipo_cliente){
        try{
            tipo_cliente = pTipo_cliente;
        }catch(Error error){
            System.out.println("EC FACTURA:setTipo_cliente "+error);
        }
    }
    
    public float getCredito_disponible(){
        float vCredito = 0;
        try{
            vCredito = credito_disponible;
        }catch(Error error){
            System.out.println("EC FACTURA:getCredito_disponible "+error);
        }
        return vCredito;
    }
    
    public void setCredito_disponible(float pCredito){
        try{
            credito_disponible = pCredito;
        }catch(Error error){
            System.out.println("EC FACTURA:setCredito_disponible "+error);
        }
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }
    
    
}
