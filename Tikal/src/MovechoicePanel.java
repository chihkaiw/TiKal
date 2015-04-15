package gitproject;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MovechoicePanel extends JFrame{
	
	JPanel _choice;
	JButton _upgrade;
	JButton _LTOP;
	JButton _TOP;
	JButton _RTOP;
	JButton _LBOTTOM;
	JButton _BOTTOM;
	JButton _RBOTTOM;
	
	TileFigure[][] _fitable;
	
	int _LocX, _LocY;
	int[] _path;

	Player[] _playerlist;
	int[] _index;
	TopPanelTilte _text;
	Move _movebuttonlistener;
	JLabel _informationlsit;
	

	public MovechoicePanel(int LocX, int LocY, int[] path, TileFigure[][] fitable, Player[] playerlist, int[] index, TopPanelTilte text, JLabel informationlsit) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_LocX=LocX;
		_LocY=LocY;
		_path=path;
		_fitable=fitable;
		_playerlist=playerlist;
		_index=index;
		_text=text;
		_informationlsit=informationlsit;
		
		setSize(300, 150);
		setLayout(null);
		setTitle("Tile [ " +_LocX + " , " +_LocY + " ]"+" Move Action Panel");
		setVisible(false);
		
		_choice = new JPanel();
		_choice.setBounds(0, 0, 300, 100);
		_choice.setLayout(new GridLayout(3,3));
		_choice.setVisible(true);
		add(_choice);
		
		_LTOP = new JButton("LTOP");
		_LTOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		//_LTOP.setSize(100, 50);
		
		_TOP= new JButton("TOP");
		_TOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		//_TOP.setSize(100, 50);
		
		_RTOP= new JButton("RTOP");
		_RTOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		//_RTOP.setSize(100, 50);
		
		_LBOTTOM= new JButton("LBOTTOM");
		_LBOTTOM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		//_LBOTTOM.setSize(100, 50);
		
		_BOTTOM= new JButton("BOTTOM");
		_BOTTOM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		//_BOTTOM.setSize(100, 50);
		
		_RBOTTOM= new JButton("RBOTTOM");
		_RBOTTOM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		//_RBOTTOM.setSize(100, 50);
		
		_upgrade=new JButton("Upgrade Pyramid");
		_upgrade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		_movebuttonlistener = new Move(_upgrade,_LTOP, _TOP, _RTOP, _LBOTTOM, _BOTTOM, _RBOTTOM, _LocX, _LocY, _fitable, _playerlist, _index, _text, _informationlsit);
		_LTOP.addActionListener(_movebuttonlistener);
		_TOP.addActionListener(_movebuttonlistener);
		_RTOP.addActionListener(_movebuttonlistener);
		_LBOTTOM.addActionListener(_movebuttonlistener);
		_BOTTOM.addActionListener(_movebuttonlistener);
		_RBOTTOM.addActionListener(_movebuttonlistener);
		_upgrade.addActionListener(_movebuttonlistener);
		
		_choice.add(_LTOP);
		_choice.add(_TOP);
		_choice.add(_RTOP);
		_choice.add(_LBOTTOM);
		_choice.add(_BOTTOM);
		_choice.add(_RBOTTOM);
		_choice.add(_upgrade);
	}
	
	public void initial(){
		//set first col TiteData Button
		if(_LocX==0){
			_LTOP.setVisible(false);
			_LBOTTOM.setVisible(false);
			//set 1 item in this col
			if(_LocY==0){
				_TOP.setVisible(false);
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
			}
			//set 2 item in this col
			else if(_LocY==1){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
			}
			//set 3 item in this col
			else if(_LocY==2){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}			
			}
			//set 4 item in this col
			else if(_LocY==3){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
			}
			//set 5 item in this col
			else{
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				_BOTTOM.setVisible(false);
			}
		}
		//set second col TiteData Button
		else if(_LocX==1){
			//set 1 item in this col
			if(_LocY==0){
				_TOP.setVisible(false);
				_RTOP.setVisible(false);
				_LTOP.setVisible(false);
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}	
			}
			//set 2 item in this col
			else if(_LocY==1){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 3 item in this col
			else if(_LocY==2){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 4 item in this col
			else if(_LocY==3){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 5 item in this col
			else if(_LocY==4){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 6 item in this col
			else{
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
				_RBOTTOM.setVisible(false);
				_BOTTOM.setVisible(false);
				_LBOTTOM.setVisible(false);
			}
		}
		//set third col TiteData Button
		else if(_LocX==2){
			//set 1 item in this col
			if(_LocY==0){
				_TOP.setVisible(false);
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 2 item in this col
			else if(_LocY==1){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 3 item in this col
			else if(_LocY==2){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}			
			}
			//set 4 item in this col
			else if(_LocY==3){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 5 item in this col
			else{
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
				_BOTTOM.setVisible(false);
			}
		}
		//set fourth col TiteData Button
		else if(_LocX==3){
			//set 1 item in this col
			if(_LocY==0){
				_TOP.setVisible(false);
				_RTOP.setVisible(false);
				_LTOP.setVisible(false);
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}	
			}
			//set 2 item in this col
			else if(_LocY==1){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 3 item in this col
			else if(_LocY==2){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 4 item in this col
			else if(_LocY==3){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 5 item in this col
			else if(_LocY==4){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 6 item in this col
			else{
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
				_RBOTTOM.setVisible(false);
				_BOTTOM.setVisible(false);
				_LBOTTOM.setVisible(false);
			}
			
		}
		//set fifth col TiteData Button
		else if(_LocX==4){
			//set 1 item in this col
			if(_LocY==0){
				_TOP.setVisible(false);
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 2 item in this col
			else if(_LocY==1){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 3 item in this col
			else if(_LocY==2){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 4 item in this col
			else if(_LocY==3){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 5 item in this col
			else{
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[1]==0){
					_RTOP.setVisible(false);
				}
				if(_path[2]==0){
					_RBOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
				_BOTTOM.setVisible(false);
			}
		}
		//set sixth col TiteData Button
		else{
			_RTOP.setVisible(false);
			_RBOTTOM.setVisible(false);
			//set 1 item in this col
			if(_LocY==0){
				_TOP.setVisible(false);
				_LTOP.setVisible(false);
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
			}
			//set 2 item in this col
			else if(_LocY==1){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 3 item in this col
			else if(_LocY==2){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}			
			}
			//set 4 item in this col
			else if(_LocY==3){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 5 item in this col
			else if(_LocY==4){
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[3]==0){
					_BOTTOM.setVisible(false);
				}
				if(_path[4]==0){
					_LBOTTOM.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
			//set 6 item in this col
			else{
				_BOTTOM.setVisible(false);
				_LBOTTOM.setVisible(false);
				if(_path[0]==0){
					_TOP.setVisible(false);
				}
				if(_path[5]==0){
					_LTOP.setVisible(false);
				}
			}
		}
		if(!_fitable[_LocX][_LocY].getTileData()._pyramid){
			_upgrade.setVisible(false);
		}
	}

}
