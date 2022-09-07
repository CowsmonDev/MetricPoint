package main.statico;

public class JPanelFondo extends javax.swing.JPanel{
    private final String url;
    public JPanelFondo(String url){    
        this.url = url;
    }
    
    @Override
    public void paint(java.awt.Graphics g){
        
        java.awt.Dimension dimension = this.getSize();
        javax.swing.ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource(this.url));
        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, this);
        setOpaque(false);
        super.paintChildren(g);
    }
}
