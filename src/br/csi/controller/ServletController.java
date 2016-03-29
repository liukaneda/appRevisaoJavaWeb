package br.csi.controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.Usuario;
import br.csi.model.dao.UsuarioDao;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/servletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String opcao = request.getParameter("opcao");
		System.out.println("opcao ... " + opcao);
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		System.out.println("senha: .. " + senha);

		Usuario u = new Usuario();
		u.setLogin(login);
		u.setSenha(senha);

		UsuarioDao uD = new UsuarioDao();
		RequestDispatcher dispatcher;

		if (opcao.equals("logar")) {

			try {

				boolean retorno = uD.autenticado(u);
				if (retorno) {
					String pagina = "/WEB-INF/jsp/principal.jsp";
					request.setAttribute("usuario", u);
					dispatcher = getServletContext().getRequestDispatcher(
							pagina);
					dispatcher.forward(request, response);

				} else {
					String pagina = "/index.jsp";
					request.setAttribute("msg", "Erro ao logar!");
					dispatcher = getServletContext().getRequestDispatcher(
							pagina);
					dispatcher.forward(request, response);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				String pagina = "index.jsp";
				dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}

		} else if (opcao.equals("cadastrarUsuario")) {

			String pagina = "/WEB-INF/jsp/cadastraUsuario.jsp";
			request.setAttribute("usuario", u);
			dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);

		} else {
			System.out.println("nenhuma opcao detectada....");
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ")
				.append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
