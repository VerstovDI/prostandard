package ru.Aidar.ParsingProffStandards.Utills;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;

public class FileUtils {
    private static final Logger log = LogManager.getLogger(FileUtils.class);

    /**
     *
     * @param dir
     * @return последний файл в директории
     */
    public static Optional<Path> getLastFilePath(String dir) {
        try {
            return Files.list(Path.of(dir))
                    .filter(f -> !Files.isDirectory(f))
                    .max(Comparator.comparingLong(f -> f.toFile().lastModified()));
        } catch (IOException e) {
            log.error(e);
        }
        return Optional.empty();
    }

    /**
     * удаление подпапок в текущей директории, если они созданы ранее,чем 24 часа назад
     * @param dir
     */
    public static void clearOldDirectories(File dir) {
        for (File subDir :dir.listFiles(File::isDirectory)){
            removeDirectory(subDir);
        }
    }

    private static void removeDirectory(File dir) {
        boolean delSource = false;
        long purgeTime = System.currentTimeMillis() - (24 * 60 * 60 * 1000);
        if (dir.lastModified()< purgeTime) delSource = true;
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File aFile : files) {
                if (aFile.lastModified() < purgeTime) {
                    aFile.delete();
                }
            }
        }
        if(delSource) dir.delete();
    }
}