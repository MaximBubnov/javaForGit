package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class JSONc {
    public static void main(String[] args) throws IOException
    {
       Dog dog = new Dog();
       dog.name = "Barbos";
       dog.age = 4;
       dog.weight = 7;

        StringWriter writer = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(writer, dog);

        String result = writer.toString();
        System.out.println(result);
    }
}
