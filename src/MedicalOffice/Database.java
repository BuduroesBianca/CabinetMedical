package MedicalOffice;

import java.util.Vector;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Database {

    private static Database db = null;

    public static Database getDatabaseInstance() {
        if (db == null)
            db = new Database();
        return db;
    }

    private Database() {
    }

    protected List<String[]> readDataFromCsv(String csvFile) {
        try {
            List<String[]> data = Files.readAllLines(Paths.get("data/" + csvFile)).stream()
                    .map(line -> line.split(","))
                    .collect(Collectors.toList());
            return data;
        } catch (IOException e) {
            System.out.println("Error while loading the file");
        }
        return null;
    }

    protected static void writeDataToCsv(String csvFile, String[] data){
        try {
            File file = new File ("data/"+csvFile);
            if (!file.exists())
                file.createNewFile();

            FileWriter csvWriter = new FileWriter(file, true);
            csvWriter.write(String.join(",", data));
            csvWriter.write("\n");
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

