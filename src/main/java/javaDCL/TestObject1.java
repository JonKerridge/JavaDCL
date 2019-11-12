package javaDCL;

import java.io.Serializable;

public class TestObject1 implements Serializable {

    int data1;

    public TestObject1(int data1) {
        this.data1 = data1;
    }

    public String toString() {
        String s = "TO1: " + data1;
        return s;
    }
}
