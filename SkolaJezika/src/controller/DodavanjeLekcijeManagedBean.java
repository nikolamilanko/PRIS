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

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import beans.impl.TestBazaBean;
import entities.Kurs11;
import entities.Lekcija11;
import entities.Slika11;

@ManagedBean
@SessionScoped
public class DodavanjeLekcijeManagedBean {

	@EJB
	TestBazaBean testBaza;

	boolean isClicked = false;
	private StreamedContent[] listImages;
	private int radioNumberChecked = 0;
	List<File> fajlovi = new ArrayList<>();
	List<Slika11> slike = new ArrayList<>();
	private String opisLekcije;
	int i = 0;
	boolean saSlikom = false;
	
	boolean saVideom = false;
	
	public void promeniSaSlikom(){
		saSlikom = true;
	}
	public void promeniSaVideom(){
		saVideom = true;
	}
	
	
	
	

	public boolean isSaVideom() {
		return saVideom;
	}

	public void setSaVideom(boolean saVideom) {
		this.saVideom = saVideom;
	}

	public boolean isSaSlikom() {
		return saSlikom;
	}

	public void setSaSlikom(boolean saSlikom) {
		this.saSlikom = saSlikom;
	}

	public DodavanjeLekcijeManagedBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOpisLekcije() {
		return opisLekcije;
	}

	public void setOpisLekcije(String opisLekcije) {
		this.opisLekcije = opisLekcije;
	}

	public StreamedContent[] getListImages() {
		return listImages;
	}

	public void setListImages(StreamedContent[] listImages) {
		this.listImages = listImages;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public List<File> getFajlovi() {
		return fajlovi;
	}

	public void setFajlovi(List<File> fajlovi) {
		this.fajlovi = fajlovi;
	}

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

	public Kurs11 getKursTest() {
		return testBaza.findKurs();
	}

	public void upload(FileUploadEvent event) {
		System.out.println("upload");
		System.out.println("OPIS LEKCIJE " + opisLekcije);
		UploadedFile uploadedFile = event.getFile();
		File theDir = new File("D:/images");
		isClicked = true;
		if (!theDir.exists()) {
			theDir.mkdirs();
		}

		File fileToWrite = new File("D:/images/" + uploadedFile.getFileName());
		fajlovi.add(fileToWrite);
		Slika11 slika11 = new Slika11();
		slika11.setPutanjaslike(fileToWrite.getPath());
		slike.add(slika11);

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

	public void setujuCliked() {
		System.out.println("CLICKED!");
		isClicked = true;
	}

	public StreamedContent streamIzUplFajla() {
		System.out.println("streamIzUplFajla");
		try {
			Path path = Paths.get(fajlovi.get(i).getPath());

			byte[] data = Files.readAllBytes(path);

			StreamedContent ret = new DefaultStreamedContent(new ByteArrayInputStream(data), "image/png");
			if (i < fajlovi.size() - 1) {
				i++;
			} else {
				i = 0;
			}
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void popuniListuIzFajla(File folder) {
		// for (File fileEntry : folder.listFiles()) {
		// if (fileEntry.isDirectory()) {
		// popuniListuIzFajla(fileEntry);
		// } else {
		// fajlovi.add(fileEntry);
		// }
		// }
		//
		for (File file2 : fajlovi) {
			System.out.println("IME: " + file2.getName() + " ZAUZETO: " + file2.getTotalSpace());
		}
	}

	public void sacuvajLekciju() {
		System.out.println("LEKICJA ISPISI" + opisLekcije);
		if (saSlikom) {
			Lekcija11 lekcija11 = new Lekcija11();
			lekcija11.setKurs11(testBaza.findKurs());
			lekcija11.setTekstlekcije(opisLekcije);
			lekcija11.setVideolekcije(null);
			lekcija11.setSlika11s(slike);
			int idLekcije = testBaza.sacuvajLekcijuUBazu(lekcija11);
			for (Slika11 slika11 : slike) {
				slika11.setLekcija11(lekcija11);
				testBaza.sacuvajSlikuUBazu(slika11);
			}
		}

	}
}
