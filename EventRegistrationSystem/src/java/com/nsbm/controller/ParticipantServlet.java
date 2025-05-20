package com.nsbm.controller;

import com.nsbm.dao.ParticipantDAO;
import com.nsbm.model.Participant;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author IsuruKumara
 */
@WebServlet("/ParticipantServlet")
public class ParticipantServlet extends HttpServlet {
    private ParticipantDAO participantDAO;

    /**
     *
     */
    @Override
    public void init() {
        participantDAO = new ParticipantDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String event = request.getParameter("event");

        Participant participant = new Participant();
        participant.setName(name);
        participant.setEmail(email);
        participant.setEvent(event);

        participantDAO.insertParticipant(participant);
        response.sendRedirect("ParticipantServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Participant> list = participantDAO.listParticipants();
        request.setAttribute("participantList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("participantList.jsp");
        dispatcher.forward(request, response);
    }
}
