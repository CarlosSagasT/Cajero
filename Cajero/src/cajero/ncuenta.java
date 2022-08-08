package cajero;
public class ncuenta {
    private String cuenta;
    private float saldo;
    
    public ncuenta(){
   
        saldo = 0;
    }
    public void setsaldo(float nuevosaldo){
        this.saldo = nuevosaldo;
    }
    
    public float getsaldo(){
    return this.saldo;
    }
    
    public String getcuenta(){
        return this.cuenta;
    }
    
    public void setcuenta(String ncuenta){
    this.cuenta = ncuenta;
    }
    
}