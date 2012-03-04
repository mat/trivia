package com.adaptionsoft.games.trivia.runner;

import java.io.*;

import junit.framework.Assert;

import org.junit.Test;

public class NewGameRunnerTest {

	@Test
	public void newShouldBehaveAsOld() {
		testWithSeedAndCompare(0);
		testWithSeedAndCompare(42);
		testWithSeedAndCompare(1337);
	}

	private void testWithSeedAndCompare(int seed) {
		String oldOutput = runGame("old", seed);
		String newOutput = runGame("new", seed);
		Assert.assertEquals("Outputs should be equal, but are not for seed=" + seed, oldOutput, newOutput);
	}

	private String runGame(String oldOrNew, int seed) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		if (oldOrNew.equals("old")) {
			GameRunner.main(new String[] { "" + seed });
		} else {
			NewGameRunner.main(new String[] { "" + seed });
		}
		String output = baos.toString();
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		return output;
	}
}
