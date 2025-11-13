package com.teaching.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class FileUtils {

  /**  Lists all files and folders in the given directory path.
  * @param path the directory path as string
    @return a list of file and folder names, or an empty list if the path is invalid or an error occurs
  */
  @SuppressWarnings("checkstyle:EmptyForIteratorPad")
  public static List<String> listFilesAndFolders(String path) {
    Objects.requireNonNull(path, "Path cannot be null");
    Path p = Paths.get(path);

    if (!path.isEmpty() && Files.exists(p) && Files.isDirectory(p)) {
      List<String> result = new ArrayList<>();

      try (Stream<Path> stream =  Files.list(p)) {
        for (Iterator<Path> it = stream.iterator(); it.hasNext(); ) {
          result.add(it.next().toString());
        }
        return result;
      } catch (Exception _) {
        // Ignore exceptions and return empty list
      }
    }

    return Collections.emptyList();
  }
}
