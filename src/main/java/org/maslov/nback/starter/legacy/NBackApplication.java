/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.maslov.nback.starter.legacy;

import javax.swing.JFrame;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NBackApplication {
    private static int  Height = 500;
    private static int  Width = 400;   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            mainView mV = new mainView();
            mV.setSize(Width, Height);
            mV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mV.setVisible(true);
        } catch (Throwable th) {
            log.info(th.getMessage());
        }
    }
    
}
