//package controller;
//
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.primefaces.event.FileUploadEvent;
//import org.primefaces.model.DefaultStreamedContent;
//import org.primefaces.model.StreamedContent;
//import org.primefaces.model.UploadedFile;
//
//public class ADmin2 {
//	List<UploadedFile> list = new ArrayList<>();
//	private List<StreamedContent> listImages = new ArrayList<>();
//	private StreamedContent imageTest;
//	List<File> fajlovi = new ArrayList<>();
//	UploadedFile uplFileTest;
//
//	public UploadedFile getUplFileTest() {
//		return uplFileTest;
//	}
//
//	public void setUplFileTest(UploadedFile uplFileTest) {
//		this.uplFileTest = uplFileTest;
//	}
//
//	int i = 0;
//
//	public List<File> getFajlovi() {
//		return fajlovi;
//	}
//
//	public void setFajlovi(List<File> fajlovi) {
//		this.fajlovi = fajlovi;
//	}
//
//	public StreamedContent getImageTest() {
//		return imageTest;
//	}
//
//	public void setImageTest(StreamedContent imageTest) {
//		this.imageTest = imageTest;
//	}
//
//	public int getI() {
//		return i;
//	}
//
//	public void setI(int i) {
//		this.i = i;
//	}
//
//	public boolean isClicked() {
//		return isClicked;
//	}
//
//	public void setClicked(boolean isClicked) {
//		this.isClicked = isClicked;
//	}
//
//	public List<StreamedContent> getListImages() {
//		return listImages;
//	}
//
//	public void setListImages(List<StreamedContent> listImages) {
//		this.listImages = listImages;
//	}
//
//	public List<UploadedFile> getList() {
//		return list;
//	}
//
//	public void setList(List<UploadedFile> list) {
//		this.list = list;
//	}
//
//	private int radioNumberChecked = 0;
//
//	public int getRadioNumberChecked() {
//		return radioNumberChecked;
//	}
//
//	public void setRadioNumberChecked(int radioNumberChecked) {
//		this.radioNumberChecked = radioNumberChecked;
//	}
//
//	public void dodajUListu(UploadedFile uploadedFile) {
//		StreamedContent image = new DefaultStreamedContent(new ByteArrayInputStream(uploadedFile.getContents()),
//				"image/png");
//		listImages.add(image);
//	}
//
//	public void ispis() {
//		// popuniListuIzFajla(new File("D:/images/"));
//		// System.out.println(fajlovi.size());
//		System.out.println(list.size());
//		uplFileTest = list.get(0);
//		for (UploadedFile file : list) {
//			System.out.println("FILE IZ LISTA DATA: " + file.getSize());
//		}
//	}
//
//	public StreamedContent streamIzUplFajla(UploadedFile uploadedFile) {
//		byte[] data = uploadedFile.getContents();
//		System.out.println(data.length);
//		StreamedContent ret = new DefaultStreamedContent(new ByteArrayInputStream(data), "image/png");
//		return ret;
//	}
//
//	public StreamedContent streamIzUplFajla() {
//		try {
//			Path path = Paths.get(fajlovi.get(i).getPath());
//			System.out.println(fajlovi.get(i).getPath());
//
//			byte[] data = Files.readAllBytes(path);
//			System.out.println(data.length);
//			StreamedContent ret = new DefaultStreamedContent(new ByteArrayInputStream(data), "image/png");
//			if (i < fajlovi.size() - 1) {
//				i++;
//			} else {
//				i = 0;
//			}
//			return ret;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	public void popuniListuIzFajla(File folder) {
//
//		for (File fileEntry : folder.listFiles()) {
//			if (fileEntry.isDirectory()) {
//				popuniListuIzFajla(fileEntry);
//			} else {
//				fajlovi.add(fileEntry);
//
//			}
//		}
//
//	}
//
//}
