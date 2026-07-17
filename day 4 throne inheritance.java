class ThroneInheritance {
    private String king;
    private Map<String, List<String>> children;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        children = new HashMap<>();
        dead = new HashSet<>();
        children.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        children.putIfAbsent(childName, new ArrayList<>());
        children.get(parentName).add(childName);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        dfs(king, result);
        return result;
    }
    
    private void dfs(String name, List<String> result) {
        if (!dead.contains(name)) {
            result.add(name);
        }
        for (String child : children.get(name)) {
            dfs(child, result);
        }
    }
}
