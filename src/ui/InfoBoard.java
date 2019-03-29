package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class InfoBoard {
    private JPanel infoPanel;
    private JTextArea description;
    private Queue<String> infoQueue = new LinkedBlockingQueue<String>();
    private static final Integer INFOSIZE = 5;

    public InfoBoard(){
        initialize();
    }

    private void initialize(){
        this.description=new JTextArea("HeroPatton战场欢迎您！");
        Border infoTitle=BorderFactory.createTitledBorder("信息面板");
        this.description.setBorder(infoTitle);
        this.description.setEditable(false);

        this.infoPanel=new JPanel();
        this.infoPanel.add(description);
        this.infoPanel.setVisible(true);
    }

    public JPanel getInfoPanel() {
        return infoPanel;
    }

    /**
     * 提供給外部，直接更新信息面板内容
     * @param infoText
     */
    public void setInfoText(String infoText){
        if(this.infoQueue.size() == this.INFOSIZE){
            this.infoQueue.poll();
        }
        this.infoQueue.offer(infoText);
        changeInfoBoard();
    }

    /**
     * 更新信息面板
     */
    private void changeInfoBoard(){
        String cache = "";
        for(String info:infoQueue){
            cache += info +"\n";
        }
        this.description.setText(cache);
        this.description.validate();
    }
}
