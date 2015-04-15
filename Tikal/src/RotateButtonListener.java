package gitproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RotateButtonListener implements ActionListener{
	JButton _Clockwise_bu;
	JButton _Counterclockwise_bu;
	TileData _cur;
	TileFigure _curfigure;

	public RotateButtonListener(JButton Clockwise_bu,JButton Counterclockwise_bu,TileData cur,TileFigure curfigure) {
		_Clockwise_bu=Clockwise_bu;
		_Counterclockwise_bu=Counterclockwise_bu;
		_cur=cur;
		_curfigure=curfigure;
	}

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource(); // !!!!!!  to recognize that we press which button 
	    if( b.equals(_Clockwise_bu) ){
	    	_cur.RotateClockwise();
	    	_curfigure.UpdatePaths();
		}
	    if( b.equals(_Counterclockwise_bu) ){
	    	_cur.RotateCounterClockwise();
	    	_curfigure.UpdatePaths();
		}
		
	}

}
