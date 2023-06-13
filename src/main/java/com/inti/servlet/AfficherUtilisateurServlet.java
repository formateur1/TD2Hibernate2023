package com.inti.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.inti.model.Role;
import com.inti.model.Utilisateur;
import com.inti.model.UtilisateurDetails;
import com.inti.util.HibernateUtil;
import com.inti.util.TraitementBDD;

/**
 * Servlet implementation class AfficherUtilisateurServlet
 */
@WebServlet("/afficher")
public class AfficherUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LogManager.getLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TraitementBDD tbdd = new TraitementBDD();
		request.setAttribute("listeU", tbdd.getListeUtilisateur());
		
		logger.debug("Envoi de cette liste à la page jsp");		

		this.getServletContext().getRequestDispatcher("/WEB-INF/afficherUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
