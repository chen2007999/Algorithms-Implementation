package RecursionAndDynamicProgramming;

public class PaintFill {

	enum Colour {
		Blue, Red, Green, Yellow
	}

	void paintFill(Colour[][] img, int r, int c, Colour colour) {
		if (img == null) {
			return;
		}
		if (colour == img[r][c]) {
			return;
		}
		paintFillHelper(img, r, c, colour, img[r][c]);
	}

	void paintFillHelper(Colour[][] img, int r, int c, Colour toColour, Colour initial) {
		if (img[r][c] != initial) {
			return;
		}
		if (r < 0 || c < 0 || r == img.length || c == img[0].length) {
			return;
		}
		img[r][c] = toColour;
		paintFillHelper(img, r + 1, c, toColour, initial);
		paintFillHelper(img, r - 1, c, toColour, initial);
		paintFillHelper(img, r, c - 1, toColour, initial);
		paintFillHelper(img, r, c + 1, toColour, initial);
	}

}
