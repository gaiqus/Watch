import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Watch extends JFrame {
    public Watch()
    {
        super("Watch");
        this.setBounds(300, 300, 300, 200);

        initComponents();

        this.setDefaultCloseOperation(3);
    }

    public void initComponents()
    {
        panel.add(time);

        ActionListener stoper = new Zegar();

        Timer zegar = new Timer(1000, stoper);

        zegar.start();

        this.getContentPane().add(panel);
        pack();
    }
    JPanel panel = new JPanel();
    JLabel time = new JLabel(getTime());

    private class Zegar implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            time.setText(getTime());
        }
    }

    public String getTime()
    {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        String h = ""+gregorianCalendar.get(Calendar.HOUR_OF_DAY);
        String min = ""+gregorianCalendar.get(Calendar.MINUTE);
        String sec = ""+gregorianCalendar.get(Calendar.SECOND);

        if (Integer.parseInt(h) < 10)
            h = "0" + h;
        if (Integer.parseInt(min) < 10)
            min = "0" + min;
        if (Integer.parseInt(sec) < 10)
            sec = "0" + sec;

        return h+" : "+min+" : "+sec;
    }
    public static void main(String[] args)
    {
        new Watch().setVisible(true);
    }

}
