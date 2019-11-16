package practice.practice12;

class RegularDoc extends Document{
	int wordCount;

	@Override
	String getDocInfo() {
		// TODO Auto-generated method stub
		// split the whole text by space(\\s) and return(\n)
		wordCount = fileContent.toString().split("\\s|\n").length;
		return String.format("Words: %d", wordCount);
	}
	
}
