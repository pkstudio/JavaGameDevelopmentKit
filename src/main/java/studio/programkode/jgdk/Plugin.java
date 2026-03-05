package studio.programkode.jgdk;

import studio.programkode.jgdk.library.helper.Terminal;


public abstract class Plugin
{
    //# Fields
    private final String identifier;


    //# Constructors
    public Plugin() {
        this.identifier = "Plugin%s".formatted(this.hashCode());

        Terminal.log("Canvas.%s".formatted(this.identifier), "Plugin initialized");
    }

    public Plugin(String identifier) {
        this.identifier = identifier;

        Terminal.log(this.identifier, "Plugin initialized");
    }


    //# Methods
    public String getIdentifier() {
        return this.identifier;
    }

    public void setup(API.Setup window) {}

    public void update(API.Update window) {}

    abstract public void draw(API canvas);
}
