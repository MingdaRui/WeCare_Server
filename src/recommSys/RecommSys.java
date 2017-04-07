package recommSys;

import java.util.ArrayList;
import java.util.Random;

import com.wecare.entry.Food;


public class RecommSys {
	
	public int clusterSize;
	
	public int ieterTime;

	public int dataSetLength;
	
	public static float[][] FoodToCalcu = new float[10][2];
	
	public ArrayList<Food> FoodList = new ArrayList<Food>();
	
	public ArrayList<float[]> dataSet;
	
	public ArrayList<float[]> center;
	
	public ArrayList<ArrayList<float[]>> cluster;
	
	public ArrayList<Float> jc;
	
	public Random random;
	
	public ArrayList<ArrayList<float[]>> getCluster() {
		return cluster;
	}
	
	public void setDataSet2(ArrayList<Food> FoodList) {
		this.FoodList = FoodList;
	}
	
	public void setDataSet(ArrayList<float[]> dataSet) {
		this.dataSet = dataSet;
	}

	public RecommSys(){
		initDataSet();
	}
	
	public RecommSys (int clusterSize)
	{
		if(clusterSize <= 1)
		{
			clusterSize = 1;
		}
		else
		{
			this.clusterSize = clusterSize;
		}
	}
	
	public void init()
	{
		ieterTime = 0;
		random = new Random();
		
		if(dataSet == null || dataSet.size() == 0)
		{
			//initDataSet(parseStr);
			initDataSet();
		}
		
		dataSetLength = dataSet.size();
		if (clusterSize > dataSetLength) {
			clusterSize = dataSetLength;
		}
		
		center = initCenter();
		cluster = initCluster();
		
		jc = new ArrayList<Float>();
	}
	
	public void initDataSet() {
		
		
		Food Food1 = new Food("beef", "meat", 10, 31.3);
		FoodList.add(Food1);
		
		Food Food2 = new Food("lamb", "meat", 100, 62.6);
		FoodList.add(Food2);
		
		Food Food3 = new Food("pork", "meat", 200, 62.6);
		FoodList.add(Food3);
		
		Food Food4 = new Food("beef", "meat", 50, 62.6);
		FoodList.add(Food4);
		
		Food Food5 = new Food("pork", "meat", 500, 62.6);
		FoodList.add(Food5);
		 
		Food Food6 = new Food("beef", "meat", 100, 62.6);
		FoodList.add(Food6);
		
		Food Food7 = new Food("lamb", "meat", 5, 62.6);
		FoodList.add(Food7);
		
		Food Food8 = new Food("pork", "meat", 30, 62.6);
		FoodList.add(Food8);
		
		Food Food9 = new Food("beef", "meat", 200, 62.6);
		FoodList.add(Food9);
		
		Food Food10 = new Food("lamb", "meat", 10, 62.6);
		FoodList.add(Food10);
		//transIntoArray(FoodList);
		
		
	}
	
    public Food match(String kind, double gram){
			Food clostMatch = null;
			double closet = 1000000;
			for(int i = 0; i < FoodList.size(); i++){
				Food f = FoodList.get(i);
				if(f.getKind().equalsIgnoreCase(kind)){
					if(Math.abs(f.getG() - gram) < closet){
						closet = Math.abs(f.getG() - gram);
						clostMatch = f;
					}
				}
			}
		return clostMatch;
	} 


	private void transIntoArray (ArrayList<Food> Foodist)
	{
		int m = 0;
		int n = 0;
		
		for(int i = 0; i < Foodist.size(); i++)
		{
			Food Food = Foodist.get(i);
	
				if(Food.getKind().equals("beef"))
				{
					m = 0;
				}
				else if (Food.getKind().equals("lamb"))
				{
					m = 1;
				}
				else
				{
					m = 2;
				}
				
				if (Food.getG() == 5)
				{
					n = 0;
				}
				else if (Food.getG() == 10)
				{
					n = 1;
				}
				else if (Food.getG() == 30)
				{
					n = 2;
				}
				else if (Food.getG() == 50)
				{
					n = 3;
				}
				else if (Food.getG() == 100)
				{
					n = 4;
				}
				else if (Food.getG() == 200)
				{
					n = 5;
				}
				else if (Food.getG() == 300)
				{
					n = 6;
				}
				else
				{
					n = 7;
				}
				
				FoodToCalcu[i][0] = m;
				FoodToCalcu[i][1] = n;
				
		}
		
		for (int i = 0; i < FoodToCalcu.length; i++) {
			dataSet.add(FoodToCalcu[i]);
		}
		
	}
	
	
//	private void initDataSet(String parseStr) {
//		
//		String[][] dataSetArray = new String[][] {"0200020002000200", "1500150014001700" };
//
//		for (int i = 0; i < dataSetArray.length; i++) {
//			dataSet.add(dataSetArray[i]);
//		}
//		*/
//
//		JSONArray array = JSONArray.fromObject(parseStr);
//	    List<Food> FoodList = JSONArray.toList(array, Food.class);
//		
//	 }

	private ArrayList<ArrayList<float[]>> initCluster() {
		ArrayList<ArrayList<float[]>> cluster = new ArrayList<ArrayList<float[]>>();
		for (int i = 0; i < clusterSize; i++) {
			cluster.add(new ArrayList<float[]>());
		}

		return cluster;
	}

	
	private ArrayList<float[]> initCenter() 
	{
		
		ArrayList<float[]> center = new ArrayList<float[]>();
		int[] randoms = new int[clusterSize];
		boolean flag;
		int temp = random.nextInt(dataSetLength);
		randoms[0] = temp;
		
		for (int i = 1; i < clusterSize; i++) 
		{
			
			flag = true;
			while (flag) {
				temp = random.nextInt(dataSetLength);
				int j = 0;
		
				while (j < i) 
				{
					
					if (temp == randoms[j]) 
					{
						break;
					}
					
					j++;
				}
				
				if (j == i) 
				{
					flag = false;
				}
			}
			randoms[i] = temp;
		}
		// 濞村鐦梾蹇旀簚閺佹壆鏁撻幋鎰剰閸愶拷
				// for(int i=0;i<k;i++)
				// {
				// System.out.println("test1:randoms["+i+"]="+randoms[i]);
				// }

				// System.out.println();
				for (int i = 0; i < clusterSize; i++) 
				{
					center.add(dataSet.get(randoms[i]));// 閻㈢喐鍨氶崚婵嗩潗閸栨牔鑵戣箛鍐懠鐞涳拷
				}
				return center;
	}
	
	
	
	private float distance (float[] element, float[] center)
	{
		
		
		float distance = 0.0f;
		
		float x = element[0] - center[0];
		
		float y = element[1] - center[1];
		
		float distNoTrnafer = x * x + y * y;
		
		distance = (float) Math.sqrt(distNoTrnafer);		
		
		return distance;
	}
	
	private int minDistance(float[] distance) {
		float minDistance = distance[0];
		int minLocation = 0;
		for (int i = 1; i < distance.length; i++) {
			if (distance[i] < minDistance) {
				minDistance = distance[i];
				minLocation = i;
			} else if (distance[i] == minDistance) // 婵″倹鐏夐惄鍝ョ搼閿涘矂娈㈤張楦跨箲閸ョ偘绔存稉顏冪秴缂冿拷
			{
				if (random.nextInt(10) < 5) {
					minLocation = i;
				}
			}
		}

		return minLocation;
	}
	
	
	private void clusterSet() {
		float[] distance = new float[clusterSize];
		for (int i = 0; i < dataSetLength; i++) {
			for (int j = 0; j < clusterSize; j++) {
				distance[j] = distance(dataSet.get(i), center.get(j));
				// System.out.println("test2:"+"dataSet["+i+"],center["+j+"],distance="+distance[j]);

			}
			int minLocation = minDistance(distance);
			// System.out.println("test3:"+"dataSet["+i+"],minLocation="+minLocation);
			// System.out.println();

			cluster.get(minLocation).add(dataSet.get(i));// 閺嶇绺鹃敍灞界殺瑜版挸澧犻崗鍐閺�鎯у煂閺堬拷鐏忓繗绐涚粋璁宠厬韫囧啰娴夐崗宕囨畱缁ㄥ洣鑵�

		}
	}
	
	private float errorSquare (float[] FoodToCalcu, float[] center)
	{
		
		
		float distance = 0.0f;
		
		float x = FoodToCalcu[0] - center[0];
		
		float y = FoodToCalcu[1] - center[1];
		
		float errorSquare = x * x + y * y;
		
		return errorSquare;
	}
	

	
	private void countRule() {
		float jcF = 0;
		for (int i = 0; i < cluster.size(); i++) {
			for (int j = 0; j < cluster.get(i).size(); j++) {
				jcF += errorSquare(cluster.get(i).get(j), center.get(i));

			}
		}
		jc.add(jcF);
	}

	private void setNewCenter() 
	{
		for (int i = 0; i < clusterSize; i++) 
		{
			int n = cluster.get(i).size();
			if (n != 0) 
			{
				float[] newCenter = { 0, 0 };
				for (int j = 0; j < n; j++) 
				{
					newCenter[0] += cluster.get(i).get(j)[0];
					newCenter[1] += cluster.get(i).get(j)[1];
				}
				
				newCenter[0] = newCenter[0] / n;
				newCenter[1] = newCenter[1] / n;
				center.set(i, newCenter);
			}
		}
	}
	
	public void printDataArray(ArrayList<float[]> dataArray,
			String dataArrayName) 
	{
		for (int i = 0; i < dataArray.size(); i++)
		{
			System.out.println("print:" + dataArrayName + "[" + i + "]={"
					+ dataArray.get(i)[0] + "," + dataArray.get(i)[1] + "}");
		}
	}
	
	
	private void kmeans() {
		init();
		
		while (true) {
			clusterSet();
			
			countRule();

			if (ieterTime != 0) {
				if (jc.get(ieterTime) - jc.get(ieterTime - 1) == 0) {
					break;
				}
			}

			setNewCenter();
			// printDataArray(center,"newCenter");
			ieterTime++;
			cluster.clear();
			cluster = initCluster();
		}

		
	}


	public void execute() {
		long startTime = System.currentTimeMillis();
		System.out.println("kmeans begins");
		kmeans();
		long endTime = System.currentTimeMillis();
		System.out.println("kmeans running time=" + (endTime - startTime)
				+ "ms");
		System.out.println("kmeans ends");
		System.out.println();
	}
	
}
