package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.controller.ControllerTest;
import cz.fit.dpo.mvcshooter.controller.ContollerMenuBar;
import java.awt.BorderLayout;


import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Ondrej Stuchlik
 */
public class MainWindow extends JFrame {
    public JMenuBar menuBar;

    public MainWindow(View view, final ControllerTest controller, Model model) {
        try {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("MyShooter");
            this.setResizable(false);

            Dimension obrazovka = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(
                  (int) (obrazovka.getWidth() / 2 - 250),
                  (int) (obrazovka.getHeight() / 2 - 250));

            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent evt) {
                    controller.handleKeyboardPressed(evt);
                }
            });
            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent evt) {
                    controller.handleKeyboardReleased(evt);
                
                }
            });

            this.add(view.getCanvas(), BorderLayout.PAGE_END);
            this.add(view.getInfoCanvas(), BorderLayout.PAGE_START);
            menuBar = ContollerMenuBar.createGUI();
            this.setJMenuBar(menuBar);
            this.pack();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }

    }
    public void showHelp() {
        JOptionPane.showMessageDialog(this, 
              "Controls: \n"
              + "here goes some description...");
    }
}
