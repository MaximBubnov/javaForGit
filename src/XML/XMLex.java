package XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class XMLex {

    public static void main(String[] args) throws JAXBException {

        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 4;
        cat.weight = 8;

        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(Cat.class);

        Marshaller marshaller = context.createMarshaller();

        //устанавливает свойство FORMATTED_OUTPUT в TRUE. В результат будут добавлены переносы строки и пробелы,
        // чтобы код был читабельным для человека, а не весь текст в одну строку
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(cat, writer);

        String result = writer.toString();

        System.out.println(result);
    }
}
