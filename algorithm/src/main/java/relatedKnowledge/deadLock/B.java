package relatedKnowledge.deadLock;

/**
 * @Author: Gpw
 * @Date: 2020/7/3
 * @Description:
 */
public class B {
    public void get(){
        System.out.println("B说:我开始启动了，A，给我你的资源");
    }
    public void say(){
        System.out.println("B获得资源");
    }
}
