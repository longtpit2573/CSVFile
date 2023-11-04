/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import DataAccess.CSVDao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bravo
 */
public class CSVresponsitory implements ICSVresponsitory {

    @Override
    public void ImportCSV() {
        try {
            CSVDao.instance().importFile();
        } catch (IOException ex) {
            Logger.getLogger(CSVresponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        CSVDao.instance().print();
    }

    @Override
    public void Format_Address() {
        CSVDao.instance().formatAddress();
        CSVDao.instance().print();
    }

    @Override
    public void Format_Name() {
        CSVDao.instance().formatName();
        CSVDao.instance().print();
    }

    @Override
    public void ExportCSV() {
        CSVDao.instance().exportFileToCSV();
    }
    
}
