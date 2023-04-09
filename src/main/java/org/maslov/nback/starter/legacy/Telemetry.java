/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.maslov.nback.starter.legacy;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Telemetry implements Runnable {

    public static String dfltTelemetryFlName = "NBackTelemetry.txt";
    private static String fileEnding = ".txt";
    private NBackGame game;
    private String    gamerName;

    public void setGame(NBackGame game) {
        this.game = game;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }
    
    
    
    @Override
    public void run() {
        FileWriter writer = null;
        BufferedWriter bf = null;
        try {
            writer = new FileWriter(gamerName, true);
            bf = new BufferedWriter(writer);
            bf.write(game.toString());
            bf.close();
        } catch (IOException ex) {
            Logger.getLogger(Telemetry.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                 bf.close();
                //writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Telemetry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        System.out.println("Telemetry start");
       // PrintWriter pw = new PrintWriter(dfltTelemetryFlName);
        FileWriter writer = new FileWriter(dfltTelemetryFlName, true);
        BufferedWriter bf = new BufferedWriter(writer);
        bf.write(dfltTelemetryFlName +"\n");
        bf.close();
        System.out.println("Telemetry finished");
    
    
    }        
    
}
