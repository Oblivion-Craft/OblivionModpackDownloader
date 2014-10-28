package oblivionmodpack.downloader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Logger;


/*@author ViolentNinjaD

  Licensed under LGPL V3

*/
public class ModpackDownloader
{
    public static JFrame frame = new JFrame("Oblivion Modpack Downloader");
    public static JProgressBar pbar;
    public static final int PROGRESS_MIN = 0;
    public static final int PROGRESS_MAX = 100;
    public static void createAndShowGui()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(720, 512));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);

        JPanel panel = new JPanel();
        frame.add(panel);
        JButton buttonClose = new JButton("Close");
        //panel.setLayout(new BorderLayout());
        panel.setLayout(null);
        panel.add(buttonClose, BorderLayout.SOUTH);
        buttonClose.addActionListener(new ActionClose());
        buttonClose.setBounds(0, 462, 300, 50);

        JButton buttonOblivionModpack4 = new JButton("Download Oblivion Modpack 4");
        panel.add(buttonOblivionModpack4);
        buttonOblivionModpack4.addActionListener(new ActionDownloadOblivionModpack4());
        buttonOblivionModpack4.setBounds(0, 0, 300, 50);

        pbar = new JProgressBar();
        pbar.setMinimum(PROGRESS_MIN);
        pbar.setMaximum(PROGRESS_MAX);
        //frame.add(pbar);
        //pbar.setBounds(0, 362, 300, 50);

        final ModpackDownloader md = new ModpackDownloader();

        for (int i = PROGRESS_MIN; i <= PROGRESS_MAX; i++) {
            final int percent = i;
            try {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        md.updateBar(percent);
                    }
                });
                java.lang.Thread.sleep(100);
            } catch (InterruptedException e) {
                ;
            }
        }
    }

    public void updateBar(int newValue)
    {
        pbar.setValue(newValue);
    }

    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGui();
            }
        });
    }

    public static class ActionClose implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            frame.dispose();
            System.out.println("The Modpack Downloader has been closed!");
        }
    }

    public static class ActionDownloadOblivionModpack4 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    }
}
