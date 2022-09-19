import javax.swing.*;
import java.io.*;

class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    
    public ImageViewerFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        var label = new JLabel();
        add(label);
        
        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        var menu = new JMenu("文件");
        menuBar.add(menu);
        
        var openItem = new JMenuItem("打开");
        menu.add(openItem);
        openItem.addActionListener(enent -> {
            int result = chooser.showOpenDialog(null);
            
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });
        
        var closeItem = new JMenuItem("关闭");
        menu.add(closeItem);
        menu.addActionListener(event -> label.setIcon(null));
        
        menu.addSeparator();
        
        var exitItem = new JMenuItem("退出");
        menu.add(exitItem);
        menu.addActionListener(event -> System.exit(0));
    }
}
