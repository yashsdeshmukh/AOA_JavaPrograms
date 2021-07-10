package aoaPrograms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    static class Item {
        Double ratio;
        double weight, profit, index;
 
        // item value function
		public Item(int weight, int profit, int index){
            this.weight = weight;
            this.profit = profit;
            this.index = index;
            ratio = (double)profit /(double) weight ;
        }
    }
	
	// function to get maximum value
    private static double getMaxValue(int[] weight, int[] profit, int capacity)
    {
        Item[] iVal = new Item[weight.length];
 
        for (int i = 0; i < weight.length; i++) {
            iVal[i] = new Item(weight[i], profit[i], i);
        }

        //sorting items by ratio
        Comparator<Item> compareByRatio = (Item o1, Item o2) -> o2.ratio.compareTo(o1.ratio);
        Arrays.sort(iVal, compareByRatio);
        double totalValue = 0d;
 
        for (Item i : iVal) {
 
            int curWt = (int)i.weight;
            int curProf = (int)i.profit;
 
            if (capacity - curWt >= 0) {
                // this weight can be picked while
                capacity = capacity - curWt;
                totalValue += curProf;
            }
            else {
                // when item can't be picked whole, divide 
                double fraction = ((double)capacity / (double)curWt);
                totalValue += (curProf * fraction);
                capacity = (int)(capacity - (curWt * fraction));
                break;
            }
        }
 
        return totalValue;
    }
 
    
 
    // Driver code
    public static void main(String[] args)
    {
        int[] weight = { 10, 40, 20, 30 };
        int[] profit = { 60, 40, 100, 120 };
        int capacity = 50;
 
        double maxValue = getMaxValue(weight, profit, capacity);
 
        // Function call
        System.out.println("Maximum value we can obtain = "+ maxValue);
    }

}
