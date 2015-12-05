package gitproject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FieldMouseListener extends MouseAdapter{
	

	JPanel _playfield_pa_a_b_c_d_e_F_E_100______aaaasdasdasdf_;
	TileData[][] _table;
	TileData[] _newone;
	TileFigure[][] _fitable;
	TileFigure _newonefigure;
	TopPanelTilte _text;
	TileData _firsttile;
	boolean[] _puttile;
	JLabel _informationlsit;
	int _x=-1,_y=-1;
	//MovechoicePanel _choicepath;
	Player[] _playerlist;
	int[] _index;
	
	JButton resume;
	JButton end;
	JButton save;
	JButton load;
	
	JFrame _save;
	JPanel _save_panel;
	
	JFrame _main;
	JPanel _player_panel;
	JPanel _tile_panel;
	

	
	RotateButtonListener _Rotatelistener;
	JoinAndMoveListener _JoinAndMovelistener;
	
	SaveAndLoadListener _saveandloadlistener;

	public FieldMouseListener(JFrame main, JPanel playfield_panel,TileData[][] table,TileData[] newone,TileFigure[][] fitable,TileFigure newonefigure,
			TopPanelTilte text,TileData firsttile,boolean[] puttile, JLabel informationlsit, Player[] playerlist, int[] index) {
		_playfield_panel=playfield_panel;
		_table=table;
		_newone=newone;
		_fitable=fitable;
		_newonefigure=newonefigure;
		_text=text;
		_firsttile=firsttile;
		_puttile=puttile;
		_informationlsit=informationlsit;
		_playerlist=playerlist;
		_index=index;
		_main=main;

		
		_save = new JFrame("Exit Panel");
		_save.setSize(100, 300);
		_save.setVisible(false);
		_save_panel = new JPanel();
		_save.add(_save_panel);
		resume = new JButton("RESUME");
		save = new JButton("SAVE");
		load = new JButton("LOAD");
		end = new JButton("END");
		_save_panel.add(resume);
		_save_panel.add(save);
		_save_panel.add(load);
		_save_panel.add(end);
		
		_saveandloadlistener = new SaveAndLoadListener (resume,save,load,end,_playerlist,_table,_index,_playerlist.length,_puttile,_newone,_text,_informationlsit, _main);
		resume.addActionListener(_saveandloadlistener);
		save.addActionListener(_saveandloadlistener);
		load.addActionListener(_saveandloadlistener);
		end.addActionListener(_saveandloadlistener);
	}
	
	public void mouseClicked(MouseEvent e) {
		
		if (e.getButton() == MouseEvent.BUTTON3) {
        	_save.setVisible(true);
        }
		else{
			int mx = e.getX();
	        int my = e.getY();
	        //_text.setText("mouseClicked"+"x = "+mx+",y = "+my);
	        if(_puttile[0]){
		        int[] tmp = _newone[0].getpath();
		        int type = _newone[0].getType();
		        if(mx >= 20 && mx <= 85){
		        	if(my >= 20 && my <= 80){
		        		if(_table[0][0].getinitial()){
		        			_fitable[0][0].tileData.setinitail(false);
							_fitable[0][0].tileData.setpath(tmp);
							_fitable[0][0].tileData.setType(type);
							_fitable[0][0].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[0][0].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 130 && my <= 200){
		        		if(_table[0][1].getinitial()){
		        			_fitable[0][1].tileData.setinitail(false);
							_fitable[0][1].tileData.setpath(tmp);
							_fitable[0][1].tileData.setType(type);
							_fitable[0][1].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[0][1].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 240 && my <= 300){
		        		if(_table[0][2].getinitial()){
		        			_fitable[0][2].tileData.setinitail(false);
							_fitable[0][2].tileData.setpath(tmp);
							_fitable[0][2].tileData.setType(type);
							_fitable[0][2].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[0][2].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 340 && my <= 400){
		        		if(_table[0][3].getinitial()){
		        			_fitable[0][3].tileData.setinitail(false);
							_fitable[0][3].tileData.setpath(tmp);
							_fitable[0][3].tileData.setType(type);
							_fitable[0][3].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[0][3].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
					else if(my >= 450 && my <= 500){
						if(_table[0][4].getinitial()){
		        			_fitable[0][4].tileData.setinitail(false);
							_fitable[0][4].tileData.setpath(tmp);
							_fitable[0][4].tileData.setType(type);
							_fitable[0][4].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[0][4].tileData.getinitial());
		        		}
						else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
		        }
		        else if(mx >= 120 && mx <= 180){
		        	if(my >= 20 && my <= 80){
		        		if(_table[1][0].getinitial()){
		        			_fitable[1][0].tileData.setinitail(false);
							_fitable[1][0].tileData.setpath(tmp);
							_fitable[1][0].tileData.setType(type);
							_fitable[1][0].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[1][0].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 110 && my <= 170){
		        		if(_table[1][1].getinitial()){
		        			_fitable[1][1].tileData.setinitail(false);
							_fitable[1][1].tileData.setpath(tmp);
							_fitable[1][1].tileData.setType(type);
							_fitable[1][1].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[1][1].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 200 && my <= 255){
		        		if(_table[1][2].getinitial()){
		        			_fitable[1][2].tileData.setinitail(false);
							_fitable[1][2].tileData.setpath(tmp);
							_fitable[1][2].tileData.setType(type);
							_fitable[1][2].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[1][2].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 290 && my <= 345){
		        		if(_table[1][3].getinitial()){
		        			_fitable[1][3].tileData.setinitail(false);
							_fitable[1][3].tileData.setpath(tmp);
							_fitable[1][3].tileData.setType(type);
							_fitable[1][3].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[1][3].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
					else if(my >= 375 && my <= 435){
						if(_table[1][4].getinitial()){
		        			_fitable[1][4].tileData.setinitail(false);
							_fitable[1][4].tileData.setpath(tmp);
							_fitable[1][4].tileData.setType(type);
							_fitable[1][4].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[1][4].tileData.getinitial());
		        		}
						else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
					else if(my >= 465 && my <= 525){
						if(_table[1][5].getinitial()){
		        			_fitable[1][5].tileData.setinitail(false);
							_fitable[1][5].tileData.setpath(tmp);
							_fitable[1][5].tileData.setType(type);
							_fitable[1][5].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[1][5].tileData.getinitial());
		        		}
						else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
		        }
		        else if(mx >= 220 && mx <= 280){
		        	if(my >= 20 && my <= 80){
		        		if(_table[2][0].getinitial()){
		        			_fitable[2][0].tileData.setinitail(false);
							_fitable[2][0].tileData.setpath(tmp);
							_fitable[2][0].tileData.setType(type);
							_fitable[2][0].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[2][0].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 130 && my <= 200){
		        		if(_table[2][1].getinitial()){
		        			_fitable[2][1].tileData.setinitail(false);
							_fitable[2][1].tileData.setpath(tmp);
							_fitable[2][1].tileData.setType(type);
							_fitable[2][1].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[2][1].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 240 && my <= 300){
		        		if(_table[2][2].getinitial()){
		        			_fitable[2][2].tileData.setinitail(false);
							_fitable[2][2].tileData.setpath(tmp);
							_fitable[2][2].tileData.setType(type);
							_fitable[2][2].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[2][2].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 340 && my <= 400){
		        		if(_table[2][3].getinitial()){
		        			_fitable[2][3].tileData.setinitail(false);
							_fitable[2][3].tileData.setpath(tmp);
							_fitable[2][3].tileData.setType(type);
							_fitable[2][3].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[2][3].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
					else if(my >= 450 && my <= 500){
						if(_table[2][4].getinitial()){
		        			_fitable[2][4].tileData.setinitail(false);
							_fitable[2][4].tileData.setpath(tmp);
							_fitable[2][4].tileData.setType(type);
							_fitable[2][4].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[2][4].tileData.getinitial());
		        		}
						else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
		        }
		        else if(mx >= 310 && mx <= 375){
		        	if(my >= 20 && my <= 80){
		        		if(_table[3][0].getinitial()){
		        			_fitable[3][0].tileData.setinitail(false);
							_fitable[3][0].tileData.setpath(tmp);
							_fitable[3][0].tileData.setType(type);
							_fitable[3][0].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[3][0].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 110 && my <= 170){
		        		if(_table[3][1].getinitial()){
		        			_fitable[3][1].tileData.setinitail(false);
							_fitable[3][1].tileData.setpath(tmp);
							_fitable[3][1].tileData.setType(type);
							_fitable[3][1].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[3][1].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 200 && my <= 255){
		        		if(_table[3][2].getinitial()){
		        			_fitable[3][2].tileData.setinitail(false);
							_fitable[3][2].tileData.setpath(tmp);
							_fitable[3][2].tileData.setType(type);
							_fitable[3][2].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[3][2].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 290 && my <= 345){
		        		if(_table[3][3].getinitial()){
		        			_fitable[3][3].tileData.setinitail(false);
							_fitable[3][3].tileData.setpath(tmp);
							_fitable[3][3].tileData.setType(type);
							_fitable[3][3].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[3][3].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
					else if(my >= 375 && my <= 435){
						if(_table[3][4].getinitial()){
		        			_fitable[3][4].tileData.setinitail(false);
							_fitable[3][4].tileData.setpath(tmp);
							_fitable[3][4].tileData.setType(type);
							_fitable[3][4].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[3][4].tileData.getinitial());
		        		}
						else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
					else if(my >= 465 && my <= 525){
						if(_table[3][5].getinitial()){
		        			_fitable[3][5].tileData.setinitail(false);
							_fitable[3][5].tileData.setpath(tmp);
							_fitable[3][5].tileData.setType(type);
							_fitable[3][5].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[3][5].tileData.getinitial());
		        		}
						else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
		        }
		        else if(mx >= 410 && mx <= 470){
		        	if(my >= 20 && my <= 80){
		        		if(_table[4][0].getinitial()){
		        			_fitable[4][0].tileData.setinitail(false);
							_fitable[4][0].tileData.setpath(tmp);
							_fitable[4][0].tileData.setType(type);
							_fitable[4][0].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[4][0].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 130 && my <= 200){
		        		if(_table[4][1].getinitial()){
		        			_fitable[4][1].tileData.setinitail(false);
							_fitable[4][1].tileData.setpath(tmp);
							_fitable[4][1].tileData.setType(type);
							_fitable[4][1].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[4][1].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 240 && my <= 300){
		        		if(_table[4][2].getinitial()){
		        			_fitable[4][2].tileData.setinitail(false);
							_fitable[4][2].tileData.setpath(tmp);
							_fitable[4][2].tileData.setType(type);
							_fitable[4][2].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[4][2].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 340 && my <= 400){
		        		if(_table[4][3].getinitial()){
		        			_fitable[4][3].tileData.setinitail(false);
							_fitable[4][3].tileData.setpath(tmp);
							_fitable[4][3].tileData.setType(type);
							_fitable[4][3].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[4][3].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
					else if(my >= 450 && my <= 500){
						if(_table[4][4].getinitial()){
		        			_fitable[4][4].tileData.setinitail(false);
							_fitable[4][4].tileData.setpath(tmp);
							_fitable[4][4].tileData.setType(type);
							_fitable[4][4].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[4][4].tileData.getinitial());
		        		}
						else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
		        }
		        else if(mx >= 505 && mx <= 560){
		        	if(my >= 20 && my <= 80){
		        		if(_table[5][0].getinitial()){
		        			_fitable[5][0].tileData.setinitail(false);
							_fitable[5][0].tileData.setpath(tmp);
							_fitable[5][0].tileData.setType(type);
							_fitable[5][0].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[5][0].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 110 && my <= 170){
		        		if(_table[5][1].getinitial()){
		        			_fitable[5][1].tileData.setinitail(false);
							_fitable[5][1].tileData.setpath(tmp);
							_fitable[5][1].tileData.setType(type);
							_fitable[5][1].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[5][1].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 200 && my <= 255){
		        		if(_table[5][2].getinitial()){
		        			_fitable[5][2].tileData.setinitail(false);
							_fitable[5][2].tileData.setpath(tmp);
							_fitable[5][2].tileData.setType(type);
							_fitable[5][2].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[5][2].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
		        	}
		        	else if(my >= 290 && my <= 345){
		        		if(_table[5][3].getinitial()){
		        			_fitable[5][3].tileData.setinitail(false);
							_fitable[5][3].tileData.setpath(tmp);
							_fitable[5][3].tileData.setType(type);
							_fitable[5][3].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[5][3].tileData.getinitial());
		        		}
		        		else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
					else if(my >= 375 && my <= 435){
						if(_table[5][4].getinitial()){
		        			_fitable[5][4].tileData.setinitail(false);
							_fitable[5][4].tileData.setpath(tmp);
							_fitable[5][4].tileData.setType(type);
							_fitable[5][4].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[5][4].tileData.getinitial());
		        		}
						else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
					else if(my >= 465 && my <= 525){
						if(_table[5][5].getinitial()){
		        			_fitable[5][5].tileData.setinitail(false);
							_fitable[5][5].tileData.setpath(tmp);
							_fitable[5][5].tileData.setType(type);
							_fitable[5][5].UpdatePaths();
							_puttile[0]=false;
							System.out.println("ans = " + _fitable[5][5].tileData.getinitial());
		        		}
						else{
		        			_informationlsit.setText("This Tile is set-up already, try other place. You can move ppl after it");
		        		}
					}
		        }
	        }
	        else{
	        	_informationlsit.setText("Move the explorers now");
	        	
	        	if(mx >= 20 && mx <= 85){
		        	if(my >= 20 && my <= 80){
		        		if(!_table[0][0].getinitial()){
		        			/*_table[0][0].getChoicepath().initial();
		        			_table[0][0].getChoicepath().setVisible(true);*/
		        			_x=0;
		        			_y=0;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 130 && my <= 200){
		        		if(!_table[0][1].getinitial()){
		        			/*_table[0][1].getChoicepath().initial();
		        			_table[0][1].getChoicepath().setVisible(true);*/
		        			_x=0;
		        			_y=1;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 240 && my <= 300){
		        		if(!_table[0][2].getinitial()){
		        			/*_table[0][2].getChoicepath().initial();
		        			_table[0][2].getChoicepath().setVisible(true);*/
		        			_x=0;
		        			_y=2;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 340 && my <= 400){
		        		if(!_table[0][3].getinitial()){
		        			/*_table[0][3].getChoicepath().initial();
		        			_table[0][3].getChoicepath().setVisible(true);*/
		        			_x=0;
		        			_y=3;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
					else if(my >= 450 && my <= 500){
						if(!_table[0][4].getinitial()){
							/*_table[0][4].getChoicepath().initial();
		        			_table[0][4].getChoicepath().setVisible(true);*/
							_x=0;
		        			_y=4;
		        		}
						else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
		        }
		        else if(mx >= 120 && mx <= 180){
		        	if(my >= 20 && my <= 80){
		        		if(!_table[1][0].getinitial()){
		        			/*_table[1][0].getChoicepath().initial();
		        			_table[1][0].getChoicepath().setVisible(true);*/
		        			_x=1;
		        			_y=0;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 110 && my <= 170){
		        		if(!_table[1][1].getinitial()){
		        			/*_table[1][1].getChoicepath().initial();
		        			_table[1][1].getChoicepath().setVisible(true);*/
		        			_x=1;
		        			_y=1;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 200 && my <= 255){
		        		if(!_table[1][2].getinitial()){
		        			/*_table[1][2].getChoicepath().initial();
		        			_table[1][2].getChoicepath().setVisible(true);*/
		        			_x=1;
		        			_y=2;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 290 && my <= 345){
		        		if(!_table[1][3].getinitial()){
		        			/*_table[1][3].getChoicepath().initial();
		        			_table[1][3].getChoicepath().setVisible(true);*/
		        			_x=1;
		        			_y=3;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
					else if(my >= 375 && my <= 435){
						if(!_table[1][4].getinitial()){
							/*_table[1][4].getChoicepath().initial();
		        			_table[1][4].getChoicepath().setVisible(true);*/
							_x=1;
		        			_y=4;
		        		}
						else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
					else if(my >= 465 && my <= 525){
						if(!_table[1][5].getinitial()){
							/*_table[1][5].getChoicepath().initial();
		        			_table[1][5].getChoicepath().setVisible(true);*/
							_x=1;
		        			_y=5;
		        		}
						else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
		        }
		        else if(mx >= 220 && mx <= 280){
		        	if(my >= 20 && my <= 80){
		        		if(!_table[2][0].getinitial()){
		        			/*_table[2][0].getChoicepath().initial();
		        			_table[2][0].getChoicepath().setVisible(true);*/
		        			_x=2;
		        			_y=0;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 130 && my <= 200){
		        		if(!_table[2][1].getinitial()){
		        			/*_table[2][1].getChoicepath().initial();
		        			_table[2][1].getChoicepath().setVisible(true);*/
		        			_x=2;
		        			_y=1;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 240 && my <= 300){
		        		if(!_table[2][2].getinitial()){
		        			/*_table[2][2].getChoicepath().initial();
		        			_table[2][2].getChoicepath().setVisible(true);*/
		        			_x=2;
		        			_y=2;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 340 && my <= 400){
		        		if(!_table[2][3].getinitial()){
		        			/*_table[2][3].getChoicepath().initial();
		        			_table[2][3].getChoicepath().setVisible(true);*/
		        			_x=2;
		        			_y=3;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
					else if(my >= 450 && my <= 500){
						if(!_table[2][4].getinitial()){
							/*_table[2][4].getChoicepath().initial();
		        			_table[2][4].getChoicepath().setVisible(true);*/
							_x=2;
		        			_y=4;
		        		}
						else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
		        }
		        else if(mx >= 310 && mx <= 375){
		        	if(my >= 20 && my <= 80){
		        		if(!_table[3][0].getinitial()){
		        			/*_table[3][0].getChoicepath().initial();
		        			_table[3][0].getChoicepath().setVisible(true);*/
		        			_x=3;
		        			_y=0;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 110 && my <= 170){
		        		if(!_table[3][1].getinitial()){
		        			/*_table[3][1].getChoicepath().initial();
		        			_table[3][1].getChoicepath().setVisible(true);*/
		        			_x=3;
		        			_y=1;
		        		}
		        	}
		        	else if(my >= 200 && my <= 255){
		        		if(!_table[3][2].getinitial()){
		        			/*_table[3][2].getChoicepath().initial();
		        			_table[3][2].getChoicepath().setVisible(true);*/
		        			_x=3;
		        			_y=2;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 290 && my <= 345){
		        		if(!_table[3][3].getinitial()){
		        			/*_table[3][3].getChoicepath().initial();
		        			_table[3][3].getChoicepath().setVisible(true);*/
		        			_x=3;
		        			_y=3;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
					else if(my >= 375 && my <= 435){
						if(!_table[3][4].getinitial()){
							/*_table[3][4].getChoicepath().initial();
		        			_table[3][4].getChoicepath().setVisible(true);*/
							_x=3;
		        			_y=4;
		        		}
						else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
					else if(my >= 465 && my <= 525){
						if(!_table[3][5].getinitial()){
							/*_table[3][5].getChoicepath().initial();
		        			_table[3][5].getChoicepath().setVisible(true);*/
							_x=3;
		        			_y=5;
		        		}
						else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
		        }
		        else if(mx >= 410 && mx <= 470){
		        	if(my >= 20 && my <= 80){
		        		if(!_table[4][0].getinitial()){
		        			/*_table[4][0].getChoicepath().initial();
		        			_table[4][0].getChoicepath().setVisible(true);*/
		        			_x=4;
		        			_y=0;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 130 && my <= 200){
		        		if(!_table[4][1].getinitial()){
		        			/*_table[4][1].getChoicepath().initial();
		        			_table[4][1].getChoicepath().setVisible(true);*/
		        			_x=4;
		        			_y=1;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 240 && my <= 300){
		        		if(!_table[4][2].getinitial()){
		        			/*_table[4][2].getChoicepath().initial();
		        			_table[4][2].getChoicepath().setVisible(true);*/
		        			_x=4;
		        			_y=2;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 340 && my <= 400){
		        		if(!_table[4][3].getinitial()){
		        			/*_table[4][3].getChoicepath().initial();
		        			_table[4][3].getChoicepath().setVisible(true);*/
		        			_x=4;
		        			_y=3;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
					else if(my >= 450 && my <= 500){
						if(!_table[4][4].getinitial()){
							/*_table[4][4].getChoicepath().initial();
		        			_table[4][4].getChoicepath().setVisible(true);*/
							_x=4;
		        			_y=4;
		        		}
						else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
		        }
		        else if(mx >= 505 && mx <= 560){
		        	if(my >= 20 && my <= 80){
		        		if(!_table[5][0].getinitial()){
		        			/*_table[5][0].getChoicepath().initial();
		        			_table[5][0].getChoicepath().setVisible(true);*/
		        			_x=5;
		        			_y=0;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 110 && my <= 170){
		        		if(!_table[5][1].getinitial()){
		        			/*_table[5][1].getChoicepath().initial();
		        			_table[5][1].getChoicepath().setVisible(true);*/
		        			_x=5;
		        			_y=1;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 200 && my <= 255){
		        		if(!_table[5][2].getinitial()){
		        			/*_table[5][2].getChoicepath().initial();
		        			_table[5][2].getChoicepath().setVisible(true);*/
		        			_x=5;
		        			_y=2;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
		        	}
		        	else if(my >= 290 && my <= 345){
		        		if(!_table[5][3].getinitial()){
		        			/*_table[5][3].getChoicepath().initial();
		        			_table[5][3].getChoicepath().setVisible(true);*/
		        			_x=5;
		        			_y=3;
		        		}
		        		else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
					else if(my >= 375 && my <= 435){
						if(!_table[5][4].getinitial()){
							/*_table[5][4].getChoicepath().initial();
		        			_table[5][4].getChoicepath().setVisible(true);*/
							_x=5;
		        			_y=4;
		        		}
						else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
					else if(my >= 465 && my <= 525){
						if(!_table[5][5].getinitial()){
							/*_table[5][5].getChoicepath().initial();
		        			_table[5][5].getChoicepath().setVisible(true);*/
							_x=5;
		        			_y=5;
		        		}
						else{
		        			_informationlsit.setText("This is covered Tile!! You can not move anything from it");
		        		}
					}
		        }
	        	if(_x != -1 && _y != -1){
	        		MovechoicePanel _choicepath = new MovechoicePanel(_x, _y,_table[_x][_y].getpath(), _fitable, _playerlist, _index,_text,_informationlsit);
	        		_choicepath.initial();
	        		_choicepath.setVisible(true);
	        		_x=-1;
	        		_y=-1;
	        	}
	        }
		}
        
        
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
