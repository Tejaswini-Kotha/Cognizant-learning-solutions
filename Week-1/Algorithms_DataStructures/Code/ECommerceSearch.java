import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearch {

    static class Product {
        int id;
        String name;
        String category;

        Product(int id, String name, String category) {
            this.id = id;
            this.name = name;
            this.category = category;
        }

        @Override
        public String toString() {
            return String.format("ID: %d, Name: %s, Category: %s", id, name, category);
        }
    }

    static class SearchEngine {

        public static Product searchByNameLinear(Product[] products, String targetName) {
            for (Product product : products) {
                if (product.name.equalsIgnoreCase(targetName)) {
                    return product;
                }
            }
            return null;
        }

        public static Product searchByNameBinary(Product[] sortedProducts, String targetName) {
            int low = 0, high = sortedProducts.length - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                int comparison = sortedProducts[mid].name.compareToIgnoreCase(targetName);

                if (comparison == 0) {
                    return sortedProducts[mid];
                } else if (comparison < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return null;
        }
    }

    public static void main(String[] args) {
        Product[] inventory = {
            new Product(10, "Laptop", "Electronics"),
            new Product(11, "Dress", "Fashion"),
            new Product(12, "Ring", "Accessories"),
            new Product(13, "Dress", "Fashion"),
            new Product(14, "Bag", "Travel")
        };

        System.out.println(" Performing Linear Search for 'Dress':");
        Product foundLinear = SearchEngine.searchByNameLinear(inventory, "Dress");
        System.out.println(foundLinear != null ? foundLinear : "Product not found");

        Arrays.sort(inventory, Comparator.comparing(product -> product.name));

        System.out.println("\n Performing Binary Search for 'Phone':");
        Product foundBinary = SearchEngine.searchByNameBinary(inventory, "Dress");
        System.out.println(foundBinary != null ? foundBinary : "Product not found");
    }
}
