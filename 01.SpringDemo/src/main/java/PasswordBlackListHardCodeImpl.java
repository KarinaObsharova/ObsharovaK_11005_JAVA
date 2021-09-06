import java.util.Arrays;
import java.util.List;

public class PasswordBlackListHardCodeImpl implements PasswordBlackList {
    private static List<String> blackList = Arrays.asList("qwerty007", "qwerty008", "karina2002");

    @Override
    public boolean contains(String password){
        return blackList.contains(password);
    }

}
