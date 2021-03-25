package util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2020-10-05
 */
public class CookiesUtil {
    public static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") > -1) {
            isWindowsOS = true;
        }
        return isWindowsOS;
    }

    public static String getLocalIP() throws UnknownHostException, SocketException {
        if (isWindowsOS()) {
            return InetAddress.getLocalHost().getHostAddress();
        } else {
            String dockerIP = DockerUtil.ensureDockerIpFromEtcResolveConf();
            return StringUtils.isEmpty(dockerIP) ? getLinuxLocalIp() : dockerIP;
        }
    }

    private static String getLinuxLocalIp() throws SocketException {
        String ip = "";

        try {
            Enumeration en = NetworkInterface.getNetworkInterfaces();

            label43:
            while(true) {
                NetworkInterface intf;
                String name;
                do {
                    do {
                        if (!en.hasMoreElements()) {
                            break label43;
                        }

                        intf = (NetworkInterface)en.nextElement();
                        name = intf.getName();
                    } while(name.contains("docker"));
                } while(name.contains("lo"));

                Enumeration enumIpAddr = intf.getInetAddresses();

                while(enumIpAddr.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress)enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String ipaddress = inetAddress.getHostAddress().toString();
                        if (!ipaddress.contains("::") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {
                            ip = ipaddress;
                            System.out.println(ipaddress);
                        }
                    }
                }
            }
        } catch (SocketException var7) {
            System.out.println("获取ip地址异常");
            ip = "127.0.0.1";
            var7.printStackTrace();
        }

        System.out.println("IP:" + ip);
        return ip;
    }

    public static void main(String[] args) throws Exception{
        getLocalIP();
    }
}
