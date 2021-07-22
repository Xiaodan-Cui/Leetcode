class Solution {
    Set<String> zeros = new HashSet();
        Map<String, Map<String, Double>> map = new HashMap();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for(int i = 0; i < values.length; i++){
            if (values[i] == 0){
                zeros.add(equations.get(i).get(0));
                continue;
            }
            String divisor = equations.get(i).get(0);
            String dividend = equations.get(i).get(1);
            Map<String, Double> map1 = map.getOrDefault(divisor, new HashMap());
            Map<String, Double> map2 = map.getOrDefault(dividend, new HashMap());
            map1.put(dividend, values[i]);
            map2.put(divisor, 1 / values[i]);
            map.put(divisor, map1);
            map.put(dividend, map2);
        }
        double[] res = new double[queries.size()];
        for(int i = 0; i < res.length; i++){
            String divisor = queries.get(i).get(0);
            String dividend = queries.get(i).get(1);
            res[i] = dfs(divisor, dividend, 1, new HashSet());
        }
        return res;
    }
    
    private double dfs(String divisor, String dividend, double res, Set<String> visited){
        if (zeros.contains(divisor)){
            if (map.containsKey(dividend)){
                return 0;
            }
            return -1;
        }
        if (!map.containsKey(divisor) || !map.containsKey(dividend) || visited.contains(divisor)){
            return -1;
        }
        visited.add(divisor);
        Map<String, Double> nextMap = map.get(divisor);
        if (nextMap.containsKey(dividend)){
            return res * nextMap.get(dividend);
        }
        for(String key : nextMap.keySet()){
            if (visited.contains(key)) continue;
            double next = dfs(key, dividend, res * nextMap.get(key), visited);
            if (next != -1){
                return next;
            }
        }
        return -1;
    }
}