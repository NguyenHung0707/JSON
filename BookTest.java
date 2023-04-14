package Json;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class BookTest {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("Book.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray BookList = (JSONArray) obj;
            System.out.println(BookList);

            BookList.forEach( book -> BookObject((JSONObject) book));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static void BookObject(JSONObject book) {
        JSONObject BookObject = (JSONObject) book.get("Book");
        String id = (String) BookObject.get("id");
        System.out.println(id);

        String Name = (String) BookObject.get("Name");
        System.out.println(Name);

        String price = (String) BookObject.get("price");
        System.out.println(price);

        String author = (String) BookObject.get("author");
        System.out.println(author);

    }
}
