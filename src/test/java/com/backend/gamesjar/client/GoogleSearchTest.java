package com.backend.gamesjar.client;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoogleSearchTest {

    @Test
    public void getUrl() {

        //Given
        GoogleSearch googleSearch = new GoogleSearch();
        String url = "https://cse.google.com/cse?cx=012821511456309802056:limczlo7e7w";

        //When
        String testUrl = googleSearch.getUrl();

        //Then
        Assert.assertEquals(url, testUrl);
    }
}