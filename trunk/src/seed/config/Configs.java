package seed.config;

import java.util.Hashtable;

public final class Configs {

		private static Hashtable<String, PlantConfig> type = new Hashtable<String,PlantConfig>();

		public static void setType(String key, PlantConfig value) {
			type.put(key, value);
		}

		public static PlantConfig getType(String key) {
			return type.get(key);
		}
		
		public static void init(){
			HerbConfig herbConfig = new HerbConfig();
			FlowerConfig flowerConfig = new FlowerConfig();
			TreeConfig treeConfig = new TreeConfig();
			
			setType("HERB", herbConfig);
			setType("FLOWER", flowerConfig);
			setType("TREE", treeConfig);
		}
}
