package designpattern.flyweight;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public enum Color {
        RED,
        GREEN,
        BLUE
    }

    public enum FontEffect {
        BOLD,
        ITALIC,
        SUPERSCRIPT,
        SUBSCRIPT,
        STRIKETHROUGH
    }

    public static final class FontData {
        private static final Set<FontData> flyweightData = new HashSet<>();
        private final int pointSize;
        private final String fontFace;
        private final Color color;
        private final Set<FontEffect> effects;

        private FontData(int pointSize, String fontFace, Color color, EnumSet<FontEffect> effects) {
            this.pointSize = pointSize;
            this.fontFace = fontFace;
            this.color = color;
            this.effects = Collections.unmodifiableSet(effects);
        }

        public static FontData create(
                int pointSize, String fontFace, Color color, FontEffect... effects) {
            EnumSet<FontEffect> effectsSet = EnumSet.noneOf(FontEffect.class);
            effectsSet.addAll(Arrays.asList(effects));
            // We are unconcerned with object creation cost, we are reducing overall memory
            // consumption

            /** FontData has a cache mechanism via Set */
            FontData data = new FontData(pointSize, fontFace, color, effectsSet);
            // add to cache
            flyweightData.add(data);
            // return the single immutable copy with the given values
            return flyweightData.stream().filter(data::equals).findFirst().get();
        }

        /** To check if element is not in the cache */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            FontData other = (FontData) obj;
            if (color == null) {
                if (other.color != null) return false;
            } else if (!color.equals(other.color)) return false;
            if (effects == null) {
                if (other.effects != null) return false;
            } else if (!effects.equals(other.effects)) return false;
            if (fontFace == null) {
                if (other.fontFace != null) return false;
            } else if (!fontFace.equals(other.fontFace)) return false;
            if (pointSize != other.pointSize) return false;
            return true;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((color == null) ? 0 : color.hashCode());
            result = prime * result + ((effects == null) ? 0 : effects.hashCode());
            result = prime * result + ((fontFace == null) ? 0 : fontFace.hashCode());
            result = prime * result + pointSize;
            return result;
        }

        // Getters for the font data, but no setters. FontData is immutable.
    }
}
