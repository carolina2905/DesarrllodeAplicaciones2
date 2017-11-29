package utng.dom;

import java.util.List;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import utng.model.GeneProduct;;

public class GeneProductDOM {
	private String pathFile = "C:\\Users\\Alejandro RG\\eclipse-workspace\\CRVUnidad2\\src\\data\\GeneProduct.xml";

	public void add(GeneProduct data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			Element products = document.getDocumentElement();
			// Create student tag
			Element product = document.createElement("product");
			// Create id tag
			Element id = document.createElement("id");
			id.appendChild(document.createTextNode(data.getId()));
			product.appendChild(id);
			// Create name tag
			Element symbol = document.createElement("symbol");
			symbol.appendChild(document.createTextNode(data.getSymbol()));
			product.appendChild(symbol);
			
			// Create age tag
			Element dbxref = document.createElement("dbxref");
			dbxref.appendChild(document.createTextNode(String.valueOf(data.getSpecies())));
			product.appendChild(dbxref);

			// Create age tag
			Element species = document.createElement("species");
			species.appendChild(document.createTextNode(String.valueOf(data.getSpecies())));
			product.appendChild(species);

			// Create age tag
			Element type = document.createElement("type");
			type.appendChild(document.createTextNode(String.valueOf(data.getType())));
			product.appendChild(type);

			// Create name tag
			Element name = document.createElement("name");
			name.appendChild(document.createTextNode(data.getName()));
			product.appendChild(name);

			products.appendChild(product);

			// Write to file
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(String id) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("product");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element product = (Element) nodeList.item(i);
				if (product.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					product.getParentNode().removeChild(product);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(GeneProduct data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("product");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element product = (Element) nodeList.item(i);
				if (product.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					product.getElementsByTagName("dbxref").item(0).setTextContent(String.valueOf(data.getDbxref()));
					product.getElementsByTagName("species").item(0).setTextContent(String.valueOf(data.getSpecies()));
					product.getElementsByTagName("type").item(0).setTextContent(String.valueOf(data.getType()));
					product.getElementsByTagName("name").item(0).setTextContent(data.getName());
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public GeneProduct findById(String id) {
		GeneProduct geneProduct = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("product");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element s = (Element) nodeList.item(i);
				if (s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					geneProduct = new GeneProduct();
					geneProduct.setId(id);
					geneProduct.setSymbol(s.getElementsByTagName("symbol").item(0).getTextContent());
					geneProduct.setSpecies(Integer.parseInt(s.getElementsByTagName("dbxref").item(0).getTextContent()));
					geneProduct.setSpecies(Integer.parseInt(s.getElementsByTagName("species").item(0).getTextContent()));
					geneProduct.setType(Integer.parseInt(s.getElementsByTagName("type").item(0).getTextContent()));
					geneProduct.setName(s.getElementsByTagName("name").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return geneProduct;
	}

	public List<GeneProduct> getGeneProducts() {
		List<GeneProduct> geneProducts = new ArrayList<GeneProduct>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodeList = document.getElementsByTagName("product");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element p = (Element) nodeList.item(i);
			GeneProduct geneProduct = new GeneProduct();
			geneProduct.setId(p.getElementsByTagName("id").item(0).getTextContent());
			geneProduct.setSymbol(p.getElementsByTagName("symbol").item(0).getTextContent());
			geneProduct.setDbxref(Integer.parseInt(p.getElementsByTagName("dbxref").item(0).getTextContent()));
			geneProduct.setSpecies(Integer.parseInt(p.getElementsByTagName("species").item(0).getTextContent()));
			geneProduct.setType(Integer.parseInt(p.getElementsByTagName("type").item(0).getTextContent()));
			geneProduct.setName(p.getElementsByTagName("name").item(0).getTextContent());
			geneProducts.add(geneProduct);
		}
		return geneProducts;
	}
}
