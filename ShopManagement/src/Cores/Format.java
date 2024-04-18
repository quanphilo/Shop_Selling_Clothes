package Cores;


public class Format {
    private String text;

    public Format() {

    }

    public Format(String text) {
        this.text = text;
    }

    public static int isNumber(String text) {
        try {
            Float number = Float.parseFloat(text);
            return 1;
        } catch (Exception e) {
           return 0;
        }
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

	public static int checkLength(String text, int length) {
		if (text.length() == length) {
			return 1;
		} else {
			return 0;
		}
	}
}



