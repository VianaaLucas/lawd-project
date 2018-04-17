/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.DAO.PedidoDAO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class CsvTest {

    public static void main(String... args) {

        PedidoDAO dao = new PedidoDAO();

        List<String> list = new ArrayList<>();
        try {
            list = dao.testCsvTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(
                            new File("C:\\Users\\lucas\\Desktop\\csvtest.csv")));

            bufferedWriter.write("id;data_pedido;valor_pedido;status;\r\n");
            
            int cont = 0;
            
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i) + ";");
                
                if (cont == 3) {
                    bufferedWriter.write(list.get(i) + ";\r\n");
                    cont = 0;
                    continue;
                }
                cont++;
            }
            
            bufferedWriter.close();

        } catch (IOException ex) {
            Logger.getLogger(CsvTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
