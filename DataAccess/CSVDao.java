/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.CSV;

/**
 *
 * @author Bravo
 */
public class CSVDao {

    Scanner in = new Scanner(System.in);
    private List<CSV> ls;

    public CSVDao() {
        this.ls = new ArrayList<>();
    }

    private static CSVDao instance = null;

    public static CSVDao instance() {
        if (instance == null) {
            synchronized (CSVDao.class) {
                if (instance == null) {
                    instance = new CSVDao();
                }
            }
        }
        return instance;
    }

    private int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public void formatName() {
        for (int i = 0; i < ls.size(); i++) {
            String name = ls.get(i).getName().trim();
            name = name.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = name.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0)))
                        .append(arr[j].substring(1)).append(" ");
            }
            ls.get(i).setName(sb.toString().trim());
        }
        System.err.println("Format: Done");
    }

    public void formatAddress() {
        for (int i = 0; i < ls.size(); i++) {
            String address = ls.get(i).getAddress().trim();
            address = address.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = address.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0)))
                        .append(arr[j].substring(1)).append(" ");
            }
            ls.get(i).setAddress(sb.toString().trim());
        }
        System.err.println("Format: Done");
    }

    public void importFile() throws FileNotFoundException, IOException {
        System.out.print("Enter Path: ");
        String fileName = in.nextLine().trim();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] splitCSV = line.split(",");
                if (splitCSV.length == 5) {
                    int id = Integer.parseInt(splitCSV[0].trim());
                    String name = splitCSV[1].trim();
                    String email = splitCSV[2].trim();
                    String phone = splitCSV[3].trim();
                    String address = splitCSV[4].trim();

                    ls.add(new CSV(id, name, email, phone, address));
                } else {
                    System.err.println("Invalid CSV format: " + line);
                }
            }
            System.err.println("Import Done!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportFileToCSV() {
    System.out.print("Enter Path: ");
    String fileName = in.nextLine();

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        for (CSV csv : ls) {
            String csvLine = csv.getId() + "," + csv.getName() + "," + csv.getEmail() + "," + csv.getPhone() + "," + csv.getAddress();
            writer.write(csvLine);
            writer.newLine(); // Add a newline for each record
        }
        System.err.println("Export Done!!!");
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    }

    public void print() {
        for (int i = 0; i < ls.size(); i++) {
            System.out.printf("%d,%s,%s,%s,%s\n", ls.get(i).getId(),
                    ls.get(i).getName(), ls.get(i).getEmail(), ls.get(i).getPhone(),
                    ls.get(i).getAddress());
        }
    }

}
