package cn.saintshaga.excel.operation.base;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import cn.saintshaga.excel.operation.library.FieldProperty;

public class AnnotationDemo {
	@FieldProperty("StringA")
	private String a;
	
	@FieldProperty("IntegerB")
	private int b;
	
	
	@SuppressWarnings("unused")
	private int c;
	
	public static void main(String[] args) throws Exception{
		Class<AnnotationDemo> cls = AnnotationDemo.class;
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			if(field.getModifiers() == Modifier.PRIVATE) {
				String string="";
				if(field.isAnnotationPresent(FieldProperty.class)) {
					string = field.getAnnotation(FieldProperty.class).value();
				}
				System.out.println(field.getName() + " " +string);
			}
		}
	}

}
