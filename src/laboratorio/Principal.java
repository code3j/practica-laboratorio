/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio;

/**
 *
 * @author NB-3170
 */
import java.io.*;
import java.util.*;
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int cat_Reg;
        
        cat_Reg=Calidad.can_reg();
        String lote[] = new String[cat_Reg]; 
        double porcentajes[][] = new double[cat_Reg][6];
        double promedios[][]= new double [cat_Reg][2];
        String aprueba []=new String [cat_Reg];
        Calidad.leo_arch(lote, porcentajes);
        Calidad.mostrar_datos(lote, porcentajes);
        Calidad.calcu_promedio(porcentajes, promedios);
        Calidad.aprobacion(promedios, aprueba);
        Calidad.mostrar_resul( lote,promedios,aprueba);
        
    }
    
}
