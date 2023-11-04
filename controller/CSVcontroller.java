/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Responsitory.CSVresponsitory;
import view.Menu;

/**
 *
 * @author Bravo
 */
public class CSVcontroller extends Menu {

    private CSVresponsitory csvresponsitory;
    static String[] option = {"Import CSV", "Format Address", "Format Name", "Export CSV", "Exit"};

    public CSVcontroller() {
        super("======= Format CSV Program =======", option);
        csvresponsitory = new CSVresponsitory();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                csvresponsitory.ImportCSV();
                break;
            case 2:
                csvresponsitory.Format_Address();
                break;
            case 3:
                csvresponsitory.Format_Name();
                break;
            case 4:
                csvresponsitory.ExportCSV();
                break;
            case 5:
                System.out.println("Exit!!!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid,Pls Again!!!");
        }
    }

}
