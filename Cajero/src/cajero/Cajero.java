package cajero;

import java.util.Scanner;

public class Cajero {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int billetes_de_200, billetes_de_50, billetes_de_500, cantidad_de_dinero, monedas_de_1;
        int monedas_de_10, monedas_de_2, monedas_de_5;
        System.out.print("Ingresa el valor de cantidad de dinero: ");
        cantidad_de_dinero = in.nextInt();
        in.nextLine();
        monedas_de_1=cantidad_de_dinero%500;
        billetes_de_500=(cantidad_de_dinero-monedas_de_1)/500;
        billetes_de_200=(monedas_de_1-monedas_de_1%200)/200;
        monedas_de_1=monedas_de_1%200;
        billetes_de_50=(monedas_de_1-monedas_de_1%50)/50;
        monedas_de_1=monedas_de_1%50;
        monedas_de_10=(monedas_de_1-monedas_de_1%10)/10;
        monedas_de_1=monedas_de_1%10;
        monedas_de_5=(monedas_de_1-monedas_de_1%5)/5;
        monedas_de_1=monedas_de_1%5;
        monedas_de_2=(monedas_de_1-monedas_de_1%2)/2;
        monedas_de_1=monedas_de_1%2;
        System.out.println("Valor de billetes de 200: " + billetes_de_200);
        System.out.println("Valor de billetes de 50: " + billetes_de_50);
        System.out.println("Valor de billetes de 500: " + billetes_de_500);
        System.out.println("Valor de billetes de 1: " + monedas_de_1);
        System.out.println("Valor de billetes de 10: " + monedas_de_10);
        System.out.println("Valor de billetes de 2: " + monedas_de_2);
        System.out.println("Valor de billetes de 5: " + monedas_de_5);
         ncuenta d = new ncuenta();
        String cuenta;
        String opcion;
        float monto;       
        Scanner tc = new Scanner(System.in);      
        System.out.println("-----Bienvenido a su ATM------");
        System.out.print("Ingrese su numero de cuenta: ");
        cuenta = tc.next();
        d.setcuenta(cuenta);
        do{
        System.out.print("Desea depositar SI/NO: ");
        opcion = tc.next();       
        switch (opcion){
            case "SI":
                System.out.println("Ingrese la cantidad a depositar: ");
                monto = tc.nextFloat();
                if(monto >0){
                    System.out.println("Por favor espere...Depositando.......");
                    monto = monto + d.getsaldo();
                    d.setsaldo(monto);
                    System.out.println("Nuevo saldo: "+ d.getsaldo());
                }else{
                    System.out.print("Debe ingresar una cantidad mayor a su saldo en cuenta");
                }               
            break;
            case "NO":
                System.out.println("Ingrese la cantidad a retirar: ");              
                monto = tc.nextFloat();               
                if(d.getsaldo()-monto >=0){
                    System.out.println("Retirando.......");
                    monto = d.getsaldo()-monto;
                    d.setsaldo(monto);
                    System.out.println("------Recibo------");
                    System.out.println("Cuenta: "+d.getcuenta());
                    System.out.println("Nuevo saldo: "+d.getsaldo());
                    System.out.println("--------Gracias por preferirnos----------");
                }else{
                    System.out.println("Saldo insuficiente ");
                }
            break;
            case "SALIR":
                System.out.println("--------Gracias por preferirnos----------");              
            break;
            default:
                System.out.println("Opcion no valida");
            break;
        }
        }while(!opcion.equals("SALIR"));
    }

}