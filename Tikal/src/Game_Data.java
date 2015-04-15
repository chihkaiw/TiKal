package gitproject;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game_Data{
	public ArrayList<Player_Data> player=new ArrayList<Player_Data>();
	public ArrayList<ArrayList<Tile_Data>> tile=new ArrayList<ArrayList<Tile_Data>>();
	public Cur_Data cur=new Cur_Data();
	public int numberofTiles;
}
class Player_Data{
	public String _Name;
	public int _ActionPoints;
	public int _AvailableExplores;
	public int _Score;
	public int _ID;
	public boolean _myround;
}
class Tile_Data{
	public int X;
	public int Y;
	
	public int[] paths=new int[6];
	
	public ArrayList<Integer> explorers=new ArrayList<Integer>();
	public int numofExplorers;
	public int type;
	
	public boolean intial;
	
	//public Pyramid _PM;
	public int _pyramidvalue;
	public boolean PMV;
	public boolean empty;
	public boolean full;
	//public boolean volcano;
	
}
class Cur_Data{

	public int[] index;
	public Player[] playerlist;
	public int numofExplorers;
	public boolean[] puttile;
	public TopPanelTilte text;
	public JLabel informationlsit;
	
	public int nX;
	public int nY;
	
	public int[] npaths=new int[6];
	
	public ArrayList<Integer> nexplorers=new ArrayList<Integer>();

	public int ntype;
	
	public boolean nintial;
	
	//public Pyramid _PM;
	public int n_pyramidvalue;
	public boolean nPMV;
	public boolean nempty;
	public boolean nfull;
}
