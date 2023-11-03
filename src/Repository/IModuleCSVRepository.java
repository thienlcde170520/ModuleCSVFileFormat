
package Repository;

import java.util.ArrayList;
import model.csvFile;


public interface IModuleCSVRepository {
    void formatName(ArrayList<csvFile> format);
    void formatAddress(ArrayList<csvFile> format);
    void importFile(ArrayList<csvFile> format);
    void exportFile(ArrayList<csvFile> format);
    void print(ArrayList<csvFile> format);
}
