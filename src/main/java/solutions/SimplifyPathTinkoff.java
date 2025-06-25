package solutions;

public class SimplifyPathTinkoff {

    public String simplifyPath(String path) {
        String path1 = path.replaceAll("//", "/");

        while(path1.contains("//")) {
            path1 = path1.replaceAll("//", "/");
        }

        StringBuilder builder = new StringBuilder();
        builder.append("/");

        String[] tokens = path1.split("/");
        for (int i = 1; i < tokens.length; i++) {
            if ("..".equals(tokens[i]) ) {
                if(builder.length() > 2) {
                    int positionLast = builder.lastIndexOf("/");
                    builder.deleteCharAt(builder.length() - 1);
                    int position = builder.lastIndexOf("/");
                    builder.delete(position, positionLast);
                    builder.append("/");
                }
            } else if(!".".equals(tokens[i])){
                builder.append(tokens[i]);
                builder.append("/");
            }
        }

        if(builder.length() != 1) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return  builder.toString();
    }
}
