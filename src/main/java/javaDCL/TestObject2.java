package javaDCL;

import java.io.Serializable;

public class TestObject2 implements Serializable {

    int data2;
    TestObject1  to1;

    public TestObject2(int data2, TestObject1 to1) {
        this.data2 = data2;
        this.to1 = to1;
    }

    public String toString(){
        String s = "TO2: " + data2 + " plus " +to1.toString();
        return s;
    }
}
