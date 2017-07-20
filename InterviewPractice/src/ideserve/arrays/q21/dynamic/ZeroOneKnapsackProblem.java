package ideserve.arrays.q21.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.ideserve.co.in/learn/dynamic-programming-0-1-knapsack-problem
 */
public class ZeroOneKnapsackProblem {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(0,2,3));
        items.add(new Item(1,2,7));
        items.add(new Item(2,4,2));
        items.add(new Item(3,5,9));

        getMaxValue(items, 10);
    }

    /**
     * O(w*i) runtime - 'w' is weight, 'i' is number of items
     * O(w*i) space
     *
     * @param items
     * @param weight
     * @return
     */
    private static int getMaxValue(List<Item> items, int weight) {
        int value = 0;
        int maxValueWeight = 0;

        Knapsack[] values = new Knapsack[weight + 1];
        for (int i = 0; i < values.length; i++) {
            values[i] = new Knapsack();
        }

        for (int i = 1; i < values.length; i++) {
            Knapsack currentKnapsack = values[i];
            for (Item item : items) {
                if (i - item.weight >= 0 && !currentKnapsack.containsItem(item)) {
                    Knapsack previousKnapsack = values[i - item.weight];
                    if (previousKnapsack.value + item.value > currentKnapsack.value) {
                        currentKnapsack.clear();
                        currentKnapsack.mergeItems(previousKnapsack.items);
                        currentKnapsack.addItem(item);
                    }
                }
            }
            if (currentKnapsack.value > value) {
                value = currentKnapsack.value;
                maxValueWeight = i;
            }
        }
        System.out.println("Max benefit: " + value + ". Weight: " + maxValueWeight);
        return value;
    }

    static class Knapsack {
        private int value;
        private List<Item> items;

        public Knapsack() {
            this.value = 0;
            this.items = new ArrayList<>();
        }

        boolean containsItem(Item item) {
            return this.items.contains(item);
        }

        void addItem(Item item) {
            this.items.add(item);
            this.value += item.value;
        }

        void mergeItems(List<Item> itemsToMerge) {
            for (Item item : itemsToMerge) {
                this.items.add(item);
                this.value += item.value;
            }
        }

        void clear() {
            this.value = 0;
            this.items.clear();
        }
    }

    static class Item {
        private int id;
        private int weight;
        private int value;

        public Item(int id, int weight, int value) {
            this.id = id;
            this.weight = weight;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Item item = (Item) o;

            return id == item.id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }
}
