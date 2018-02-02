package Output;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test{

    ArrayList<Song> list = new ArrayList<Song>();

    public static void main(String[] args) throws IOException {
        new Test().go();
    }

    class ArtistCompare implements Comparator<Song> {

        @Override
        public int compare(Song o1, Song o2) {
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }

    public void go() {
        getSongs();
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(list, artistCompare);

        System.out.println(list);
    }

    void getSongs() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:/BD/sort.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        Song nextSong = new Song(tokens[0],tokens[1],tokens[2],tokens[3]);
        list.add(nextSong);
    }
}

