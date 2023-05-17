package SetsAndMapsAdvancedLab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        Map<String, List<String>> shopAndProduct = new TreeMap<>();

        while (!info.equals("Revision")) {
            String[] productInfo = info.split(", ");
            String shop = productInfo[0];
            String product = productInfo[1];
            String price = productInfo[2];

            if (!shopAndProduct.containsKey(shop)) {
                shopAndProduct.put(shop, new ArrayList<>());
            }
            int index = shopAndProduct.get(shop).size();
            shopAndProduct.get(shop).add(index, product);
            shopAndProduct.get(shop).add(index + 1, price);
            info = scanner.nextLine();
        }

        for (String shop : shopAndProduct.keySet()) {
            System.out.println(shop + "->");
            int i = 0;
            while (i < shopAndProduct.get(shop).size()) {
                String product = shopAndProduct.get(shop).get(i);
                double price = Double.parseDouble(shopAndProduct.get(shop).get(i + 1));
                System.out.printf("Product: %s, Price: %.1f\n",product , price);
                i += 2;
            }
        }
    }
}

