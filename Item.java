import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class Item {
    public int[] itemCode;
    public String[] itemName;
    public float[] unitPrice;
    /** Item constructor */
    Item() {
        String [] data = new String[0];
        data = this.readFile(data);

        itemCode = new int[data.length];
        itemName = new String[data.length];
        unitPrice = new float[data.length];

        for (int i = 0; i < data.length; i++) {
            String [] dataDivided = data[i].split(",");
            itemCode[i] = Integer.parseInt(dataDivided[0]);
            itemName[i] = dataDivided[1];
            unitPrice[i] = Float.parseFloat(dataDivided[2]);
        }
    }
    public String [] readFile(String[] fileData) {
        try {
            File eleFile = new File("StoringData.txt");
            int arraySize = 0;
            String line;

            BufferedReader br = new BufferedReader(new FileReader(eleFile));
            while ((line = br.readLine()) != null) {
                arraySize++;
            }
            br.close();

            fileData = new String[arraySize];

            br = new BufferedReader(new FileReader(eleFile));
            int i = 0;
            while ((line = br.readLine()) != null) {
                fileData[i] = line;
                i++;
            }
            br.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return fileData;
    }
    public String getName(int code) {
        return itemName[code - 1];
    }
    public double getPrice(int code) {
        return unitPrice[code - 1];
    }
}

