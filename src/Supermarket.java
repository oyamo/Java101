import java.util.Scanner;

public class Supermarket {
    public static class Product{
        private String productCode;
        private float price;
        private int quantity;
        private float totalPrice;
        private float discount;
        //If the total cost per item is more than 20,000 there is a discount of 14% on that item and a discount of 10%
        // on an item whose total cost is between 10,000 and 20,000. No discount is given
        // on items whose total cost is less than 10,000
        public float getDiscount() {
            float tempDiscount  = 0;
            if(getTotalPrice()>20000){
                tempDiscount = (float) (.14*getTotalPrice());
            }else if(getTotalPrice()>10000){
                tempDiscount = (float) (.1*getTotalPrice());
            }
            return tempDiscount;
        }

        public float getNetPrice() {
            return getTotalPrice() - getDiscount();
        }


        private float netPrice;
        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public float getTotalPrice() {
            return this.quantity*this.price;
        }

        public Product(String productCode, float price, int quantity) {
            this.productCode = productCode;
            this.price = price;
            this.quantity = quantity;
        }

        public Product() {
        }
    }

    public static void main(String[] args) {
        Product[] products = null;
        int count;
        float ttl = 0 ;
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many products would you wish to deal with?");
        count = Integer.parseInt(scanner.nextLine());
        products = new Product[count];
        for (int i = 0; i < count; i++) {
            Product tempProduct = new Product();
            float tempPrice;
            int tempQuantity;
            String tempProdCode;
            System.out.print(String.format("Enter Product code for product %d", i+1));
            tempProdCode = scanner.nextLine();
            System.out.print(String.format("Enter Price for product %d", i+1));
            tempPrice = Integer.parseInt(scanner.nextLine());
            System.out.print(String.format("Enter Quanitity for product %d", i+1));
            tempQuantity = Integer.parseInt(scanner.nextLine());

            tempProduct.setProductCode(tempProdCode);
            tempProduct.setPrice(tempPrice);
            tempProduct.setQuantity(tempQuantity);

            products[i] = tempProduct;
        }
        System.out.println("Item Code\tPrice\tQuantity\tTotal Cost\tDiscount\tNet ");
        for (Product product :products) {
                String row = String.format("%s\t\t\t%.2f\t\t\t%d\t\t\t%.2f\t\t\t%.2f\t\t\t%.2f",product.getProductCode(),
                        product.getPrice(),
                        product.getQuantity(),
                        product.getTotalPrice(),
                        product.getDiscount(),
                        product.getNetPrice());
                 System.out.println(row);
             ttl += product.getNetPrice();
        }
        System.out.println(String.format("The total amount payable is %.2f",ttl));
    }
}
