package br.furb.utils;

public class StringManipulationUtil {
	
	public static int getRowError(int positionStartError, String input) {

		String[] arrayLines = input.split("\n");
		int lineError = 0;
		int countLine = 0;

		for (int i = 0; i < arrayLines.length; i++) {

			arrayLines[i] += "\n";
			countLine += arrayLines[i].length();

			if (countLine > positionStartError) {
				lineError += i + 1;

				break;
			}
		}

		return lineError == 0 ? lineError + 1 : lineError;
	}

}
