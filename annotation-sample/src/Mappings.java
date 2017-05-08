import java.lang.reflect.Method;
import java.util.Arrays;

public class Mappings {
	
	public static void processMapping(Object obj) {
		if (obj == null) {
			return;
		}
		
		Class<?> clazz = obj.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		
		for (Method method : methods) {
			Mapping mapping = method.getAnnotation(Mapping.class);
			
			if (mapping != null) {
				String[] values = mapping.value();
				System.out.println(Arrays.toString(values));
			}
		}
	}
}
