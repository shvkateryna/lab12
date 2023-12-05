package ua.ucu.edu.task2;

import java.util.HashMap;
import java.util.Map;

public class StampingVisitor {
    private boolean inGroup;

    public Map<String, Object> onGroupStart(Group group, Map<String, String> headers) {
        this.inGroup = true;
        Map<String, Object> result = new HashMap<>();
        result.put("in_group", new boolean[]{this.inGroup});
        result.put("stamped_headers", new String[]{"in_group"});
        return result;
    }

    public void onGroupEnd(Group group, Map<String, String> headers) {
        this.inGroup = false;
    }

    public Map<String, Object> onSignature(Signature signature, Map<String, String> headers) {
        Map<String, Object> result = new HashMap<>();
        result.put("in_group", new boolean[]{this.inGroup});
        result.put("stamped_headers", new String[]{"in_group"});
        return result;
    }
}
