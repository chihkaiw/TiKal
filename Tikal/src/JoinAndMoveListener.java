package gitproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JoinAndMoveListener implements ActionListener{

	Player[] _playerlist;
	TopPanelTilte _text;
	JButton _finishround_bu;
	JButton _joinExplores;
	TileData _firsttile;
	int[] _playerindex;
	int _numofExplorers;
	TileFigure[][] _fitable;
	boolean[] _puttile;
	TileData[] _newone;
	TileFigure _newonefigure;
	int _type;
	JLabel _informationlist;
	JPanel _playfield_panel;
	Move _movelistener;
	boolean _movecontroler=true;
	
	public JoinAndMoveListener(Player[] playerlist,int[] playerindex, TopPanelTilte text, JButton finishround_bu, JButton joinExplores,TileData firsttile,TileFigure[][] fitable, boolean[] puttile, TileData[] newone,TileFigure newonefigure, JLabel informationlist, JPanel playfield_panel) {
		_playerlist=playerlist;
		_playerindex=playerindex;
		_text=text;
		_finishround_bu=finishround_bu;
		_joinExplores=joinExplores;
		_firsttile=firsttile;
		_numofExplorers=_playerlist.length;
		_fitable=fitable;
		_puttile=puttile;
		_newone=newone;
		_newonefigure=newonefigure;
		_informationlist=informationlist;
		_playfield_panel=playfield_panel;
	}

	public void actionPerformed(ActionEvent e) {
		if(_puttile[0]==false){
			JButton b = (JButton)e.getSource(); // !!!!!!  to recognize that we press which button
		    if( b.equals(_finishround_bu) ){
		    	_playerlist[_playerindex[0]].setWhoRound(false);
		    	_playerlist[_playerindex[0]].setActionPoints(12);
		    	_puttile[0]=true;
		    	if(_playerindex[0] == _playerlist.length-1){
		    		_playerlist[0].setWhoRound(true);
		    		_playerindex[0]=0;
		    	}
		    	else{
		    		_playerlist[_playerindex[0]+1].setWhoRound(true);
		    		_playerindex[0]=_playerindex[0]+1;
		    	}
		    	_text.setinformationText(_playerindex[0]);
		    	_newone[0]=generateTileData();
		    	resetfigure();
		    	_informationlist.setText(" Now is " +_playerlist[ _playerindex[0]].getName()+" Round " + ", Set up the Tile first Please.");
			}
		    if(_playerlist[_playerindex[0]].getActionPoints() >0){
			    if( b.equals(_joinExplores) ){
			    	if(_playerlist[_playerindex[0]].getAvailableExplores() > 0){
				    	int nowAExp = _playerlist[_playerindex[0]].getAvailableExplores();
				    	int nowAP = _playerlist[_playerindex[0]].getActionPoints();
				    	_playerlist[_playerindex[0]].setAvailableExplores(nowAExp-1);
				    	_playerlist[_playerindex[0]].setActionPoints(nowAP-1);
				    	int nowExplorers = _fitable[0][0].getTileData().GetExplorers(_playerindex[0]);
				    	_fitable[0][0].setTexttoExplorers(nowExplorers+1, _playerindex[0]);
				    	_text.setinformationText(_playerindex[0]);
				    	_informationlist.setText("Increase one explorers to the field");
			    	}
			    	else{
			    		_informationlist.setText("You have no more Available Explores, too bad");
			    	}
				}
		    }
		    else{
				_informationlist.setText("************************There is no more Action Point you can use****************************");
			}
		}
		else{
			_informationlist.setText("************************Please Set Up The Current Tile First****************************");
		}
		
		
	}
	private TileData generateTileData(){
		int[] paths = generate_rock();
		_type=(int) (Math.random()*3+1);
		TileData tmp = new TileData(-1, -1, paths,_type , _numofExplorers,false);
		return tmp;
	}
	
	private int[] generate_rock(){
		int[] path = new int[6];
		int counter=0;
		for(int i=0 ; i<6 ; i++){
			int inside=(int) (Math.random()*3);
			if(counter < 2 && inside!=0){
				path[i]=inside;
				counter++;
			}
		}
		return path;
	}
	public void resetfigure(){
		int[] tmp = _newone[0].getpath();
		_newonefigure.tileData.setinitail(false);
		_newonefigure.tileData.setpath(tmp);
		_newonefigure.tileData.setType(_type);
		_newonefigure.UpdatePaths();
	}

}
