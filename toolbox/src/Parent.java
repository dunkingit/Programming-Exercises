import java.util.ArrayList;
import java.util.List;

public class Parent {
    int value = 10;
    List<String> alist;

    void theList (List<String> sendList){
        this.alist = sendList;
    }

    void addto(String str){
        alist.add(str);
    }

    void incrementValue() {
        value++;
    }

    int getValue() {
        return value;
    }

    public List<String> outList(){
        return alist;
    }
}
