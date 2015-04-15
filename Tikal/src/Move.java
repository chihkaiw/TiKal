package gitproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Move implements ActionListener{
	JPanel _playfield_panel;
	TileFigure[][] _fitable;
	Player[] _playerlist;
	int[] _playerindex;
	TopPanelTilte _text;
	
	int _Lox;
	int _Loy;
	
	JButton _LTOP;
	JButton _TOP;
	JButton _RTOP;
	JButton _LBOTTOM;
	JButton _BOTTOM;
	JButton _RBOTTOM;
	JButton _upgrade;
	
	JLabel _informationlsit;

	public Move(JButton upgrade, JButton LTOP, JButton TOP, JButton RTOP, JButton LBOTTOM, JButton BOTTOM, JButton RBOTTOM, int Lox, int Loy, TileFigure[][] fitable,Player[] playerlist,int[] playerindex,TopPanelTilte text, JLabel informationlsit) {
		_Lox=Lox;
		_Loy=Loy;
		_fitable=fitable;
		_playerlist=playerlist;
		_playerindex=playerindex;
		_text=text;
		_LTOP=LTOP;
		_TOP=TOP;
		_RTOP=RTOP;
		_LBOTTOM=LBOTTOM;
		_BOTTOM=BOTTOM;
		_RBOTTOM=RBOTTOM;
		_upgrade=upgrade;
		_informationlsit=informationlsit;
	}
	public void actionPerformed(ActionEvent e) {
		if(_playerlist[_playerindex[0]].getActionPoints() > 1){
			JButton b = (JButton)e.getSource(); // !!!!!!  to recognize that we press which button
			int nowAP = _playerlist[_playerindex[0]].getActionPoints();
	    	int originalExplorers = _fitable[_Lox][_Loy].getTileData().GetExplorers(_playerindex[0]);
	    	TileFigure ori = _fitable[_Lox][_Loy];
	    	TileFigure dis;
	    	int distanceExplorers;
	    	
	    	if(b==_upgrade){
	    		if(_playerlist[_playerindex[0]].getActionPoints() > 3){
					int cost=3;
					upgrade_thep(nowAP,cost,ori);
	    		}
	    		else{
	    			_informationlsit.setText("************************You Need More Action Point To UP Grade****************************");
	    		}
			}
	    	else{
		    	if(ori.getTileData().GetExplorers(_playerindex[0]) > 0){
			    	if(b==_LTOP){
						if(_Lox == 0 || _Lox==2 || _Lox==4){
							distanceExplorers = _fitable[_Lox-1][_Loy].getTileData().GetExplorers(_playerindex[0]);
							dis=_fitable[_Lox-1][_Loy];
						}
						else{
							distanceExplorers = _fitable[_Lox-1][_Loy-1].getTileData().GetExplorers(_playerindex[0]);
							dis=_fitable[_Lox-1][_Loy-1];
						}
						if(!dis.getTileData().getinitial()){
							int opath = ori.getTileData().getPathValue(5);
							int dpath = dis.getTileData().getPathValue(2);
							int cost = opath+dpath;
							calculate_result(ori,dis,nowAP,cost,originalExplorers,distanceExplorers);
						}
						else{
							_informationlsit.setText("The Tile you want to go is covered, try other tile");
						}
					}
					else if(b==_TOP){
						distanceExplorers = _fitable[_Lox][_Loy-1].getTileData().GetExplorers(_playerindex[0]);
						dis=_fitable[_Lox][_Loy-1];
						if(!dis.getTileData().getinitial()){
							int opath = ori.getTileData().getPathValue(0);
							int dpath = dis.getTileData().getPathValue(3);
							int cost = opath+dpath;
							calculate_result(ori,dis,nowAP,cost,originalExplorers,distanceExplorers);
						}
						else{
							_informationlsit.setText("The Tile you want to go is covered, try other tile");
						}
					}
					else if(b==_RTOP){
						if(_Lox == 0 || _Lox==2 || _Lox==4){
							distanceExplorers = _fitable[_Lox+1][_Loy].getTileData().GetExplorers(_playerindex[0]);
							dis=_fitable[_Lox+1][_Loy];
						}
						else{
							distanceExplorers = _fitable[_Lox+1][_Loy-1].getTileData().GetExplorers(_playerindex[0]);
							dis=_fitable[_Lox+1][_Loy-1];
						}
						if(!dis.getTileData().getinitial()){
							int opath = ori.getTileData().getPathValue(1);
							int dpath = dis.getTileData().getPathValue(4);
							int cost = opath+dpath;
							calculate_result(ori,dis,nowAP,cost,originalExplorers,distanceExplorers);
						}
						else{
							_informationlsit.setText("The Tile you want to go is covered, try other tile");
						}
					}
					else if(b==_LBOTTOM){
						if(_Lox == 0 || _Lox==2 || _Lox==4){
							distanceExplorers = _fitable[_Lox-1][_Loy+1].getTileData().GetExplorers(_playerindex[0]);
							dis=_fitable[_Lox-1][_Loy+1];
						}
						else{
							distanceExplorers = _fitable[_Lox-1][_Loy].getTileData().GetExplorers(_playerindex[0]);
							dis=_fitable[_Lox-1][_Loy];
						}
						if(!dis.getTileData().getinitial()){
							int opath = ori.getTileData().getPathValue(4);
							int dpath = dis.getTileData().getPathValue(1);
							int cost = opath+dpath;
							calculate_result(ori,dis,nowAP,cost,originalExplorers,distanceExplorers);
						}
						else{
							_informationlsit.setText("The Tile you want to go is covered, try other tile");
						}
					}
					else if(b==_BOTTOM){
						distanceExplorers = _fitable[_Lox][_Loy+1].getTileData().GetExplorers(_playerindex[0]);
						dis=_fitable[_Lox][_Loy+1];
						if(!dis.getTileData().getinitial()){
							int opath = ori.getTileData().getPathValue(3);
							int dpath = dis.getTileData().getPathValue(0);
							int cost = opath+dpath;
							calculate_result(ori,dis,nowAP,cost,originalExplorers,distanceExplorers);
						}
						else{
							_informationlsit.setText("The Tile you want to go is covered, try other tile");
						}
					}
					else if(b==_RBOTTOM){
						if(_Lox == 0 || _Lox==2 || _Lox==4){
							distanceExplorers = _fitable[_Lox+1][_Loy+1].getTileData().GetExplorers(_playerindex[0]);
							dis=_fitable[_Lox+1][_Loy+1];
						}
						else{
							distanceExplorers = _fitable[_Lox+1][_Loy].getTileData().GetExplorers(_playerindex[0]);
							dis=_fitable[_Lox+1][_Loy];
						}
						if(!dis.getTileData().getinitial()){
							int opath = ori.getTileData().getPathValue(2);
							int dpath = dis.getTileData().getPathValue(5);
							int cost = opath+dpath;
							calculate_result(ori,dis,nowAP,cost,originalExplorers,distanceExplorers);
						}
						else{
							_informationlsit.setText("The Tile you want to go is covered, try other tile");
						}
					}
		    	}
		    	else{
		    		_informationlsit.setText("********There is no more  Your Explores On This Tile, You Can Not Move Anyone From here**************");
		    	}
	    	}
		}
		else{
			_informationlsit.setText("************************There is no more Action Point you can use****************************");
		}
		
		
	}

	public void calculate_result(TileFigure origin, TileFigure distance, int nowAP, int cost, int originalExplorers, int distanceExplorers){
	    	_playerlist[_playerindex[0]].setActionPoints(nowAP-cost);
	    	origin.setTexttoExplorers(originalExplorers-1, _playerindex[0]);
	    	distance.setTexttoExplorers(distanceExplorers+1, _playerindex[0]);
	    	_text.setinformationText(_playerindex[0]);
	}
	// index 0: North path
	// index 1: NorthEast path
	// index 2: SouthEast path
	// index 3: South path
	// index 4: SouthWest path
	// index 5: NorthWest path
	
	public void upgrade_thep(int nowAP, int cost, TileFigure ori){
		_playerlist[_playerindex[0]].setActionPoints(nowAP-cost);
		int curP_value = ori.getTileData().getPyramid().getValue();
		ori.getTileData().getPyramid().setValue(curP_value+1);
		ori.UpdatePaths();
		_text.setinformationText(_playerindex[0]);
		_informationlsit.setText("UP GRADE GOOD");
	}
	
}
