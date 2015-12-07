package GUI;

/**
 * Created by Mathias on 30-11-2015.
 */
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ScreenFrame extends JFrame {
    public final String LOGIN = "login";
    public final String USERSCREEN = "userscreen";
    public final String CREATE = "create";
    public final String JOIN = "join";
    public final String DELETE = "delete";
    public final String HIGHSCORE = "Highscore";

    private LoginScreen login;
    private UserScreen userscreen;
    private CreateScreen create;
    private JoinScreen join;
    private DeleteScreen delete;
    private ScoreScreen highscore;

    private JPanel contentPane;
    private CardLayout c;

    public ScreenFrame(){

        setTitle("Snake Client");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout(0, 0));
        setContentPane(contentPane);

        login = new LoginScreen();
        login.setBackground(new Color(255, 255, 255));
        login.setBounds(100, 100, 600, 500);
        login.setLayout(null);
        contentPane.add(login, LOGIN);

        userscreen = new UserScreen();
        userscreen.setBackground(new Color(255, 255, 255));
        userscreen.setBounds(100, 100, 600, 500);
        userscreen.setLayout(null);
        contentPane.add(userscreen, USERSCREEN);

        create = new CreateScreen();
        create.setBackground(new Color(255, 255, 255));
        create.setBounds(100, 100, 600, 500);
        create.setLayout(null);
        contentPane.add(create,CREATE);

        join = new JoinScreen();
        join.setBackground(new Color(255, 255, 255));
        join.setBounds(100, 100, 600, 500);
        join.setLayout(null);
        contentPane.add(join, JOIN);

        delete = new DeleteScreen();
        delete.setBackground(new Color(255, 255, 255));
        delete.setBounds(100, 100, 600, 500);
        delete.setLayout(null);
        contentPane.add(delete, DELETE);

        highscore = new ScoreScreen();
        highscore.setBackground(new Color(255,255,255));
        highscore.setBounds(100,100,600,500);
        highscore.setLayout(null);
        contentPane.add(highscore,HIGHSCORE);

        c = (CardLayout) getContentPane().getLayout();
    }

    public LoginScreen getLoginScreen(){
        return login;
    }

    public UserScreen getUserScreen(){
        return userscreen;
    }

    public CreateScreen getCreate(){ return create;}

    public JoinScreen getJoin() { return join;}

    public DeleteScreen getDelete() {return delete;}

    public ScoreScreen getHighscore() {return highscore;}

    public void show(String card){
        c.show(this.getContentPane(), card);
    }
}
