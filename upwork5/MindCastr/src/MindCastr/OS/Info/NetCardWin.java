package MindCastr.OS.Info;

import MindCastr.constants.*;
import MindCastr.utils.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NetCardWin {

    private static String getNetMac() {
        InetAddress ip;
        String retString = "";
        
        try {
                Enumeration nets =
                    NetworkInterface.getNetworkInterfaces();
            for (Object netint : Collections.list(nets)) {
                String tmp = NetCardMac.getNetCardAddress((NetworkInterface) netint);
                if (tmp.length() > 0)
                {
                    retString = tmp;
                    break;
                }
            }
        } catch (SocketException ex) {
             Logger.getLogger(NetCardWin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        StringBuilder sb = new StringBuilder();
//        try {
//            ip = InetAddress.getLocalHost();
//            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
//            byte[] mac = network.getHardwareAddress();
//            for (int i = 0; i < mac.length; i++) {
//                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
//            }
//        } catch (UnknownHostException e) {
//        } catch (SocketException e) {
//        }
//        if (sb.toString() == null) {
//            try {
//                Enumeration nets =
//                    NetworkInterface.getNetworkInterfaces();
//            for (Object netint : Collections.list(nets)) {
//                String tmp = NetCardMac.getNetCardAddress((NetworkInterface) netint);
//                if (tmp.length() > 0)
//                {
//                    retString = tmp;
//                    break;
//                }
//            }
//            } catch (SocketException ex) {
//                Logger.getLogger(NetCardWin.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            retString = sb.toString();
//        }
        return retString;
    }

    public static void setNetMacToFile() {
        try {
            String NetMac = getNetMac();
            File fin = new File(Utils.getJarFilePath() + Constants.NET_MAC_FILE_NAME);
            fin.createNewFile();
            FileWriter fw = new FileWriter(fin);
            fw.write(NetMac);
            fw.close();
            MindCastr.crypto.Cryptor.doEncrypt(Utils.getJarFilePath()
                    + Constants.NET_MAC_FILE_NAME,
                    Utils.getJarFilePath()
                    + Constants.NET_MAC_FILE_NAME_ENCRYPTED);
            fin.delete();
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }

    public static boolean checkNetMac() throws FileNotFoundException, IOException {
        File fout = new File(Utils.getJarFilePath() + Constants.NET_MAC_FILE_NAME_DECRYPTED);

        fout.createNewFile();
        MindCastr.crypto.Cryptor.doDecrypt(Utils.getJarFilePath()
                + Constants.NET_MAC_FILE_NAME_ENCRYPTED,
                Utils.getJarFilePath()
                + Constants.NET_MAC_FILE_NAME_DECRYPTED);
        BufferedReader br = new BufferedReader(new FileReader(fout));
        String netMac = br.readLine();
        if (netMac.equals(getNetMac())) {
            br.close();
            fout.delete();
            return true;
        } else {
            fout.delete();
            br.close();
            return false;
        }
    }
}