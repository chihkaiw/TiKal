package project;

public class Player {
	public String _Name;
	public int _ActionPoints;
	private int _AvailableExplores;
	private int _Score;
	//private Tile _Next_to_place;
	private int _ID;
	public boolean _myround=false;
	public Player(String name, int id){
		_ID = id;
		_Name = name;
		_ActionPoints = 12;
		_AvailableExplores = 10;
		//_Next_to_place = null;
		_Score = 0;
	}
	
	public int getActionPoints(){
		return _ActionPoints;
	}
	
	public void setActionPoints(int AP){
		_ActionPoints = AP;
	}
	
	/*public void setNextTile(Tile tile){
		_Next_to_place = tile; 
	}*/
	
	/*public Tile getNextTile(){
		return _Next_to_place;
	}*/
	public String getName(){
		return _Name;
	}
	public int getAvailableExplores(){
		return _AvailableExplores;
	}
	
	public void setAvailableExplores(int AE){
		_AvailableExplores = AE;
	}
	public int getScore(){
		return _Score;
	}
	public void setScore(int val){
		_Score = val;
	}
	public int getID(){
		return _ID;
	}
	public boolean getRoundFlag(){
		return _myround;
	}
	public void setWhoRound(boolean x){
		_myround=x;
	}
}
