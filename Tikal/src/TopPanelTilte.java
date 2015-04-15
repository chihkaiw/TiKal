package gitproject;

import javax.swing.JLabel;

public class TopPanelTilte extends JLabel{
	Player[] _playerlist;

	public TopPanelTilte(Player[] playerlist) {
		_playerlist=playerlist;
	}
	public void setinformationText(int index){
		String s = "";
		for(int i=0 ; i<_playerlist.length ; i++){
			s=s+_playerlist[i].getName() + " Score : " + _playerlist[i].getScore() + " , ";
		}
		this.setText(s + " now is  "+_playerlist[index].getName()+"   "+
				" AP = " +  _playerlist[index].getActionPoints() + " , explores = " + _playerlist[index].getAvailableExplores());
	}

}
