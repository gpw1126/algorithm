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
public class Age {

    private int age;

    public Age(int age) {
        this.age = age;
    }

    public Age(Age a) {
        this.age = a.age;
    }
}
