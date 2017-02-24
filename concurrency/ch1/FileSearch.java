package concurrency.ch1;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class FileSearch implements Runnable {
	private String initPath;
	private String end;
	private List<String> results;
	private Phaser phaser;
	
	public FileSearch() {
		this.initPath = initPath;
		this.end = end;
		this.phaser = phaser;
		this.results = new ArrayList<>();
	}

	@Override
	public void run() {
		//directoryProcess
	}
	
	private void directoryProcess(File file) {
		File[] lists = file.listFiles();
		if (lists != null) {
			for (int i = 0; i < lists.length; i++) {
				if (lists[i].isDirectory()) {
					directoryProcess(lists[i]);
				} else {
					fileProcess(lists[i]);
				}
			}
		}
	}
	
	private void fileProcess(File file) {
		if (file.getName().endsWith(end)) {
			results.add(file.getAbsolutePath());
		}
	}
	
	private void filterResults() {
		List<String> newResults = new ArrayList<>();
		long actualDate = new Date().getTime();
		for (int i = 0; i < results.size(); i++) {
			File file = new File(results.get(i));
			long fileDate = file.lastModified();
			if (actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
				newResults.add(results.get(i));
			}
		}
		results = newResults;
	}
	
	//private boolean check

}
