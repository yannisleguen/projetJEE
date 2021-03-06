package controler.dedie;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PAP.SESSION.IApplication;

public class CConnect implements ICTreatment {
	Context ctx;
	IApplication app;
	String name,email,pass,city;
	
	public CConnect() throws NamingException {
		ctx = new InitialContext();
		app = (IApplication) ctx.lookup("ejb/PAP");
		
		
	}
	
	@Override
	public void treatRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//We get request's attributes 
		
		String email = request.getParameter("email");
		System.out.println(email);
		String pass = request.getParameter("pass");
		System.out.println(pass);
		HttpSession session = request.getSession();
		
		
			try {
				if (app.connect(email, pass)) {
					session.setAttribute("mail", email);
					System.out.println(session.getAttribute("mail"));
					session.setAttribute("connected", "ok");
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("erreur",e);
				System.err.println(e);
			}
		


		//
		RequestDispatcher dispatch = request.getRequestDispatcher("./View/loginAns.jsp");
		dispatch.forward(request, response);
	}

}
