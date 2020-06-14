package relatedKnowledge.Generic;

/**
 * @Author:Gpw
 * @Date:2020/6/13
 * @Description:relatedKnowledge.Generic
 */
public class GenericObj<T> {

    T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
