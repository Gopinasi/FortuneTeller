import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;


public class FortuneTellerFrame extends JFrame
{
    JPanel mainPanel;
    JPanel topPanel;
    JPanel displayPanel;
    JPanel controlPanel;

    JTextArea display;
    JScrollPane scroll;

    JLabel title;
    ImageIcon image;

    JButton fortuneButton;
    JButton quitButton;

    Random rnd = new Random(12);
    ArrayList<String> fortunes = new ArrayList();
    String oldFortune = "";
    String newFortune = "";


    public FortuneTellerFrame()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = (int) (screenSize.width/2.75);
        int height = (int) (screenSize.height*0.10);

        setLocation(width, height);

        createTopPanel();

        mainPanel.add(topPanel, BorderLayout.NORTH);

        createDisplayPanel();
        mainPanel.add(displayPanel, BorderLayout.CENTER);

        createControlPanel();
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        createFortunes();

        add(mainPanel);
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTopPanel()
    {
        topPanel = new JPanel();
        image = new ImageIcon("src/FortuneTellerImage.jpg");
        title = new JLabel("Fortune Teller",image,JLabel.CENTER);
        title.setFont(new Font ("Monospaced",Font.BOLD,36));
        title.setVerticalTextPosition(SwingConstants.BOTTOM);
        title.setHorizontalTextPosition(SwingConstants.CENTER);

        topPanel.add(title);
    }

    private void createDisplayPanel()
    {
        displayPanel = new JPanel();
        display = new JTextArea(13, 25);
        display.setEditable(false);
        display.setFont(new Font ("Times New Roman",Font.PLAIN,14));
        scroll = new JScrollPane(display);
        displayPanel.add(scroll);
    }

    private void createFortunes(){
        fortunes.add("You will pass this course with an A+!");
        fortunes.add("You will get money in the next week!");
        fortunes.add("You will achieve your dream sooner than you think!");
        fortunes.add("You will soon find true love!");
        fortunes.add("Change is headed your way!");
        fortunes.add("The next person you see is going to turn your life around!");
        fortunes.add("Happiness is all around you!");
        fortunes.add("At a time of sorrow a saviour will be upon you!");
        fortunes.add("You will be showered with love in a couple hours!");
        fortunes.add("You will do great on midterms!");
        fortunes.add("Trust your intuition, be the leader of your life!");
        fortunes.add("Those that you trust will never leave your side!");
    }

    private void createControlPanel()
    {

        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout());

        fortuneButton = new JButton("Read My Fortune!");
        fortuneButton.setFont(new Font ("Arial",Font.BOLD,14));
        fortuneButton.addActionListener((ActionEvent ae) ->
        {
            while (newFortune.equals(oldFortune)) {
                int index = rnd.nextInt(fortunes.size());
                newFortune = fortunes.get(index);
            }

            oldFortune = newFortune;
            display.append(newFortune + "\n");
        });


        quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));
        quitButton.setFont(new Font ("Arial",Font.BOLD,14));



        controlPanel.add(fortuneButton);
        controlPanel.add(quitButton);

    }


}
