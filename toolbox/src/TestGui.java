import javax.swing.JFrame;
import java.awt.*;

public class TestGui extends JFrame{
    private int guiHeight;
    private int guiWidth;
    private Label label;

    public TestGui(int guiHeight, int guiWidth) throws HeadlessException {
        this.setSize(guiWidth, guiHeight);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        label = new Label();
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}
