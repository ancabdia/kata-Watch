package watch;

import javax.swing.JFrame;

public class Main extends JFrame{
    
    public static void main(String[] args) {
        new Main().launch();
    }

    public Main() {
        Watch watch = new Watch();
        WatchDisplay watchDisplay = new WatchDisplay();
        new WatchPresenter(watch, watchDisplay);
        this.setTitle("Watch");
        this.setSize(400,424);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(watchDisplay);
    }
    
    

    private void launch() {
        this.setVisible(true);
    }
    
}
