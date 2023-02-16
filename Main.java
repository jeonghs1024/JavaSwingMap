import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;

public class Main extends JFrame {
    private JTextField textField = new JTextField(30);
    private JButton button = new JButton("Search");
    private JPanel panel = new JPanel();

    private GoogleAPI googleAPI = new GoogleAPI();
    private JLabel googleMap = new JLabel();

    public class Event implements MouseListener{
        //add unimplemented methods
        public void mouseClicked(MouseEvent e){
            setMap(textField.getText());
        }
        public void mouseEntered(MouseEvent e){
           
        }
        public void mouseExited(MouseEvent e){
            
        }
        public void mousePressed(MouseEvent e){
            
        }
        public void mouseReleased(MouseEvent e){
            
        }
    }

    public void setMap(String location) {
        googleAPI.downloadMap(location);
        googleMap.setIcon(googleAPI.getMap(location));
        googleAPI.fileDelete(location);
        add(BorderLayout.SOUTH, googleMap);
        pack();
    }

    public Main() {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Google Maps");
        setVisible(true);

        panel.add(textField);
        panel.add(button);
        button.addMouseListener(new Event());

        add(BorderLayout.NORTH, panel);
        pack();
    }

}
