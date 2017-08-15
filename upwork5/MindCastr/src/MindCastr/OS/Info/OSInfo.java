package MindCastr.OS.Info;

public class OSInfo {

    public static String getOSName(){
        String nameOS = System.getProperty("os.name");
        return nameOS;
    }
    
    public static String getOSVersion(){
        String version = System.getProperty("os.version");
        return version;
    }
    
    public static String getOSArch(){
        String arch = System.getProperty("os.arch");
        return arch;
    }
//    
//    public static void main(String args[]) {
//        System.out.println(getOSName());
//    }
}