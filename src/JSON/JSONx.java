package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

//сериализация
public class JSONx {
    public static void main(String[] args) throws IOException {
        //создание объекта для сериализации в JSON
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 4;
        cat.weight = 6;
        //писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();
        //это объект Jackson, который выполняет сериализацию
        ObjectMapper objectMapper = new ObjectMapper();
        // сама сериализация: 1-куда, 2-что
        objectMapper.writeValue(writer, cat);
        //преобразовываем все записанное во StringWriter в строку
        String result = writer.toString();

        System.out.println(result);
    }
}
