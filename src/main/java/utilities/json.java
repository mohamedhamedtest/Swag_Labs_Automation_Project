package utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class json {


    private static final String path ="src/test/resources/testData/";
    public static String GetJsonData(String filname ,String field) throws FileNotFoundException {

        try {


        FileReader reader=new FileReader(path + filname +".json");
        JsonElement element = JsonParser.parseReader(reader);
        return element.getAsJsonObject().get(field).getAsString();

    }catch (Exception E){
        E.printStackTrace();
        }
    return "";}


    public static String GETPropertriesData(String filename,String key) throws IOException {
        Properties pro = new Properties();
        pro.load(new FileInputStream(path +filename +".properties"));
        return pro.getProperty(key);


    }
}
