// Homework 1: Cash Registar Problem
// Course: CIS357
// Due Date: 7/5/2022
// Name: Christian Jaquith
// GitHub: https://github.com/cjjaquith/cis357-hw1-Jaquith
// Instructor: Il-Hyung Cho
// Program Description: This program simulates a cash registar at a grocery store.
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;
/** Javadoc commenets for CashRegistar.java */
class Item {
    public int[] itemCode;
    public String[] itemName;
    public float[] unitPrice;
    /** Item constructor */
    Item() {
        String [] data = new String[0];
        data = readFile(data);


        itemCode = new int[data.length];
        itemName = new String[data.length];
        unitPrice = new float[data.length];

        for (int i = 0; i < data.length; i++) {
            String[] dataDivided = data[i].split(",");
            itemCode[i] = Integer.parseInt(dataDivided[0]);
            itemName[i] = dataDivided[1];
            unitPrice[i] = Float.parseFloat(dataDivided[2]);
        }
    }
    public String [] readFile(String [] fileData) {
        try {
            File eleFile = new File("SortingData.txt");
            int arraySize = 0;
            String line;

            BufferedReader br = new BufferedReader(new FileReader(eleFile));
            while((line = br.readLine()) != null ) {
                arraySize++;
            }
            br.close();

            fileData = new String[arraySize];

            br = new BufferedReader(new FileReader(eleFile));
            int i =0;
            while((line = br.readLine()) != null) {
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
public class CashRegistar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String [] data = new String[100];
        int count = 0;
        int code;
        double totalDataCode = 0;
        double sales = 0;

        System.out.println("Welcome to Jaquith's cash register system");
        System.out.println ("");
        System.out.println("Beginnig a new sale (Y/N) ");
        String answer = input.next();

        while (answer.toLowerCase(Locale.ROOT).equals("y")) {
            if (answer.toLowerCase(Locale.ROOT).equals("y")) {
                do {
                    Item n1 = new Item();

                    System.out.print("Enter product code: ");
                    String value1 = input.next();

                    while (value1.charAt(0) < 48 || value1.charAt(0) > 57) {
                        System.out.println("!!!Invalid product code");
                        System.out.print("Enter priduct code: ");
                        value1 = input.next();
                    }
                    code = Integer.parseInt(value1);

                    if (code == -1) {
                        continue;
                    }

                    System.out.println("       item name: " + n1.getName(code));
                    String itemName = n1.getName(code);
                    double price = n1.getPrice(code);

                    System.out.print("Enter quantity: ");
                    value1 = input.next();

                    while (value1.charAt(0) < 48 || value1.charAt(0) > 57) {
                        System.out.println("!!!Invalid quantity");
                        System.out.print("Enter quantity code: ");
                        value1 = input.next();
                    }
                    int quantity = Integer.parseInt(value1);

                    double total = quantity * price;
                    System.out.println("Item total : $ " + total);

                    totalDataCode = totalDataCode + total;
                    data[count] = quantity + " " + itemName + " $" + String.format("%.2f", total);
                    count++;
                }
                while (code != -1);

                System.out.println("-----------------------");
                System.out.println("Item list: ");
                for (String datum : data) {
                    if (datum != null) {
                        System.out.print(datum);
                    }
                }
                System.out.println("SubTotal  $" + totalDataCode);
                double totalWithTax = totalDataCode * 6 / 100;
                System.out.println("Total with tax " + String.format("%.2f", totalWithTax));
                System.out.print("Tendered amount: $ ");
                double amountPay = Double.parseDouble(input.next());

                while (true) {
                    if (totalWithTax - amountPay > 0) {
                        System.out.println("Enter tenderd amount again.");
                        amountPay = Double.parseDouble(input.next());
                    } else {
                        break;
                    }
                }

                sales = sales + totalWithTax;
                double change = amountPay > totalWithTax ? amountPay - totalWithTax : 0;
                System.out.println("Change: " + String.format("%.2f", change));
                System.out.println("-----------------------");

                System.out.println();
                System.out.println();

                System.out.println("-----------------------");
                System.out.println("Beginning new sale (Y/N) ");
                answer = input.next();
            }
        }

        if (answer.toLowerCase(Locale.ROOT).equals("n")) {
            System.out.println("Total sales of the day is $" + String.format("%.2f", sales));
            System.out.println("Thanks for using POST system. Goodbye.");
        }
    }
}