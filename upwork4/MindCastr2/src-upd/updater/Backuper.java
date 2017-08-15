package updater;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Backuper {

	public void backup(String appdir, String backupdir, String backupfile) throws IOException {
		List<File> files = this.listFilesForFolder(new File(appdir), backupdir);
		zipFiles(files, new File(createBackupDir(appdir, backupdir), String.format("%s.zip", backupfile)));
	}

	private void zipFiles(List<File> files, File backup) throws IOException {
		try (FileOutputStream out = new FileOutputStream(backup);
			 ZipOutputStream zout = new ZipOutputStream(new BufferedOutputStream(out))) {
			for (File f : files) {
				try (FileInputStream in = new FileInputStream(f.getPath())) {
					zout.putNextEntry(new ZipEntry(f.getPath()));
					byte[] buf = new byte[512];
					int size;
					while ((size = in.read(buf)) != -1) {
						zout.write(buf, 0, size);
					}
					zout.flush();
				}
			}
		}
	}

	private ArrayList<File> listFilesForFolder(final File folder, final String patternFileFilter) throws IOException {
		boolean filteredFile = false;
		final ArrayList<File> files = new ArrayList<>();

		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				files.addAll(listFilesForFolder(fileEntry, patternFileFilter));
			} else {
				if (patternFileFilter.length() == 0) {
					filteredFile = true;
				} else {
					filteredFile = !fileEntry.getPath().contains("backup")
							&& !fileEntry.getPath().contains("tmp");
				}
				if (filteredFile) files.add(fileEntry);
			}
		}
		return files;
	}

	private File createBackupDir(final String app, final String backup) throws IOException {
		final File dir = new File(app, backup);
		if (!dir.exists() && !dir.mkdirs()) {
			throw new IOException(String.format("Unable to create %s", dir.getAbsolutePath()));
		}
		return dir;
	}
}
