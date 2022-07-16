package alpro3;

import java.util.Arrays;

import javax.swing.*;

public class tebakkata {


		// TODO Auto-generated method stub
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Selamat Datang di Permainan Tebak Kata ");
		
		String wordkey[] = {"Tenang"};
		
		String word = wordkey[(int)(Math.random())]; 
		
		char guessWord[] = new char[word.length()]; 
		int clue = (int)(word.length()/2); 
		for(int i=0;i<word.length();i++) {
			if(i%clue==0) {
				guessWord[i] = word.charAt(i);
				System.out.print(guessWord[i]+" ");
			} else {
				guessWord[i] = '_';
				System.out.print("_ ");
			}
		}

		int chance = word.length();
		String guess;
		while(chance>0) {
			String clueWord = Arrays.toString(guessWord);
			guess = JOptionPane.showInputDialog("Ikan bernafas di air dengan ?\n"+clueWord+"\n"+"Masukkan 1 karakter tebakan anda!\nKesempatan anda "+chance).toLowerCase();
			for(int i=0;i<word.length();i++) {
				if(word.charAt(i)==guess.charAt(0)) {
					guessWord[i] = guess.charAt(0);
				}
			}
			if(Wordkeychecker(guessWord, word)) chance = 0;
			chance--;
		}
		if(Wordkeychecker(guessWord, word)) {
			JOptionPane.showMessageDialog(null, "Selamat ! Kamu memang pintar, kata tersebut adalah "+ "("+word+")");
		} else {
			JOptionPane.showMessageDialog(null, "I'm sorry, but you ran out of tries. The word was " + word + ". Maybe next time!");
		}
	}
	
	public static boolean Wordkeychecker(char[] guessWord, String word) {
		int titik = 0;
		for(int i=0;i<guessWord.length;i++) {
			if(guessWord[i]==word.charAt(i)) {
				titik++;
			}
		}
		return (titik==word.length());
	}
	
}