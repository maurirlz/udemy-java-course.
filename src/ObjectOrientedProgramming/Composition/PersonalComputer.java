package ObjectOrientedProgramming.Composition;

public class PersonalComputer {

    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PersonalComputer(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        theCase.pressPowerButoon();
        drawLogo();
    }

    private void drawLogo() {
        // fancy graphics
        monitor.drawPixelAt(1200,50,"yellow");
    }

}
