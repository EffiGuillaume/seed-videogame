package seed.tests;

public class BlockType {
	public enum Types{
		DESSERT, FORET, CHEMIN, NON_CONSTRUCTIBLE, DECOR
	}
	 
	Types type;
	
	public BlockType(Types t){
		type = t;
	}
	
	public Types getType(){
		return type;
	}
	
	public void setType(Types t){
		type = t;
	}
	
	public void setType(BlockType t){
		type = t.getType();
	}
}
