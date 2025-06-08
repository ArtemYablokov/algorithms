package com.yablokovs.LC_v3.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sol {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Set<String> suppl = new HashSet<>();
        for (String s : supplies)
            suppl.add(s);

        Map<String, List<String>> map = new HashMap<>();
        int l = recipes.length;
        for (int i = 0; i < l; i++) {
            map.put(recipes[i], ingredients.get(i));
        }

        Set<String> result = new HashSet<>();
        Set<String> visited = new HashSet<>();


        // List<String> result = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            boolean b = dfs(recipes[i], result, visited, suppl, map);
            if (b)
                result.add(recipes[i]);
        }

        return Arrays.stream(recipes).toList();
    }

    boolean dfs(String recipe, Set<String> result, Set<String> visited, Set<String> suppl, Map<String, List<String>> map) {
        if (result.contains(recipe) || suppl.contains(recipe))
            return true;

        if (visited.contains(recipe))
            return false;
        visited.add(recipe);

        List<String> ingredients = map.get(recipe);
        if (ingredients != null) {
            for (String ingr : ingredients) {
                boolean b = dfs(ingr, result, visited, suppl, map);
                if (!b)
                    return false;
            }
        }
        result.add(recipe);
        return true;
    }

}
