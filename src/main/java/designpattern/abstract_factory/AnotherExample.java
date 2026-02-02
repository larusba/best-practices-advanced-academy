package designpattern.abstract_factory;


/**
 * It has more factory methods
 */
public class AnotherExample {

    /**
     * COMPONENT: Product Abstract Class
     */
    abstract static class UrlHandler {
        public static final String KEY_VALUE = "K-V";
    
        protected String getElasticSearchUrl(String hostOrKey) {
            return "MY-URL" + hostOrKey;
        }
    
        protected String toQueryParams(Object query) {
            return query + KEY_VALUE;
        }
    
        protected String getQueryUrl(String hostOrKey, String index, String type, String id, Object query) {
            return getElasticSearchUrl(hostOrKey) + formatQueryUrl(index, type, id, query);
        }
    
        protected String getSearchQueryUrl(String hostOrKey, String index, String type, Object query) {
            return getElasticSearchUrl(hostOrKey) + formatSearchQueryUrl(index, type, query);
        }
    
        protected abstract String formatSearchQueryUrl(String index, String type, Object query);
        protected abstract String formatQueryUrl(String index, String type, String id, Object query);
    
        /**
         * COMPONENT: Abstract (Enum) Factory with enums which instantiate the proper class
         */
        enum Version {
            ONE(new One()),
            TWO(new Two());
    
            private final UrlHandler handler;
            
            Version(UrlHandler handler) {
                this.handler = handler;
            }
    
            public UrlHandler get() {
                return handler;
            }
        }

        /**
         * COMPONENT: Concrete Product
         */
        static class One extends UrlHandler {
    
            @Override
            protected String formatSearchQueryUrl(String index, String type, Object query) {
                return index + type + query;
            }
    
            @Override
            protected String formatQueryUrl(String index, String type, String id, Object query) {
                return index + type + id + query;
            }
        }
    
        static class Two extends UrlHandler {
    
            private static final String FOO = "foo";
            private static final String BAR = "bar";
    
            @Override
            protected String formatSearchQueryUrl(String index, String type, Object query) {
                return index + FOO + type + BAR + query;
            }
    
            @Override
            protected String formatQueryUrl(String index, String type, String id, Object query) {
                return index + FOO + type + BAR + id + query;
            }
        }
        
    }
    
    
    // main class
    public static class Main {
        public static void main(String[] args) {
            UrlHandler one = UrlHandler.Version.ONE.get();
            String queryUrlOne = one.getQueryUrl("myHostOne", "index", "type", "id", "query");

            UrlHandler two = UrlHandler.Version.TWO.get();
            String queryUrlTwo = two.getQueryUrl("myHostOne", "index", "type", "id", "query");
            
            
            System.out.println("queryUrlTwo = " + queryUrlTwo);
            System.out.println("queryUrlOne = " + queryUrlOne);
        }
    }
}
