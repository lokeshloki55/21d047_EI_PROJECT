package EI_Exercise1;
import java.util.*;
class ConfigurationManager {
    private static ConfigurationManager instance;
    private String config;

    private ConfigurationManager() {}

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getConfig() {
        return config;
    }
}

public class CDP_singletonPattern{
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter configuration: ");
        String config = scanner.nextLine();

        configManager.setConfig(config);
        System.out.println("Config set to: " + configManager.getConfig());
    }
}
