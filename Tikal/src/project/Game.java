package project;

import java.util.ArrayList;
import java.util.Random;


public class Game {
	
	//public final static String[] args;
	TileData[][] field;
	Player[] playerlist;
	GUI _gui;
	int _numofExplorers;

	public Game(String args[]) {
		field = new TileData[6][6];
		_numofExplorers=args.length;
		playerlist = new Player[_numofExplorers];
		for(int i=0 ; i<_numofExplorers ; i++){
			playerlist[i] = new Player(args[i],i);
		}
		//TileData test = generateTileData();
		initfield();
		_gui = new GUI(field, playerlist);
	}
	public Game(TileData[][] f, Player[] p, GUI g){
		field=f;
		playerlist=p;
		_gui=g;
		_numofExplorers=playerlist.length;
		System.out.println("done 4");
	}
	
	public TileData[][] getTileData(){
		return field;
	}

	
	private void initfield(){
		int[] x = {0,0,0,0,0,0}; 
		TileData aa;
		for (int i=0;   i<=5;  i++){
			if(i%2==0){
				for(int j=0; j<=4; j++){
					aa = new TileData(i, j, x, 0, _numofExplorers, true);
					field[i][j]=aa; //put the JLabel into tempList (one row -------)
				}
			}
			else{
				for(int j=0; j<=5; j++){
					aa = new TileData(i, j, x, 0, _numofExplorers, true);
					field[i][j]=aa; 
				}
			}
		}
	}
	
	public static void main(final String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Game(args);
			}
		});
	}

}
