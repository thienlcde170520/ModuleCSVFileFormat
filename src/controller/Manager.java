
package controller;

import Repository.IModuleCSVRepository;
import Repository.ModuleCSVRepository;
import java.util.ArrayList;
import model.csvFile;
import view.Menu;


public class Manager extends Menu<String>{
    static String[] mc = {"Import CSV.","Format Address.","Format Name.","Export CSV.","Exit."};
    IModuleCSVRepository module;
    ArrayList<csvFile> format = new ArrayList<>();
    public Manager(){
       super("===== Format CSV Program =====",mc);
        module = new ModuleCSVRepository();
    }
    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                module.importFile(format);
                module.print(format);
                break;
            case 2:
                module.formatAddress(format);
                module.print(format);
                break;                           
            case 3:
                module.formatName(format);
                module.print(format);
                break;
            case 4:
                module.exportFile(format);
                module.print(format);
                break;
            case 5:
                System.out.println("Exitting...!!!");
                System.exit(0); 
        }
    }
    
}
