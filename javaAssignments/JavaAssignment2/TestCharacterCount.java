package com.company;

import org.junit.Assert;

public class TestCharacterCount {
    public static void test() {
        CharacterCount charactercount = new CharacterCount();
        Assert.assertEquals(true, charactercount.containsAllLetters("AbcdeFGHIjklmnoPQrstuvWxyZ"));
        Assert.assertEquals(false, charactercount.containsAllLetters("dsfufhuhDSHOFJSFDOdhfos"));

    }
}
