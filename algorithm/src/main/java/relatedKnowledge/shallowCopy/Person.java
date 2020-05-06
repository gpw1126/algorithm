package relatedKnowledge.shallowCopy;

import lombok.Data;
import lombok.ToString;

/**
 * @Author:Gpw
 * @Date:2020/3/27
 * @Description:relatedKnowledge.shallowCopy
 */
@Data
@ToString
public class Person {

    private String name;
    private Age age;

    public Person(String name, Age age) {
        this.name = name;
        this.age = age;
    }

    public Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }
}
