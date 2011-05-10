package seed.interfaces;

import seed.engine.Entity;

public class Enemy extends Entity{
	int MAX_EVOLUTIONS = 3;
	
	int evolutionNumber = 0;
	int[][] evolutions = new int[MAX_EVOLUTIONS][2];
	
	public Enemy(String id) {
		super(id);
		
		//evolutions[x][0] = quantité de production de pullution
		//evolutions[x][1] = delai de production
		//evolutions[x][2] = delai avant d'évoluer
		int pollutionProfQty = 1;
		int delayBeforeEvolve = 1000000;
		for(int i=0;i < MAX_EVOLUTIONS; i++){
			evolutions[i][0] = pollutionProfQty;
			evolutions[i][1] = 5000;
			evolutions[i][2] = delayBeforeEvolve;
			pollutionProfQty += 1;
			delayBeforeEvolve += 1000000;
		}
		
		addComponent(new EnemyComponent());
	}

	public int getPollutionProdQty() {
		return evolutions[evolutionNumber][0];
	}
	
	public int getPollutionProdDelay() {
		return evolutions[evolutionNumber][1];
	}
	
	public int getEvolutionDelay() {
		return evolutions[evolutionNumber][2];
	}
	
	public void evolve(){
		if(evolutionNumber<MAX_EVOLUTIONS)
			evolutionNumber++;
	}
}
