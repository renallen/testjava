import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventDemo5 extends WindowAdapter implements ActionListener {
	JButton b1 = null;
	JButton b2 = null;

	public EventDemo5() {
		JFrame f = new JFrame("EventDemo5");
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new GridLayout(1, 2));
		b1 = new JButton("按我有声音喔");
		b2 = new JButton("按我可开新窗口");
		b1.addActionListener(this);
		b2.addActionListener(this);
		contentPane.add(b1);
		contentPane.add(b2);
		f.pack();
		f.show();
		f.addWindowListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1)// getSource判断哪个按钮被按下了。
			Toolkit.getDefaultToolkit().beep();
		if (e.getSource() == b2) {
			JFrame newF = new JFrame("新窗口");
			newF.setSize(200, 200);
			newF.show();
		}
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String args[]) {
//		new EventDemo5();
		new EventDemo6();
	}
}
class EventDemo6 extends WindowAdapter implements ActionListener {
	JButton b1 = null;
	JButton b2 = null;

	public EventDemo6() {
		JFrame f = new JFrame("EventDemo6");
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new GridLayout(1, 2));
		b1 = new JButton("按我有声音喔");
		b2 = new JButton("按我可开新窗口");
		b1.addActionListener(this);
		b2.addActionListener(this);
		contentPane.add(b1);
		contentPane.add(b2);
		f.pack();
		f.show();
		f.addWindowListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if ((e.getActionCommand()).equals("按我有声音喔")) // getActionCommand()方法会返回按钮上的文字字符串。
			Toolkit.getDefaultToolkit().beep();
		if ((e.getActionCommand()).equals("按我可开新窗口")) {
			JFrame newF = new JFrame("新窗口");
			newF.setSize(200, 200);
			newF.show();
		}
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}


}