import java.lang.reflect.Method;
import java.util.Arrays;

public class BotCommands {
    @Command(name = {"/hi", "/hello", "/start"}, description = "Say hi to user", args = "")
    public String hello(String[] args) {
        return "Hello, my friend";
    }

    @Command(name = "/help", description = "return you all commands of bot", args = "")
    public String help(String[] args) {
        StringBuilder builder = new StringBuilder("I can do for you this commands:\n");

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (!m.isAnnotationPresent(Command.class))
                continue;

            Command cmd = m.getAnnotation(Command.class);
            builder.append(Arrays.toString(cmd.name())).append(": ").append(cmd.description()).append(" - ").append(cmd.args()).append("\n");
        }

        return builder.toString();
    }

    @Command(name = {"/bye", "/goodbye"}, description = "Say bye to user", args = "")
    public String goodBye(String[] args) {
        return "Goodbye";
    }

    @Command(name = "/fact", description = "return factorial of args[1]", args = "")
    public String fact(String[] args) {
        String res = String.join(" ", args);
        int res1 = Integer.parseInt(res);
        float buf = 1f;
        for (int i = 1; i <= res1; i++) {
            buf *= i;
        }
        return Float.toString(buf);
    }
}
