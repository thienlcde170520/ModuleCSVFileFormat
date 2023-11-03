
package DataAccess;

import common.Library;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.csvFile;


public class CSVFileDao {
    Library l;

    public CSVFileDao(){
    l = new Library();
 
    }
    private static CSVFileDao instance = null;
    public static CSVFileDao Instance(){
        if(instance == null){
            synchronized (CSVFileDao.class){
                if(instance == null){
                    instance = new  CSVFileDao();
                }
            }
        }
        return instance;
    }

    public void formatName(ArrayList<csvFile> format) {
        for (int i = 0; i < format.size(); i++) {
            String name = format.get(i).getName().trim();
            name = name.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = name.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0)))
                        .append(arr[j].substring(1)).append(" ");
            }
            format.get(i).setName(sb.toString().trim());
        }
        System.err.println("Format: Done");
    }

    public void formatAddress(ArrayList<csvFile> format) {
        for (int i = 0; i < format.size(); i++) {
            String address = format.get(i).getAddress().trim();
            address = address.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = address.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0)))
                        .append(arr[j].substring(1)).append(" ");
            }
            format.get(i).setAddress(sb.toString().trim());
        }
        System.err.println("Format: Done");
    }

    public void importFile(ArrayList<csvFile> format) {
        String line = "";
        BufferedReader fileReader = null;
        l.checkInputPathFile("Enter Path: ");
        String fileName = l.getString("Enter file Name: "); 
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
//                System.out.println(line);
                String[] splitCSV = line.split(l.COMMA_DELIMITER);
                format.add(new csvFile(Integer.parseInt(splitCSV[0]), splitCSV[1],
                        splitCSV[2], splitCSV[3], splitCSV[4]));

            }
            System.err.println("Import: Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void exportFile(ArrayList<csvFile> format) {
        FileWriter fileWriter = null;
        l.checkInputPathFile("Enter Path: ");       
        String fileName = l.getString("Enter file: ");
        try {
            fileWriter = new FileWriter(fileName);
            for (csvFile listCSV : format) {
                fileWriter.append(String.valueOf(listCSV.getID()));
                fileWriter.append(l.COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getName()));
                fileWriter.append(l.COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getEmail()));
                fileWriter.append(l.COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getPhone()));
                fileWriter.append(l.COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getAddress()));
                fileWriter.append(l.NEW_LINE_SEPARATOR);
            }
            System.err.println("Export Done!!!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void print(ArrayList<csvFile> format) {
        for (int i = 0; i < format.size(); i++) {
            System.out.printf("%d,%s,%s,%s,%s\n", format.get(i).getID(),
                    format.get(i).getName(), format.get(i).getEmail(), format.get(i).getPhone(),
                    format.get(i).getAddress());
        }
    }
}
