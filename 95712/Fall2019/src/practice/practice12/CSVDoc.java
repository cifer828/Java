package practice.practice12;

class CSVDoc extends Document{
	int rowCount;
	int columnCount;
	@Override
	String getDocInfo() {
		// TODO Auto-generated method stub
		System.out.println(fileContent.toString());
		String[] allRows = fileContent.toString().split("\n");
		rowCount = allRows.length;
		columnCount = allRows[0].split(",").length;
		return String.format("Rows: %d, Columns: %d", rowCount, columnCount);
	}
	
}
