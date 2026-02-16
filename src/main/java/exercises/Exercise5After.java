package exercises;


/**
 * Decorator Pattern, 
 * che permette di aggiungere dinamicamente nuove funzionalità (come il costo per la confezione regalo o la spedizione) 
 * a un oggetto esistente senza modificarne la struttura o usare l'ereditarietà statica.
 * Nel codice "After", l'oggetto SimpleProduct viene "avvolto" (wrapped) all'interno di classi decoratrici (GiftWrap, ExpeditedShipping) 
 * che implementano la stessa interfaccia comune, sommando i prezzi e concatenando le descrizioni a runtime.
 */
public class Exercise5After {
    /**
     * Decorator interface
     */
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

    public static class Main {
        public static void main(String[] args) {
            Product product = new SimpleProduct("Shirt", 29.99);

            System.out.println("product.getPrice() = " + product.getPrice());
            System.out.println("product.getDescription()() = " + product.getDescription());
            Product giftWrap = new GiftWrap(product);

            ExpeditedShipping expeditedShipping = new ExpeditedShipping(giftWrap);

            System.out.println("expeditedShipping.getPrice() = " + expeditedShipping.getPrice());
            System.out.println("expeditedShipping.getDescription()() = " + expeditedShipping.getDescription());
        }
    }
}
