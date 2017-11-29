package utng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utng.dom.GeneProductDOM;
import utng.model.GeneProduct;



	/**
	 * Servlet implementation class ProductController
	 */
	@WebServlet("/GeneProductController")
	public class GeneProductController extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private GeneProduct geneProduct;
		private List<GeneProduct> geneProducts;
		private GeneProductDOM geneProductDOM;
		private List<String> ids = new ArrayList<String>();    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public GeneProductController() {
	        super();
	        geneProduct = new GeneProduct();
	        geneProducts = new java.util.ArrayList<>();
	        geneProductDOM = new GeneProductDOM();
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			if (request.getParameter("btn_save") != null) {
				geneProduct.setSymbol(request.getParameter("symbol"));
					//System.out.println("Save");
				try {
					geneProduct.setDbxref(Integer.parseInt(request.getParameter("dbxref")));
					geneProduct.setSpecies(Integer.parseInt(request.getParameter("species")));
					geneProduct.setType(Integer.parseInt(request.getParameter("type")));
				} catch (NumberFormatException e) {
					geneProduct.setSpecies(8);
					geneProduct.setType(10);
				}
				geneProduct.setName(request.getParameter("name"));
				System.out.println("Save");
				if (geneProduct.getId() == "") {
					String newId =  "pdt"+String.format("%05d", 1);
					geneProduct.setId(newId);
					if (geneProducts.size()>0) {
						ids.clear();
						for(GeneProduct s: geneProducts) {
							ids.add(s.getId());
						}
						for (int i=0; i<=ids.size(); i++) {
							newId = "pdt"+String.format("%05d", i+1);
							if (!ids.contains(newId)) {
								geneProduct.setId(newId);
								break;
							}
						}
					}
					geneProductDOM.add(geneProduct);

				} else {
					geneProductDOM.update(geneProduct);

				}
				geneProducts = geneProductDOM.getGeneProducts();
				request.setAttribute("products", geneProducts);
				request.getRequestDispatcher("geneProduct_list.jsp").forward(request, response);
				
			}else if(request.getParameter("btn_new")!=null) {
				geneProduct = new GeneProduct();
				request.getRequestDispatcher("geneProduct_form.jsp").forward(request, response);
			}else if(request.getParameter("btn_edit")!=null) {
				try {
					String id = request.getParameter("id");
					geneProduct = geneProductDOM.findById(id);
				}catch (IndexOutOfBoundsException e) {
					geneProduct = new GeneProduct();
				}
			 request.setAttribute("product", geneProduct);
			 request.getRequestDispatcher("geneProduct_form.jsp").forward(request, response);
			}else if(request.getParameter("btn_delete")!=null) {
				try {
					String id= request.getParameter("id");
					geneProductDOM.delete(id);
					geneProducts = geneProductDOM.getGeneProducts();
			
				}catch (Exception e) {
					e.printStackTrace();
				}
				request.setAttribute("products", geneProducts);
				request.getRequestDispatcher("geneProduct_list.jsp").forward(request, response);
			}else {
				geneProducts = geneProductDOM.getGeneProducts();
				request.setAttribute("products", geneProducts);
				request.getRequestDispatcher("geneProduct_list.jsp").forward(request, response);
			}
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

}
