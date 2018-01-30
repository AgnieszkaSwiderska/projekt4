package calculator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calculator.CalculatorBean;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
	    CalculatorBean obiekt = (CalculatorBean)session.getAttribute("calculatorBean");
	    /*if(obiekt == null) 
	    {
	        obiekt = new CalculatorBean();
	        
	        obiekt.setWynik("0");
	        obiekt.setStart(true);
	        obiekt.setOperator("=");
	        session.setAttribute("calculatorBean",obiekt);
	    }*/
        session.setAttribute("calculatorBean",obiekt);
        if(request.getParameterMap().containsKey("color"))
	    	obiekt.setColor(request.getParameter("color"));
        if(request.getParameterMap().containsKey("color_tla"))
 	    	obiekt.setColor_tla(request.getParameter("color_tla"));
	    	
		if(request.getParameterMap().containsKey("btnArg")) 
	        pressNumber(obiekt, request.getParameter("btnArg"));
		else
			if(request.getParameterMap().containsKey("btnOp"))
				pressOperator(obiekt, request.getParameter("btnOp"),request,response);
			else
				if(request.getParameterMap().containsKey("btnOblicz"))
					pressOblicz(obiekt,request,response);
			
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/webCalc.jsp");
		requestDispatcher.forward(request, response);
	}


	private void pressNumber(CalculatorBean obiekt, String parameter) {
		// TODO Auto-generated method stub
		
		if(obiekt.isStart())
		{
			obiekt.setWynik(parameter);
			obiekt.setStart(false);
		}
		else
			obiekt.setWynik(obiekt.getWynik()+parameter);
	}
		
	private void pressOperator(CalculatorBean obiekt, String command, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(command.equals("+/-"))
        {
			obiekt.setOperator("=");
			obiekt.setWynik(Double.toString(Double.parseDouble(obiekt.getWynik())*(-1.0)));
        }
        
        if(command.equals("C"))
        {
       	    obiekt.setOperator("=");
       	    obiekt.setArgument(null);
       	   	obiekt.setWynik("0");
       	   	obiekt.setStart(true);
       	   
       	   	/*if(blokada)
       	   		ustawBlokade(false);*/  //gdy ustawiona blokada t odblokowac klawisze  !!!!
        }
         
        if(command.equals("sqrt"))
        {
       	 	double liczba = Double.parseDouble(obiekt.getWynik());
       	 	if(liczba>=0)
       	 	{
	        	 obiekt.setWynik("" + Math.sqrt(liczba));
	        	 obiekt.setOperator("=");
	        	 obiekt.setStart(true);
       	 	}
       	 	else
       	 	{
       	 		obiekt.setWynik("ERR");
       	 	
       	 	RequestDispatcher requestDispatcherErr = getServletContext().getRequestDispatcher("/error.jsp");
    		requestDispatcherErr.forward(request, response);
       	 	}
        }
        
        if(command.equals("%"))	
        {
       	 	obiekt.setOperator("=");
       	 	obiekt.setStart(true);
            obiekt.setWynik(Double.toString(Double.parseDouble(obiekt.getWynik())/100));
        }
        
        if(command.equals("."))
        {
        	if(obiekt.isStart())
        	{
        		obiekt.setWynik("0.");
        		obiekt.setStart(false);
        	}
        	else
        		obiekt.setWynik(obiekt.getWynik()+".");
        }
        
        if(command.equals("+")||command.equals("-")||command.equals("*")||command.equals("/"))
        {
        	obiekt.setArgument(obiekt.getWynik());
        	obiekt.setOperator(command);
        	obiekt.setStart(true);
        	obiekt.setWynik(command);
        }
	}

	private void pressOblicz(CalculatorBean obiekt, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		/*if(obiekt.getArgument().equals(null)||obiekt.getOperator().equals("=")||obiekt.getWynik().equals("*")||obiekt.getWynik().equals("/")||obiekt.getWynik().equals("+")||obiekt.getWynik().equals("-"))
		
			obiekt.setStart(true);
		else
		{
			obiekt.setWynik(obliczWynik(obiekt.getArgument(), obiekt.getOperator(), obiekt.getWynik()));
			obiekt.setStart(true);
		} */
		
		obiekt.setStart(true);
		obiekt.setWynik(obliczWynik(obiekt.getArgument(), obiekt.getOperator(), obiekt.getWynik()));
	}

	private String obliczWynik(String argument, String operator, String wynik) {
		// TODO Auto-generated method stub
		double arg, wyn;
		arg = Double.parseDouble(argument);
		wyn = Double.parseDouble(wynik);
		
		if (operator.equals("+")) arg += wyn;
	      	else if (operator.equals("-")) arg -= wyn;
	      	else if (operator.equals("*")) arg *= wyn;
	      	else if (operator.equals("/")) arg /= wyn;
	    //dodać reakcję na błędy dzielenia
		return (""+ arg);
	}
}
