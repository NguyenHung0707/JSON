package Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Book {
    public static void main(String[] args) {
            JSONObject BookDetails = new JSONObject();
            BookDetails.put("id", "01");
            BookDetails.put("Name", "Giết con chim nhại");
            BookDetails.put("Price","2000$");
            BookDetails.put("author","Harper Lee");

            JSONObject BookObject = new JSONObject();
            BookObject.put("Book", BookDetails);

            JSONObject BookDetails2 = new JSONObject();
            BookDetails2.put("id", "02");
            BookDetails2.put("Name", "Vụ án");
            BookDetails2.put("price", "1000$");
            BookDetails2.put("author","Franz Kafka");

            JSONObject BookObject2 = new JSONObject();
            BookObject2.put("Book", BookDetails2);

            JSONArray BookList = new JSONArray();
            BookList.add(BookObject);
            BookList.add(BookObject2);

            try(FileWriter file = new FileWriter("Book.json")){
                file.write(BookList.toJSONString());
                file.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

