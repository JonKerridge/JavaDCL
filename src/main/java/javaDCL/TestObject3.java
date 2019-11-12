package javaDCL;

import java.io.Serializable;

public class TestObject3 implements Serializable {

    int data3;
    TestObject2  to2;

    public TestObject3(int data3, TestObject2 to2) {
        this.data3 = data3;
        this.to2 = to2;
    }

    public String toString(){
        String s = "TO3: " + data3 + " plus " + to2.toString();
        return s;
    }
}
