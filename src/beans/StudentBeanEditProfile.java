package beans;

import java.io.File;
import java.io.IOException;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

import org.primefaces.event.CaptureEvent;

@ManagedBean(name = "studentBeanEditProfile")
@ViewScoped
public class StudentBeanEditProfile {

	private String filename;
	public String imgsrc;

	private String getRandomImageName() {
		return "picture";
	}

	public String getFilename() {
		return filename;
	}

	public void oncapture(CaptureEvent captureEvent) {
		filename = getRandomImageName();

		byte[] data = captureEvent.getData();

		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
				.getContext();
		// String newFileName =" W:\\Projects\\learnTocode\\WebContent" +
		// File.separator + "demo" + File.separator + "images" + File.separator
		// + "photocam" + File.separator + filename + ".jpeg";
		String newFileName = servletContext.getRealPath("") + File.separator + "demo" + File.separator + "images"
				+ File.separator + "photocam" + File.separator + filename + ".jpeg";
		imgsrc = newFileName;
		FileImageOutputStream imageOutput;
		try {
			imageOutput = new FileImageOutputStream(new File(newFileName));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
		} catch (IOException e) {
			throw new FacesException(e);
		}
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
}