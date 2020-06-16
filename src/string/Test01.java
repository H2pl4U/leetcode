package src.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test01 {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Map<String, String> types = new HashMap<>();

        public Builder addTypes(String columnName, String type) {
            types.put(columnName, type);
            return this;
        }

        public Map<String, String> build() {
            return types;
        }
    }
    public static void main(String[] args) {
       Long a = 1000l;
       Long b = 444l;
       System.out.println((float)b/a);
    }
}