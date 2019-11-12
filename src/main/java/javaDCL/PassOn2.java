package javaDCL;

import jcsp.lang.CSProcess;
import jcsp.net2.NetChannelInput;

public class PassOn2 implements CSProcess {

    NetChannelInput fromPrevious;
    int offset2;

    public PassOn2(NetChannelInput fromPrevious, int offset2) {
        this.fromPrevious = fromPrevious;
        this.offset2 = offset2;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++){
            TestObject2 in2 = (TestObject2) fromPrevious.read();
            TestObject3 out3 = new TestObject3 (offset2, in2);
            System.out.println("PassOn2: " + out3.toString());
            offset2 += 1000;
        }
    }
}
