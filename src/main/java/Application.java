import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {
    public Application(){
        this.packages("controller");
    }
}
