package com.yablokovs.LC_v3.Graph;

import org.junit.jupiter.api.Test;

import java.util.List;

class SolTest {

    @Test
    void findAllRecipes() {
        Sol sol = new Sol();
        List<String> allRecipes = sol.findAllRecipes(new String[]{"bread", "sandwich", "burger"},
                List.of(
                        List.of("yeast", "sandwich"),
                        List.of("bread", "meat"),
                        List.of("sandwich", "meat", "bread")
                ),
                new String[]{"yeast", "flour", "meat"});
    }
}