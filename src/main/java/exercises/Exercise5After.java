package exercises;

public class Exercise5After {
    // Component interface
    public interface Product {
        String getDescription();
        double getPrice();
    }

    // Concrete component
    public static class SimpleProduct implements Product {
        private String name;
        private double price;

        public SimpleProduct(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String getDescription() {
            return name;
        }

        @Override
        public double getPrice() {
            return price;
        }
    }

    // Decorator
    public abstract static class ProductDecorator implements Product {
        protected Product decoratedProduct;

        public ProductDecorator(Product decoratedProduct) {
            this.decoratedProduct = decoratedProduct;
        }

        @Override
        public String getDescription() {
            return decoratedProduct.getDescription();
        }

        @Override
        public double getPrice() {
            return decoratedProduct.getPrice();
        }
    }

    // Concrete decorator
    public static class GiftWrap extends ProductDecorator {
        public GiftWrap(Product decoratedProduct) {
            super(decoratedProduct);
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", with gift wrap";
        }

        @Override
        public double getPrice() {
            // Gift wrap costs $5.00
            return super.getPrice() + 5.00; 
        }
    }

    // Concrete decorator
    public static class ExpeditedShipping extends ProductDecorator {
        public ExpeditedShipping(Product decoratedProduct) {
            super(decoratedProduct);
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", with expedited shipping";
        }

        @Override
        public double getPrice() {
            // Expedited shipping costs $10.00
            return super.getPrice() + 10.00;
        }
    }

}
