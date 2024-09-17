package org.CharacterCreator.HTTP;

import java.util.List;

public class AllRacesResponse {
    private int count;
    private List<AllRacesResult> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<AllRacesResult> getResults() {
        return results;
    }

    public void setResults(List<AllRacesResult> results) {
        this.results = results;
    }

}
