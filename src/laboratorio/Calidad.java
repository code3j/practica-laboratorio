/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio;

import java.io.*;
import java.util.*;

/**
 *
 * @author NB-3170
 */
public class Calidad {

    public static int can_reg() throws IOException {
        int reg = 0;
        Scanner leo = new Scanner(new File("Lotes.txt"));
        while (leo.hasNextLine()) {
            String linea = leo.nextLine();
            reg++;
        }
        leo.close();
        return reg;
    }

    public static void leo_arch(String lote[], double porcentajes[][]) throws IOException {
        int i = 0;
        Scanner leo = new Scanner(new File("Lotes.txt"));
        while (leo.hasNextLine()) {
            String linea = leo.nextLine();
            Scanner separador = new Scanner(linea);
            separador.useDelimiter(",");
            separador.useLocale(Locale.US);
            while (separador.hasNext()) { //DUDA 1 AQUI ES CORRECTO COLOCAR  .hasnext?
                lote[i] = separador.next();//aqui es correcto colocar .next (PORQUE EN EL ARCHIVO NO HAY PALABRAS ENTONCES CUANDO VAYA A BUSCAR NO HABRA NADA)
                for (int j = 0; j < porcentajes[0].length; j++) {
                    porcentajes[i][j] = separador.nextDouble();
                }
                i++;
            }

        }
        leo.close();
    }

    public static void mostrar_datos(String lote[], double porcentajes[][]) {
        System.out.println("No Lote  ------Carbono-------      ------Magnecio%------");
        for (int i = 0; i < lote.length; i++) {
            System.out.printf("%-5s  ", lote[i]);
            for (int j = 0; j < porcentajes[0].length; j++) {
                System.out.printf("%7.2f ", porcentajes[i][j]);

            }
            System.out.println("");
        }
    }

    public static void calcu_promedio(double porcentajes[][], double promedios[][]) {

        for (int i = 0; i < porcentajes.length; i++) {
            double suma = 0;
            double cont = 0;
            double valor = 0;
            double prom = 0;
           
            int colum = 0;
            for (int j = 0; j < porcentajes[0].length; j++) {
                valor = porcentajes[i][j];
                suma+= valor;
               
                cont++;
                if (cont == 3.0) {
                    prom = suma / 3;
                    cont = 0;
                    suma = 0;
                    valor = 0;
                  

                    promedios[i][colum] = prom;
                    colum++;
                }

            }
        }
    }
    public static void aprobacion(double promedios[][],String aprueba[]){
        for (int i = 0; i < promedios.length; i++) {
            double prom1=0 , prom2=0 ;
            for (int j = 0; j < promedios[0].length; j++) {
                prom1=promedios[i][j];
                if(prom2==0){
                   prom2=prom1;
                }
               if((prom2>24.92 && prom2 <27.92) && (prom1>19.84 && prom1<25.30) ){
                   aprueba[i]="Aprobado";
               }else{aprueba[i]="Rechazado";}
               
                
            }
            
        }
        
    }
    public static void mostrar_resul(String lotes[], double promedio[][],String aprueba []) {
        System.out.println("");
        System.out.println("Lotes    Carb%   Mag%    Status");
        for (int i = 0; i < promedio.length; i++) {
            System.out.println("");
            System.out.printf("%-8s ", lotes[i]);
            for (int j = 0; j < promedio[0].length; j++) {
                System.out.printf("%6.2f ", promedio[i][j]);

                
            }
            System.out.printf("%10s",aprueba[i]);
        }

    }
}
