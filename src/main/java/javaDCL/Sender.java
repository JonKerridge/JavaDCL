package javaDCL;

import jcsp.lang.CSProcess;
import jcsp.net2.NetChannelOutput;

public class Sender implements CSProcess {

    NetChannelOutput toNext;

    public Sender(NetChannelOutput toNext) {
        this.toNext = toNext;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++){
            TestObject1 obj1 = new TestObject1(i);
            toNext.write(obj1);
            System.out.println("Sender: " + obj1.toString());
        }
    }
}
