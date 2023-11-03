
package Repository;

import DataAccess.CSVFileDao;
import java.util.ArrayList;
import java.util.List;
import model.csvFile;


public class ModuleCSVRepository implements IModuleCSVRepository{
    /*private List<CSVFileDao> format;
    
    public ModuleCSVRepository(){
        format = new ArrayList();
        
    }*/
    
    @Override
    public void formatName(ArrayList<csvFile> format) {
        CSVFileDao.Instance().formatName(format);
    }

    @Override
    public void formatAddress(ArrayList<csvFile> format) {
        CSVFileDao.Instance().formatAddress(format);
    }

    @Override
    public void importFile(ArrayList<csvFile> format) {
        CSVFileDao.Instance().importFile(format);
    }

    @Override
    public void exportFile(ArrayList<csvFile> format) {
        CSVFileDao.Instance().exportFile(format);
    }

    @Override
    public void print(ArrayList<csvFile> format) {
        CSVFileDao.Instance().print(format); 
    }
    
}
