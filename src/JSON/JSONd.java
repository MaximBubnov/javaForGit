package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
//дессериализация
public class JSONd {
    public static void main(String[] args) throws IOException
    {
        String jsonString = "{ \"name\"=\"Murka\", \"age\"=5, \"weight\"=4}";
        StringReader reader = new StringReader(jsonString);

        ObjectMapper mapper = new ObjectMapper();

        Cat cat = mapper.readValue(reader, Cat.class);
    }
}
