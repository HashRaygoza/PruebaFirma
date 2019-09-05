/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebafirma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class PruebaFirma {

    static public void main(String[] args) {
        try {
            Runtime rt = Runtime.getRuntime();
            String comando = "jarsigner -verify -verbose -certs " + "dist/PruebaFirma.jar";
            String[] llamada = {"cmd.exe", "/C", comando};
            
            System.out.println("llamando comando: " + comando);

            Process proc = rt.exec(llamada);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String s;
            
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

        } catch (IOException ex) {
            Logger.getLogger(PruebaFirma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
