package com.inti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inti.model.Utilisateur;
import com.inti.util.TraitementBDD;

/**
 * Permet de modifier les informations d'un utilisateur
 * 
 * Servlet implementation class ModifierUtilisateurServlet
 */
@WebServlet("/modifierU")
public class ModifierUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TraitementBDD tbdd = new TraitementBDD();
		Utilisateur u1 = tbdd.getUtilisateurById(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("utilisateur", u1);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TraitementBDD tbdd = new TraitementBDD();
		tbdd.updateUtilisateur(Integer.parseInt(request.getParameter("id")), request.getParameter("login"), 
				request.getParameter("password"), 
				request.getParameter("adresse"), request.getParameter("ville"), 
				Integer.parseInt(request.getParameter("cp")), request.getParameter("tel"), request.getParameter("email"));
		
		response.sendRedirect("afficher");
	}

}
