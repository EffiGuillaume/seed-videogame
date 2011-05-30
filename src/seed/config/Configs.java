package seed.config;

import java.util.ArrayList;
import java.util.Hashtable;

import seed.field.BlockType;
import seed.interactions.Evolution;
import seed.units.Plant;

public final class Configs {

		private static Hashtable<String, PlantConfig> plantConfigs = new Hashtable<String,PlantConfig>();
		
		private static Hashtable<String, ArrayList<Evolution>> evolutions = new Hashtable<String,  ArrayList<Evolution>>();

		public static void setPlantConfig(String key, PlantConfig value) {
			plantConfigs.put(key, value);
		}

		public static PlantConfig getPlantConfig(String key) {
			return plantConfigs.get(key);
		}
		
		public static void LoadPlantConfig(String key,Plant p){
			p.setEvolution(key);
			p.setDelay(Integer.parseInt(Configs.getPlantConfig(key).getProperty("DELAY")));
			p.setRange(Integer.parseInt(Configs.getPlantConfig(key).getProperty("RANGE")));
			p.setStorage(0);
			p.setEnergy(0);
			p.setEnergyDelay(Integer.parseInt(Configs.getPlantConfig(key).getProperty("ENERGYDELAY")));
			p.setCost(Integer.parseInt(Configs.getPlantConfig(key).getProperty("COST")));
			p.setWaterEvolQty(Integer.parseInt(Configs.getPlantConfig(key).getProperty("WATEREVOLQTY")));
			p.setAirProd(Integer.parseInt(Configs.getPlantConfig(key).getProperty("AIRPROD")));
			p.setWaterRegressQty(Integer.parseInt(Configs.getPlantConfig(key).getProperty("WATERREGRESSQTY")));
			p.setEnergyRegressQty(Integer.parseInt(Configs.getPlantConfig(key).getProperty("ENERGYREGRESSQTY")));
			p.setImageReference(Integer.parseInt(Configs.getPlantConfig(key).getProperty("IMAGEREFERENCE")));
		}
		
		public static void setEvolution(String key,  ArrayList<Evolution> values) {
			evolutions.put(key, values);
		}

		public static ArrayList<Evolution> getEvolution(String key) {
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
			
			setPlantConfig("MUSHROOM_LVL0", new MushroomConfig(0));
			setPlantConfig("MUSHROOM_LVL1", new MushroomConfig(1));
			setPlantConfig("MUSHROOM_LVL2", new MushroomConfig(2));
			setPlantConfig("MUSHROOM_LVL3", new MushroomConfig(3));
			
			setPlantConfig("ALGA_LVL0", new AlgaConfig(0));
			setPlantConfig("ALGA_LVL1", new AlgaConfig(1));
			setPlantConfig("ALGA_LVL2", new AlgaConfig(2));
			setPlantConfig("ALGA_LVL3", new AlgaConfig(3));
			
			//création des évolutions
			try
			{
			//HERB
			Evolution herb_lvl1 = new Evolution("HERB_LVL1_Evolution");
			herb_lvl1.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("HERB_LVL1").getProperty("EVOLCOST")));
			ArrayList<BlockType> herb_fields0 = new ArrayList<BlockType>();
				herb_fields0.add(BlockType.DESERT);
				herb_fields0.add(BlockType.FORET);
			herb_lvl1.setFields(herb_fields0);
			herb_lvl1.setType("HERB");
			herb_lvl1.setEvol("LVL1");
			
			Evolution herb_lvl2 = new Evolution("HERB_LVL2_Evolution");
			herb_lvl2.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("HERB_LVL2").getProperty("EVOLCOST")));
			ArrayList<BlockType> herb_fields = new ArrayList<BlockType>();
				herb_fields.add(BlockType.DESERT);
				herb_fields.add(BlockType.FORET);
			herb_lvl2.setFields(herb_fields);
			herb_lvl2.setType("HERB");
			herb_lvl2.setEvol("LVL2");
			
			Evolution herb_lvl3 = new Evolution("HERB_LVL3_Evolution");
			herb_lvl3.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("HERB_LVL3").getProperty("EVOLCOST"))); 
			ArrayList<BlockType> herb_fields2 = new ArrayList<BlockType>();
				herb_fields2.add(BlockType.DESERT);
				herb_fields2.add(BlockType.FORET);
			herb_lvl3.setFields(herb_fields2);
			herb_lvl3.setType("HERB");
			herb_lvl3.setEvol("LVL3");
			
			//MUSHROOM
			Evolution mushroom_lvl1 = new Evolution("MUSHROOM_LVL1_Evolution");
			mushroom_lvl1.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("MUSHROOM_LVL1").getProperty("EVOLCOST")));
			ArrayList<BlockType> mushroom_fields0 = new ArrayList<BlockType>();
				mushroom_fields0.add(BlockType.FORET);
			mushroom_lvl1.setFields(mushroom_fields0);
			mushroom_lvl1.setType("MUSHROOM");
			mushroom_lvl1.setEvol("LVL1");
			
			Evolution mushroom_lvl2 = new Evolution("MUSHROOM_LVL2_Evolution");
			mushroom_lvl2.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("MUSHROOM_LVL2").getProperty("EVOLCOST")));
			ArrayList<BlockType> mushroom_fields = new ArrayList<BlockType>();
				mushroom_fields.add(BlockType.FORET);
			mushroom_lvl2.setFields(mushroom_fields);
			mushroom_lvl2.setType("MUSHROOM");
			mushroom_lvl2.setEvol("LVL2");
			
			Evolution mush_lvl3 = new Evolution("MUSHROOM_LVL3_Evolution");
			mush_lvl3.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("MUSHROOM_LVL3").getProperty("EVOLCOST"))); 
			ArrayList<BlockType> mush_fields2 = new ArrayList<BlockType>();
				mush_fields2.add(BlockType.FORET);
			mush_lvl3.setFields(mush_fields2);
			mush_lvl3.setType("MUSHROOM");
			mush_lvl3.setEvol("LVL3");
			
			//FLOWER
			Evolution flower_lvl1 = new Evolution("FLOWER_LVL1_Evolution");
			flower_lvl1.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("FLOWER_LVL1").getProperty("EVOLCOST")));
			ArrayList<BlockType> flower_fields0 = new ArrayList<BlockType>();
				flower_fields0.add(BlockType.FORET);
			flower_lvl1.setFields(flower_fields0);
			flower_lvl1.setType("FLOWER");
			flower_lvl1.setEvol("LVL1");
			
			Evolution flower_lvl2 = new Evolution("FLOWER_LVL2_Evolution");
			flower_lvl2.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("FLOWER_LVL2").getProperty("EVOLCOST")));
			ArrayList<BlockType> flower_fields = new ArrayList<BlockType>();
				flower_fields.add(BlockType.FORET);
			flower_lvl2.setFields(flower_fields);
			flower_lvl2.setType("FLOWER");
			flower_lvl2.setEvol("LVL2");
			
			Evolution flower_lvl3 = new Evolution("FLOWER_LVL3_Evolution");
			flower_lvl3.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("FLOWER_LVL3").getProperty("EVOLCOST"))); 
			ArrayList<BlockType> flower_fields2 = new ArrayList<BlockType>();
				flower_fields2.add(BlockType.FORET);
			flower_lvl3.setFields(flower_fields2);
			flower_lvl3.setType("FLOWER");
			flower_lvl3.setEvol("LVL3");
			
			//TREE
			Evolution tree_lvl1 = new Evolution("LVL1_TREE_Evolution");
			tree_lvl1.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("TREE_LVL1").getProperty("EVOLCOST")));
			ArrayList<BlockType> tree_fields0 = new ArrayList<BlockType>();
				tree_fields0.add(BlockType.DESERT);
				tree_fields0.add(BlockType.FORET);
			tree_lvl1.setFields(tree_fields0);
			tree_lvl1.setType("TREE");
			tree_lvl1.setEvol("LVL1");
			
			Evolution tree_lvl2 = new Evolution("LVL2_TREE_Evolution");
			tree_lvl2.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("TREE_LVL2").getProperty("EVOLCOST")));
			ArrayList<BlockType> tree_fields = new ArrayList<BlockType>();
				tree_fields.add(BlockType.DESERT);
				tree_fields.add(BlockType.FORET);
			tree_lvl2.setFields(tree_fields);
			tree_lvl2.setType("TREE");
			tree_lvl2.setEvol("LVL2");
			
			Evolution tree_lvl3 = new Evolution("LVL3_TREE_Evolution");
			tree_lvl3.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("TREE_LVL3").getProperty("EVOLCOST"))); 
			ArrayList<BlockType> tree_fields2 = new ArrayList<BlockType>();
				tree_fields2.add(BlockType.DESERT);
				tree_fields2.add(BlockType.FORET);
			tree_lvl3.setFields(tree_fields2);
			tree_lvl3.setType("TREE");
			tree_lvl3.setEvol("LVL3");
			
			Evolution alga_lvl1 = new Evolution("ALGA_LVL1_Evolution");
			alga_lvl1.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("ALGA_LVL1").getProperty("EVOLCOST")));
			ArrayList<BlockType> alga_fields0 = new ArrayList<BlockType>();
				alga_fields0.add(BlockType.CHEMIN);
				alga_fields0.add(BlockType.FORET);
			alga_lvl1.setFields(alga_fields0);
			alga_lvl1.setType("ALGA");
			alga_lvl1.setEvol("LVL1");
		
			Evolution alga_lvl2 = new Evolution("ALGA_LVL2_Evolution");
			alga_lvl2.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("ALGA_LVL2").getProperty("EVOLCOST")));
			ArrayList<BlockType> alga_fields = new ArrayList<BlockType>();
				alga_fields.add(BlockType.CHEMIN);
			alga_lvl2.setFields(alga_fields);
			alga_lvl2.setType("ALGA");
			alga_lvl2.setEvol("LVL2");
				
			Evolution alga_lvl3 = new Evolution("ALGA_LVL3_Evolution");
			alga_lvl3.setEnergyCost(Integer.parseInt(Configs.getPlantConfig("ALGA_LVL3").getProperty("EVOLCOST"))); 
			ArrayList<BlockType> alga_fields2 = new ArrayList<BlockType>();
				alga_fields2.add(BlockType.CHEMIN);
			alga_lvl3.setFields(alga_fields2);
			alga_lvl3.setType("ALGA");
			alga_lvl3.setEvol("LVL3");
			
			//puis on crée le tableau des évolutions
			
			//HERB
			ArrayList<Evolution> evol_herb_lvl0 = new ArrayList<Evolution>();
			evol_herb_lvl0.add(herb_lvl1);
			setEvolution("HERB_LVL0",evol_herb_lvl0);
			
			ArrayList<Evolution> evol_herb_lvl1= new ArrayList<Evolution>();
			evol_herb_lvl1.add(herb_lvl2);
			//evol_herb_lvl1.add(herb_lvl3);
			setEvolution("HERB_LVL1",evol_herb_lvl1);
			
			ArrayList<Evolution> evol_herb_lvl2= new ArrayList<Evolution>();
			evol_herb_lvl2.add(herb_lvl3);
			setEvolution("HERB_LVL2",evol_herb_lvl2);
			
			ArrayList<Evolution> evol_herb_lvl3= new ArrayList<Evolution>();
			evol_herb_lvl3.add(flower_lvl3);
			setEvolution("HERB_LVL3",evol_herb_lvl3); //à voir si ça convient
			
			//MUSHROOM
			ArrayList<Evolution> evol_mush_lvl0 = new ArrayList<Evolution>();
			evol_mush_lvl0.add(mushroom_lvl1);
			setEvolution("MUSHROOM_LVL0",evol_mush_lvl0);
			
			ArrayList<Evolution> evol_mush_lvl1= new ArrayList<Evolution>();
			evol_mush_lvl1.add(mushroom_lvl2);
			evol_mush_lvl1.add(mush_lvl3);
			setEvolution("MUSHROOM_LVL1",evol_mush_lvl1);
			
			ArrayList<Evolution> evol_mush_lvl2= new ArrayList<Evolution>();
			evol_mush_lvl2.add(mush_lvl3);
			setEvolution("MUSHROOM_LVL2",evol_mush_lvl2);
		
			
			//FLOWER
			ArrayList<Evolution> evol_flower_lvl0= new ArrayList<Evolution>();
			evol_flower_lvl0.add(flower_lvl1);
			setEvolution("FLOWER_LVL0",evol_flower_lvl0);
			
			ArrayList<Evolution> evol_flower_lvl1= new ArrayList<Evolution>();
			evol_flower_lvl1.add(flower_lvl2);
			//evol_flower_lvl1.add(flower_lvl3);
			setEvolution("FLOWER_LVL1",evol_flower_lvl1);
			
			ArrayList<Evolution> evol_flower_lvl2= new ArrayList<Evolution>();
			evol_flower_lvl2.add(flower_lvl3);
			setEvolution("FLOWER_LVL2",evol_flower_lvl2);
			
			//TREE
			ArrayList<Evolution> evol_tree_lvl0= new ArrayList<Evolution>();
			//evol_tree_lvl0.add(herb_lvl1);
			evol_tree_lvl0.add(tree_lvl1);
			setEvolution("TREE_LVL0",evol_tree_lvl0); //à voir si ça convient (cas où les conditions sont déplorables : l'arbre ne repousse qu'en HERB !)
			
			ArrayList<Evolution> evol_tree_lvl1= new ArrayList<Evolution>();
			evol_tree_lvl1.add(tree_lvl2);
			//evol_tree_lvl1.add(tree_lvl3);
			setEvolution("TREE_LVL1",evol_tree_lvl1);
			
			ArrayList<Evolution> evol_tree_lvl2= new ArrayList<Evolution>();
			evol_tree_lvl2.add(tree_lvl3);
			setEvolution("TREE_LVL2",evol_tree_lvl2);
			
			//ALGA
			ArrayList<Evolution> evol_alga_lvl0= new ArrayList<Evolution>();
			evol_alga_lvl0.add(alga_lvl1);
			setEvolution("ALGA_LVL0",evol_alga_lvl0);
			
			ArrayList<Evolution> evol_alga_lvl1= new ArrayList<Evolution>();
			evol_alga_lvl1.add(alga_lvl2);
			evol_alga_lvl1.add(alga_lvl3);
			setEvolution("ALGA_LVL1",evol_alga_lvl1);
			
			ArrayList<Evolution> evol_alga_lvl2= new ArrayList<Evolution>();
			evol_alga_lvl2.add(alga_lvl3);
			evol_alga_lvl2.add(flower_lvl2);
			setEvolution("ALGA_LVL2",evol_alga_lvl2); //à voir si ça convient
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
}
