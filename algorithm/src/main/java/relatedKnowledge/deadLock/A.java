package relatedKnowledge.deadLock;

/**
 * @Author: Gpw
 * @Date: 2020/7/3
 * @Description:
 */
public class A {
    public void get(){
        System.out.println("A说:我开始启动了，B，给我你的资源");
    }
    public void say(){
        System.out.println("A获得资源");
    }
}
