package updater;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class Updater {
	private String appPath;
	private String tmpPath;

	public Updater(String appPath, String tmpPath) {
		this.appPath = appPath;
		this.tmpPath = tmpPath;
	}

	public void update(File xml) throws ParserConfigurationException, IOException, SAXException {
		if (!xml.exists() || xml.isDirectory())
			throw new IOException("Wrong xml file");

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml);
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("instruction");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				action(new Instruction((Element) nNode));
			}
		}
	}

	private void copy(String src, String dst) throws IOException {
		try (InputStream in = new FileInputStream(new File(src));
			 OutputStream out = new FileOutputStream(new File(dst))) {
			byte[] buf = new byte[512];
			int size;
			while ((size = in.read(buf)) > 0) {
				out.write(buf, 0, size);
			}
		}
	}

	private void action(Instruction instr) throws IOException {
		final File dst = new File(String.format("%s%s%s", appPath, File.separator, instr.getDestination()));
		switch (instr.getAction()) {
			case UPDATE:
				final File dir = new File(dst.getAbsoluteFile().getParent());
				if (!dir.exists() && !dir.mkdirs()) {
					throw new IOException(String.format("Unable to create %s", dir.getCanonicalPath()));
				}
				copy(String.format("%s%s%s", tmpPath, File.separator, instr.getFilename()), dst.getCanonicalPath());
				break;
			case DELETE:
				new File(dst.getCanonicalPath()).delete();
				break;
			case EXECUTE:
				Runtime.getRuntime().exec(String.format("java -jar %s%s%s", tmpPath, File.separator, instr.getFilename()));
				break;
		}
	}
}