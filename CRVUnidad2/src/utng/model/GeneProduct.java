/**-
 * 
 */
package utng.model;

import java.io.Serializable;

/**
 * @author usuario
 *
 */
public class GeneProduct implements Serializable {
	private String id;
	private String symbol;
	private int dbxref;
	private int species;
	private int type;
	private String name;
	public GeneProduct(String id, String symbol, int dbxref, int species, int type, String name) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.dbxref = dbxref;
		this.species = species;
		this.type = type;
		this.name = name;
	}
	public GeneProduct() {
		this("","",0,0,0,"");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getDbxref() {
		return dbxref;
	}
	public void setDbxref(int dbxref) {
		this.dbxref = dbxref;
	}
	public int getSpecies() {
		return species;
	}
	public void setSpecies(int species) {
		this.species = species;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "GeneProduct [id=" + id + ", symbol=" + symbol + ", dbxref=" + dbxref + ", species=" + species
				+ ", type=" + type + ", name=" + name + "]";
	}
	
	
	
	
}
