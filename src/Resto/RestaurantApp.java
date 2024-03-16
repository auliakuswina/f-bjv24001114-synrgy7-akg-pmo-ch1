package Resto;
import java.util.Scanner;

    public class RestaurantApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean ordering = true;
            Order order = new Order();

            while (ordering) {
                System.out.println("===========================");
                System.out.println("Selamat datang di BinarFud");
                System.out.println("===========================");
                System.out.println("Silahkan pilih makanan");
                System.out.println("1. Nasi Goreng  |15.000");
                System.out.println("2. Mie Goreng   |13.000");
                System.out.println("3. Es Teh Manis |3.000");
                System.out.println("4. Es Jeruk     |5.000");
                System.out.println("5. Lihat Pesanan");
                System.out.println("3. Konfirmasi dan Bayar");
                System.out.println("4. Keluar");

                System.out.print("Pilih menu: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        orderFood(scanner, order);
                        break;
                    case 2:
                        viewOrder(order);
                        break;
                    case 3:
                        confirmAndPay(scanner, order);
                        break;
                    case 4:
                        ordering = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                }
            }

            System.out.println("Terima kasih telah menggunakan layanan kami.");
            scanner.close();
        }

        public static void orderFood(Scanner scanner, Order order) {
            System.out.println("==== Menu Makanan ====");
            System.out.println("1. Nasi Goreng  | Rp 15.000");
            System.out.println("2. Mie Ayam     | Rp 13.000");
            System.out.println("3. Nasi + Ayam  | Rp 18.000");
            System.out.println("4. Es Teh Manis | Rp.3000");
            System.out.println("5. Es Jeruk     | Rp.5000");

            System.out.print("Pilih makanan: ");
            int foodChoice = scanner.nextInt();

            System.out.print("Masukkan jumlah pesanan: ");
            int quantity = scanner.nextInt();

            switch (foodChoice) {
                case 1:
                    order.addItem("Nasi Goreng", 15000, quantity);
                    break;
                case 2:
                    order.addItem("Mie Ayam", 13000, quantity);
                    break;
                case 3:
                    order.addItem("Nasi + Ayam", 18000, quantity);
                    break;
                case 4:
                    order.addItem("Es Teh Manis", 3000,quantity);
                case 5:
                    order.addItem("Es Jeruk", 5000,quantity);
                default:
                    System.out.println("Makanan tidak tersedia.");
            }
        }

        public static void viewOrder(Order order) {
            order.displayOrder();
        }

        public static void confirmAndPay(Scanner scanner, Order order) {
            System.out.println("==== Konfirmasi Pesanan ====");
            order.displayOrder();
            System.out.println("Total Tagihan: Rp " + order.getTotal());

            System.out.print("Apakah Anda ingin membayar? (Y/N): ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("Pembayaran berhasil dilakukan.");
                order.clearOrder();
            } else {
                System.out.println("Pesanan dibatalkan.");
            }
        }
    }

    class Order {
        private StringBuilder orderDetails;
        private int total;

        public Order() {
            orderDetails = new StringBuilder();
            total = 0;
        }

        public void addItem(String itemName, int price, int quantity) {
            orderDetails.append(itemName).append(" x ").append(quantity).append(" = Rp ").append(price * quantity).append("\n");
            total += price * quantity;
        }

        public void displayOrder() {
            if (orderDetails.length() == 0) {
                System.out.println("Belum ada pesanan.");
            } else {
                System.out.println("==== Pesanan Anda ====");
                System.out.println(orderDetails.toString());
            }
        }

        public int getTotal() {
            return total;
        }

        public void clearOrder() {
            orderDetails.setLength(0);
            total = 0;
        }
    }