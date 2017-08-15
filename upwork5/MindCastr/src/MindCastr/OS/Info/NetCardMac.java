package MindCastr.OS.Info;

import java.net.*;
import java.util.*;

public class NetCardMac {

    public static void main(String args[]) throws SocketException {
        Enumeration nets =
                NetworkInterface.getNetworkInterfaces();
        for (Object netint : Collections.list(nets)) {
            getNetCardAddress((NetworkInterface) netint);
        }
    }

    public static String getNetCardAddress(NetworkInterface netint)
            throws SocketException {
        String NetMacAddress = Arrays.toString(netint.getHardwareAddress());
//        if (NetMacAddress != "" || NetMacAddress != null || NetMacAddress != "[]") {
//            System.out.println("Display name: "
//                    + netint.getDisplayName());
//            System.out.println("Hardware address: " + NetMacAddress);
//        }
        return NetMacAddress;
    }
}
