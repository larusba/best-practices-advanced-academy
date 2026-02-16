package exercises;

/**
 * ESERCIZIO: Rifattorizza per disaccoppiare l'Agenzia dai canali specifici.
 * Attualmente, l'aggiunta di un nuovo canale richiede la modifica della classe NewsAgency.
 */
public class Exercise6Before {

    public static class TvChannel {
        public void updateTv(String news) {
            System.out.println("Canale TV: Nuova notizia -> " + news);
        }
    }

    public static class RadioChannel {
        public void updateRadio(String news) {
            System.out.println("Canale Radio: In onda -> " + news);
        }
    }

    public static class NewsAgency {
        private TvChannel tvChannel;
        private RadioChannel radioChannel;

        public NewsAgency() {
            this.tvChannel = new TvChannel();
            this.radioChannel = new RadioChannel();
        }

        public void broadcastNews(String news) {
            // ACCOPPIAMENTO FORTE: La logica dipende dalle classi concrete
            tvChannel.updateTv(news);
            radioChannel.updateRadio(news);
        }
    }

    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        agency.broadcastNews("Il mercato azionario è in rialzo!");
    }
}