
public class Encoder {
	
	//reference string
	public static final String reference = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
	
	public String encode(String plainText) {
		
		//define offset
		String offset = "F";
		
		String encodedText = offset;
		int referenceCheck;
	
		for (int i = 0; i<plainText.length(); i++) {
			
			//check if character is not in reference
			referenceCheck = reference.indexOf(plainText.charAt(i));
			if(referenceCheck == -1) {
				encodedText += plainText.charAt(i);
				continue;
			}
			
			//get the index of the current character in the reference string
			int pos = reference.indexOf(plainText.charAt(i));
			
			//get the index of the character after offset
			int encryptPos = (44 + pos - reference.indexOf(offset)) % 44;
			
			//get the encoded char and put it in the string
			char encodedChar = reference.charAt(encryptPos);
			encodedText += encodedChar;
		}

		return encodedText;
	}
	public String decode(String encodedText) {
		
		String decodedText = "";
		int referenceCheck;
		int offsetPos = reference.indexOf(encodedText.charAt(0));
		

		
		for (int i = 1; i<encodedText.length(); i++) {
			
			//check if character is not in reference
			referenceCheck = reference.indexOf(encodedText.charAt(i));
			if(referenceCheck == -1) {
				decodedText += encodedText.charAt(i);
				continue;
			}
			//get the index of the current character in the reference string
			int pos = reference.indexOf(encodedText.charAt(i));
			
			//get the index of the character after offset
			int decodePos = (44 + pos + offsetPos) % 44;
			
			//get the decoded char and put it in a string
			char decodedChar = reference.charAt(decodePos);

			decodedText += decodedChar;
		}
		
		return decodedText;
	}
	public static void main(String[] args) {
	
		//create new object encoder
		Encoder encoder = new Encoder();
		
		//print encoded text to console
		System.out.println(encoder.encode("HELLO WORLD"));
		//print decoded text to console
		System.out.println(encoder.decode("FC/GGJ RJMG."));

	}
}
