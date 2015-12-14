package project;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 *	@authors: 
 * 	
 */


public class TileColumn extends JPanel { 
    
    int _col;
    public TileColumn(int col){
    	_col=col;
    	//Size of 5x1 of Tiles
        this.setSize(100, _col*100-100);
        this.setOpaque(false);
        
        //Set Holder Layout 
        GridLayout layout = new GridLayout(_col,1);
        this.setLayout(layout);
                    
    }
}
