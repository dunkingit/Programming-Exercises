import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testA {
    Map<String, Integer> newmap = new HashMap<>();

    public testA() {
        List<String> test = TestNameGenerator.MethodNames(this.getClass(), true);
    }

    public Map<String, Integer> getNewmap() {
        return newmap;
    }

    public void putstuff(){
        for (int i = 0; i < 5 ; i++) {
            newmap.put("test" + i, 1 + i + i);
        }
    };

    public void setNewmap(Map<String, Integer> newmap) {
        this.newmap = newmap;
    }
}
