package cuentas;

public class CCuenta {


    private String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInteres;

    public CCuenta(){
        nombre= null;
        cuenta= null;
        saldo= 0;
        tipoInteres= 0;
    }

    public CCuenta(String nom, String cue, double sal, double tipo){
        nombre = nom;
        cuenta = cue;
        saldo = sal;
        tipoInteres= tipo;
    }

    public double estado(){
        return saldo;
    }

    public void ingresar(double cantidad) throws Exception{
        if (cantidad<0)
            throw new Exception("No se puede ingresar una cantidad negativa");
        saldo = saldo + cantidad;
    }

    public void retirar(double cantidad) throws Exception{
        if (cantidad <= 0)
            throw new Exception ("No se puede retirar una cantidad negativa");
        if (estado()< cantidad)
            throw new Exception ("No se hay suficiente saldo");
        saldo = saldo - cantidad;
    }
    
    public void setNombre(String nombre){
        this.nombre= nombre;
    }
    
    public void setCuenta(String cuenta){
        this.cuenta= cuenta;
    }
    
    public void setTipoInteres(double tipoInteres){
        this.tipoInteres= tipoInteres;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getCuenta(){
        return cuenta;
    }
    
    public double getTipoInteres(){
        return tipoInteres;
    }
    
    public double calcularSaldo(int tiempo){
        double total= saldoXTiempo(tiempo) - 2*saldo;
        
        return (total < 0)? total : 0;
    }
    
    private double saldoXTiempo(int tiempo){
        double total= 0;
        
        for (int i= 0; i < tiempo; i++){
            total+= i*saldo+i;
        }
        
        return total;
    }
}
