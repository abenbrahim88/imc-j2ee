package controlers;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Person;

/**
 * Servlet implementation class ImcController
 */
@WebServlet("/ImcController")
public class ImcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImcController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// read form fields
		boolean numeric=true;
		double height=0;
		double weight=0;
		try {
			
			height = Double.parseDouble(request.getParameter("height").replace(',', '.'));
			weight = Double.parseDouble(request.getParameter("weight").replace(',', '.'));
			

		} catch (NumberFormatException e) {
			numeric = false;
		}

		if(numeric) {
			Person P=new Person(height,weight);
			if(!P.CalculateIMC().equals("bad value")) {
				double imc=Double.parseDouble(P.CalculateIMC());
				String message="";
				String img="";
				boolean isok=false;
				if (imc<16.5){
					message="Dénutrition";
					img="underweight.png";
				}
				else if (imc<18.5){
					message="Maigre";
					img="underweight.png";
				}
				else if (imc<25){
					message="Corpulence Normale";
					isok=true;
					img="normal.png";
				}
				else if (imc<30){
					message="Surpoids";
					img="overweight.png";
				}
				else if (imc<35){
					message="Obésité Moderée";
					img="overweight.png";
				}
				else if (imc<40){
					message="Obésité Sévère";
					img="obese.png";
				}
				else{
					message="Obésité Massive";
					img="obese.png";
					
				}
				request.setAttribute("imc", imc);
				request.setAttribute("isok",isok );
				request.setAttribute("message", message);
				request.setAttribute("img", img);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else {
			request.setAttribute("isok",false );
			request.setAttribute("error", true);
			request.setAttribute("imc", "bad value");
			request.setAttribute("message", "Veuillez verifier votre Saisi");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}else {
		request.setAttribute("isok",false );
		request.setAttribute("error", true);
		request.setAttribute("imc", "bad value");
		request.setAttribute("message", "Veuillez verifier votre Saisi");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
		}





}


