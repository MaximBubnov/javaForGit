package XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class XMLhard {
    public static void main(String[] args) throws JAXBException {
        Tiger tiger = new Tiger();
        tiger.name = "Vaska";
        tiger.age = 5;
        tiger.weight = 8;

        Zoo zoo = new Zoo();
        zoo.list.add(tiger);
        zoo.list.add(tiger);

        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(Tiger.class, Zoo.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(zoo, writer);

        String result = writer.toString();

        System.out.println(result);
    }
}
