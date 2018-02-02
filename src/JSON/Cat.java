package JSON;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.StringReader;

@JsonAutoDetect
class Cat {
    public String name;
    public int age;
    public int weight;
    Cat() { }
}
