package controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@ApplicationScoped
public class DodavanjeLekcijeManagedBean {
	boolean isClicked = false;
	private List<StreamedContent> listImages = new ArrayList<>();
	private int radioNumberChecked = 0;
	
	

	public int getRadioNumberChecked() {
		return radioNumberChecked;
	}

	public void setRadioNumberChecked(int radioNumberChecked) {
		this.radioNumberChecked = radioNumberChecked;
	}

	public boolean isClicked() {
		return isClicked;
	}

	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}

	public List<StreamedContent> getListImages() {
		return listImages;
	}

	public void setListImages(List<StreamedContent> listImages) {
		this.listImages = listImages;
	}

	public void upload(FileUploadEvent event) {
		isClicked = true;
		addStreamIzUplFajla(event.getFile());
		UploadedFile uploadedFile = event.getFile();
		File theDir = new File("D:/images");

		if (!theDir.exists()) {
			theDir.mkdirs();
		}

		File fileToWrite = new File("D:/images/" + uploadedFile.getFileName());
		try (FileOutputStream fop = new FileOutputStream(fileToWrite)) {
			if (!fileToWrite.exists()) {
				fileToWrite.createNewFile();
			}
			byte[] contentInBytes = uploadedFile.getContents();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addStreamIzUplFajla(UploadedFile uploadedFile) {
		byte[] data = uploadedFile.getContents();
		System.out.println(data.length);
		StreamedContent ret = new DefaultStreamedContent(new ByteArrayInputStream(data), "image/png");
		listImages.add(ret);
	}

	public void ispis() {
		System.out.println(listImages.size());
	}
}
