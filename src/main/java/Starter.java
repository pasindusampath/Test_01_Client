import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {
    public static void main(String[] args) throws IOException {
        excCommand("");
    }

    public static void excCommand(String new_dir) throws IOException {
        String path = new Starter().getClass().getResource("allowall.policy").getPath().toString();
        System.out.println(path);
        StringBuilder builder1 = new StringBuilder();
        char[] chars = path.toCharArray();
        for (int i = 1; i < chars.length ; i++) {
            builder1.append(chars[i]);
        }
        path=builder1.toString();
        String[] split = path.split("/");
        split[split.length-1]="";
        split[split.length-2]="";
        builder1.delete(0,builder1.length());
        for (String s : split) {
            builder1.append(s+"\\");
        }
        builder1.deleteCharAt(builder1.length()-1);

        System.out.println(path=builder1.toString());
        System.out.println(path);
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c" ,"cd "+path," && tree && cd classes " +
                "&& dir && rmic MathServer &&start rmiregistry &&java -Djava.security.policy=allowall.policy CalculatorClient");
        builder.redirectErrorStream(true);
        Process p = builder.start();

        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }

}
