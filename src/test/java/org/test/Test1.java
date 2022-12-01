package org.test;

import java.util.*;

import org.hamcrest.core.StringStartsWith;



public class Test1 {
	
//	@Test
//	private void iingti() throws IOException {
//		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\SMS\\ExcelSheet\\sms.xlsx");
//		
//		FileInputStream inputStream=new FileInputStream(file);
//		
//		Workbook book = new XSSFWorkbook(inputStream);
//		Sheet sheet = book.getSheet("Dynamicdata");
//		Row row = sheet.createRow(0);
//		Cell cell = row.createCell(0);
//		System.out.println(cell);
////		cell.setCellType(cell.CELL_TYPE_STRING);
//		cell.setCellType(CellType.STRING);
//		FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\SMS\\\\ExcelSheet\\\\sms.xlsx");
//		book.write(fos);
//		fos.close();
//
//	}
	
//	public static void main(String[] args) throws IOException {
//		
//		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\SMS\\ExcelSheet\\sms.xlsx");
//		
////		FileInputStream inputStream=new FileInputStream(file);
////		
////		Workbook book = new XSSFWorkbook(inputStream);
////		Sheet sheet = book.getSheet("Dynamicdata");
////		Row row = sheet.createRow(0);
////		Cell cell = row.createCell(1);
////		System.out.println(cell);
////		cell.setCellType(cell.CELL_TYPE_STRING);
////		cell.setCellType(CellType.STRING);
////		FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\SMS\\\\ExcelSheet\\\\sms.xlsx");
////		book.write(fos);
////		fos.close();
//
//	}
	String s="";
	
	
	private void teww() {
		String s1="45";
		s=s1;
		

	}
	private void teww2() {
		System.out.println(s);

	}
	
	public static void main(String[] args) {
		
//		   List<Integer> li = Arrays.asList(10,15,18,49,25,98,32,98);
//		   li.stream().filter(n->n%2!=0).forEach(System.out::println);
//		   li.stream().map(s -> s+"").filter(s->s.startsWith("1")).forEach(System.out::println);
		   
//		   
//		   Set<Integer> set = new HashSet();
//           li.stream().filter(n -> !set.add(n)).forEach(System.out::println);
//		   long count=li.stream().count();
//		   System.out.println(count);
		   
//		   int max =li.stream().max(Integer::compare).get();
//		   System.out.println(max);
		
		Test1 t1 =new Test1();
		t1.teww();
		t1.teww2();
		
}
}