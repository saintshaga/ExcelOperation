package cn.saintshaga.excel.operation.base;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import cn.saintshaga.excel.operation.library.InputFieldProperty;

public class AnnotationDemo {
	@InputFieldProperty("StringA")
	private String a;
	
	@InputFieldProperty("IntegerB")
	private int b;
	
	
	@SuppressWarnings("unused")
	private int c;
	
	public static void main(String[] args) throws Exception{
		Class<AnnotationDemo> cls = AnnotationDemo.class;
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			if(field.getModifiers() == Modifier.PRIVATE) {
				String string="";
				if(field.isAnnotationPresent(InputFieldProperty.class)) {
					string = field.getAnnotation(InputFieldProperty.class).value();
				}
				System.out.println(field.getName() + " " +string);
			}
		}
	}

}
