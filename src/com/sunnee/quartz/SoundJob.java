package com.sunnee.quartz;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import sun.audio.AudioStream;

import java.io.*;
import sun.audio.*;
import java.util.Random;
import java.util.Calendar;
public class SoundJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		String soundFile = "path/to/sound";
		
		AudioStream audioStream = null;
		
		Random randomGenerator = new Random();
		Integer random = randomGenerator.nextInt(5);
		
		try {
			InputStream in = new FileInputStream(soundFile);
			audioStream = new AudioStream(in);
			
			if(random.equals(3)) {
				AudioPlayer.player.start(audioStream);
				
			}
		} catch(IOException ex) {
			//add logger
			System.out.println(ex.getMessage());
		}
		
		
		
		
		
		
	
	}
}
