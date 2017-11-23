package main.java.dev.fr.pizzeria.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class StringUtils {
	static String getStringValue(Object obj) {
		String str = "";
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			if(f.isAnnotationPresent(ToString.class)) {
				/* Get ToString annotation*/
				ToString annotation = f.getAnnotation(ToString.class);
				/* get attribute value */
				try {
					Object value = f.get(obj);
					if(annotation.uppercase() == true) {
						f.getName().toUpperCase();
					}
					str += value + annotation.separator();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		return str;
	}

}
