import java.util.*;

public class FractionalKnapSack {
    static class ItemValue {
        int weight;
        int value;
        double cpu;

        public ItemValue(int val, int wt) {
            this.weight = wt;
            this.value = val;
            cpu = (double) value / weight;
        }
    }

    static double getMaxValue(ItemValue arr[], int capacity) {
        Arrays.sort(arr, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue v1, ItemValue v2) {
                if (v1.cpu < v2.cpu)
                    return 1;
                return -1;
            }
        });

        double totalValue = 0d;
        for (ItemValue item : arr) {
            int curWt = item.weight;
            int curVal = item.value;

            if (capacity - curWt >= 0) {
                capacity = capacity - curWt;
                totalValue += curVal;
            } else {
                double fraction = (double) capacity / (double) curWt;
                totalValue += (double) (curVal * fraction);
                capacity = (int) (capacity - (curWt * fraction));
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        ItemValue arr[] = {
                new ItemValue(60, 10),
                new ItemValue(120, 30),
                new ItemValue(100, 20),
        };
        int capacity = 50;
        double maxValue = getMaxValue(arr, capacity);
        System.out.println(maxValue);
    }
}