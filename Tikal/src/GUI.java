package gitproject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUI {
	JFrame main;
	JPanel player_panel;
	JPanel playfield_panel;
	JPanel tile_panel;
	// for top text player_panel
	TopPanelTilte text;
	JLabel _informationlist;
	// for playfield_panel;
	TileColumn col_1;
	TileColumn col_2;
	TileColumn col_3;
	TileColumn col_4;
	TileColumn col_5;
	TileColumn col_6;
	//for tile_panel;
	//JLabel information;
	JButton finishround_bu;
	JButton joinExplores;

	JButton Clockwise_bu;
	JButton Counterclockwise_bu;
	
	
	TileData[] _newone= new TileData[1];  // new tile
	TileData _firsttile;
	TileData[][] _table;
	TileFigure[][] _fitable;
	TileFigure _newonefigure;
	
	RotateButtonListener _Rotatelistener;
	JoinAndMoveListener _JoinAndMovelistener;
	FieldMouseListener _mouseListener;
	
	
	int[] _index=new int[1];
	Player[] _playerlist;
	int _numofExplorers;
	boolean[] _puttile = new boolean[1];
	
	
	/*public GUI(GUI g){
		main=g.main;
		main.setVisible(true);
		player_panel=g.player_panel;
		playfield_panel=g.playfield_panel;
		tile_panel=g.tile_panel;
		_Rotatelistener=g._Rotatelistener;
		_JoinAndMovelistener=g._JoinAndMovelistener;
		_index=g._index;
		_numofExplorers=g._numofExplorers;
		_puttile=g._puttile;
		_newone=g._newone;
		_playerlist=g._playerlist;
		text=g.text;
		col_1=g.col_1;
		col_2=g.col_2;
		col_3=g.col_3;
		col_4=g.col_4;
		col_5=g.col_5;
		col_6=g.col_6;
		_informationlist=g._informationlist;
		_mouseListener= new FieldMouseListener(playfield_panel, _table, _newone, _fitable, _newonefigure, text, _firsttile, _puttile,
		_informationlist,_playerlist,_index);
		
	}*/
	
	public GUI(int[] index, int numofExplorers, boolean[] puttile, TileData[] newone, Player[] player, TileData[][] BoardData){
		main = new JFrame("Git_Projecct2");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(600, 750);
		main.setVisible(true);
		
		//set player panel
		player_panel = new JPanel();
		player_panel.setLayout(new GridLayout(2,1));
		player_panel.setSize(600, 50);
		main.add(player_panel);
		
		//set field panel
		playfield_panel = new JPanel();
		playfield_panel.setLayout(new GridLayout(1,6));
		playfield_panel.setSize(600, 600);
		main.add(playfield_panel);
		
		//set tile panel
		tile_panel = new JPanel();
		
		tile_panel.setLayout(new GridLayout(1,5));
		tile_panel.setSize(600, 50);
		main.add(tile_panel);
		
		
		_numofExplorers=numofExplorers;
		
		
		_informationlist = new JLabel("Information List");
		_informationlist.setBounds(0, 0, 800, 50);
		
		//set player name
		_playerlist=player;
		_index=index;
		_index[0]=0;
		//set only put one tile in field once
		_puttile=puttile;
		//_puttile[0]=true;
		//set num of _numofExplorers
		_numofExplorers=_playerlist.length;
		
		//set player label
		text = new TopPanelTilte(_playerlist);
		text.setBounds(0, 0, 800, 50);
		/*_informationlist = new JLabel("Information List");
		_informationlist.setBounds(0, 0, 800, 50);*/
		player_panel.add(text);
		player_panel.add(_informationlist);
		
		// set field graphics
		playfield_panel.setBackground(Color.white);
		col_1 = new TileColumn(5);
		col_2 = new TileColumn(6);
		col_3 = new TileColumn(5);
		col_4 = new TileColumn(6);
		col_5 = new TileColumn(5);
		col_6 = new TileColumn(6);
		playfield_panel.add(col_1);
		playfield_panel.add(col_2);
		playfield_panel.add(col_3);
		playfield_panel.add(col_4);
		playfield_panel.add(col_5);	
		playfield_panel.add(col_6);
		
		
		
		//set tile place
		ImageIcon Clockwise_pic = new ImageIcon("pic/Clockwise.png");
		ImageIcon Counterclockwise_pic = new ImageIcon("pic/Counterclockwise.png");
		Clockwise_bu = new JButton(Clockwise_pic);
		Counterclockwise_bu = new JButton(Counterclockwise_pic);
		finishround_bu = new JButton("Finish Round");
		joinExplores = new JButton("Join An Explores");
		/*resume = new JButton("RESUME");
		save = new JButton("SAVE");
		load = new JButton("LOAD");
		end = new JButton("END");*/
		//information = new JLabel();
		
		//set initial Tile
		_newone=newone;
		//_newone[0]=generateTileData();
		_table=BoardData;
		_fitable=new TileFigure[6][6];
		_newonefigure = new TileFigure(_newone[0]);
		
		//set Listener
		//set Rotate listener
		_Rotatelistener = new RotateButtonListener(Clockwise_bu,Counterclockwise_bu,_newone[0],_newonefigure);
		Clockwise_bu.addActionListener(_Rotatelistener);
		Counterclockwise_bu.addActionListener(_Rotatelistener);
		
		//set Join and Move listener
		_JoinAndMovelistener = new JoinAndMoveListener(_playerlist, _index, text, finishround_bu, joinExplores, _table[0][0],
				_fitable,_puttile,_newone,_newonefigure,_informationlist,playfield_panel);
		finishround_bu.addActionListener(_JoinAndMovelistener);
		joinExplores.addActionListener(_JoinAndMovelistener);
		
		//set field mouse listener
		_mouseListener= new FieldMouseListener(main,playfield_panel, _table, _newone, _fitable, _newonefigure, text, _firsttile, _puttile,
				_informationlist,_playerlist,_index);
		playfield_panel.addMouseListener(_mouseListener);
		
		//set frame layout
		Container main_cp=main.getContentPane();
		main_cp.add(player_panel,BorderLayout.NORTH);
		main_cp.add(playfield_panel,BorderLayout.CENTER);
		main_cp.add(tile_panel,BorderLayout.SOUTH);
		initfield();
		draw();
		text.setinformationText(_index[0]);
		
	}
	
	public GUI(TileData[][] table, Player[] playerlist) {
		main = new JFrame("Git_Projecct");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(600, 750);
		main.setVisible(true);
		
		//set player panel
		player_panel = new JPanel();
		player_panel.setLayout(new GridLayout(2,1));
		player_panel.setSize(600, 50);
		main.add(player_panel);
		
		//set field panel
		playfield_panel = new JPanel();
		playfield_panel.setLayout(new GridLayout(1,6));
		playfield_panel.setSize(600, 600);
		main.add(playfield_panel);
		
		//set tile panel
		tile_panel = new JPanel();
		
		tile_panel.setLayout(new GridLayout(1,5));
		tile_panel.setSize(600, 50);
		main.add(tile_panel);
		
		//set player name
		_playerlist=playerlist;
		_index[0]=0;
		//set only put one tile in field once
		_puttile[0]=true;
		//set num of _numofExplorers
		_numofExplorers=_playerlist.length;
		
		//set player label
		text = new TopPanelTilte(_playerlist);
		text.setBounds(0, 0, 800, 50);
		_informationlist = new JLabel("Information List");
		_informationlist.setBounds(0, 0, 800, 50);
		player_panel.add(text);
		player_panel.add(_informationlist);
		
		// set field graphics
		playfield_panel.setBackground(Color.white);
		col_1 = new TileColumn(5);
		col_2 = new TileColumn(6);
		col_3 = new TileColumn(5);
		col_4 = new TileColumn(6);
		col_5 = new TileColumn(5);
		col_6 = new TileColumn(6);
		playfield_panel.add(col_1);
		playfield_panel.add(col_2);
		playfield_panel.add(col_3);
		playfield_panel.add(col_4);
		playfield_panel.add(col_5);	
		playfield_panel.add(col_6);
		
		
		
		//set tile place
		ImageIcon Clockwise_pic = new ImageIcon("pic/Clockwise.png");
		ImageIcon Counterclockwise_pic = new ImageIcon("pic/Counterclockwise.png");
		Clockwise_bu = new JButton(Clockwise_pic);
		Counterclockwise_bu = new JButton(Counterclockwise_pic);
		finishround_bu = new JButton("Finish Round");
		joinExplores = new JButton("Join An Explores");
		/*resume = new JButton("RESUME");
		save = new JButton("SAVE");
		load = new JButton("LOAD");
		end = new JButton("END");*/
		//information = new JLabel();
		
		//set initial Tile
		_newone[0]=generateTileData();
		_table=table;
		_fitable=new TileFigure[6][6];
		_newonefigure = new TileFigure(_newone[0]);
		
		//set Listener
		//set Rotate listener
		_Rotatelistener = new RotateButtonListener(Clockwise_bu,Counterclockwise_bu,_newone[0],_newonefigure);
		Clockwise_bu.addActionListener(_Rotatelistener);
		Counterclockwise_bu.addActionListener(_Rotatelistener);
		
		//set Join and Move listener
		_JoinAndMovelistener = new JoinAndMoveListener(_playerlist, _index, text, finishround_bu, joinExplores, _table[0][0],
				_fitable,_puttile,_newone,_newonefigure,_informationlist,playfield_panel);
		finishround_bu.addActionListener(_JoinAndMovelistener);
		joinExplores.addActionListener(_JoinAndMovelistener);
		
		//set field mouse listener
		_mouseListener= new FieldMouseListener(main,playfield_panel, _table, _newone, _fitable, _newonefigure, text, _firsttile, _puttile,
				_informationlist,_playerlist,_index);
		playfield_panel.addMouseListener(_mouseListener);
		
		//set frame layout
		Container main_cp=main.getContentPane();
		main_cp.add(player_panel,BorderLayout.NORTH);
		main_cp.add(playfield_panel,BorderLayout.CENTER);
		main_cp.add(tile_panel,BorderLayout.SOUTH);
		initfield();
		draw();
		text.setinformationText(_index[0]);
	}
	
	public void draw(){
		tile_panel.add(Clockwise_bu);
		tile_panel.add(_newonefigure);
		tile_panel.add(Counterclockwise_bu);
		tile_panel.add(finishround_bu);
		tile_panel.add(joinExplores);
	
	}
	
	// set up the Tile Figure at first **************************************************//
	private void initfield(){
		
		for(int j=0; j<=4; j++){
			_fitable[0][j]=new TileFigure(_table[0][j]);
			col_1.add(_fitable[0][j]);
		}
		for(int j=0; j<=4; j++){
			_fitable[2][j]=new TileFigure(_table[2][j]);
			col_3.add(_fitable[2][j]);
		}
		for(int j=0; j<=4; j++){
			_fitable[4][j]=new TileFigure(_table[4][j]);
			col_5.add(_fitable[4][j]);
		}
		for(int j=0; j<=5; j++){
			_fitable[1][j]=new TileFigure(_table[1][j]);
			col_2.add(_fitable[1][j]);
		}
		for(int j=0; j<=5; j++){
			_fitable[3][j]=new TileFigure(_table[3][j]);
			col_4.add(_fitable[3][j]);
		}
		for(int j=0; j<=5; j++){
			_fitable[5][j]=new TileFigure(_table[5][j]);
			col_6.add(_fitable[5][j]);
		}
	}
	//**************************************************************************************//
	public int getIndex(){
		return _index[0];
	}
	// set up the Tile at first time  *****************************************************//
	private TileData generateTileData(){
		int[] paths = generate_rock();
		TileData tmp = new TileData(-1, -1, paths, 1, _numofExplorers,false);
		return tmp;
	}
	private int[] generate_rock(){
		int[] path = new int[6];
		int counter=0;
		for(int i=0 ; i<6 ; i++){
			int inside=(int) (Math.random()*3);
			if(counter < 3 && inside!=0){
				path[i]=inside;
				counter++;
			}
		}
		return path;
	}
	//*******************************************************************//

}
