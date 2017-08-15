package updater;

import org.w3c.dom.Element;

public class Instruction {
    private Action action;
    private String destination;
    private String filename;

    public Instruction(Element element) {
        filename = element.getElementsByTagName("file").item(0).getTextContent();
        destination = element.getElementsByTagName("destination").item(0).getTextContent();
        setAction(element.getElementsByTagName("action").item(0).getTextContent());
    }

    public Action getAction() {
        return action;
    }

    public String getDestination() {
        return destination;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setAction(String value) {
        if (value.equalsIgnoreCase("UPDATE")) {
            this.action = Action.UPDATE;
        } else if (value.equalsIgnoreCase("DELETE")) {
            this.action = Action.DELETE;
        } else if (value.equalsIgnoreCase("EXECUTE")) {
            this.action = Action.EXECUTE;
        }
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "action=" + action +
                ", filename='" + filename + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
