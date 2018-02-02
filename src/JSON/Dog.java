package JSON;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect class Dog {
    @JsonProperty(value = "alias") public String name; //изменение при выводе name на alias
    public int age;
    @JsonIgnore public int weight;  //будет игнорироваться при сериализации
    Dog() {}
}
