import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Words extends JFrame implements ActionListener {

    private JTabbedPane tabbedPane;


    public static void main(String[] args) {

        new Words().setVisible(true);

    }

    private Words() {
        super("Words");
        setSize(1024, 768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initialize();
    }

    private void initialize() {

        tabbedPane = new JTabbedPane();

        WordDocument doc = new WordDocument();
        tabbedPane.addTab(doc.getName(), doc);


        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem newDoc = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveas = new JMenuItem("Save As");
        JMenuItem exit = new JMenuItem("OpeExit");

        JMenuItem[] items = {newDoc, open, save, saveas, exit};
        for (JMenuItem item : items) {
            item.addActionListener(this);
        }

        file.add(newDoc);
        file.add(open);
        file.add(save);
        file.add(saveas);
        file.addSeparator();
        file.add(exit);

        bar.add(file);


        add(tabbedPane);
        setJMenuBar(bar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New")) {
            WordDocument doc = new WordDocument();
            tabbedPane.addTab(doc.getName(), doc);
        } else if (e.getActionCommand().equals("Open")) {
            open();
        } else if (e.getActionCommand().equals("Save")) {
            save();
        } else if (e.getActionCommand().equals("Save As")) {
            saveAs();
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }

    }


    private void open() {
        JFileChooser chooser = new JFileChooser("./");
        int returned = chooser.showOpenDialog(this);

        if (returned == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            WordDocument doc = new WordDocument(file.getName(), new JTextArea());

            tabbedPane.addTab(file.getName(), doc);

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    doc.getText().append(line + "\n");
                }

                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void save() {
        WordDocument doc = (WordDocument)tabbedPane.getSelectedComponent();
        doc.save();



    }

    private void saveAs() {
        JFileChooser chooser = new JFileChooser("./");

        int returned = chooser.showSaveDialog(this);

        if (returned==JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();

            WordDocument doc = (WordDocument) tabbedPane.getSelectedComponent();
            doc.saveAs(file.getAbsolutePath());
        }
    }


}
