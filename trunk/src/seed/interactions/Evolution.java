package seed.interactions;

import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.SlickException;

import seed.engine.Entity;
import seed.field.BlockType;

public class Evolution extends Entity{
	private String type;
	private String evol;
	private int energyCost;
	private ArrayList<BlockType> fields = new ArrayList<BlockType>();
	
	public Evolution(String id) throws SlickException{
		super(id);
	}
	
	public int getEnergyCost() {
		return energyCost;
	}
	public void setEnergyCost(int energyCost) {
		this.energyCost = energyCost;
	}
	public ArrayList<BlockType> getFields() {
		return fields;
	}
	
	public void setFields(ArrayList<BlockType> fields) {
		this.fields = fields;
	}
	
	public void addField(BlockType f) {
		this.fields.add(f);
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setEvol(String evol) {
		this.evol = evol;
	}

	public String getEvol() {
		return evol;
	}

	//Vérifie la constructibilité suivant un autre tableau de type de terrain
	public boolean isConstructibleOnField(ArrayList<BlockType> fieldArray){
		Iterator<BlockType> it = fields.iterator();
		while(it.hasNext()){
			BlockType field = (BlockType) it.next();
			Iterator<BlockType> it2 = fieldArray.iterator();
			while(it2.hasNext()){
				BlockType field2 = (BlockType) it2.next();
				if(field == field2){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isConstructibleOnField(BlockType f){
		Iterator<BlockType> it = fields.iterator();
		while(it.hasNext()){
			BlockType field = (BlockType) it.next();
			if(field == f){
				return true;
			}
		}
		return false;
	}
}
