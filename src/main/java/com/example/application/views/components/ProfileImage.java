package com.example.application.views.components;

import com.example.application.entity.Student;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinService;
import org.apache.catalina.webresources.FileResource;
import org.vaadin.liveimageeditor.LiveImageEditor;

import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.sql.Blob;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileImage extends Div {

    private String originalFileName;
    private String mimeType;
    private File file;

    public ProfileImage() { //https://dcstatic.com/images/brandcrowd/logos/brandcrowd-logo-5d59400c52.svg

        Image img = new Image();
        Div imageFrame = new Div();
        img.setSrc("man.png");
        img.getClassNames().add("img-avatar");
        imageFrame.getClassNames().add("frame-avatar");

        Upload upload = new Upload(this::receiveUpload);
        Div output = new Div(new Text("(no image file uploaded yet)"));

        // Configure upload component
        upload.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");
        upload.addSucceededListener(event -> {
            output.removeAll();
//            output.add(new Text("Uploaded: "+originalFileName+" to "+ file.getAbsolutePath()+ "Type: "+mimeType));
            StreamResource sr = (new StreamResource(this.originalFileName,this::loadFile));
            img.setSrc(sr);
            // - Set the image to be edited:
//            imageEditor.setImage(sr);
        });
        upload.addFailedListener(event -> {
            output.removeAll();
            output.add(new Text("Upload failed: " + event.getReason()));
        });

        imageFrame.add(img);
        add(imageFrame,upload,output);
    }

    /** Load a file from local filesystem.
     *
     */
    public InputStream loadFile() {
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Failed to create InputStream for: '" + this.file.getAbsolutePath(), e);
        }
        return null;
    }

    public OutputStream receiveUpload(String originalFileName, String MIMEType) {
        this.originalFileName = originalFileName;
//        this.mimeType = MIMEType;
        try {
            // Create a temporary file for example, you can provide your file here.
            this.file = File.createTempFile("prefix-", "-suffix");
            file.deleteOnExit();
            return new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Failed to create InputStream for: '" + this.file.getAbsolutePath(), e);
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Failed to create InputStream for: '" + this.file.getAbsolutePath() + "'", e);
        }

        return null;
    }
}
