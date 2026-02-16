package exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * **Pattern Observer**
 * L'Agenzia (Subject) ora gestisce una lista di interfacce generiche (Channel),
 * permettendo di aggiungere o rimuovere osservatori dinamicamente senza modificare la logica centrale.
 */
public class Exercise6After {

    // Interfaccia comune per tutti gli osservatori
    interface Channel {
        void update(String news);
    }

    // Osservatore Concreto 1
    public static class TvChannel implements Channel {
        @Override
        public void update(String news) {
            System.out.println("Canale TV: Nuova notizia -> " + news);
        }
    }

    // Osservatore Concreto 2
    public static class RadioChannel implements Channel {
        @Override
        public void update(String news) {
            System.out.println("Canale Radio: In onda -> " + news);
        }
    }

    // Subject (Soggetto)
    public static class NewsAgency {
        private List<Channel> channels = new ArrayList<>();

        public void addChannel(Channel channel) {
            channels.add(channel);
        }

        public void removeChannel(Channel channel) {
            channels.remove(channel);
        }

        public void broadcastNews(String news) {
            // Notifica tutti gli iscritti indipendentemente dal loro tipo concreto
            for (Channel channel : channels) {
                channel.update(news);
            }
        }
    }

    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        TvChannel tv = new TvChannel();
        RadioChannel radio = new RadioChannel();

        agency.addChannel(tv);
        agency.addChannel(radio);

        agency.broadcastNews("Il mercato azionario è in rialzo!");

        System.out.println("-- Rimozione Radio --");
        agency.removeChannel(radio);
        agency.broadcastNews("Aggiornamento meteo: Soleggiato.");
    }
}