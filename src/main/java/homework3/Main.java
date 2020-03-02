package homework3;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
    static Logger LOG = Logger.getLogger(Shop.class);

    public static void main(String[] args) {
        DOMConfigurator.configure("loggerConfig.xml");
        Shop shop = new Shop();
        shop.productChoicer();
    }
}
