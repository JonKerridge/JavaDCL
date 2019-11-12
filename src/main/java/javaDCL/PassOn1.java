package javaDCL;

import jcsp.lang.CSProcess;
import jcsp.net2.NetChannelInput;
import jcsp.net2.NetChannelOutput;

public class PassOn1 implements CSProcess {

    NetChannelInput fromPrevious;
    NetChannelOutput toNext;
    int offset1;

    public PassOn1(NetChannelInput fromPrevious, NetChannelOutput toNext, int offset1) {
        this.fromPrevious = fromPrevious;
        this.toNext = toNext;
        this.offset1 = offset1;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++){
            TestObject1 in1 = (TestObject1)fromPrevious.read();
            TestObject2 out2 = new TestObject2(offset1, in1);
            toNext.write(out2);
            System.out.println("PassOn1: " + out2.toString());
            offset1 += 100;
        }
    }
}
