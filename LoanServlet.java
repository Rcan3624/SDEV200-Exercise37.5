/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter37;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rcann
 */
public class LoanServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // Get form data
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double interestRate = Double.parseDouble(request.getParameter("interestRate"));
        int numYears = Integer.parseInt(request.getParameter("numYears"));

        // Compute loan payments
        Loan loan = new Loan(interestRate, numYears, loanAmount);
        double monthlyPayment = loan.getMonthlyPayment();
        double totalPayment = loan.getTotalPayment();

        // Display results
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Loan Payment</title></head><body>");
        out.println("<h1>Loan Payment</h1>");
        out.println("<p>Loan Amount: $" + loanAmount + "</p>");
        out.println("<p>Interest Rate: " + interestRate + "%</p>");
        out.println("<p>Number of Years: " + numYears + "</p>");
        out.println("<p>Monthly Payment: $" + monthlyPayment + "</p>");
        out.println("<p>Total Payment: $" + totalPayment + "</p>");
        out.println("</body></html>");
    }
}
