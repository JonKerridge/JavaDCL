package javaDCL;

import jcsp.lang.CSProcess;
import jcsp.net2.NetChannel;
import jcsp.net2.NetChannelOutput;
import jcsp.net2.Node;
import jcsp.net2.mobile.CodeLoadingChannelFilter;
import jcsp.net2.tcpip.TCPIPNodeAddress;

public class RunSender {
    public static void main(String[] args) {
        String sendIP = "127.0.0.1";
        String po1IP = "127.0.0.2";
        String po2IP = "127.0.0.3";

        TCPIPNodeAddress sendAddress = new TCPIPNodeAddress(sendIP, 1000);
        Node.getInstance().init(sendAddress);

        TCPIPNodeAddress po1IPAddress = new TCPIPNodeAddress(po1IP, 1000);
        NetChannelOutput toNext = NetChannel.one2net(po1IPAddress, 1, new CodeLoadingChannelFilter.FilterTX());

        CSProcess send = new Sender(toNext);

        send.run();
    }
}
