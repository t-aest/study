package taest.jvm;

import sun.awt.HKSCS;
import sun.net.spi.nameservice.dns.DNSNameService;

public class ClassLoaderLevelTest {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(HKSCS.class.getClassLoader());
        System.out.println(DNSNameService.class.getClassLoader());
        System.out.println(ClassLoaderLevelTest.class.getClassLoader());


        System.out.println(DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(ClassLoaderLevelTest.class.getClassLoader().getClass().getClassLoader());

    }
}
