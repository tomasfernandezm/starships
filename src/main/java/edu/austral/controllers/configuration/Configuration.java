package edu.austral.controllers.configuration;

public abstract class Configuration {

    private final String filePath;

    public Configuration(String filePath) {
        this.filePath = filePath;
    }

}
