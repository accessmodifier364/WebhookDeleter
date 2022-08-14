package me.accessmodifier364.webhookdeleter.gui;

import me.accessmodifier364.webhookdeleter.service.HttpService;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.util.Objects;

/**
 * @author accessmodifier364
 * @since 5/16/2022 at 05:24
 */

public class GraphicalInterface extends JFrame {

    /**
     * <init> method which initializes our graphical interface.
     *
     * @throws HeadlessException From parent.
     */
    public GraphicalInterface() throws HeadlessException {
        super("Webhook Deleter v1.1");

        /* Set some attributes to our gui (icon, size, background color, look-and-feel). */
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(204, 204, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/assets/icon.png"))).getImage());
        setSize(500, 150);
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ignored) {
        }

        /* Creates the text area where the webhook should be put. */
        final JTextArea textArea = new JTextArea();
        textArea.setToolTipText("Put your webhook here!");
        textArea.setBounds(10, 10, getWidth() - 35, 25);
        add(textArea);

        /* Creates the button and adds a listener to the button. */
        final JButton button = new JButton("Delete");
        button.setBounds(getWidth() / 2 - 50, 70, 80, 30);
        button.addActionListener(e -> HttpService.deleteWebhook(textArea.getText()));
        add(button);

        /* Adds the label in the center */
        final JLabel label = new JLabel("Made by accessmodifier364");
        label.setBounds(getWidth() / 2 - 110, 40, 240, 20);
        label.setFont(new Font("Lato", Font.ITALIC, 16));
        add(label);

        /* Shows the GUI */
        setVisible(true);
    }
}