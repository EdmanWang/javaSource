package javaSource.securityManager;

import javaSource.securityManager.util.CustomerSecurityManager;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SecurityManagerDemo {

    @Test
    public void test() throws IOException {
        SecurityManager securityManager = new CustomerSecurityManager();
        System.setSecurityManager(securityManager);

        FileInputStream fis = new FileInputStream(new File("src/javaSource/securityManager/util/wgx.txt"));

        int read = fis.read();
        System.out.println(read);
    }
}
