package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2020-10-05
 */
public class DockerUtil {
    public DockerUtil() {
    }

    public static String ensureDockerIpFromEtcResolveConf() {
        String docker = System.getenv("C_CONTAINER");
        if (!StringUtils.isEmpty(docker) && "docker".equalsIgnoreCase(docker)) {
            File file = new File("/etc/resolv.conf");
            if (!file.exists()) {
                return null;
            } else {
                FileReader fileReader = null;
                BufferedReader bufferedReader = null;

                String var6;
                try {
                    String dockerIp;
                    try {
                        fileReader = new FileReader(file);
                        bufferedReader = new BufferedReader(fileReader);
                        String line = null;

                        do {
                            if ((line = bufferedReader.readLine()) == null) {
                                return null;
                            }
                        } while(!line.startsWith("nameserver"));

                        dockerIp = line.replaceAll("nameserver", "").trim();
                        System.out.println("docker容器IP： " + dockerIp);
                        var6 = dockerIp;
                    } catch (Throwable var22) {
                        var22.printStackTrace();
                        dockerIp = null;
                        return dockerIp;
                    }
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException var21) {
                            var21.printStackTrace();
                        }
                    }

                    if (fileReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException var20) {
                            var20.printStackTrace();
                        }
                    }

                }

                return var6;
            }
        } else {
            return null;
        }
    }
}
