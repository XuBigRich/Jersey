import controller.Controller;
import org.glassfish.jersey.internal.inject.JerseyClassAnalyzer;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

import java.net.URI;

public class App {
    public static void main(String[] args) {
        JettyHttpContainerFactory.createServer(URI.create("http://localhost:8082/"), new Application());
    }

}
