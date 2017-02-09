package concurrency.ch2;

public class FileMock {
	private String[] contents;
	private int index;
	
	public FileMock(int size, int length) {
		index = 0;
		contents = new String[size];
		for (int i = 0; i < size; i++) {
			StringBuilder buffer = new StringBuilder(length);
			for (int j = 0; j < length; j++) {
				int indice = (int) (Math.random() * 255);
				buffer.append((char) indice);
			}
			contents[i] = buffer.toString();
		}
	}
	
	public boolean hasMoreLines() {
		return index < contents.length;
	}
	
	public String getLine() {
		if (hasMoreLines()) {
			System.out.println("Mock: " + (contents.length - index));
			return contents[index++];
		}
		return null;
	}
	
	
}
