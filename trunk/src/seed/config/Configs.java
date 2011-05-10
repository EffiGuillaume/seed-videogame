package seed.config;

import java.util.Hashtable;

public final class Configs {

		private static Hashtable<String, PlantConfig> plantConfigs = new Hashtable<String,PlantConfig>();
		
		private static Hashtable<String, String> evolutions = new Hashtable<String, String>();

		public static void setPlantConfig(String key, PlantConfig value) {
			plantConfigs.put(key, value);
		}

		public static PlantConfig getPlantConfig(String key) {
			return plantConfigs.get(key);
		}
		
		public static void setEvolution(String key, String value) {
			evolutions.put(key, value);
		}

		public static String getEvolution(String key) {
			return evolutions.get(key);
		}

		public static void init(){
			//on crée le tableau des Configurations des plantes			
			setPlantConfig("HERB_LVL0", new HerbConfig(0));
			setPlantConfig("HERB_LVL1", new HerbConfig(1));
			setPlantConfig("HERB_LVL2", new HerbConfig(2));
			setPlantConfig("HERB_LVL3", new HerbConfig(3));
			
			setPlantConfig("FLOWER_LVL0", new FlowerConfig(0));
			setPlantConfig("FLOWER_LVL1", new FlowerConfig(1));
			setPlantConfig("FLOWER_LVL2", new FlowerConfig(2));
			setPlantConfig("FLOWER_LVL3", new FlowerConfig(3));
			
			setPlantConfig("TREE_LVL0", new TreeConfig(0));
			setPlantConfig("TREE_LVL1", new TreeConfig(1));
			setPlantConfig("TREE_LVL2", new TreeConfig(2));
			setPlantConfig("TREE_LVL3", new TreeConfig(3));
			
			setPlantConfig("ALGA_LVL0", new AlgaConfig(0));
			setPlantConfig("ALGA_LVL1", new AlgaConfig(1));
			setPlantConfig("ALGA_LVL2", new AlgaConfig(2));
			setPlantConfig("ALGA_LVL3", new AlgaConfig(3));
			
			//puis on crée le tableau des évolution
			setEvolution("HERB_LVL0","HERB_LVL1");
			setEvolution("HERB_LVL1","HERB_LVL2");
			setEvolution("HERB_LVL1","HERB_LVL3");
			setEvolution("HERB_LVL2","HERB_LVL3");
			setEvolution("HERB_LVL2","FLOWER_LVL2"); //à voir si ça convient
			
			setEvolution("FLOWER_LVL0","FLOWER_LVL1");
			setEvolution("FLOWER_LVL1","FLOWER_LVL2");
			setEvolution("FLOWER_LVL1","FLOWER_LVL3");
			setEvolution("FLOWER_LVL2","FLOWER_LVL3");
			
			setEvolution("TREE_LVL0","HERB_LVL1"); //à voir si ça convient (cas où les conditions sont déplorables : l'arbre ne repousse qu'en HERB !)
			setEvolution("TREE_LVL0","TREE_LVL1");
			setEvolution("TREE_LVL1","TREE_LVL2");
			setEvolution("TREE_LVL1","TREE_LVL3");
			setEvolution("TREE_LVL2","TREE_LVL3");
			
			setEvolution("ALGA_LVL0","ALGA_LVL1");
			setEvolution("ALGA_LVL1","ALGA_LVL2");
			setEvolution("ALGA_LVL1","ALGA_LVL3");
			setEvolution("ALGA_LVL2","ALGA_LVL3");
			setEvolution("ALGA_LVL2","FLOWER_LVL2"); //à voir si ça convient
			
		}
}
