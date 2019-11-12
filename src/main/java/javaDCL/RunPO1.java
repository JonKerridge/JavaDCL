package javaDCL;

import jcsp.lang.CSProcess;
import jcsp.net2.NetChannel;
import jcsp.net2.NetChannelInput;
import jcsp.net2.NetChannelOutput;
import jcsp.net2.Node;
import jcsp.net2.mobile.CodeLoadingChannelFilter;
import jcsp.net2.tcpip.TCPIPNodeAddress;

public class RunPO1 {
    public static void main(String[] args) {
        String sendIP = "127.0.0.1";
        String po1IP = "127.0.0.2";
        String po2IP = "127.0.0.3";

        TCPIPNodeAddress po1IPAddress = new TCPIPNodeAddress(po1IP, 1000);
        Node.getInstance().init(po1IPAddress);

        NetChannelInput fromSend = NetChannel.numberedNet2One(1, new CodeLoadingChannelFilter.FilterRX());

        TCPIPNodeAddress po2IPAddress = new TCPIPNodeAddress(po2IP, 1000);
        NetChannelOutput toNext = NetChannel.one2net(po2IPAddress, 1, new CodeLoadingChannelFilter.FilterTX());

        CSProcess po1 = new PassOn1( fromSend, toNext, 100);

        po1.run();
    }
}
