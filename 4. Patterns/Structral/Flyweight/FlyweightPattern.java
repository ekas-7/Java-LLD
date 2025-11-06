// Save as FlyweightPattern.java and run: javac FlyweightPattern.java && java FlyweightPattern
public class FlyweightPattern {

    // --- Flyweight interface ---
    interface Glyph {
        // extrinsic state passed as parameters (position, color, etc.)
        void draw(int x, int y, String color);
        char getSymbol(); // for demo / debugging
    }

    // --- ConcreteFlyweight: intrinsic state is shared (symbol + fontMetrics) ---
    static class ConcreteGlyph implements Glyph {
        private final char symbol;          // intrinsic
        private final String fontName;      // intrinsic (example of shared data)
        private final int fontSize;         // intrinsic

        public ConcreteGlyph(char symbol, String fontName, int fontSize) {
            this.symbol = symbol;
            this.fontName = fontName;
            this.fontSize = fontSize;
            // imagine loading glyph vector data here (heavy)
        }

        @Override
        public void draw(int x, int y, String color) {
            // Use intrinsic state (fontName, fontSize) and extrinsic (x,y,color)
            System.out.printf("Drawing '%c' at (%d,%d) in %s, font=%s %dpt%n",
                    symbol, x, y, color, fontName, fontSize);
        }

        @Override
        public char getSymbol() {
            return symbol;
        }
    }

    // --- Optional unshared flyweight (not used in pooling) ---
    static class UnsharedGlyph implements Glyph {
        private final String data; // some heavy non-shareable data

        public UnsharedGlyph(String data) {
            this.data = data;
        }

        @Override
        public void draw(int x, int y, String color) {
            System.out.printf("Drawing UnsharedGlyph(%s) at (%d,%d) color=%s%n",
                    data, x, y, color);
        }

        @Override
        public char getSymbol() {
            return '?';
        }
    }

    // --- FlyweightFactory: creates/shares ConcreteGlyphs ---
    static class GlyphFactory {
        // key could be a composite key (symbol+fontName+fontSize). For simplicity, use string key.
        private final java.util.Map<String, Glyph> pool = new java.util.HashMap<>();

        public Glyph getGlyph(char symbol, String fontName, int fontSize) {
            String key = makeKey(symbol, fontName, fontSize);
            return pool.computeIfAbsent(key, k -> {
                // System.out.println("Creating glyph for key: " + k);
                return new ConcreteGlyph(symbol, fontName, fontSize);
            });
        }

        private String makeKey(char symbol, String fontName, int fontSize) {
            return symbol + "|" + fontName + "|" + fontSize;
        }

        public int getPoolSize() {
            return pool.size();
        }
    }

    // --- Client/demo usage ---
    public static void main(String[] args) {
        GlyphFactory factory = new GlyphFactory();

        // Suppose we need to layout a string many times in different positions/colors.
        String doc = "ABBCCCDDDDDDE";
        // Random positions/colors to simulate extrinsic state
        int x = 0, y = 0;
        java.util.Random rnd = new java.util.Random(42);
        String[] colors = {"black", "red", "blue", "green"};

        // We'll request glyphs with two fonts/sizes to show sharing by key
        String font = "Roboto";
        int size = 12;

        for (char ch : doc.toCharArray()) {
            Glyph g = factory.getGlyph(ch, font, size); // shared glyph
            // extrinsic state: position and color
            g.draw(x, y, colors[rnd.nextInt(colors.length)]);
            x += 10;
            if (x > 40) { x = 0; y += 20; }
        }

        // Request same glyphs with same intrinsic state -> reused
        System.out.println("\nRequesting some glyphs repeatedly to show sharing:");
        Glyph gA1 = factory.getGlyph('A', font, size);
        Glyph gA2 = factory.getGlyph('A', font, size);
        Glyph gB = factory.getGlyph('B', font, size);
        System.out.println("gA1 == gA2 ? " + (gA1 == gA2)); // should be true (shared)
        System.out.println("gA1 == gB ? " + (gA1 == gB));   // false

        // Show pool size (unique intrinsic keys)
        System.out.println("Glyph pool size: " + factory.getPoolSize());

        // Unshared glyph example
        UnsharedGlyph ug = new UnsharedGlyph("one-time-image");
        ug.draw(100, 200, "magenta");
    }
}
