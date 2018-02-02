package XML;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "zoo")
@XmlRootElement
public class Zoo {
    @XmlElementWrapper(name = "wild-animal", nillable = true)
    public ArrayList<Tiger> list = new ArrayList<>();
}

@XmlType(name = "tiger")
class Tiger {
    @XmlElement(name = "catname")
    public String name;
    @XmlAttribute(name = "age")
    public int age;
    @XmlAttribute(name = "w")
    public int weight;

    Tiger() {}
}
