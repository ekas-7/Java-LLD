import java.util.ArrayList;
import java.util.Collections;

public class Iterator{
    public static void main(String[] args) {
        Playlist myPlaylist = new Playlist();
        myPlaylist.addSong("Bohemian Rhapsody");
        myPlaylist.addSong("Stairway to Heaven (Fav)");
        myPlaylist.addSong("Hotel California");
        myPlaylist.addSong("Imagine (Fav)");
        myPlaylist.addSong("Smells Like Teen Spirit");

        System.out.println("--- Playing Simple (In-Order) Iterator ---");
        PlaylistIterator simpleIter = myPlaylist.iterator("simple");
        while (simpleIter.hasNext()) {
            System.out.println("Playing: " + simpleIter.next());
        }

        System.out.println("\n--- Playing Shuffled Iterator ---");
        PlaylistIterator shuffledIter = myPlaylist.iterator("shuffled");
        while (shuffledIter.hasNext()) {
            System.out.println("Playing: " + shuffledIter.next());
        }

        System.out.println("\n--- Playing Favorites Iterator ---");
        PlaylistIterator favIter = myPlaylist.iterator("favorites");
        if (!favIter.hasNext()) {
            System.out.println("No favorite songs found.");
        } else {
            while (favIter.hasNext()) {
                System.out.println("Playing Favorite: " + favIter.next());
            }
        }
    }
}

class Playlist {
    private ArrayList<String> songs;

    public Playlist() {
        songs = new ArrayList<>();
    }

    public void addSong(String song) {
        songs.add(song);
    }

    public PlaylistIterator iterator(String type) {
        switch (type) {
            case "simple":
                return new SimplePlaylistIterator(this);
            case "shuffled":
                return new ShuffledPlaylistIterator(this);
            case "favorites":
                return new FavoritesPlaylistIterator(this);
            default:
                return new SimplePlaylistIterator(this);
        }
    }

    public ArrayList<String> getSongs() {
        return songs;
    }
}

interface PlaylistIterator {
    boolean hasNext();
    String next();
}

class SimplePlaylistIterator implements PlaylistIterator {
    private Playlist playlist;
    private int index;

    public SimplePlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < playlist.getSongs().size();
    }

    @Override
    public String next() {
        return playlist.getSongs().get(index++);
    }
}

class ShuffledPlaylistIterator implements PlaylistIterator {
    private int index;
    private ArrayList<String> shuffledSongs;

    public ShuffledPlaylistIterator(Playlist playlist) {
        this.shuffledSongs = new ArrayList<>(playlist.getSongs());
        Collections.shuffle(shuffledSongs);
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < shuffledSongs.size();
    }

    @Override
    public String next() {
        return shuffledSongs.get(index++);
    }
}

class FavoritesPlaylistIterator implements PlaylistIterator {
    private int index;
    private ArrayList<String> favoriteSongs;

    public FavoritesPlaylistIterator(Playlist playlist) {
        this.favoriteSongs = new ArrayList<>();
        this.index = 0;

        for (String song : playlist.getSongs()) {
            if (song.contains("(Fav)")) {
                favoriteSongs.add(song);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return index < favoriteSongs.size();
    }

    @Override
    public String next() {
        return favoriteSongs.get(index++);
    }
}