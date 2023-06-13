package com.inti.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.*;
import org.hibernate.Session;

import com.inti.model.Role;
import com.inti.model.Utilisateur;
import com.inti.model.UtilisateurDetails;
import com.inti.util.HibernateUtil;

/**
 * 
 * Servlet qui va être appelé par l'url se terminant par : creerCompte
 * Objectif : redigiré la requête http vers une page jsp contenant un
 * formulaire pour saisir les propriétés d'un utilisateur avec les détails.
 * De plus, le rôle minimum client sera affecté par défaut à tous les
 * nouveaux utilisateurs.
 * 
 * @author Me
 *
 */
@WebServlet("/creerCompte")
public class CreerCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LogManager.getLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerCompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Permet de rediriger les objets request et response vers la page creerCompte.jsp
	 * 
	 * @param request : la requête http qu'on récupère
	 * @param response : l'objet utilisé pour envoyer la réponse au navigateur (client)
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/creerCompte.jsp").forward(request, response);
		
	}

	/**
	 * Permet de récupérer les valeurs saisies par un utilisateur dans le formulaire
	 * et de les enregistrer en BDD.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			
			session.beginTransaction();
			
			logger.debug("Début des transactions pour insérer un utilisateur");
			
			Utilisateur u1 = new Utilisateur(request.getParameter("login"), request.getParameter("password"));
			UtilisateurDetails ud1 = new UtilisateurDetails(request.getParameter("adresse"), request.getParameter("ville"),
					Integer.parseInt(request.getParameter("cp")), request.getParameter("tel"), request.getParameter("email"));
			
			u1.setUtilisateurDetails(ud1);
			
//			List<Role> listeRole = List.of(new Role("client"));
			
			Role r1 = session.get(Role.class, 1);
			List<Role> listeRole = List.of(r1);
			
			u1.setListeRoles(listeRole);
			
			session.save(u1);
			
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			logger.error("Erreur d'enregistrement d'un utilisateur !");
			
			session.getTransaction().rollback();
		}
	}

}
