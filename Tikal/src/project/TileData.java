package project;

import java.util.ArrayList;

public class TileData {

	// Location of the Tile
	int LocX, LocY;

	// Size of path in each six directions;
	int[] _paths;

	// Values of Player Explorers on this tile

	public int[] explorers;
	int _numofExplorers;
	int _type;
	public boolean _intial=true;
	
	public Pyramid _PM;
	int _pyramidvalue;
	
	boolean _empty=false;
	boolean _pyramid=false;
	boolean _full=false;
	boolean _volcano=false;

	public TileData(int x, int y, int[] paths, int type, int numofExplorers, boolean intial) {
		LocX = x;
		LocY = y;
		_paths = paths;
		_type = type;
		_intial=intial;
		_numofExplorers = numofExplorers;
		explorers = new int[numofExplorers];
		_PM=new Pyramid(0);
		_pyramidvalue=_PM.getValue();
		if(_type == 0){
			_empty=true;
			_pyramid=false;
			_full=false;
			_volcano=false;
		}
		else if(_type == 1){
			_pyramid=false;
			_empty=false;
			_full=true;
			_volcano=false;
		}
		else if(_type == 2){
			_full=true;
			_empty=false;
			_pyramid=true;
			_volcano=false;
		}
		else{
			_full=true;
			_empty=false;
			_pyramid=false;
			_volcano=true;
		}
		
	}

	public int getType(){
		return _type;
	}
	public void setType(int x){
		_type=x;
		if(_type == 1){
			_pyramid=false;
			_empty=false;
			_full=true;
			_volcano=false;
		}
		else if(_type == 2){
			_full=true;
			_empty=false;
			_pyramid=true;
			_volcano=false;
		}
		else{
			_full=true;
			_empty=false;
			_pyramid=false;
			_volcano=true;
		}
	}

	public boolean hasempty(){
		return _empty;
	}
	public boolean haspyramid(){
		return _pyramid;
	}
	public boolean hasfull(){
		return _full;
	}
	public boolean hasvolcano(){
		return _volcano;
	}
	public boolean getinitial(){
		return _intial;
	}
	public void setinitail(boolean x){
		_intial=x;
	}
	public int getPathValue(int i) {
		return _paths[i];
	}

	public int GetX() {
		return LocX;
	}

	public void SetX(int x) {
		LocX = x;
	}

	public int GetY() {
		return LocY;
	}

	public void SetY(int y) {
		LocY = y;
	}

	public void SetExplorer(int playerIndex, int e) {
		explorers[playerIndex] = e;
	}

	public int GetExplorers(int playerIndex) {
		return explorers[playerIndex];

	}

	// Rotates the wall array counter clockwise and updates the visuals
	public void RotateClockwise() {
		int temp = _paths[5];
		_paths[5] = _paths[4];
		_paths[4] = _paths[3];
		_paths[3] = _paths[2];
		_paths[2] = _paths[1];
		_paths[1] = _paths[0];
		_paths[0] = temp;
		// UpdatePaths();

	}

	// Rotates the wall array counter clockwise and updates the visuals
	public void RotateCounterClockwise() {
		int temp = _paths[0];
		_paths[0] = _paths[1];
		_paths[1] = _paths[2];
		_paths[2] = _paths[3];
		_paths[3] = _paths[4];
		_paths[4] = _paths[5];
		_paths[5] = temp;
		// UpdatePaths();

	}

	public int getnumofplayers() {
		return _numofExplorers;
	}
	public int[] getpath(){
		return _paths;
	}
	public void setpath(int[] path){
		_paths=path;
	}
	public Pyramid getPyramid(){
		return _PM;
	}
	public void setThisPyramidvalue(int x){
		_pyramidvalue=x;
	}

}
