package javaDCL;

import jcsp.lang.CSProcess;
import jcsp.net2.NetChannel;
import jcsp.net2.NetChannelInput;
import jcsp.net2.Node;
import jcsp.net2.mobile.CodeLoadingChannelFilter;
import jcsp.net2.tcpip.TCPIPNodeAddress;

public class RunPO2 {
    public static void main(String[] args) {

        String sendIP = "127.0.0.1";
        String po1IP = "127.0.0.2";
        String po2IP = "127.0.0.3";

        TCPIPNodeAddress po2IPAddress = new TCPIPNodeAddress(po2IP, 1000);
        Node.getInstance().init(po2IPAddress);

        NetChannelInput fromPrevious = NetChannel.numberedNet2One( 1, new CodeLoadingChannelFilter.FilterRX());

        CSProcess po2 = new PassOn2( fromPrevious, 1000);

        po2.run();
    }
}
