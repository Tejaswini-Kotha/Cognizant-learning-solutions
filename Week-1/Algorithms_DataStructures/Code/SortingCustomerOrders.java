class CustomerOrder {
    String id;
    String customer;
    double amount;

    public CustomerOrder(String id, String customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public String toString() {
        return "Order ID : " + id + " , Customer : " + customer + " , Total : " + amount;
    }
}

public class SortingCustomerOrders {

    public static void sortWithBubble(CustomerOrder[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].amount > orders[j + 1].amount) {
                    CustomerOrder temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void sortWithQuick(CustomerOrder[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            sortWithQuick(orders, low, pivotIndex - 1);
            sortWithQuick(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(CustomerOrder[] orders, int low, int high) {
        double pivot = orders[high].amount;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].amount < pivot) {
                i++;
                CustomerOrder temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        CustomerOrder temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void showOrders(CustomerOrder[] orders) {
        for (CustomerOrder order : orders) {
            System.out.println(order);
        }
        
    }

    public static void main(String[] args) {
        CustomerOrder[] orders = {
            new CustomerOrder("1", "Ravi", 500.0),
            new CustomerOrder("2", "Sneha", 300.0),
            new CustomerOrder("3", "Ajay", 700.0)
        };

        System.out.println(" Original Orders:");
        showOrders(orders);

        sortWithBubble(orders);
        System.out.println("Bubble Sorted Orders:");
        showOrders(orders);

        orders = new CustomerOrder[]{
            new CustomerOrder("1", "Ravi", 500.0),
            new CustomerOrder("2", "Sneha", 300.0),
            new CustomerOrder("3", "Ajay", 700.0)
        };

        sortWithQuick(orders, 0, orders.length - 1);
        System.out.println(" Quick Sorted Orders:");
        showOrders(orders);
    }
}
