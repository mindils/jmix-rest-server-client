package com.company.app.view.filedownload;

import com.company.app.view.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.Route;
import io.jmix.core.FileRef;
import io.jmix.core.FileStorage;
import io.jmix.core.FileStorageException;
import io.jmix.flowui.Notifications;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.download.Downloader;
import io.jmix.flowui.exception.ValidationException;
import io.jmix.flowui.view.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


@Route(value = "file-download", layout = MainView.class)
@ViewController("FileDownloadView")
@ViewDescriptor("file-download-view.xml")
public class FileDownloadViewController extends StandardView {
  private static final Logger log = LoggerFactory.getLogger(FileDownloadViewController.class);

  @ViewComponent
  private TypedTextField<String> fileRefField;

  @Autowired
  private Notifications notifications;

  @Autowired
  private Downloader downloader;

  @Autowired
  @Qualifier("serviceappFileStorage")
  private FileStorage remoteFileStorage;

  private static final String EXPECTED_STORAGE_PREFIX = "serviceapp-fs://";

  @Subscribe("downloadButton")
  public void onDownloadButtonClick(final ClickEvent<Button> event) {
    String fileRefString = fileRefField.getValue();

    if (fileRefString == null || fileRefString.isBlank()) {
      notifications.create("Please enter a FileRef.")
          .withType(Notifications.Type.WARNING)
          .show();
      return;
    }

//    if (!fileRefString.startsWith(EXPECTED_STORAGE_PREFIX)) {
//      notifications.create("Invalid FileRef format. It should start with: " + EXPECTED_STORAGE_PREFIX)
//          .withType(Notifications.Type.ERROR)
//          .show();
//      return;
//    }

    String filePath = fileRefString.substring(EXPECTED_STORAGE_PREFIX.length());
    if (filePath.isBlank()) {
      notifications.create("Invalid FileRef format: path part is missing.")
          .withType(Notifications.Type.ERROR)
          .show();
      return;
    }

//    FileRef fileRef = FileRef.create(EXPECTED_STORAGE_PREFIX.replace("://", ""), filePath);
    FileRef fileRef = FileRef.fromString(fileRefString);

    System.out.println();

    try {
      if (!remoteFileStorage.fileExists(fileRef)) {
        notifications.create("File not found in remote storage: " + fileRefString)
            .withType(Notifications.Type.ERROR)
            .show();
        return;
      }


      downloader.download(
          () -> remoteFileStorage.openStream(fileRef), // Лямбда, которая предоставит InputStream
          fileRef.getFileName()
      );

      notifications.create("Download started for: " + fileRef.getFileName())
          .withType(Notifications.Type.SUCCESS)
          .show();

    } catch (FileStorageException e) {
      log.error("Error accessing remote file for download", e);
      notifications.create("Error accessing file: " + e.getMessage())
          .withType(Notifications.Type.ERROR)
          .show();
    } catch (Exception e) { // Ловим другие возможные исключения (например, при выполнении downloader.download)
      log.error("Unexpected error during file download initiation", e);
      notifications.create("An unexpected error occurred while starting download: " + e.getMessage())
          .withType(Notifications.Type.ERROR)
          .show();
    }
  }

  @Install(to = "fileRefField", subject = "validator")
  private void fileRefFieldValidator(String value) {
    if (value != null && !value.isBlank() && !value.startsWith(EXPECTED_STORAGE_PREFIX)) {
      throw new ValidationException("FileRef must start with " + EXPECTED_STORAGE_PREFIX);
    }
  }
}