package reflection.clazz;


import java.lang.reflect.Field;

public class ClassDetail {

	private ClassDetail() {
	}
	
	public static String getInfo(Class clazz){
		StringBuilder buf = new StringBuilder();
		if (clazz.isAnnotation())
			buf.append("Annotation ");
		else if(clazz.isInterface())
			buf.append("Interface ");
		else if(clazz.isEnum())
			buf.append("Enum ");
		else 
			buf.append("Class ");
		buf.append(clazz.getName()).append(" ");
		if (clazz.isArray())
			buf.append("array");
		if (clazz.isLocalClass())
			buf.append("local");
		buf.append("\n");
		buf.append(getFieldNames(clazz));  
		return buf.toString();
	}
	
	public static String getFieldNames(Class clazz) {
		StringBuilder buf = new StringBuilder();
		try{
			Field[] publicFields = clazz.getDeclaredFields();
			for (Field publicField : publicFields) {
				try {
					String fieldName = publicField.getName();
					buf.append("Name: ").append(fieldName);
					Class typeClass = publicField.getType();
					String fieldType = typeClass.getName();
					buf.append(", Type: ").append(fieldType).append("\n");
				}catch(Exception e){
					buf.append("\n");
				}
			}
		}catch(Throwable e){
			
		}
	    return buf.toString();
	}
}