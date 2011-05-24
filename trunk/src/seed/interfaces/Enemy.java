package seed.interfaces;

import seed.engine.Entity;

public class Enemy extends Entity{
	static int MAX_EVOLUTIONS = 50;
	
	static int evolutionNumber = 0;
	int[][] evolutions = new int[MAX_EVOLUTIONS][3];
	
	public Enemy(String id) {
		super(id);
		
		//evolutions[x][0] = quantité de production de pullution
		//evolutions[x][1] = delai de production
		//evolutions[x][2] = delai avant d'évoluer
		int pollutionProfQty = 1;
		int delayBeforeEvolve = 10000;
		for(int i=0;i < MAX_EVOLUTIONS; i++){
			evolutions[i][0] = pollutionProfQty;
			evolutions[i][1] = 250;
			evolutions[i][2] = delayBeforeEvolve;
			//pollutionProfQty += 1;
			if(pollutionProfQty < 10)
				pollutionProfQty = (int)(pollutionProfQty*2.5);
			else if(pollutionProfQty < 30)
				pollutionProfQty = (int)(pollutionProfQty*3.2);
			else if(pollutionProfQty < 300)
				pollutionProfQty = (int)(pollutionProfQty*1.5);
			else
				pollutionProfQty = (int)(pollutionProfQty*1.1);
			delayBeforeEvolve += 1000;
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
	
	static public void evolve(){
		if(evolutionNumber<MAX_EVOLUTIONS-1)
			evolutionNumber++;
		System.out.println("Enemi lvl : " + evolutionNumber);
	}
}
