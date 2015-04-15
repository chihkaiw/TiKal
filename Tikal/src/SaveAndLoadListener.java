package gitproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.thoughtworks.xstream.XStream;

public class SaveAndLoadListener implements ActionListener{
	
	JButton _resume;
	JButton _save;
	JButton _load;
	JButton _end;
	
	Player[] _player;
	TileData[][] _BoardData;
	
	JFrame _main;
	JPanel _player_panel;
	JPanel _playfield_panel;
	JPanel _tile_panel;

	int[] _index;
	int _numofExplorers;
	boolean[] _puttile;
	TileData[] _newone;
	
	TopPanelTilte _text;
	JLabel _informationlsit;
	
	public SaveAndLoadListener(JButton resume, JButton save, JButton load, JButton end, Player[] player, TileData[][] boardData,
			int[] index,int numofExplorers,boolean[] puttile,TileData[] newone,TopPanelTilte text, JLabel informationlsit, JFrame main) {
		
		_resume=resume;
		_save=save;
		_load=load;
		_end=end;
		
		_player=player;
		_BoardData=boardData;
		

		_index=index;
		_numofExplorers=numofExplorers;
		_puttile=puttile;
		_newone=newone;
		_text=text;
		_informationlsit=informationlsit;
		_main=main;
	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource(); // !!!!!!  to recognize that we press which button
		if(button==_resume){
			_main.setVisible(false);
			String[] args = new String[_player.length];
			for(int i=0 ; i<_player.length ; i++){
				args[i]=_player[i].getName();
			}
			Game newgame=new Game(args);
		}
		else if(button==_save){
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
			    "XML Files", "xml");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showSaveDialog(chooser.getParent());
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			
				   try {
					  // System.out.println(chooser.getSelectedFile().getAbsolutePath());
					Save(chooser.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		}
		else if(button==_load){
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
			    "XML Files", "xml");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(chooser.getParent());
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					FileInputStream fis=new FileInputStream(new File(chooser.getSelectedFile().getAbsolutePath()));
					byte[] b=new byte[fis.available()];
					fis.read(b);
					fis.close();
					String xml=new String(b);
					XStream xstream=new XStream();
					xstream.alias("Game_Data",Game_Data.class);
					xstream.alias("Player_Data",Player_Data.class);
					xstream.alias("Tile_Data",Tile_Data.class);
					xstream.alias("Cur_Data",Cur_Data.class);
					Game_Data game=(Game_Data)xstream.fromXML(xml);
					// set up player *******************************************************************************//
					Player [] _player=new Player[game.player.size()];
					for(int i=0;i<game.player.size();i++){
						_player[i]=new Player(game.player.get(i)._Name,game.player.get(i)._ID);
						_player[i].setActionPoints(game.player.get(i)._ActionPoints);
						_player[i].setAvailableExplores(game.player.get(i)._AvailableExplores);
						_player[i].setScore(game.player.get(i)._Score);
						_player[i].setWhoRound(game.player.get(i)._myround);
					}
					// set up Tile *******************************************************************************//
					TileData[][] BoardData=new TileData[6][6];
					for(int i=0;i<BoardData.length;i++){
						if(i % 2==0){
							for(int j=0;j<BoardData[i].length-1;j++){
								BoardData[i][j] = new TileData(game.tile.get(i).get(j).X, game.tile.get(i).get(j).Y, 
										game.tile.get(i).get(j).paths, game.tile.get(i).get(j).type,
										game.tile.get(i).get(j).numofExplorers, game.tile.get(i).get(j).intial);
								
								for(int k=0 ; k<game.tile.get(i).get(j).explorers.size(); k++){
									BoardData[i][j].SetExplorer(k, game.tile.get(i).get(j).explorers.get(k));
								}
								//BoardData[i][j]._PM=new Pyramid(0);
								BoardData[i][j]._PM.setValue(game.tile.get(i).get(j)._pyramidvalue);
								
								//tmp_tile.volcano=_BoardData[i][j]._volcano;
							}
						}
						else{
							for(int j=0;j<BoardData[i].length;j++){
								BoardData[i][j] = new TileData(game.tile.get(i).get(j).X, game.tile.get(i).get(j).Y, 
										game.tile.get(i).get(j).paths, game.tile.get(i).get(j).type,
										game.tile.get(i).get(j).numofExplorers, game.tile.get(i).get(j).intial);
								
								for(int k=0 ; k<game.tile.get(i).get(j).explorers.size(); k++){
									BoardData[i][j].SetExplorer(k, game.tile.get(i).get(j).explorers.get(k));
								}
								//BoardData[i][j]._PM=new Pyramid(0);
								BoardData[i][j]._PM.setValue(game.tile.get(i).get(j)._pyramidvalue);
								
								//tmp_tile.volcano=_BoardData[i][j]._volcano;
							}
						}
					}
					// set up GUI ********************************************************************************//

					int[] index=game.cur.index;
					int numofExplorers=game.cur.numofExplorers;
					boolean[] puttile=game.cur.puttile;
					
					TileData n1 = new TileData(game.cur.nX, game.cur.nY, game.cur.npaths, game.cur.ntype, game.cur.numofExplorers, game.cur.nintial);
					n1._PM.setValue(game.cur.n_pyramidvalue);
					TileData[] newone = new TileData[1];
					newone[0]=n1;

					_main.setVisible(false);
					System.out.println("done 1");
					GUI gui = new GUI(index, numofExplorers, puttile, newone, _player,BoardData);
					System.out.println("done 2");
					Game newgame=new Game(BoardData,_player,gui);	
					System.out.println("done 3");
				} 
				catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		}
		else if(button==_end){
			score();
		}
		
	}
	
	public void score(){
		int[] score_box = new int[_numofExplorers];
		for(int i=0 ; i< 6 ; i++ ){
			if(i % 2 ==0){
				for(int j=0 ; j<5 ; j++){
					if(_BoardData[i][j].haspyramid() && !_BoardData[i][j].getinitial()){
						int thispyramidvalue = _BoardData[i][j].getPyramid().getValue();
						int index = 0;
						int max=_BoardData[i][j].GetExplorers(0);
						for(int k=1 ; k<_BoardData[i][j].getnumofplayers() ; k++){
							if(_BoardData[i][j].GetExplorers(k) > max){
								index=k;
							}
						}
						score_box[index]=score_box[index]+thispyramidvalue;
					}
				}
			}
			else{
				for(int j=0 ; j<6 ; j++){
					if(_BoardData[i][j].haspyramid() && !_BoardData[i][j].getinitial()){
						int thispyramidvalue = _BoardData[i][j].getPyramid().getValue();
						int index = 0;
						int max=_BoardData[i][j].GetExplorers(0);
						for(int k=1 ; k<_BoardData[i][j].getnumofplayers() ; k++){
							if(_BoardData[i][j].GetExplorers(k) > max){
								index=k;
							}
						}
						score_box[index]=score_box[index]+thispyramidvalue;
					}
				}
			}
		}
		_text.setinformationText(_index[0]);
		String s = "";
		for(int i=0 ; i<_numofExplorers ; i++){
			_player[i].setScore(score_box[i]);
			s=s+_player[i].getName() + "Score = " + _player[i].getScore() + " , ";
			score_box[i]=0;
		}
		JOptionPane.showMessageDialog(null,s);
		
	}
	
	public void Save(String path) throws FileNotFoundException{
		Game_Data game=new Game_Data(); 
		XStream xstream=new XStream();
		xstream.alias("Game_Data",Game_Data.class);
		xstream.alias("Player_Data",Player_Data.class);
		xstream.alias("Tile_Data",Tile_Data.class);
		xstream.alias("Cur_Data",Cur_Data.class);
		// Player Data *****************************************************************************//
		for(int i=0;i<_player.length;i++){
			Player_Data player=new Player_Data();
			player._Name=_player[i].getName();
			player._ActionPoints=_player[i].getActionPoints();
			player._AvailableExplores=_player[i].getAvailableExplores();
			player._Score=_player[i].getScore();
			player._ID=_player[i].getID();
			player._myround = _player[i].getRoundFlag();
			game.player.add(player);
		}
		// Tile Data  *************************************************************************************//
		TileData[][] BoardData=new TileData[6][6];
		for(int i=0;i<BoardData.length;i++){
			ArrayList<Tile_Data> tmp_array=new ArrayList<Tile_Data>();
			if(i % 2==0){
				for(int j=0;j<BoardData[i].length-1;j++){
					Tile_Data tmp_tile=new Tile_Data();
					tmp_tile.X=_BoardData[i][j].LocX;
					tmp_tile.Y=_BoardData[i][j].LocY;
					for(int k=0;k<6;k++){
						tmp_tile.paths[k]=_BoardData[i][j]._paths[k];
					}
					tmp_tile.PMV=_BoardData[i][j]._pyramid;
					tmp_tile.empty=_BoardData[i][j]._empty;
					tmp_tile.full=_BoardData[i][j]._full;
					//tmp_tile.volcano=_BoardData[i][j]._volcano;
					tmp_tile.numofExplorers=_BoardData[i][j]._numofExplorers;
					for(int k=0;k<_BoardData[i][j].explorers.length;k++){
						tmp_tile.explorers.add(_BoardData[i][j].explorers[k]);
					}
					//tmp_tile._PM=_BoardData[i][j]._PM;
					tmp_tile._pyramidvalue=_BoardData[i][j]._PM.currentValue;
					tmp_tile.type=_BoardData[i][j].getType();
					tmp_array.add(tmp_tile);
				}
			}
			else{
				for(int j=0;j<BoardData[i].length;j++){
					Tile_Data tmp_tile=new Tile_Data();
					tmp_tile.X=_BoardData[i][j].LocX;
					tmp_tile.Y=_BoardData[i][j].LocY;
					for(int k=0;k<6;k++){
						tmp_tile.paths[k]=_BoardData[i][j]._paths[k];
					}
					tmp_tile.PMV=_BoardData[i][j]._pyramid;
					tmp_tile.empty=_BoardData[i][j]._empty;
					tmp_tile.full=_BoardData[i][j]._full;
					//tmp_tile.volcano=_BoardData[i][j]._volcano;
					tmp_tile.numofExplorers=_BoardData[i][j]._numofExplorers;
					for(int k=0;k<_BoardData[i][j].explorers.length;k++){
						tmp_tile.explorers.add(_BoardData[i][j].explorers[k]);
					}
					//tmp_tile._PM=_BoardData[i][j]._PM;
					tmp_tile._pyramidvalue=_BoardData[i][j]._PM.currentValue;
					tmp_tile.type=_BoardData[i][j].getType();
					tmp_array.add(tmp_tile);
				}
			}
			game.tile.add(tmp_array);
		}
		// Move Data **************************************************************************//
		//Cur_Data cur=new Cur_Data();
		game.cur.index=_index;
		//game.cur.playerlist=_player;
		game.cur.numofExplorers=_numofExplorers;
		game.cur.puttile=_puttile;

		game.cur.nX=_newone[0].GetX();
		game.cur.nY=_newone[0].GetY();
		for(int k=0;k<6;k++){
			game.cur.npaths[k]=_newone[0]._paths[k];
		}
		game.cur.nintial = _newone[0]._intial;
		game.cur.nPMV=_newone[0]._pyramid;
		game.cur.nempty=_newone[0]._empty;
		game.cur.nfull=_newone[0]._full;
		//tmp_tile.volcano=_BoardData[i][j]._volcano;
		for(int k=0;k<_newone[0].explorers.length;k++){
			game.cur.nexplorers.add(_newone[0].explorers[k]);
		}
		//tmp_tile._PM=_BoardData[i][j]._PM;
		game.cur.n_pyramidvalue=_newone[0]._PM.currentValue;
		game.cur.ntype=_newone[0].getType();

		
		FileOutputStream fos=new FileOutputStream(new File(path));
		xstream.toXML(game, fos);
	}

}
