package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShufflePlayList {
	List<?> playList;
	int index;

	public void shuffleSongs(List<?> songs) {
		playList = new ArrayList<>(songs);
		Collections.shuffle(playList);
		startPlay(index);
	}

	public void startPlay(int songIndex) {
		if (!playList.isEmpty()) {
			if (songIndex == -1 && index != 0) {
				// If user selects previous song
				index -= 1;
				System.out.println("--------------------------");
				System.out.println("play previous song");
			} else if (songIndex == -1 && index == 0) {
				// If user selects previous song while playing first song
				index = playList.size() - 1;
			} else if (songIndex == -2 && index != playList.size() - 1) {
				// If user selects next song
				index += 1;
				System.out.println("--------------------------");
				System.out.println("play next song");
			} else {
				index = 0;
			}
			for (int i = index; i < playList.size(); i++) {
				index = i;
				System.out.println("playing song " + playList.get(index));
			}

		}

	}

	public static void main(String[] args) {
		ShufflePlayList shuffle = new ShufflePlayList();
		List<Integer> songs = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			songs.add(i);
		}
		System.out.println("List of songs:"+songs);
		shuffle.shuffleSongs(songs);
		shuffle.startPlay(-1); // passing parameter -1 if user selects previous song

		// shuffle.startPlay(-2); //passing parameter -2 if user selects next song

	}

}
