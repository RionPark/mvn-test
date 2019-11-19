import java.util.HashMap;
import java.util.Map;

public class Test {

	
	public static void main(String[] args) {
		Map<String,Object> map =new HashMap<>();
		
		map.put("name", "req");
		String name = (String)map.get("name");
	}
}
