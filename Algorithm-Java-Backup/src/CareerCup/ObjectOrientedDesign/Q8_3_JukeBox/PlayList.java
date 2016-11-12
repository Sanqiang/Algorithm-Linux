/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_3_JukeBox;

import java.util.LinkedList;
import java.util.Queue;

public class PlayList {

    private Queue<Song> playlist;
    Song cur;

    public PlayList(Queue<Song> _playlist) {
        this.playlist = new LinkedList<>();
    }

    public void playNext() {
        cur = playlist.poll();
    }

    public static void main(String[] args) {
    }
}
